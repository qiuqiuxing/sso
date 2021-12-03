<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="<%= basePath%>user/login" method="post">
    <span>用户名:</span><input type="text" name="username"/>
    <span>密&nbsp;&nbsp;码</span><input type="password" name="password"/>
    <input type="hidden" name="gotoUrl" value="${gotoUrl}">
    <input type="submit"/>
</form>
</body>
</html>
