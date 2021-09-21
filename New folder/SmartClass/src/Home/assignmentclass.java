package Home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.subjectmodel;
import extraclasses.AssigmnetAvailable;

@WebServlet("/jsp/assign")
public class assignmentclass  extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession();
		subjectmodel obj = new subjectmodel();
		String tid = ses.getAttribute("TID").toString();
		
		String subid = ses.getAttribute("subid").toString(); 
		try {
			obj.showsubjectname(subid);
			obj.showassigmnets(subid);
			ses.setAttribute("avaiassignments", reverse(obj.showassobj));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		res.sendRedirect("Assignment.jsp");
	}
	
	// this method is used to reverse the list of objects so that latest uploaded one are shown above 
	public ArrayList<AssigmnetAvailable> reverse( ArrayList<AssigmnetAvailable> obj)
	{
		ArrayList<AssigmnetAvailable> reversed = new ArrayList<AssigmnetAvailable>();
		
		for(int i = obj.size()-1;i>=0;i--)
		{
			reversed.add(obj.get(i));
		}
		return reversed;
	}
}
