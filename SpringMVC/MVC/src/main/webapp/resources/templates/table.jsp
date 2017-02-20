<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Table</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<table border="1px">
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Пол</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.patronymic}</td>
            <td>${user.date}</td>
            <td>
                <c:choose>
                    <c:when test="${user.gender == ''}">
                    </c:when>
                    <c:otherwise>
                        ${user.gender}
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/">на главную</a>
</body>
</html>
