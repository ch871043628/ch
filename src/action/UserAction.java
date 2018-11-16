package action;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import dao.UserDao;

public class UserAction {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		UserDao dao = (UserDao) context.getBean("userDao");
//		dao.findUsers();
//		dao.addUser();
//		dao.delUser();
		dao.upUser();
	}
	

	
}
