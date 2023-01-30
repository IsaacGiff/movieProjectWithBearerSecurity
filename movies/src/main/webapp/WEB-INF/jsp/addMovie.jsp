<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Movie</title>

    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

</head>
    <body>
        <h1>We are on the poster page!</h1>

        <c:if test="${addMovieSuccess}">
            <div id="success">Successfully added Book with Title: ${addMovieTitle}</div>
        </c:if>

        <form:form action="/movie" method="post" modelAttribute="movie">
        <form:errors path="*" cssClass="errorblock" element="div" />
            <form:label path="id">ID: </form:label> <form:input path="id" type="text" />
            <form:label path="isbn">ISBN: </form:label> <form:input path="isbn" type="text"/>
            <form:label path="title">TITLE: </form:label> <form:input path="title" type="text"/>
            <form:select path="movieType">
                <form:options items="${movieTypeList}" itemLabel="type" itemValue="id" />
            </form:select>
            <input id="submit" type="submit" value="submit">
        </form:form>
    </body>
</html>
