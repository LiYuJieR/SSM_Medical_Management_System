<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/11
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者${patient.name}主页</title>    <!--Bootstrap-->
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        h1{
            width: 250px;
            height: 48px;
            margin: 100px auto;
            text-align: center;
            line-height: 48px;

        }
        h3{
            width: 180px;
            height: 38px;
            margin: 100px auto;
            float: left;
            text-align: center;
            line-height: 38px;
            background: darkblue;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/Patient/Exit">退出登录</a>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">

            <div class="list-group">
                <a href="" class="list-group-item active">
                    功能</a>
                <a href="${pageContext.request.contextPath}/Patient/ToRegistration/0/${patient.id}" class="list-group-item">
                    自助挂号</a>
                <a href="${pageContext.request.contextPath}/Patient/SelfhelpPay/${patient.id}" class="list-group-item">
                    自助缴费</a>
                <a href="${pageContext.request.contextPath}/Patient/RegistrationInfor/${patient.id}" class="list-group-item">
                    挂号记录</a>
                <a href="${pageContext.request.contextPath}/Patient/Message/${patient.id}" class="list-group-item">
                    消息列表</a>
                <a href="${pageContext.request.contextPath}/Patient/SelfPage/${patient.id}" class="list-group-item">
                    结果查询</a>
                <a href="${pageContext.request.contextPath}/Patient/ToChangePhoneAndPassword/${patient.id}" class="list-group-item">
                    更换手机号/修改密码</a>
            </div>
        </div>
    </div>

</div>