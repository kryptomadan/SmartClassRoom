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


@WebServlet("/html/studentforgotpassword")
public class studentforgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		studentdao obj = new studentdao();
		String email = req.getParameter("email");
		
		try {
			if(obj.checkemailforotp(email))
			{
				ses.setAttribute("otprollno", obj.otprollno);
				ses.setAttribute("otp", obj.onetimepassword);
				
				res.sendRedirect("../jsp/studentpasswordchange.jsp");
			}
			else 
			{
				  out.println("<script type=\"text/javascript\">");
			      out.println("alert('Your are Email is not registered Kindly check properly');");
			      out.println("location='../html/studentlogin.html';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
