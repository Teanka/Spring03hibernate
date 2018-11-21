<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 21.11.18
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <label for="firstNameId"> First Name:</label>
    <form:input type="text" path="firstName" id="firstNameId"/><br/>

    <label for="lastNameId"> Last Name:</label>
    <form:input type="text" path="lastName" id="lastNameId"/><br/>

    <br/><br/>
    <input type = "submit" value="save"><br/>

</form:form>
</body>
</html>
