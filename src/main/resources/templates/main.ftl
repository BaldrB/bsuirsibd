<!DOCTYPE HTML>
<html leng="en">
<head>
    <title> Главная страница </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p>${title}</p>
<div>
    <a href="/add">Добавить запись</a>
</div>
<#list View as Viewg>
<table>
    <tr>
        <td>ID</td>
        <td>${View.idviewg}</td>
    </tr>
    <tr>
        <td>Наименование</td>
        <td>${View.viewg}</td>
    </tr>
    <tr>
        <td>Дополнительный ид</td>
        <td>${View.viewg_id}</td>
    </tr>
</table>
<#else>
No massage
</#list>

</body>
</html>