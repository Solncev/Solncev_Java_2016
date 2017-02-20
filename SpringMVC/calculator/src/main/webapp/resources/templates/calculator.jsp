<!doctype html>
<html lang="en">
<head>
    <title></title>
</head>
<body>
<form method="post" action="">
    <label>
        <input name="first" type="number" value="0" min="0">
    </label>
    <label>
        <select name="operator">
            <option value="PLUS">+</option>
            <option value="MINUS">-</option>
            <option value="DIV">/</option>
            <option value="MULT">*</option>
        </select>
    </label>
    <label>
        <input name="second" type="number" value="0" min="0">
    </label>
    <button type="submit">calculate</button>
</form>
</body>
</html>