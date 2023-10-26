package jspstudent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String address=req.getParameter("address");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));
	ServletContext context=req.getServletContext();
	double fees=Double.parseDouble(context.getInitParameter("fees"));
	
	Student student=new Student();
	student.setId(id);
	student.setAddress(address);
	student.setEmail(email);
	student.setFees(fees);
	student.setName(name);
	student.setPassword(password);
    student.setPhone(phone);	
    
    StudentDao dao=new StudentDao();
    dao.updateStudent(student);
    
    
   Cookie[] cookies= req.getCookies();
   String nameoftheStudentWhoChangedTheDetails=null;
	for(Cookie cookie:cookies) {
		if(cookie.getName().equals("studentWhoLoggedIn")) {
			nameoftheStudentWhoChangedTheDetails=cookie.getValue();
		}
	}
	req.setAttribute("nameofthestudent", nameoftheStudentWhoChangedTheDetails);
    req.setAttribute("list", dao.getAllStudents());
	RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
	dispatcher.forward(req, resp);
	
	
	
	
	
	
	
}
}
