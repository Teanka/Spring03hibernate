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

    <%--<form:hidden path="createdate" value="${book.createdate}"/>--%>
    <form:input type="text" path="title" id="titleId"/><br/>
    <form:errors path="title" element="div"/>

    <label for="numberId"> Rating:</label>
    <form:input type="number" path="rating" id="numberId"/><br/>
    <form:errors path="rating"/>

    <label for="descriptionId"> Description:</label>
    <form:textarea type ="textarea" id="descriptionId" cols="30" rows="10" path="description"/><br/>
    <form:errors path="description"/>
    <br/><br/>

    <label for="publisherId">Publishers:</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId" /><br/>
    <form:errors path="publisher"/>

    <label for="authorId">Author:</label>
    <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" id="authorId" />
    <form:errors path="authors"/>

    <label for="pagesId"> Pages number::</label>
    <form:input type="number" path="pages" id="pagesId"/><br/>
    <form:errors path="pages"/>

    <br/><br/>
    <input type = "submit" value="save"><br/>

</form:form>
</body>
</html>
