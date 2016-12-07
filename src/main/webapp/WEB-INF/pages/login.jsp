<%--
  Created by IntelliJ IDEA.
  User: aa001
  Date: 12/7/16
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Login</title>
    <link rel='stylesheet'
          href='${pageContext.request.contextPath}/static/css/main.css'
          type='text/css' />
</head>
<body onload='document.f.username.focus();'>
<h3>Please login with you Email and password</h3>
<c:if test="${param.error != null}">
    <div class="error">
        Login failed.<br />
        Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}<br/>
        <c:if test="${fn:containsIgnoreCase(sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message, 'disabled')}">
            Please make sure you have activated your account from the activation email.
        </c:if>
    </div>
</c:if>
<form name='f' action='${pageContext.request.contextPath}/login'
      method='POST'>
    <table class="formtable">
        <tr>
            <td>Email:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login" /></td>
            <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
        </tr>
    </table>
</form>

<p><a href="<c:url value="/register" />">Register for a new account</a></p>
</body>

</html>