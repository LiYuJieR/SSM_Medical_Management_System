<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/15
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>自助挂号</title>
    <!--Bootstrap-->
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
                <h1>
                    <small>医生结果查询</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>详细</th>

                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${patient.detail}</td>
                    </tr>
                </tbody>
            </table>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Patient/MainFrame/${patient.id}">回到主页</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Patient/Exit">退出登录</a>
        </div>

    </div>
</div>

</body>
</html>
