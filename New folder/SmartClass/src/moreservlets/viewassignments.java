package moreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.studentdao;

@WebServlet("/jsp/viewassignments")
public class viewassignments extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		

		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		studentdao obj = new studentdao();
		String assid = req.getParameter("assid");
		
		
		try {
			obj.viewassignments(assid);
			ses.setAttribute("viewassignment", obj.viewassobj);
			res.sendRedirect("Viewassignment.jsp");

			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	

}
