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
        <%--тут показан тот жанр, который был выбран у фильма--%>
            <option disabled selected value="${film.genre}" >${film.genre}</option>
        <%--жанр который указан выше уже не активен в выборе(нет дубляжа) за счёт атрибута disabled(исправил из 26 домашки)--%>
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
