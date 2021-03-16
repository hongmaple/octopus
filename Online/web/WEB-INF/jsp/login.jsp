<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎使用睿智考试网</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login_style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/jquery-3.5.1/jquery-3.5.1.min.js"></script>
    <script src=".${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="col-md-12 headfontsize">
                    <h1 class="headh1content">
                     睿智考试网站
                    </h1>
                    <h2 class="headh2content">
                    在这里，你将能够巩固你的知识<br>
                    拓展你的视野，成绩将更上一层楼
                    </h2>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2" id="myAlert">
                <div class="col-md-12">
                    <div class="alert alert-info" role="alert">
                        <strong>温馨提示：</strong>${msg }
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2" id="login">
                <div class="col-md-9 col-md-offset-2">
                    <center><h2>用户登录</h2></center>
                    <form role="form" method="post" id="log" action="${pageContext.request.contextPath}/login.action">
                        <div class="form-group">
                            <img src="${pageContext.request.contextPath}/images/user.png" id="user">
                            <label>账号：</label>
                            <input type="text" class="form-control" id="sno" name="sno">
                        </div>
                        <div class="form-group">
                            <img src="${pageContext.request.contextPath}/images/key.png" id="key">
                            <label>密码：</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="form-group">
                            <img src="${pageContext.request.contextPath}/images/user_edit.png" id="l1">
                            <label>验证码：</label>
                            <div class="row">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="verifycode" name="verifycode">
                                </div>
                                 <div class="col-sm-6">
                                    <img src="${pageContext.request.contextPath }/getVerifyCode.action"  width="110" height="34" id="verifyCodeImage" onclick="this.src=this.src+'?'">
                                </div>
                            </div>
                        </div>
                        <div class="turn">
                            <a href="${pageContext.request.contextPath }/toRegister.action" id="register">用户注册    |</a>
                            <a href="${pageContext.request.contextPath }/toChange.action" id="forget">忘记密码?</a><br>
                        </div>
                        <div class="buttons">
                            <input type="submit" class="btn btn-primary" id="sub" role="button" value="登录">
                            <input type="reset" class="btn btn-primary" role="button" value="重置">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>