<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mes" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Films</title>
</head>
<body>
    <mes:message code="title"/>

    <p>
        <mes:message code="localisation"/> <a href="//?lang=en">En</a>/<a href="//?lang=ru">Ru</a>
   </p><br>

<p>
    <mes:message code="descriptionAddFilm"/><br>
</p>

<sp:form method="post" action="/" modelAttribute="filmmodel" >
    <b>Данные фильма:</b><br>
    <p>
        <sp:input path="title" type="text" name="title" placeholder="title"/> <sp:errors path="title"/> <br>
        <sp:input path="description" type="text" name="description" placeholder="description"/><br>
        <sp:input path="year" type="number" name="year" placeholder="year"/><sp:errors path="year"/><br>
    </p>

    <b>Отметьте жанр фильма :</b><Br>
    <p>
        <select name="genre">
            <c:forEach items="${genres}" var="genre">
                <option value="${genre}">${genre}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        Вы смотели этот фильм:<input type="checkbox" name="viewed" value="viewed">
    </p>
    <input type="submit" value="save">
</sp:form>

<hr>

<ul>
    <c:forEach items="${films}" var="film">
        <li>

                ${film.title} --- ${film.description} --- ${film.genre} --- ${film.year} --- ${film.isViewed}
            --- <a href="<c:url value="/edit?id=${film.id}"/> "> Edit </a>
            --- <a href="<c:url value="/delete?id=${film.id}"/> "> Delete </a>
        </li>
    </c:forEach>
</ul>

<hr>

<form action="/search" method="post">
    <input type="text" placeholder="search" name="search"><br>
    <p>
        <input type="submit" value="search">
    </p>
</form>

</body>
</html>
