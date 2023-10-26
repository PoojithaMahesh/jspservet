<%@page import="jspstudent.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String name=(String)request.getAttribute("nameofthestudent"); %>
<%if(name!=null){ %>
<h1>Changed By <%=name %></h1>
<%} %>

<%List<Student> students=(List)request.getAttribute("list"); %>
<table border="1px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Address</th>
<th>PhoneNo</th>
<th>Fees</th>
<th>Delete</th>
<th>Edit</th>
</tr>

<%for(Student student:students){%>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getEmail()%></td>
<td><%=student.getPassword() %></td>
<td><%=student.getAddress() %></td>
<td><%=student.getPhone() %></td>
<td><%=student.getFees() %></td>
<td><a href="delete?id=<%=student.getId() %>">Delete</a></td>
<td><a href="edit?id=<%=student.getId() %>">Edit</a></td>
</tr>
<%} %>




</table>

</body>
</html>