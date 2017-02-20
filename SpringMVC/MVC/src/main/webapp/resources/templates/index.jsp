<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form method="post" action="table">
    ваше имя: <input type="text" name="name">
    ваша фамилия: <input type="text" name="surname">
    ваше отчество: <input type="text" name="patronymic">
    <input type="date" name="date">
    <select name="gender">
        <option selected value="">Пол</option>
        <option value="female">Ж</option>
        <option value="male">M</option>
    </select>
    <button type="submit">ok</button>
</form>
</body>
</html>
