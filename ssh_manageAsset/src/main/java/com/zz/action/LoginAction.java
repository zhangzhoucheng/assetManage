package com.zz.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.zz.model.User;
import com.zz.service.UserService;

@Controller
public class LoginAction implements ModelDriven<User>{

	/*利用模型驱动ModelDriven方式需要定义相关类属性并且new Class（）*/
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*采用注解方式来加载依赖关系，Resource默认通过byName*/
	@Resource
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 核对登录用户名称密码的正确与否
	 * 根据service层放回的int值来确定，返回1表示登录成功，返回0表示用户不存在，返回2表示密码错误
	 */
	public void checkUser(){
	
		/*根据ajax技术访问此处从而动态红字提示"用户不存在","密码错误"，或成功跳转*/
		int key=userService.checkUser(user);
		if(key==1){
			/*实现代码处*/
			/*ajax实现红字提示用户已经存在，即在此获取response，
			  之后输出一个流（用jasoon格式），之后在jsp页面获取流内容，通过.html(data.outBuffer)方式动态提示红字*/
			/*注意此处登录成功后，需要将用户名称存入session，便于后面身份确定*/
		}
		else if(key==0){
			/*实现代码处*/
		}
		else{
			/*实现代码处*/
		}
	}
  
}
