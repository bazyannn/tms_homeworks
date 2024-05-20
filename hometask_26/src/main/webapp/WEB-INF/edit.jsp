<%--
  Created by IntelliJ IDEA.
  User: ScorpioN
  Date: 18.05.2024
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Film</title>
</head>
<body>
<p>
    Edit Film<br>
</p>

<form action="/edit" method="post">
    <b>Данные фильма:</b><br>
    <p>
        <input name="id" type="hidden" value="${film.id}">
        <input type="text" name="title" placeholder="title" value="${film.title}"><br>
        <input type="text" name="description" placeholder="description" value="${film.description}"><br>
        <input type="number" name="year" placeholder="year" value="${film.year}"><br>
    </p>
<%--делал для себя Enum--%>
    <b>Отметьте жанр фильма :</b><Br>
    <p>
        <select name="genre">
            <option selected value="${film.genre}" >${film.genre}</option>
            <c:forEach items="${genres}" var="genre">
                <option value="${genre}">${genre}</option>
            </c:forEach>
        </select>
    </p>

    <p>
        Вы смотели этот фильм:
        <c:if test="${film.isViewed == true}">
            <input type="checkbox" checked name="viewed">
        </c:if>
        <c:if test="${film.isViewed == false}">
            <input type="checkbox" name="viewed">
        </c:if>
    </p>
    <input type="submit" value="update">

</form>

</body>
</html>
