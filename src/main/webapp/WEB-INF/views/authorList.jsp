<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 21.11.18
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors list</title>
    <script>
        function confirmDelete(id, fullName) {
            if (confirm("Do you really want to delete " + fullName + "\"")) {
                window.location.href = "/author/delete/" + id;
            }
        }
    </script>
</head>
<body>
<table border="1px solid black">
    <thead>
    </thead>
    <tbody>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="#" onclick="confirmDelete(${author.id}, '${author.fullName}')">Delete</a>
            </td>
                <%--<td><a href="/book/delete/${book.id}" onclick=""confirmDelete(${book.id} ${book.title}>Delete</a></td>--%>
            <td><a href="/author/edit/${author.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
