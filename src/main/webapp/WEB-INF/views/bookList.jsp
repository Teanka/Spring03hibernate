<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: teanka--%>
  <%--Date: 20.11.18--%>
  <%--Time: 15:37--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>BookList</title>--%>
    <%--<script>--%>
        <%--function confirmDelete(id, title,proposition) {--%>
            <%--if (confirm("Do you really want to delete " + title + "\"")) {--%>
                <%--window.location.href = "/book/delete/" + id;--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table border="1px solid black">--%>
    <%--<thead>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<tr>--%>
        <%--<th>Title</th>--%>
        <%--<th>Rating</th>--%>
        <%--<th>Publisher</th>--%>
        <%--<th>Description</th>--%>
        <%--<th>Delete</th>--%>
        <%--<th>Edit</th>--%>

    <%--</tr>--%>
    <%--<c:forEach var="book" items="${books}">--%>
        <%--<tr>--%>
            <%--<td>${book.title}</td>--%>
            <%--<td>${book.rating}</td>--%>
            <%--<td>${book.publisher.name}</td>--%>
            <%--<td>${book.description}</td>--%>
            <%--<td>--%>
                <%--<a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">Delete</a>--%>
            <%--</td>--%>
            <%--&lt;%&ndash;<td><a href="/book/delete/${book.id}" onclick=""confirmDelete(${book.id} ${book.title}>Delete</a></td>&ndash;%&gt;--%>
            <%--<td><a href="/book/edit/${book.id}">Edit</a></td>--%>
        <%--</tr>--%>
        <%--&lt;%&ndash;<c:if test="${propositions}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td>TAK</td>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 20.11.18
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookList</title>
    <script>
        function confirmDelete(id, title,proposition) {
            if(proposition===true){
                window.location.href = "/proposition/delete/" +id;
            } else{
                window.location.href = "/book/delete/" + id;
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
        <th>Title</th>
        <th>Rating</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Delete</th>
        <th>Edit</th>

    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
            <td>${book.description}</td>
            <td>
                <a href="#" onclick="confirmDelete(${book.id}, '${book.title}', ${book.proposition})">Delete</a>
            </td><td>
            <c:if test="${propositions}">
                <a href="/proposition/edit/${book.id}">Edit</a>
            </c:if>
            <c:if test="${!propositions}">
                <a href="/book/edit/${book.id}">Edit</a>
            </c:if>
        </td>
            <c:if test="${propositions}">
                <td>TAK</td>
            </c:if>
        </tr>
        <%--<td>--%>
        <%--<a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">Delete</a>--%>
        <%--</td>--%>
        <%--<td><a href="/book/delete/${book.id}" onclick=""confirmDelete(${book.id} ${book.title}>Delete</a></td>--%>
        <%--<td><a href="/book/edit/${book.id}">Edit</a></td>--%>
        <%--</tr>--%>
        <%--<c:if test="${propositions}">--%>
        <%--<td>TAK</td>--%>
        <%--</c:if>--%>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
