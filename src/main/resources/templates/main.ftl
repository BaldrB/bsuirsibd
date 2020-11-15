<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="${title}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Привет, ' + ${title} + '!'" />
<div>
    <h1 th:text="${col1}" />
    <div th:each="el : ${post}">
        <span th:text="${el.idviewg}"/>
        <span th:text="${el.viewg}"/>
        <span th:text="${el.viewg_id}"/>
    </div>
    <a href="/add">Добавить запись</a>
</div>
</body>
</html>