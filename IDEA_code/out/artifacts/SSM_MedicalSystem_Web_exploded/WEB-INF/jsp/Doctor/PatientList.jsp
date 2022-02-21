<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 15:31
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
                    <small>${doc.username}医生所有病人信息</small>
                </h1>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/MainFrame/${Doc.iddoctoruser}">返回主页</a>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>联系方式</th>
                    <th>具体描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="patient" items="${patients}" varStatus="vs">
                    <tr>
                        <td>${patient.name}</td>
                        <c:choose>
                            <c:when test="${patient.gender==male}">
                                <td>男</td>
                            </c:when>
                            <c:otherwise>
                                <td>女</td>
                            </c:otherwise>
                        </c:choose>

                        <td>${patient.age}</td>
                        <td>${patient.phone}</td>
                        <c:choose>
                            <c:when test="${patient.detail==null}">
                                <td>暂无</td>
                            </c:when>
                            <c:otherwise>
                                <td>${patient.detail}</td>
                            </c:otherwise>
                        </c:choose>
                        <td><a href="${pageContext.request.contextPath}/Doctor/Diagnosis/${DocId}/${patient.id}">诊断</a></td>
                        <td><a href="${pageContext.request.contextPath}/Doctor/ReleaseBinding/${patient.id}/${DocId}">解除绑定</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
</html>

