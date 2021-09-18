package moreservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.studentdao;
import extraclasses.meetdetails;


@WebServlet("/jsp/studentclasscall")
public class studentclasscall extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		studentdao obj = new studentdao();
		HttpSession ses = req.getSession();
		String subid = ses.getAttribute("subid").toString();
		
		
		try {
			obj.showstudentmeeting(subid);
			ses.setAttribute("stdmeetdetails", reversemeet(obj.stdmeetobj));
			res.sendRedirect("Studentclass.jsp");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
						
	}
	// this method is used to reverse the list of objects so that latest uploaded one are shown above 
		public ArrayList<meetdetails> reversemeet( ArrayList<meetdetails> obj)
		{
			ArrayList<meetdetails> reversed = new ArrayList<meetdetails>();
			
			for(int i = obj.size()-1;i>=0;i--)
			{
				reversed.add(obj.get(i));
			}
			return reversed;
		}
	

}
