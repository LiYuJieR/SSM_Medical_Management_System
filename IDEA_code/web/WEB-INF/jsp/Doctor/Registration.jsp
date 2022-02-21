<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/9
  Time: 16:41
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
                    <small>${doc.username}医生所有挂号信息</small>
                </h1>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/ToAddRegis/${doc.iddoctoruser}">添加新号</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/Doctor/MainFrame/${Docid}">返回主页</a>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>医生编号</th>
                    <th>日期</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>是否预约</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="regist" items="${AllRegists}" varStatus="vs">
                    <tr>
                        <td>${regist.did}</td>
                        <td>${regist.day}</td>
                        <td>${regist.beginTime}</td>
                        <td>${regist.endTime}</td>
                            <c:choose>
                                <c:when test="${regist.registed==false}">
                                    <td>否</td>
                                </c:when>
                                <c:otherwise>
                                    <td>是</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/Doctor/RegisDetail/${regist.id}/${doc.id}">详情</a>
                                    </td>
                                </c:otherwise>
                            </c:choose>

                        <td>
                            <c:choose>
                                <c:when test="${regist.registed==false}">
                                    <a href="${pageContext.request.contextPath}/Doctor/DeleteRegis/${regist.id}/${doc.id}">删除</a>
                                </c:when>
                                <c:otherwise>
                                    <input type="button" onclick="disp_confirm()" value="删除"/></input>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                    <script>
                    function disp_confirm(){
                        var r=confirm("该时间段已被预约，请先与病人协调好再删除")
                        var docid= [[${doc.iddoctoruser}]];
                        var regisid=[[${regist.id}]];
                        if (r==true) {
                            window.location.href="${pageContext.request.contextPath}/Doctor/DeleteRegis/"+regisid+"/"+docid;
                        }
                        else{
                            window.location.href="${pageContext.request.contextPath}/Doctor/Registration/"+docid;
                        }
                    }
                    </script>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
</html>
