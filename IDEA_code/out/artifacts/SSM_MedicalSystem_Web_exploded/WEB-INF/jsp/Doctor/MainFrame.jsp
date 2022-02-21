<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/9
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生${DocUser.username}的主页</title>
</head>
<body>
<div class="row clearfix">
    <div class="col-md-12 column">
        <dl class="dl-horizontal" style="text-align: -moz-right">
            <dt>医生姓名</dt>
            <dd>${DocUser.username}</dd>
            <dt>科室</dt>
            <dd>${department}</dd>
            <dt>级别</dt>
            <dd>${grade}</dd>
            <dt>电话</dt>
            <dd>${DocUser.phone}</dd>
            <dt>Email</dt>
            <dd><a href="https://mail.qq.com/">${DocUser.email}</a></dd>
            <dt>介绍</dt>
            <dd>${DocUser.detail}</dd>
        </dl>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/Registration/${DocUser.iddoctoruser}">挂号信息</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/PatientList/${DocUser.iddoctoruser}">病人列表</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/Message/${DocUser.iddoctoruser}">消息通知</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/Exit">退出登录</a>
    </div>
</div>

</body>
</html>
