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
    User registration complete!
</h1>

<c:if test="${not empty error}">
    <div class="error">
        ${error}
    </div>
</c:if>

<div>
    Please activate your account by clicking the verification link in the email.
</div>
<br>
<a href="<c:url value="login" />">
    Back to login.
</a>
</body>
</html>