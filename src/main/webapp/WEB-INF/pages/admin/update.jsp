<%--
  Created by IntelliJ IDEA.
  User: aa001
  Date: 12/9/16
  Time: 9:57 PM
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
    <title>Update book details</title>
    <link rel='stylesheet'
          href='${pageContext.request.contextPath}/static/css/main.css'
          type='text/css' />
</head>
<body>
<h1>Update book details</h1>
<form:form method="POST">
    <table>
        <tr>
            <td><form:label path="isbn">ISBN</form:label></td>
            <td><form:input path="isbn" value="${book.isbn}"/></td>
        </tr>
        <tr>
            <td><form:label path="isbn">ISBN</form:label></td>
            <td><form:input path="isbn" value="${book.isbn}"/></td>
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





        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
