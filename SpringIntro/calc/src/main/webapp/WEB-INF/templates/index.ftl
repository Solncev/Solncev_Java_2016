<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <title></title>
</head>
<body>
<form method="post" action="/calculator">
    <input name="first" type="number" value="0" min="0">
    <select name="operator">
        <option value="PLUS">+</option>
        <option value="MINUS">-</option>
        <option value="DIV">/</option>
        <option value="MULT">*</option>
    </select>
    <input name="second" type="number" value="0" min="0">
    <button type="submit">calculate</button>
</form>


</body>
</html>