package Home;
// it is used to show the assignments of the particular subject
// this servlet begins almost same as subject.java servlet because to avoid the complications of subid missing
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
import extraclasses.meetdetails;

@WebServlet("/jsp/assignment")
public class assignment  extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession();
		subjectmodel obj = new subjectmodel();
		
		String tid = ses.getAttribute("TID").toString();
		String id = req.getParameter("showsub");//it gets the subid from teacher.jsp
		ses.setAttribute("subid", id);//here it is set as sessiion data to use later in the session
		String subid = ses.getAttribute("subid").toString(); 
		try {
			obj.showsubjectname(subid);
			obj.showassigmnets(subid);			
			ses.setAttribute("avaiassignments", reverse(obj.showassobj));
			ses.setAttribute("subname", obj.subname);
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
