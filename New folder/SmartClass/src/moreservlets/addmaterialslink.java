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


@WebServlet("/jsp/addmaterialslink")
public class addmaterialslink extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		subjectmodel obj = new subjectmodel();
		String subid = ses.getAttribute("subid").toString();
		String subname = ses.getAttribute("subname").toString();
		String path = req.getParameter("link");
		String topic = req.getParameter("topic");
		try {
			obj.uploadmaterials(subid, subname, path, topic);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		res.sendRedirect("../jsp/studymaterialscall");
	}

}
