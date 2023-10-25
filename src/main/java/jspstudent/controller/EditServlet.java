package jspstudent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}
}
