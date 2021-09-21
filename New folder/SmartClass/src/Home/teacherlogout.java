package Home;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/logout")
public class teacherlogout extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession ses = req.getSession();
		
		ses.removeAttribute("username");
		ses.removeAttribute("TID");
		ses.removeAttribute("sub");
		
		res.sendRedirect("../jsp/home");
	}
  	
	
}
