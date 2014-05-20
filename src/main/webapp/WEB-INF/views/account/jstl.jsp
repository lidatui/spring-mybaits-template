<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
</head>
<body>

<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.realName}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>

上一页: ${usersPaginator.prePage} <br>
当前页: ${usersPaginator.page} <br>
下一页: ${usersPaginator.nextPage} <br>
总页数: ${usersPaginator.totalPages} <br>
总条数: ${usersPaginator.totalCount} <br>
</body>
</html>
