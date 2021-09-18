package Home;
import DAO.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/jsp/registerstudent")
public class studentregister extends HttpServlet

{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		model obj = new model();
		String roll = req.getParameter("rollno");
		String usrname = req.getParameter("usrname");
		String pass = req.getParameter("pass");
		String pass2 =req.getParameter("cnfrmpass");
		String clas = req.getParameter("class");
		String section = req.getParameter("section");
		String email  = req.getParameter("email");
		
		
		
		
		if(pass.equals(pass2))
		{
			try {
				if(obj.checkstudent(roll))
				{
					if(obj.checkduplicate(roll))
					{
						  out.println("<script type=\"text/javascript\">");
					      out.println("alert('Your are already registered');");
					      out.println("location='../jsp/studentregister.jsp';");
					      out.println("</script>");
					}else {
						
						
						obj.register(roll, usrname, pass, clas, email, section);
						res.sendRedirect("../html/studentlogin.html");
					}
				}
				else {
					  out.println("<script type=\"text/javascript\">");
				      out.println("alert('Your are not eligible Contact your teacher');");
				      out.println("location='../jsp/studentregister.jsp';");
				      out.println("</script>");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
			  out.println("<script type=\"text/javascript\">");
		      out.println("alert('password does not match enter properly');");
		      out.println("location='../jsp/studentregister.jsp';");
		      out.println("</script>");
		      
		      
		}
		
		
	}
}




