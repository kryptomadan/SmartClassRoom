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
import extraclasses.DocumentMaterials;
import extraclasses.VideoMaterials;


@WebServlet("/jsp/studentstudymaterials")
public class studentstudymaterials extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses  = req.getSession();
		subjectmodel obj = new subjectmodel();
		String subid = req.getParameter("showsub");
		ses.setAttribute("subid", subid);
		
		
		try {
			obj.showsubjectname(subid);
			obj.showdocumentmaterials(subid);
			obj.showvidoematerials(subid);
			ses.setAttribute("videomaterials",reverse(obj.showvideomaterials));
			ses.setAttribute("documentmaterials",reverse2(obj.showdocumentmaterials));
			ses.setAttribute("subname", obj.subname);
			res.sendRedirect("studentstudymaterials.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	// this method is used to reverse the list of objects so that latest uploaded one are shown above 
			public ArrayList<VideoMaterials> reverse( ArrayList<VideoMaterials> obj)
			{
				ArrayList<VideoMaterials> reversed = new ArrayList<VideoMaterials>();
				
				for(int i = obj.size()-1;i>=0;i--)
				{
					reversed.add(obj.get(i));
				}
				return reversed;
			}
			
			public ArrayList<DocumentMaterials> reverse2( ArrayList<DocumentMaterials> obj)
			{
				ArrayList<DocumentMaterials> reversed = new ArrayList<DocumentMaterials>();
				
				for(int i = obj.size()-1;i>=0;i--)
				{
					reversed.add(obj.get(i));
				}
				return reversed;
			}

}
