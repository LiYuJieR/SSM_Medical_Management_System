<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/7
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <style>
      a {
        text-decoration: none;
        color: black;
        font-size-adjust: initial;
      }

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
        text-align: center;
        line-height: 38px;
        background: skyblue;
        border-radius: 5px;
      }
    </style>
  </head>
  <body>
  <h1>
    <small>医疗自助管理系统</small>
  </h1>
  <h3>
    <a href="${pageContext.request.contextPath}/Doctor/Login">医生登录</a>
  </h3>
  <h3>
    <a href="${pageContext.request.contextPath}/Patient/Login">患者登录</a>
  </h3>
  <h3>
    <a href="${pageContext.request.contextPath}/Admin/Login">管理员登录</a>
  </h3>
  <address>
    <strong>大连医科大学附属第二医院</strong><br>
    中山路467号<br>
    大连市沙河口区<br>
    <abbr title="Phone">P:</abbr> 0411-84671291
  </address>

  <address>
    <strong>Creator</strong><br>
    <a href="mailto:#">lyj_dagong@163.com</a>
  </address>
  </body>
</html>
