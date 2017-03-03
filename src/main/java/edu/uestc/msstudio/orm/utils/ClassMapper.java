

/**
 * Project Name:template.orm 
 * File Name:ClassMapper.java
 * Package Name:edu.uestc.msstudio.orm.utils
 * Description:
 * this is a util tool which can transfer classes to an column map
 * Copyright: Copyright (c) 2017 
 * Organization: UESTC Microsoft Studio
 * 
 * @author I337711
 * @date 2017年3月1日 下午2:44:46
 * @version V1.0
 */
 
package edu.uestc.msstudio.orm.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uestc.msstudio.orm.exception.ErrorTabException;
import edu.uestc.msstudio.orm.exception.MissingJoinColumnException;
import edu.uestc.msstudio.orm.model.enhancer.Column;
import edu.uestc.msstudio.orm.model.enhancer.ConnectTable;
import edu.uestc.msstudio.orm.model.enhancer.ForeignKey;
import edu.uestc.msstudio.orm.model.enhancer.Table;

/**
  * ClassName: ClassMapper
  * Description: 
  * A tool class help transfer Model Classes to A column Map , which all values are empty;
  * @author I337711
  * @date 2017年3月1日 下午2:44:46
  */

public class ClassMapper
{
	private ClassMapper(){
		//this is a static util class , can not be created
	}
	
	public static Map<String, List<String>> classToMap(Class<?> inputClass) throws Exception
	{
		return classToMap(inputClass, new HashMap<>());
	}

	private static Map<String, List<String>> classToMap(Class<?> inputClass, Map<String, List<String>> target) throws Exception
	{
		final Field[] fs = inputClass.getDeclaredFields();
		final List<String> columns = new ArrayList<>();
		
		target.put(classToTableName(inputClass), columns);
		for (final Field f : fs)
		{
			f.setAccessible(true);
			if (f.isAnnotationPresent(ForeignKey.class))
			{//被注解为外键，注解值为该表中外键名称
				columns.add(f.getAnnotation(ForeignKey.class).value());
				classToMap(f.getType(), target);
			}
			else if (f.isAnnotationPresent(ConnectTable.class))
			{
				final ConnectTable midAttributes = f.getAnnotation(ConnectTable.class);
				//如果中间表没有固定模型
				if(f.getType().equals(f.getGenericType()))
				{
					throw new ErrorTabException();//如果标注在不是collection上面，报错
				}
				else if (midAttributes.middleTable().equals(void.class))
				{
					//如果还没有固定指定sourceColumn和targetColumn，则报错
					if ("".equals(midAttributes.sourceColumn())
						||
						"".equals(midAttributes.targetColumn()))
					{
						throw new MissingJoinColumnException();
					}else
					{//拥有足够的信息去定位一个中间表的链接信息，但是需要根据两个column的值确定，由函数手动添加
						List<String> midMap = new ArrayList<>();
						midMap.add(midAttributes.sourceColumn());
						midMap.add(midAttributes.targetColumn());
						target.put(f.getAnnotation(ConnectTable.class).value(),midMap);
						//然后将关联的表加入到map中
						classToMap(Class.forName(((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0].getTypeName()),target);
					}
					
				}else
				{//中间表具有描述
					classToMap(midAttributes.middleTable(),target);
					classToMap(Class.forName(((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0].getTypeName()),target);
				}

			}
			else
			{//没有被注解，应该为简单类
				columns.add(fieldToColumnName(f));
			}
		}
		return target;
	}

	public static String classToTableName(Class<?> inputClass)
	{
		if (inputClass.isAnnotationPresent(Table.class))
		{
			return inputClass.getDeclaredAnnotation(Table.class).value();
		}
		else
		{
			String result = inputClass.getName();
			result = result.substring(result.lastIndexOf('.') + 1, result.length());
			return result;
		}

	}

	public static String fieldToColumnName(Field inputField)
	{
		if (inputField.isAnnotationPresent(Column.class))
		{
			return inputField.getAnnotation(Column.class).value();
		}
		else if (inputField.isAnnotationPresent(ForeignKey.class))
		{
			return inputField.getAnnotation(ForeignKey.class).value();
		}
		else
		{
			return inputField.getName();
		}
	}
}
 
