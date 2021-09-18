// this class is used to add the meeting link to the respective subject  according to the subid

package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.subjectmodel;

@WebServlet("/jsp/classmeet")
public class classmeet extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession ses = req.getSession();
		subjectmodel obj = new subjectmodel();
		String topic = req.getParameter("topic");
		String link = req.getParameter("link");
		String dandt = req.getParameter("dandt").toString();
		String subid = req.getParameter("meetsubid");
		String tid = ses.getAttribute("TID").toString();
		
		try {
			obj.addmeetinglink(subid, link, tid, topic, dandt.substring(0, 10)+" "+dandt.substring(12, 16));
			res.sendRedirect("Class"); // it calls the meetservlet to show the class links
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
