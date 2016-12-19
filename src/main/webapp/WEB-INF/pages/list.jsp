<%--
  Created by IntelliJ IDEA.
  User: aa001
  Date: 12/8/16
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>My books</title>
    <link rel='stylesheet'
          href='${pageContext.request.contextPath}/static/css/main.css'
          type='text/css' />
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>My books</h1>
<c:if test="${empty booklist}">
    <div>
       You haven't created or updated any books yet. <a href="/createbook" type="button">Create One</a>
    </div>
</c:if>

<c:if test="${not empty booklist}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Year</th>
            <th>#Copies</th>
            <th>#Cover</th>
        </tr>

        <c:forEach items="${booklist}" var="book">
            <tr>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.publisher}</td>
                <td>${book.year}</td>
                <td>${book.numberOfCopies}</td>
                <td>
                    <c:if test="${not empty book.coverUrl}">
                        <img src="${book.coverUrl}" height="200px"/>
                    </c:if>
                </td>
                <td>
                    <a href="/show/${book.id}" type="button">Show</a>
                    <c:if test="${not empty admin}">
                        <a href="/update/${book.id}" type="button">Update</a>
                        <a href="/delete/${book.id}" type="button" onclick="return confirm('Deleting a book cannot be undone. Are you sure?')">Delete</a>
                    </c:if>
                    <c:if test="${not empty user}">
                        <a href="/checkout/${book.id}" type="button">Check Out</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
