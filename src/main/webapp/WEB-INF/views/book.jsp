<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 20.11.18
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <label for="titleId"> Title:</label>
    <form:input type="text" path="title" id="titleId"/><br/>

    <label for="numberId"> Rating:</label>
    <form:input type="number" path="rating" id="numberId"/><br/>

    <%--<label for="emailId"> email:</label>--%>
    <%--<form:input type="email" path="email" id="emailId"/><br/>--%>

    <%--<label for="firstNameId"> First name:</label>--%>
    <%--<form:input type="text" path="firstName" id="firstNameId"/><br/>--%>

    <%--<label for="lastNameId"> Last Name:</label>--%>
    <%--<form:input type="text" path="lastName" id="lastNameId"/><br/>--%>

    <%--<label for="sex"> Gender: </label>--%>
    <%--Male: <form:radiobutton path="sex" value="M" id="sex"/>--%>
    <%--Female: <form:radiobutton path="sex" value="F" id="sex"/>--%>

    <%--<br/><br/>--%>



    <label for="descriptionId"> Description:</label>
    <form:textarea type ="textarea" id="descriptionId" cols="30" rows="10" path="description"/><br/>

    <br/><br/>

    <%--<label for="mailing"></label>--%>
    <%--mailing list:<form:checkbox path="mailingList" id="mailing"/><br/>--%>

    <%--<br/><br/>--%>

    <label for="publisherId">Publishers:</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId" /><br/>

    <%--<br/><br/>--%>

    <%--<label for="hobbiesId"></label>--%>
    <%--<form:checkboxes items="${hobbies}" path="hobbies" id="hobbiesId"/><br/>--%>
    <label for="authorId">Author:</label>
    <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" id="authorId" />

    <br/><br/>
    <input type = "submit" value="save"><br/>

</form:form>
</body>
</html>
