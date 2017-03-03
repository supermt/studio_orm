package edu.uestc.msstudio.orm.model.enhancer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
  * ClassName: ConnectTable
  * Description: 
  * 
  * @param value : the middleTable's name
  * 
  * @param middleTable : the java class of middleTable's model
  * 
  * @author I337711
  * @date 2017年3月1日 下午12:29:27
  */
 
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConnectTable {

	String value();
	 
	String sourceColumn() default "";
	
	String targetColumn() default "";
	
	Class<?> middleTable() default void.class;
}
