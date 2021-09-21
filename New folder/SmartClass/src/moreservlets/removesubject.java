package moreservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.subjectmodel;


@WebServlet("/jsp/removesubject")
public class removesubject extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 	
	{
		
		subjectmodel obj = new subjectmodel();
		String subid = req.getParameter("subid");
		
		try {
			obj.removesubject(subid);
			res.sendRedirect("../jsp/teacherdash");
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		
	}

}
