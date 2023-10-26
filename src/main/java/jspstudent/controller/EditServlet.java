package jspstudent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspstudent.dao.StudentDao;
import jspstudent.dto.Student;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao studentDao=new StudentDao();
		Student  student=studentDao.getStudentById(id);
		req.setAttribute("student", student);
		
		HttpSession httpSession=req.getSession();
		String name=(String) httpSession.getAttribute("studentWhologgedIn");
		
		if(name!=null) {
//			he is coming from the login page only not directly coming to this edit.jsp page
			RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
			dispatcher.forward(req, resp);
		}else {
//			name is equals to null means that particular student is a scammer
//			they are coming dirctly to this login page
			req.setAttribute("message", "Hey Scammer Login first and then come to edit");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		
		
		
	}
}
