package moreservlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.model2;


@WebServlet("/jsp/addupdates")
public class addupdates extends HttpServlet {
	
	public String tname;
	public String topic;
	public String path;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		
		tname = ses.getAttribute("teachername").toString();
		try {
		ServletFileUpload sp = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> multi = sp.parseRequest(req);
		
		for(FileItem item:multi) {		
			if (item.isFormField()) {
			    
				topic = item.getString();
			    
			}
			else{
			path = "../Updates/"+ item.getName();
			gothere();//it call the gothere method add the path and topic of the file 
						//this is used incase of multiple files as we need all the files details to be stored in database
			item.write(new File("C:/Users/krypto kevin/eclipse-workspace/6th sem project/SmartClass/WebContent/Updates/" + item.getName()));
			
			System.out.println("success");}
		}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		res.sendRedirect("teacherdash");
	}
	
	public void gothere() throws SQLException
	{
		model2 obj = new model2();
		obj.addupdates(tname, topic, path);
	}

}
