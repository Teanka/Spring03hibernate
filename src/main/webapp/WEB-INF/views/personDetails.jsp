<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 20.11.18
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person Details</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    <label for="loginId"> Login:</label>
    <form:input type="text" path="login" id="loginId"/><br/>

    <label for="passwordId"> Password:</label>
    <form:input type="password" path="password" id="passwordId"/><br/>

    <label for="emailId"> email:</label>
    <form:input type="email" path="email" id="emailId"/><br/>

    <label for="firstNameId"> First name:</label>
    <form:input type="text" path="firstName" id="firstNameId"/><br/>

    <label for="lastNameId"> Last Name:</label>
    <form:input type="text" path="lastName" id="lastNameId"/><br/>

    <label for="sex"> Gender: </label>
    Male: <form:radiobutton path="sex" value="M" id="sex"/>
    Female: <form:radiobutton path="sex" value="F" id="sex"/>

    <br/><br/>

    <label for="countryId">Country:</label>
    <form:select path="country" items="${countries}" id="countryId" />

    <br/><br/>

    <label for="notesId"> Notes:</label>
    <form:textarea type ="textarea" id="notesId" cols="30" rows="10" path="notes"/><br/>

    <br/><br/>

    <label for="mailing"></label>
    mailing list:<form:checkbox path="mailingList" id="mailing"/><br/>

    <br/><br/>

    <label for="skillId">Skills:</label>
    <form:select path="skills" items="${skills}" id="skillId" multiple="true"/><br/>

    <br/><br/>

    <label for="hobbiesId"></label>
    <form:checkboxes items="${hobbies}" path="hobbies" id="hobbiesId"/><br/>

    <input type = "submit" value="save"><br/>

</form:form>

</body>
</html>
