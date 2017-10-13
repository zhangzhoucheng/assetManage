<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link href="../css/login.css">
<script type="text/javascript" src="../js/login.js"></script>
</head>
<style></style>
<body>

	<!-- 
任务要求：
<1>此处要用ajax动态验证用户存在不（失去焦点时候），动态提示红字
<2>以及点击登录后也要先ajax验证，动态提示红字
<3>正确后提交跳转用js实现点击不同按钮提交不同action
<4*>cokie记住密码实现（先不作要求）
<5**>响应式页面设计（先不做要求）
<6*>struts2的ajax，json结合（先不要求）
<7*>验证码的实现（先不要求）
-->
	<div class="external">

		<div id="top"></div>
		<div id="main">
			<form action="checkUserLoginAction" method="post">
				<span>用户:</span><input name="user.name" id="userName"> <span>密码:</span><input
					name="user.password" id="userPasswrod"> <input
					type="submit" value="登录"><input type="reset" value="重置">
				<a href="#">注册</a>
				<!-- 此处超链接会跳转到register.jsp -->
			</form>

		</div>
		<div id="down"></div>


	</div>

</body>
</html>