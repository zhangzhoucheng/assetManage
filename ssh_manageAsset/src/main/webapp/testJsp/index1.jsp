<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
isELIgnored="false"
%>
 <%@ include file="/common/taglibs.jsp"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="QingShiXun">
<title>用于测试输出结果</title>

<!-- 引入样式文件 -->
<link href="plugins/bootstrap/bootstrap.min.css" rel="stylesheet">

<link href="styles/default.css" rel="stylesheet">

</head>
<body class="page-body">
	<div id="page-container">
		<div id="main-container">
			<div id="page-content">
				<div class="content-header">
					<div class="header-section">
						<h1>
							<img class="" src="images/logo-white.png"> <i class="fa fa-table"></i> 案例项目-数据分页
						</h1>
					</div>
				</div>
				<div class="block full">
					<div class="block-title">
						<h2>基于Spring、JDBC、JSTL技术实现的数据分页显示</h2>
					</div>
					<div class="block-content-full ">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>NO</th>
									<th>地区</th>
									<th>月分</th>
									<th>销售金额</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${transaction}">
									<tr>
										<td>${item.id}</td>
										<td>${item.region}</td>
										<td>${item.month}</td>
										<td>${item.amount}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- 自定义分页处理TagLib -->
					
			        <zzPage:page pageSize="4" pageNo="1" url="index" totalCount="${transaction.size}"/>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入 js 库文件 -->
	<script src="plugins/jquery-1.11.1.min.js"></script>
	<script src="plugins/bootstrap/bootstrap.min.js"></script>
</body>
</html>