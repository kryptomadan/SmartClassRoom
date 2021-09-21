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


@WebServlet("/jsp/studentassignmentshow")
public class studentassignmentshow extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses =req.getSession();
		subjectmodel obj = new subjectmodel();
		String subid = req.getParameter("subidshow");
		ses.setAttribute("subid", subid);
		
		try {
			obj.showassigmnets(subid);
			obj.showsubjectname(subid); //this is to show the subject name as we click on it
			ses.setAttribute("subname", obj.subname);//here we are setting the session variable to use it on the page 
			ses.setAttribute("stdassignshow",reverse(obj.showassobj));
			res.sendRedirect("studentassignment.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
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
