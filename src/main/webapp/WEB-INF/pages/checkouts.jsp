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
<c:if test="${empty checkoutlist}">
    <div>

        You have not checked out any books.<br/>
        <a href="/list" type="button">Find books</a>
    </div>
</c:if>

<c:if test="${not empty checkoutlist}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Year</th>
            <th>#Copies</th>
            <th>Cover</th>
            <th>Due Date</th>
        </tr>

        <c:forEach items="${checkoutlist}" var="checkout">
            <tr>
                <td>${checkout.book.isbn}</td>
                <td>${checkout.book.title}</td>
                <td>${checkout.book.author}</td>
                <td>${checkout.book.publisher}</td>
                <td>${checkout.book.year}</td>
                <td>${checkout.book.numberOfCopies}</td>
                <td>
                    <c:if test="${not empty checkout.book.coverUrl}">
                        <img src="${checkout.book.coverUrl}" height="200px"/>
                    </c:if>
                </td>
                <td>${checkout.dueDate}</td>
                <td><a href="/return/${checkout.book.id}" type="button">Return</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
