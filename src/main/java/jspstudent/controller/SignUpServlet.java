package jspstudent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;

public class SignUpServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phone=Long.parseLong(req.getParameter("phone"));
	double fees=Double.parseDouble(getServletContext().getInitParameter("fees"));
	
	Student  student=new Student();
	student.setAddress(address);
	student.setEmail(email);
    student.setFees(fees);
    student.setName(name);
    student.setPassword(password);
    student.setPhone(phone);
	
    StudentDao studentDao=new StudentDao();
    studentDao.saveStudent(student);
    req.setAttribute("message", "SignedUpSuccessfully Please Login");
    RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
    dispatcher.forward(req, resp);
	
	
	
	
	
	
	
	
	
	
	
	
}
}
