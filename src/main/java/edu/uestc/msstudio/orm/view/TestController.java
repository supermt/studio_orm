package edu.uestc.msstudio.orm.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uestc.msstudio.orm.model.Role;
import edu.uestc.msstudio.orm.model.User;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	
	@GetMapping("/")
	public Object index() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException
	{
		User temp = new User();
		temp.setId("I337711");
		Role tempa = new Role();
		temp.setRoles(new ArrayList<>());
		temp.getRoles().add(tempa);
//		String result = "";
//		for (Field f : temp.getClass().getDeclaredFields()){
//			f.setAccessible(true);
//			result += f.get(temp).toString();
//		}
//		
//		return ClassMapper.classToMap(temp.getClass());
//		return SQLBuilder.select(temp);
//		String sql = "SELECT temp.user_role.userId as `temp.user_role.userId`,temp.user_role.roleId as `temp.user_role.roleId`,temp.role.id as `temp.role.id`,temp.role.function as `temp.role.function`,temp.detail.id as `temp.detail.id`,temp.detail.name as `temp.detail.name`,temp.detail.age as `temp.detail.age`,temp.user.id as `temp.user.id`,temp.user.detail_id as `temp.user.detail_id` FROM temp.user_role,temp.role,temp.detail,temp.user WHERE 1=1  AND 1=1";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return Collection.class.isInstance(User.class.getDeclaredField("roles").get(User.class.newInstance()));
			
	}
}
