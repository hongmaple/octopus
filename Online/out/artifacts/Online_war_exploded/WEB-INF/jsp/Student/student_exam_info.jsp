<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/11/29
  Time: 8:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/" %>
<html>
<head>
    <title>睿智在线考试网学生端</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/manager_main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/student_exam_paper_style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/square/square.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/jquery-3.5.1/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/icheck.js"></script>
</head>
    <%
	long curTime = System.currentTimeMillis() / 1000;
	request.setAttribute("curTime", curTime);
%>
<c:if test="${empty endTime}">
    <c:set var="endTime" scope="session" value="${curTime+sessionScope.examTime*60}" />
</c:if>
<script>
    var second =(${sessionScope.endTime-curTime});
    var timer=null;
    var showTime = function(){
        var s = second % 60; // 秒
        var mi = (second - s) / 60 % 60; // 分钟
        var h = ((second - s) / 60 - mi ) / 60 % 24; // 小时
        return h + "时" + mi + "分" + s + "秒";
    }

    timer=setInterval(function(){
        second --;
        document.getElementById("times").innerHTML = showTime ();
        if(second<=0){
            second=0;
            clearInterval(timer);
            alert("作答时间结束！");
            document.getElementById("paperForm").submit();
        }
    }, 1000);
    $(document).ready(function() {
        $('input').iCheck({
            checkboxClass : 'icheckbox_square',
            radioClass : 'iradio_square',
            increaseArea : '20%' // optional
        });
        $("input:radio").on('ifClicked',function(){
            var opt=$(this).val();$('.ans'+this.name).html(opt);
        });
        $("input:checkbox").on('ifChecked',function(){
            var opt=$(this).val();$("#s"+this.name+opt).append(opt);
        });
        $("input:checkbox").on('ifUnchecked',function(){
            var opt=$(this).val();$("#s"+this.name+opt).empty(opt);
        });
        $("input:text").on('change',function(){
            var opt=$(this).val();$('.ans'+this.name).html(opt);
        });
    });

</script>
<body>
<%--    顶部导航栏--%>
<div class="navbar-inverse navbar-static-top" role="navigation" id="top-menu">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand" id="title">睿智在线考试学生端</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/toStudentFirst.action">首页</a> </li>
            <li><a href="${pageContext.request.contextPath}/toManagerInformation.action">个人信息管理</a> </li>
            <li class="active"><a href="${pageContext.request.contextPath}/toPaperList.action">在线考试</a> </li>
            <li><a href="${pageContext.request.contextPath}/toStudentScoreList.action">成绩查询</a> </li>
            <li><a href="${pageContext.request.contextPath}/toManagerAbout.action">关于系统</a> </li>
        </ul>
        <div class="navbar-right" id="myUserList">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="myUser">
                    <span>您好，</span>
                    <span id="uu"> ${USER_SESSION.name}</span>
                    <span>同学</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/toManagerInformation.action">资料编辑</a> </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/toManagerChange.action">修改密码</a> </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/logout.action">退出登录</a> </li>
                </ul>
            </li>
        </div>
    </div>
</div>
<div class="row">
    <%--左边导航栏    --%>
    <div class="col-md-2" >
        <div id="left-menu">
            <div class="p">
                <div>
                    <img src="${pageContext.request.contextPath}/images/protrait.png" class="img-circle" id="protrait">
                </div>
                <div class="pratrait-title">
                    <h4>${USER_SESSION.name}</h4>
                </div>

            </div>

            <ul id="main-nav" class="nav nav-tabs nav-stacked">
                <li>
                    <a href="${pageContext.request.contextPath}/toStudentFirst.action" >
                        <i class="glyphicon glyphicon-th-large"></i>
                        首页
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toManagerInformation.action">
                        <i class="glyphicon glyphicon-credit-card"></i>
                        个人信息管理
                    </a>
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/toPaperList.action">
                        <i class="glyphicon glyphicon-user"></i>
                        在线考试
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toStudentScoreList.action">
                        <i class="glyphicon glyphicon-calendar"></i>
                        成绩查询
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toManagerAbout.action">
                        <i class="glyphicon glyphicon-adjust"></i>
                        关于系统
                    </a>
                </li>
            </ul>
        </div>
    </div>
