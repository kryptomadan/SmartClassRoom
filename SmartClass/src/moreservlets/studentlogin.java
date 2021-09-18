package moreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.studentdao;


@WebServlet("/html/studentlogin")
public class studentlogin extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		studentdao obj = new studentdao();
		HttpSession ses = req.getSession();
		String usr = req.getParameter("usrname");
		String pass = req.getParameter("pass");
		
		try {
			if(obj.studentlogin(usr, pass))
			{
				String roll = obj.setrollno(usr, pass);
				ses.setAttribute("rollno", roll);
				res.sendRedirect("../jsp/Student");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('check your Credentials');");
			    out.println("location='../html/studentlogin.html';");
			    out.println("</script>");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	}

}
