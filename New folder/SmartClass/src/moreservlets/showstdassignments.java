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

import DAO.subjectmodel;
import extraclasses.AssigmnetAvailable;

/**
 * Servlet implementation class showstdassignments
 */
@WebServlet("/jsp/showstdassignments")
public class showstdassignments extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	
		subjectmodel obj = new subjectmodel();
		HttpSession ses = req.getSession();
		String subid = ses.getAttribute("subid").toString();
		
		try {
			obj.showassigmnets(subid);
			ses.setAttribute("stdassignshow", reverse(obj.showassobj));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		res.sendRedirect("studentassignment.jsp");
	}
	// this method is used to reverse the list of objects so that latest uploaded one are shown above 
		public ArrayList<AssigmnetAvailable> reverse( ArrayList<AssigmnetAvailable> obj)
		{
			ArrayList<AssigmnetAvailable> reversed = new ArrayList<AssigmnetAvailable>();
			
			for(int i = obj.size()-1;i>=0;i--)
			{
				reversed.add(obj.get(i));
			}
			return reversed;
		}

}
