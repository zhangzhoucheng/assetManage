package com.zz.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
  
	private Date date;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//test时间的代码
	@SuppressWarnings("static-access")
	public void t1(){
		System.out.println("test时间"+date);
		Calendar c=Calendar.getInstance();
		
		c.setTime(date);
		System.out.println("year"+c.getWeekYear());
		System.out.println("错误year1"+c.YEAR);//有误
		System.out.println("错误month"+c.WEEK_OF_MONTH);//有误
	   System.out.println("错误month"+c.MONTH);//有误
		System.out.println("错误day"+c.DAY_OF_MONTH);//有误
		System.out.println("错误day"+c.DAY_OF_WEEK_IN_MONTH);//有误
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");//格式化输出
		String df=sf.format(date);//把date格式化，并传值给df字符串
		System.out.println(df);
		Date d = null;
		try {
			d=sf.parse(df);
			
			
			
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把格式化对象sf（传参）强转成date；
		
Calendar c1=Calendar.getInstance();
		
		c1.setTime(d);
		System.out.println("c1"+c1);
		System.out.println("year"+c1.getWeekYear());
		System.out.println("错误year1"+c1.YEAR);//有误
		System.out.println("错误month"+c1.WEEK_OF_MONTH);//有误
	   System.out.println("错误month"+c1.MONTH);//有误
		System.out.println("错误day"+c1.DAY_OF_MONTH);//有误
		System.out.println("错误day"+c1.DAY_OF_WEEK_IN_MONTH);//有误
		
		
		//一下才是正确做法
		Calendar c2=Calendar.getInstance();
		c2.setTime(d);
		System.out.println("正确year1"+c2.get(Calendar.YEAR));//年

		System.out.println("正确月"+c2.get(Calendar.MONTH));//月份要加一处理
		System.out.println("正确日"+c2.get(Calendar.DAY_OF_MONTH));
	}
}
