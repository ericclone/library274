<%--
  Created by IntelliJ IDEA.
  User: aa001
  Date: 12/7/16
  Time: 11:13 PM
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
    <link rel='stylesheet'
          href='${pageContext.request.contextPath}/static/css/main.css'
          type='text/css' />
    <title>User not found</title>
</head>
<body>
<h1>
    The link is invalid because no user can be found.
</h1>
<br>
<a href="<c:url value="register" />">
    Register a new account
</a>
</body>
</html>