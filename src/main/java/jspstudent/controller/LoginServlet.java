package jspstudent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	StudentDao  studentDao=new StudentDao();
	List<Student> list=studentDao.getAllStudents();
	boolean value=false;
	String passwordofTheStudent=null;
	String studentName=null;
	
	for(Student student:list) {
		if(email.equals(student.getEmail())) {
			value=true;
			passwordofTheStudent=student.getPassword();
//			cookie concept
			studentName=student.getName();
			break;
		}
	}
	if(value) {
//		email is present
		if(password.equals(passwordofTheStudent)) {
//			login success
			Cookie cookie=new Cookie("studentWhoLoggedIn", studentName);
			resp.addCookie(cookie);
			
//			Httpsession
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("studentWhologgedIn", studentName);
			
			req.setAttribute("list",studentDao.getAllStudents());
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "Invalid Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);

		}
		
	}else {
//		email is not present
		req.setAttribute("message", "Invalid Email");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
	
	
	
}
}
