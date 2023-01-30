<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Get All</title>
</head>
<body>
<h1>Get All!</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>TITLE</th>
        <th>AUTHOR</th>
        <th>TYPE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><a href = "
                <c:url value = "/book/edit">
                    <c:param name="id" value="${book.id}" />
                </c:url>
            ">${book.id}</a>
            </td>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.bookType.type}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
