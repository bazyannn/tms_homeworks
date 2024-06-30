<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Films</title>
</head>
<body>
<p>
    Add new Film<br>
</p>

<form method="post" action="/">
    <b>Данные фильма:</b><br>
    <p>
        <input type="text" name="title" placeholder="title" ><br>
        <input type="text" name="description" placeholder="description"><br>
        <input type="number" name="year" placeholder="year"><br>
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
</form>

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
