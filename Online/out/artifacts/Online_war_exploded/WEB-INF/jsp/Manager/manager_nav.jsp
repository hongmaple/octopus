<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common_nav_style.css">
  </head>
  
  <body>
    <ul>
    	<li>
    		<h3>教务管理</h3>
    		<dl>
    			<dd>
    				<a href="teacher_info.jsp" target="rightframe">教务信息</a>
    			</dd>
    			<dd>
    				<a href="${pageContext.request.contextPath }/ShowStuPage" target="rightframe">考生管理</a>
    			</dd>
    			<dd>
    				<a href="${pageContext.request.contextPath }/ShowScorePage" target="rightframe">成绩管理</a>
    			</dd>
    			<dd>
    				<a href="../Student/student_pw.jsp" target="rightframe">修改密码</a>
    			</dd>
    		</dl>
    	</li>
    	<li>
    		<h3>题库管理</h3>
    		<dl>
    		<dd>
    			<a href="${basepath }/ShowQuePage" target="rightframe">试卷管理</a>
    		</dd>
    		<dd>
    			<a href="teacher_que_add.jsp" target="rightframe">题库录入</a>
    		</dd>
    		</dl>
    	</li>
    </ul>
  </body>
</html>
