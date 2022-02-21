<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定病人失败</title>
</head>

<body>
<script type="text/javascript">
    alert("该病人已由其他医生绑定");
    window.document.location.href="${pageContext.request.contextPath}/Doctor/Registration/${DocId}";
</script>

</body>
</html>
