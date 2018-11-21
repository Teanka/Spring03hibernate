<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 20.11.18
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Persons</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    <label for="loginId"> Login:</label>
    <form:input type="text" path="login" id="loginId"/><br/>

    <label for="passwordId"> Password:</label>
    <form:input type="password" path="password" id="passwordId"/><br/>

    <label for="emailId"> email:</label>
    <form:input type="email" path="email" id="emailId"/><br/>

    <input type = "submit" value="save">

</form:form>
</body>
</html>
