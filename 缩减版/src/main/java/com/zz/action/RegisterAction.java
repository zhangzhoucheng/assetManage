package com.zz.action;

import javax.annotation.Resource;

import com.zz.model.User;
import com.zz.service.UserService;

/*此处采用非模型驱动的方式，即需要在注册页面中name="className.property"的方式来获取到表单提交的内容，自然此处也要有
相应类属性的get，set方法*/
public class RegisterAction {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
    /*注入依赖关系，将已经通过注解方式注入beans容器中的bean以属性的方式注入到当前类中，完成实例化，不用new，从而方便调用等*/
	@Resource
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/***
	 * 注册，从而插入信息到表中
	 */
	public void insertUser(){
		int key=0;
		key=userService.insertUser();
		if(key==1){
			/*返回值1，表示可以完成注册，跳转到登录界面*/
			/*实现代码处*/
		}
		else if(key==0){
			/*返回值0，表示用户已经存在或者输入信息格式不对，ajax实现红字提示用户已经存在，即在此获取response，
			 * 之后输出一个流（用jasoon格式），之后在jsp页面获取流内容，通过.html(data.outBuffer)方式动态提示相应红字*/
			/*实现代码处*/
		}
	}
}
