package edu.uestc.msstudio.orm.model;

import edu.uestc.msstudio.orm.model.enhancer.Table;

@Table("role")
public class Role {
	
	private String id;
	
	private String function;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
}
