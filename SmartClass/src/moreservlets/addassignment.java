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


@WebServlet("/jsp/addassignment")
public class addassignment extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		subjectmodel obj = new subjectmodel();
		HttpSession ses = request.getSession();
		String subid = ses.getAttribute("subid").toString();
		String subname= ses.getAttribute("subname").toString();
		String tid = ses.getAttribute("TID").toString();
		String dandt = request.getParameter("dandt").toString();
		String desc = request.getParameter("desc");
		String topic = request.getParameter("topic");
		int asid = (int)(Math.random()*(4000-1500+1)+1500);
		String assignmentid = String.valueOf(asid);
		
		try {
			
			obj.addassigment(subid, subname, tid, assignmentid,desc,dandt.substring(0, 10)+" "+dandt.substring(11, 16),topic);
			response.sendRedirect("../jsp/assign");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
