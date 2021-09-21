package moreservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.studentdao;


@WebServlet("/jsp/Student")
public class Student extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		studentdao obj = new studentdao();
		HttpSession ses = req.getSession();
		String rollno = ses.getAttribute("rollno").toString();
		try {
			obj.getsecandsem(rollno);
			ses.setAttribute("stdsubs", obj.stdsubobj);
			ses.setAttribute("stdname", obj.stdname);
			ses.setAttribute("secandsem", obj.secandsem);
			res.sendRedirect("Student.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	

}
