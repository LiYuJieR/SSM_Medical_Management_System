<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号成功</title>
</head>

<body>
<script type="text/javascript">
    alert("取消挂号成功");
    window.document.location.href="${pageContext.request.contextPath}/Patient/MainFrame/${Pid}";
</script>

</body>
</html>

