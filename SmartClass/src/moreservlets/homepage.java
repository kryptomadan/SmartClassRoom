package moreservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model2;


@WebServlet("/jsp/home")
public class homepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		model2 obj = new model2();
		HttpSession ses =  req.getSession();
		try {
			obj.getupdates();
			ses.setAttribute("updates", obj.update);
			res.sendRedirect("/SmartClass/jsp/index.jsp");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
