// this class is used to go the subject page after clicking on it
package Home;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.subjectmodel;
import extraclasses.meetdetails;

@WebServlet("/jsp/subject")
public class subject extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession();
		subjectmodel obj = new subjectmodel();
		String tid = ses.getAttribute("TID").toString();
		String id = req.getParameter("showsub");//it gets the subid from teacher.jsp
		ses.setAttribute("subid", id);//here it is set as session data to use later in the session
		String subid = ses.getAttribute("subid").toString(); 
		ses.setAttribute("showsubject", id);
		
		try {
			obj.showmeetinglink(tid, subid);
			obj.showsubjectname(subid);
			ses.setAttribute("subname", obj.subname);			
			ses.setAttribute("meetlinks",reversemeet(obj.objs));// it is to show the meeting links
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		

		res.sendRedirect("Subject.jsp");
		
	}
	// this method is used to reverse the list of objects so that latest uploaded one are shown above 
	public ArrayList<meetdetails> reversemeet( ArrayList<meetdetails> obj)
	{
		ArrayList<meetdetails> reversed = new ArrayList<meetdetails>();
		
		for(int i = obj.size()-1;i>=0;i--)
		{
			reversed.add(obj.get(i));
		}
		return reversed;
	}
}
