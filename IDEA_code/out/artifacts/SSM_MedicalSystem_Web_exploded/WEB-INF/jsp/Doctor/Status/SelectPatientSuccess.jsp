<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定病人成功</title>
</head>

<body>
<script type="text/javascript">
    alert("绑定该病人成功");
    window.document.location.href="${pageContext.request.contextPath}/Doctor/PatientList/${DocId}";
</script>

</body>
</html>
