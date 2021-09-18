package Home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;

@WebServlet("/html/loginteacher")
public class teacherlogin extends HttpServlet
{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		String usr= req.getParameter("usr");
		String pass= req.getParameter("pass");
		model obj = new model();
		HttpSession ses = req.getSession();
		
		try {
			if(obj.teacherlogin(usr, pass))
			{
				String id = obj.teacherid(usr, pass);
				ses.setAttribute("username", usr);
				ses.setAttribute("TID", id);
				
				
				res.sendRedirect("../jsp/teacherdash");
			}else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('check your Credentials');");
			    out.println("location='../html/teacherlogin.html';");
			    out.println("</script>");
				//res.sendRedirect("../html/teacherlogin.html");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
