<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mes" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit Film</title>
</head>
<body>
<p>
    <mes:message code="titleEdit"/><br>
</p>

<sp:form action="/edit" method="post" modelAttribute="filmmodel" >
    <b><mes:message code="descriptionFilm"/></b><br>
    <p>
        <sp:input path="id" name="id" type="hidden" value="${film.id}"/>
        <sp:input path="title" type="text" name="title" placeholder="title" value="${film.title}"/><sp:errors path="title"/><br>
        <sp:input path="description" type="text" name="description" placeholder="description" value="${film.description}"/><br>
        <sp:input path="year" type="number" name="year" placeholder="year" value="${film.year}"/><sp:errors path="year"/><br>
    </p>
    <%--делал для себя Enum--%>
    <b><mes:message code="descriptionGenre"/></b><Br>
    <p>
        <sp:select path="genre" name="genre">
            <%--тут показан тот жанр, который был выбран у фильма и решена проблема помнить, что надо выбрать genre, иначе genre = null и Exeption--%>
            <option disabled selected value="${film.genre}" >${film.genre} <sp:errors path="genre"/></option>
            <%--жанр который указан выше уже не активен в выборе(нет дубляжа) за счёт атрибута disabled--%>
            <c:forEach items="${genres}" var="genre">
                <option value="${genre}">${genre}</option>
            </c:forEach>
        </sp:select>
    </p>

    <p>
        <mes:message code="descriptionView"/>
        <c:if test="${film.isViewed == true}">
            <input type="checkbox" checked name="viewed">
        </c:if>
        <c:if test="${film.isViewed == false}">
            <input type="checkbox" name="viewed">
        </c:if>
    </p>
    <input type="submit" value="<mes:message code="update"/>">

</sp:form>

</body>
</html>
