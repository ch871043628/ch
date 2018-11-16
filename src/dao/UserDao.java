package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.UserBean;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List findUsers() {
		List<UserBean> users = jdbcTemplate.query("select * from users", new RowMapper<UserBean>(){

			@Override
			public UserBean mapRow(ResultSet resultSet, int arg1) throws SQLException {
				int  id = resultSet.getInt("id");
				String uname = resultSet.getString("u_loginname");
				String name = resultSet.getString("u_name");
				String pwd = resultSet.getString("u_pwd");
				String sex = resultSet.getString("u_sex");
				UserBean user = new UserBean();
				user.setId(id);
				user.setUname(uname);
				user.setName(name);
				user.setPwd(pwd);
				user.setSex(sex);
				return user;
			}
			
		});
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
		return users;
		
	}
	public void addUser() {
		 jdbcTemplate.update("insert into users (u_loginname,u_name,u_pwd,u_sex)value"
				+ "('cat','Ó¢¶Ì','111','Å®')");
	}
	public void delUser() {
		jdbcTemplate.update("delete from users where id=2");
	}
	public void upUser() {
		jdbcTemplate.update("update  users set u_name='bbb' where id=1");
	}
}
