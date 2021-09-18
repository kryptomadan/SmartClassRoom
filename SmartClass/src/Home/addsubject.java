package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model2;

@WebServlet("/jsp/addsubject")
public class addsubject extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession ses = req.getSession();
		String subname = req.getParameter("subname");
		String clas = req.getParameter("class");
		String section = req.getParameter("section");				
		String tid = ses.getAttribute("TID").toString();
		int sbid = (int)(Math.random()*(2000-1500+1)+1500);
		String subid = String.valueOf(sbid);
		
		model2 obj = new model2();
		try {
			obj.addsubject(subname, subid, clas, section, tid);			
			res.sendRedirect("../jsp/teacherdash");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
