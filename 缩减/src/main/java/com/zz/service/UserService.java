package com.zz.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zz.dao.UserDao;
import com.zz.model.User;


@Service
public class UserService {

	/*注解方式注入依赖关系,通过设置的bean名字去找到该bean*/
	@Resource(name="ud")
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/***
	 * 业务层，核对用户登录成功与否
	 * @param user
	 * @return
	 */
	public int checkUser(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUser();
	}
	
	/***
	 * 插入数据，且要验证
	 * @return
	 */
	public int insertUser() {
		// TODO Auto-generated method stub
		return userDao.insertUser();
	}
	
}
