//
//
///**
// * Project Name:template.orm 
// * File Name:SQLBuilder.java
// * Package Name:edu.uestc.msstudio.orm.utils
// * Description: TODO
// * Copyright: Copyright (c) 2017 
// * Company:SAP
// * 
// * @author I337711
// * @date 2017年3月1日 下午3:55:45
// * @version V1.0
// */
// 
//package edu.uestc.msstudio.orm.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
///**
//  * ClassName: SQLBuilder
//  * Description: TODO
//  * @author I337711
//  * @date 2017年3月1日 下午3:55:45
//  */
//
//public class SQLBuilder
//{
//	public static String dbName = "temp";
//	
//	private SQLBuilder(){}
//	
//	public static String select(Object input)
//	{
//		try
//		{
//			StringBuilder target = new StringBuilder(selectTemplate(ClassMapper.classToMap(input.getClass())));
//			target.append(" WHERE 1=1 ");
//			List<String> conditions = getConditions();
//			target.append(where(conditions));
//			return target.toString();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			  return " error !";
//		}
//	}
//	 
//	private static List<String> getConditions(Object input)
//	{
//		List<String> result = new ArrayList<>();
//		return result;
//		
//	}
//
//	public static String where(List<String> conditions){
//		StringBuilder conditionSubString = new StringBuilder();
//		for (String condition:conditions){
//			conditionSubString.append(condition);
//			conditionSubString.append(" ");
//		}
//		conditionSubString.append(" AND 1=1");
//		return conditionSubString.toString();
//	}
//	
//	public static String selectTemplate(Map<String, List<String>> columnMap){
//		StringBuilder sql= new StringBuilder();
//		
//		List<String> columns = new ArrayList<>();
//		
//		List<String> tables = new ArrayList<>();
//		
//		for (Entry<String, List<String>> table : columnMap.entrySet()){
//			String currentTable = dbName+"."+table.getKey();
//			tables.add(currentTable);
//			for (String column : table.getValue()){
//				columns.add(currentTable+"."+column);
//			}
//		}
//		sql.append("SELECT ");
//		for (int i = 0;i<columns.size()-1;i++){
//			sql.append(columns.get(i)+" as ");
//			sql.append('`');
//			sql.append(columns.get(i));
//			sql.append('`');
//			sql.append(',');
//		}
//		sql.append(columns.get(columns.size()-1)+" as ");
//		sql.append('`');
//		sql.append(columns.get(columns.size()-1));
//		sql.append('`');
//		sql.append(" FROM ");
//		for (int i = 0;i<tables.size()-1;i++){
//			sql.append(tables.get(i)+",");
//		}
//		sql.append(tables.get(tables.size()-1));
//		return sql.toString();
//	}
//	
//	public static String insert(Object input){
//		return "";
//	}
//	
//	public static String delete(Object input){
//		return "";
//	}
//	
//}
// 
