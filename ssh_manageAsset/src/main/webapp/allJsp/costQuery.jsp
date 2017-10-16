<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询费用记录</title>
</head>
<!-- 
要求：实现按照年月（html5提供的插件）和类型（用下拉框实现，收入，支出，全部）实现该月所有收支的查询
运用jstl标签foreach遍历处要求内容，注意每行最后添加“操作”列，有删除和编辑操作
 -->
 <script type="text/javascript"></script>
 
<body>


</form>
<div id="external">
<form action="assetQueryAllAjaxOperateAction" method="post" id="assetForm">
     <input type="submit" value="提交此处表单用于查询">
</form>
<table border="1">
<!-- private int id;
	private String userName;
	private String type;/*类型，值有两个：收入，支出*/
	private double money;/*收支的金钱，此处注意对bigDecimal对象的处理*/
	private Date time; -->
	
	<tr>
		 <td>id</td>
		 <td>名字</td>
		 <td>类型</td>
		 <td>收支的钱</td>
		 <td>备注</td>
		 <td>日期</td>
		 <td>操作</td>
	 </tr>
   <c:forEach items="${list}" var="obj">

   <tr>
    
		 <td> ${obj.id}</td>
		 <td> ${obj.userName }</td>
		 <td> ${obj.type}</td>
		 <td> ${obj.money }</td>
		 <td> ${obj.remark}</td>
		 <td> ${obj.time }</td>
		 <td><a href="#">编辑</a><a href="#">删除</a></td>
		 
   </tr>
</c:forEach>

</table>

    <div>   </div>
              
</div>
</body>
</html>