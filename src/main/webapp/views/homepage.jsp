<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Page</title>
</head>
<body>
<%
    String username = (String)request.getAttribute("username");
%>
    <h1>Welcome ${username}</h1>
</body>
</html>