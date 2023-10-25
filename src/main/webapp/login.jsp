<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>

<%if(message!=null){ %>
<h1><%=message %></h1>
<%}else{ %>
<h1><%="Welcome to LOGIN PAGE" %></h1>
<%} %>
<form action="login">

Email::<input type="text" name="email">
<br>
<br>
Password::<input type="text" name="password">
<br>
<br>
<input type="submit" value="Login">

</form>








</body>
</html>