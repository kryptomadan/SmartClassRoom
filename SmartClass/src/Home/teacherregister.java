package Home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model;

@WebServlet("/jsp/registerteacher")
public class teacherregister extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		model obj = new model();
		PrintWriter out = res.getWriter();
		String TID = req.getParameter("Tid");
		String usrname = req.getParameter("usrname");
		String pass = req.getParameter("pass");
		String pass2 = req.getParameter("cnfrmpass");
		
		if(pass.equals(pass2))
		{
			try {
				if(obj.checkteacher(TID))
				{
					if(obj.checkduplicate(TID))
					{
						  out.println("<script type=\"text/javascript\">");
					      out.println("alert('Your are already registered');");
					      out.println("location='../jsp/teachersregister.jsp';");
					      out.println("</script>");
					}else {
						obj.registerteacher(TID, usrname, pass);
						res.sendRedirect("../html/teacherlogin.html");
					}
				}
				else
				{
					out.println("<script type=\"text/javascript\">");
				      out.println("alert('Your are Not a Teacher to register InvalidTeacher ID');");
				      out.println("location='../jsp/teachersregister.jsp';");
				      out.println("</script>");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
			
			  out.println("<script type=\"text/javascript\">");
		      out.println("alert('password does not match enter properly');");
		      out.println("location='../jsp/teachersregister.jsp';");
		      out.println("</script>");
		}
	}
	
	
}
