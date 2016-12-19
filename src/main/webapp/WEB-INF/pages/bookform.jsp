<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:choose>
    <c:when test="${empty command.id}">
        <title>Create book</title>
    </c:when>
    <c:otherwise>
        <title>Update book</title>
    </c:otherwise>
</c:choose>
</head>
<body>
<c:choose>
    <c:when test="${empty command.id}">
        <h1>Create book</h1>
    </c:when>
    <c:otherwise>
        <h1>Update book</h1>
    </c:otherwise>
</c:choose>
<form:form method="POST">
   <table>
    <tr>
        <td><form:label path="isbn">ISBN</form:label></td>
        <td><form:input path="isbn" /></td>
    </tr>
    <tr>
        <td><form:label path="author">Author</form:label></td>
        <td><form:input path="author" /></td>
    </tr>
    <tr>
        <td><form:label path="title">Title</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="callNumber">Call Number</form:label></td>
        <td><form:input path="callNumber" /></td>
    </tr>

    <tr>
        <td><form:label path="publisher">Publisher</form:label></td>
        <td><form:input path="publisher" /></td>
    </tr>
    <tr>
        <td><form:label path="year">Year of Publication</form:label></td>
        <td><form:input path="year" /></td>
    </tr>
    <tr>
        <td><form:label path="location">Location in Library</form:label></td>
        <td><form:input path="location" /></td>
    </tr>
    <tr>
        <td><form:label path="numberOfCopies">Number of Copies</form:label></td>
        <td><form:input path="numberOfCopies" /></td>
    </tr>
    <tr>
        <td><form:label path="status">Current Status</form:label></td>
        <td><form:input path="status" /></td>
    </tr>
    <tr>
        <td><form:label path="keywords">Keywords</form:label></td>
        <td><form:input path="keywords" /></td>
    </tr>
    <tr>
        <td><form:label path="coverUrl">Cover Image URL</form:label></td>
        <td><form:input path="coverUrl" /></td>
    </tr>
   <c:if test = "${not empty command.coverUrl}">
    <tr>
        <td colspan="2">
            <img src = "${command.coverUrl}" width = "100"/>
        </td>
    </tr>
   </c:if>

    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>