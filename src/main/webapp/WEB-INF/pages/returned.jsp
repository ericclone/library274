<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aa001
  Date: 12/18/16
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Return Result</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${not empty success}">
    <h1>Successfully returned ${book.title}</h1>
</c:if>

<c:if test="${not empty error}">
    <h1>${error}</h1>
    <h1>${book.title}</h1>
</c:if>

<a href="/checkouts">See your current checkouts</a><br />
<a href="/list">Find another book</a>

</body>
</html>
