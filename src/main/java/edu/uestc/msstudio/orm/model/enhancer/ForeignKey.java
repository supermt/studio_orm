package edu.uestc.msstudio.orm.model.enhancer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
  * ClassName: ForeignKey
  * Description: 
  * <p>加上注解后，会自动寻找目标类，并替换为保存在数据列中的列名</p>
  * @param value
  * Description: 
  * <p>在原表中保存的外键字段</p>
  * 
  * @author I337711
  * @date 2017年3月1日 下午12:02:58
  */
 
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForeignKey {
	String value();
}