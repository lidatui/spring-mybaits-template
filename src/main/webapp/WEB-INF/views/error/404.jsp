<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(404);%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
	<title>404 - 页面不存在</title>
</head>

<body>
	<h2>404 - 页面不存在.</h2>
	<p><a href="<c:url value="/index.action"/>">返回首页</a></p>
</body>
</html>