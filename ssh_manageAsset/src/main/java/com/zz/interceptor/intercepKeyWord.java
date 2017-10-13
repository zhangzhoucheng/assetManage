package com.zz.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zz.action.RegisterAction;

public class intercepKeyWord extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//获取到拦截的action，以及相应提交的信息。
		RegisterAction action=(RegisterAction) arg0.getAction();
		if(action.getUser()==null){
			//如果获取的user空，则返回action
			return Action.LOGIN;
		}
		else{
	 	String address=action.getUser().getAddress();
	 	String addressInterceptor=address.replace("垃圾","嘻嘻");//替换“垃圾”成“嘻嘻”
	 	//能够匹配正则表达式的语句被替换成"被修正的信息"
	 	addressInterceptor=address.replaceAll("/^*['垃圾','混蛋','操你妈','你妈']$/", "被修正的信息");
		action.getUser().setAddress(addressInterceptor);
	
		return arg0.invoke();//如果还有拦截器，则把拦截提交给
		}
	}

	
	//其他例子，关于获取session
	/*Map map = arg0.getInvocationContext().getSession();
    if(map.get("user") == null) {
        return Action.LOGIN;
    } else {
        return arg0.invoke();
    }*/
	
}
