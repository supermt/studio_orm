package edu.uestc.msstudio.orm.model;

import java.util.List;

import edu.uestc.msstudio.orm.model.enhancer.ConnectTable;
import edu.uestc.msstudio.orm.model.enhancer.ForeignKey;
import edu.uestc.msstudio.orm.model.enhancer.Table;

/**
 * ClassName: User
 * 
 * @author I337711
 * @date 2017年3月1日 下午12:02:18
 */

@Table("user")
public class User
{

	private String id;

	@ForeignKey("detail_id")
	private UserDetail detail;

	@ConnectTable(
		value="user_role",
		sourceColumn="userId",
		targetColumn = "roleId")
	public List<Role> roles;

	@ConnectTable(
		value="couples",
		sourceColumn="id1",
		targetColumn="id2"
		)
	private User couple;
	
	public String getId()
	{
		return this.id;
	}

	public List<Role> getRoles()
	{
	
		return roles;
	}

	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public UserDetail getDetail()
	{
		return this.detail;
	}

	public void setDetail(UserDetail detail)
	{
		this.detail = detail;
	}

}
