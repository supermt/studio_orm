package edu.uestc.msstudio.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uestc.msstudio.orm.model.User;

@SpringBootApplication
public class OrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmApplication.class,args);
	}
	
	public String doSomething(){
		return new User().getId();
	}

}
