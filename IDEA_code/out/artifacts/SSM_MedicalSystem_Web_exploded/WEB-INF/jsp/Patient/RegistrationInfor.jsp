<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>挂号记录</title>
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
                    <small>挂号记录</small>
                </h1>
            </div>
        </div>
    </div>
</div>
<div class="row clearfix">
    <div class="col-md-12 column">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>科室</th>
                <th>医生姓名</th>
                <th>级别</th>
                <th>日期</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="registration" items="${registrations}" varStatus="vs">
                <tr>
                    <td>${doctorusers.get(vs.index).departmentid}</td>
                    <td>${doctorusers.get(vs.index).username}</td>
                    <td>${doctorusers.get(vs.index).gradeid}</td>
                    <td>${registration.day}</td>
                    <td>${registration.beginTime}</td>
                    <td>${registration.endTime}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/Patient/CancelRegist/${registration.id}/${patientId}">取消挂号</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Patient/MainFrame/${patientId}">返回主页</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Patient/Exit">退出登录</a>
    </div>

</div>
</body>
</html>
