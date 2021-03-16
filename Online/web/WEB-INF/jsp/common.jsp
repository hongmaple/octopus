<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common_top_style.css">
</head>
<script type="text/javascript">
    	function exitSystem(){
    		window.parent.location.href="${pageContext.request.contextPath}/logout.action";
    	}
    </script>
<body>
	<div id="top">
		<c:if test="${USER_SESSION.identity eq '学生' }">
			<h2>欢迎使用在线考试系统[学生端]</h2>
			<c:out value="你好，${USER_SESSION.name }同学"/>
		</c:if>
		<c:if test="${USER_SESSION.identity eq '教师' }">
			<h2>欢迎使用在线考试系统[教师端]</h2>
			<c:out value="你好，${USER_SESSION.name }老师"/>
		</c:if>
		<c:if test="${USER_SESSION.identity eq '管理员' }">
			<h2>欢迎使用在线考试系统[管理员端]</h2>
			<c:out value="你好，${USER_SESSION.name }管理员"/>
		</c:if>
		&nbsp;&nbsp;&nbsp;
		[ <a href="javascript:exitSystem()" id="logout">退出</a> ]
	</div>
</body>
</html>