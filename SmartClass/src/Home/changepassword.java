package Home;

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


@WebServlet("/jsp/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		PrintWriter out = res.getWriter();
		studentdao obj = new studentdao();
		String pass = req.getParameter("pass");
		String pass2 = req.getParameter("pass2");
		String rollno = ses.getAttribute("otprollno").toString();
		System.out.println(pass);
		System.out.println(pass2);
		try {
			if(pass.equals(pass2))
			{
			obj.changepassword(rollno, pass);
			out.println("<script type=\"text/javascript\">");
		      out.println("alert('Password Changed Successfully');");
		      out.println("location='../html/studentlogin.html';");
		      out.println("</script>");
			}
			else {
				  out.println("<script type=\"text/javascript\">");
			      out.println("alert('Password does not match');");
			      out.println("location='../jsp/setpassword.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
