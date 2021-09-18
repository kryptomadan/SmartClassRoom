package Home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Home.subjectclass;


import DAO.model2;

@WebServlet("/jsp/teacherdash")
public class Teacher  extends HttpServlet
{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		
		model2 obj = new model2();// object is created to check the teachers subjects
		HttpSession ses = req.getSession();
		
		String tid = ses.getAttribute("TID").toString();
		try {
			obj.teachersubjects(tid);//it used to check the subjects of the teacher 
			ses.setAttribute("teachername", obj.tname);																		
			ses.setAttribute("subs",obj.subs);																				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//it is used call the jsp from the servlet
		RequestDispatcher rd  = req.getRequestDispatcher("Teacher.jsp");
		rd.forward(req, res);
	}
	
}
