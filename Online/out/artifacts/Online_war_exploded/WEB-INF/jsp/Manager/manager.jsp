<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用在线考试系统管理员端</title>
</head>
<body>
	<div id="top">
		<div id="image">
		<img src="${pageContext.request.contextPath }/image/top.jpg">
		</div>
		<div id="message">
		<h1>在线考试网站管理员端</h1>
		<p>您好！${USER_SESSION.name }管理员</p>
		[&nbsp;<a href="${pageContext.request.contextPath }/logout.action">退出</a>&nbsp;]
		</div>
	</div>
</body>
</html>