<%--右边主要内容--%>
        <c:set var="count" scope="request" value="0"></c:set>
    <div class="col-md-10">
        <div class="right-title" style="margin-top: 10px">
            <p>当前位置：在线考试 > ${paper.qty_name}</p>
        </div>
        <div>
            <hr>
        </div>
        <div class="panel panel-default">
            <div class="panel-body">
                <h4 style="color: red">温馨提示：</h4>
                <p>你已参加这门考试<span style="color: red">${number}</span>次！</p>
            </div>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/calScore.action" method="post" name="paper" id="paperForm">
                <c:forEach var="que" items="${sessionScope.ques}" varStatus="status">
                    <c:choose>
                        <c:when test="${que.type eq '单选题'}">
                            <c:if test="${count==0}">
                                <h3>一、单选题</h3>
                                <c:set value="${count+1}" var="count"></c:set>
                            </c:if>

                            <div class="que">
                                <span id="${que.id}">${que.id}&nbsp;.&nbsp; </span><span>${que.title}</span>
                                <br> <br>
                                <div class="option">
                                    <label><input type="radio" name="${que.id}" value="A" />A.${que.options[0]}</label><br />
                                    <label><input type="radio" name="${que.id}" value="B" />B.${que.options[1]}</label><br />
                                    <label><input type="radio" name="${que.id}" value="C" />C.${que.options[2]}</label><br />
                                    <label><input type="radio" name="${que.id}" value="D" />D.${que.options[3]}</label><br />
                                </div>
                            </div>
                            <hr>
                        </c:when>

                        <c:when test="${que.type eq '多选题'}">
                            <c:if test="${count==1}">
                                <h3>二、多选题</h3>
                                <c:set value="${count+1}" var="count"></c:set>
                            </c:if>
                            <div class="que">
                                <span id="${que.id}">${que.id}&nbsp;.&nbsp;</span> <span>${que.title}</span>
                                <div class="option">
                                    <label><input type="checkbox" name="${que.id}" value="A" />A.${que.options[0]}</label><br />
                                    <label><input type="checkbox" name="${que.id}" value="B" />B.${que.options[1]}</label><br />
                                    <label><input type="checkbox" name="${que.id}" value="C" />C.${que.options[2]}</label><br />
                                    <label><input type="checkbox" name="${que.id}" value="D" />D.${que.options[3]}</label><br />
                                </div>
                            </div>
                            <hr>
                        </c:when>


                        <c:when test="${que.type eq '判断题'}">
                            <c:if test="${count==2}">
                                <h3>三、判断题</h3>
                                <c:set value="${count+1}" var="count"></c:set>
                            </c:if>
                            <div>
                                <span id="${que.id}">${que.id}&nbsp;.&nbsp; </span><span>${que.title}</span>
                                <div class="option">
                                    <label><input type="radio" name="${que.id}" value="对" />对</label>
                                    <label><input type="radio" name="${que.id}" value="错" />错</label>
                                </div>
                                <br />
                            </div>
                            <hr>
                        </c:when>


                        <c:when test="${que.type eq '填空题'}">
                            <c:if test="${count==3}">
                                <h3>四、填空题</h3>
                                <c:set value="${count+1}" var="count"></c:set>
                            </c:if>
                            <div class="que">
                                <span id="${que.id}">${que.id}&nbsp;.&nbsp;</span><span>${que.title}</span>
                                <input type="text" name="${que.id}" placeholder="请在此处作答" />
                            </div>
                            <br>
                            <hr>
                        </c:when>


                        <c:when test="${que.type eq '简答题'}">
                            <c:if test="${count==4}">
                                <h3>五、简答题</h3>
                                <c:set value="${count+1}" var="count"></c:set>
                            </c:if>
                            <div class="que">
                                <span id="${que.id}">${que.id}&nbsp;.&nbsp; </span><span>${que.title}</span>
                                <div class="option">
                                    <textarea rows="6" cols="50" name="${que.id}"></textarea>
                                </div>
                            </div>
                            <hr>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </form>
            <div id="submit">
                <input type="button" class="btn btn-danger" value="提交答卷" id="examEnd"
                       onclick="javascript:if(confirm('考试时间尚未结束，确认交卷吗？')){paper.submit()}" />
            </div>
        </div>
    </div>
</div>
<c:set value="0" var="count"></c:set>
<div id="showTime">
    <div class="navs">
        时间剩余：
        <hr>
        <div id="times"></div>
    </div>
</div>

</body>
</html>
