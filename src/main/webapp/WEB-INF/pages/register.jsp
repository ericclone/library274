<%--
  Created by IntelliJ IDEA.
  User: aa001
  Date: 12/7/16
  Time: 12:25 PM
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
    <title>Register</title>
    <link rel='stylesheet'
          href='${pageContext.request.contextPath}/static/css/main.css'
          type='text/css' />
</head>
<body>
<h1>
    Register a new account
</h1>

<c:if test="${not empty error}">
    <div class="error">
        ${error}
    </div>
</c:if>

<table>
<form:form method="POST">
    <br>
    <tr><td>
        <label>
            First Name:
        </label>
    </td>
        <td><form:input path="firstName" value="" /></td>
        <form:errors path="firstName" element="div"/>
    </tr>
    <tr><td>
        <label>
            Last Name:
        </label>
    </td>
        <td><form:input path="lastName" value="" /></td>
        <form:errors path="lastName" element="div" />
    </tr>
    <tr><td>
        <label>
            Email:
        </label>
    </td>
        <td><form:input path="email" value="" /></td>
        <form:errors path="email" element="div" />
    </tr>
    <tr><td>
        <label>
            Password:
        </label>
    </td>
        <td>
            <form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <%--<tr><td>--%>
        <%--<label>--%>
            <%--Confirm Password:--%>
        <%--</label>--%>
    <%--</td>--%>
        <%--<td><form:input path="matchingPassword" value="" type="password" /></td>--%>
        <%--<form:errors element="div" />--%>
    <%--</tr>--%>

    <tr><td>
        <label>
            University ID:
        </label>
    </td>
        <td><form:input path="univId" value="" type="text" /></td>
        <form:errors path="univId" element="div" />
    </tr>
    <tr>
        <td colspan="2">
            <button type="submit">
                Register
            </button>
        </td>
    </tr>
</form:form>
</table>
<br>
<a href="<c:url value="login" />">
    Already have an account? Click here to login.
</a>
</body>
</html>