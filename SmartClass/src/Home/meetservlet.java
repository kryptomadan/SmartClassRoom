package Home;
// this class is used to call the meeting class after adding the meeting link by the teacher 
// this is majorly used to avoid the subid null problem

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.subjectmodel;
import extraclasses.meetdetails;

@WebServlet("/jsp/Class")
public class meetservlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	
		HttpSession ses = req.getSession();
		subjectmodel obj = new subjectmodel();
		String tid = ses.getAttribute("TID").toString();
		
		String subid = ses.getAttribute("subid").toString(); 
		
		
		try {
			obj.showmeetinglink(tid, subid);
			ses.setAttribute("meetlinks", reversemeet(obj.objs));// it is to show the meeting links
			res.sendRedirect("Subject.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
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
