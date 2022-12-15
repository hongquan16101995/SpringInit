<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${requestScope.customers}" var="c">
        <tr>
            <td><c:out value="${c.getId()}"/></td>
            <td><c:out value="${c.getName()}"/></td>
            <td><c:out value="${c.getEmail()}"/></td>
            <td><c:out value="${c.getAddress()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
