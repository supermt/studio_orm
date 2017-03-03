package edu.uestc.msstudio.orm.model;

import edu.uestc.msstudio.orm.model.enhancer.Column;
import edu.uestc.msstudio.orm.model.enhancer.Table;

@Table("detail")
public class UserDetail {
	
	private String id;
	
	private String name;
	
	@Column("age")
	private String userage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}


}
