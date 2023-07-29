<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<br><br>

<form action="hello-servlet" method="get">

    Enter The Date of the birth <input name="birth" type="date">
    <br><br>
    The age at the date of   <input name="age" type="date">
    <input value="calculate" type="submit">

</form>
</body>
</html>