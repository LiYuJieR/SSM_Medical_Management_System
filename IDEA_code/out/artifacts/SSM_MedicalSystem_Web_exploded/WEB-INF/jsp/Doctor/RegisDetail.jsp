<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>挂号信息</title>
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
                    <small>${doc.username}详情</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <tr>
                    <td class="column">病人姓名</td>
                    <td>${patient.name}</td>
                </tr>
                <tr>
                    <td class="column">性别</td>
                    <td>${gender}</td>
                </tr>
                <tr>
                    <td class="column">年龄</td>
                    <td>${patient.age}</td>
                </tr>
                <tr>
                    <td class="column">联系方式</td>
                    <td>${patient.phone}</td>
                </tr>
                <tr>
                    <td class="column">详情</td>
                    <c:choose>
                        <c:when test="${patient.detail==null}">
                            <td>暂无</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.detail}</td>
                        </c:otherwise>
                    </c:choose>

                </tr>
                <tr>
                    <td class="column">日期</td>
                    <td>${regis.day}</td>
                </tr>
                <tr>
                    <td class="column">起始时间</td>
                    <td>${regis.beginTime}</td>
                </tr>
                <tr>
                    <td class="column">结束时间</td>
                    <td>${regis.endTime}</td>
                </tr>
            </table>
            <br>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/SelectPatient/${DocId}/${patient.id}">绑定病人</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/Registration/${DocId}">返回</a>
        </div>

    </div>
</div>

</body>
</html>
