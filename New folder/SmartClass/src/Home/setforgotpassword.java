package Home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jsp/setforgotpassword")
public class setforgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	
	{
		HttpSession ses =req.getSession();
		PrintWriter out = res.getWriter();
		int otp = Integer.parseInt(req.getParameter("otp"));
		int sessionotp = Integer.parseInt(ses.getAttribute("otp").toString());
		
		
		if(otp==sessionotp)
		{
			res.sendRedirect("setpassword.jsp");
		}else
		{
			  out.println("<script type=\"text/javascript\">");
		      out.println("alert('Incorrect OTP check properly');");
		      out.println("location='../jsp/studentpasswordchange.jsp';");
		      out.println("</script>");
		}
		
		
	}

}
