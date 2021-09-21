package Home;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.subjectmodel;



@WebServlet("/jsp/upload")
public class uploadassignment  extends HttpServlet{

	

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		try {
			HttpSession ses = req.getSession();
			
			subjectmodel obj = new subjectmodel();
			ServletFileUpload sp = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multi = sp.parseRequest(req);			
			String stdname = ses.getAttribute("stdname").toString(); // here we are getting stdname which was set during the studentlogin
			String rollno = ses.getAttribute("rollno").toString(); // here we are getting rollno which was set during the studentlogin
			String assid = ses.getAttribute("assid").toString(); // here we are getting the assid value which is set in jsp thorught the session 
				
			
		for(FileItem item:multi) {		
					
					
				item.write(new File("C:/Users/krypto kevin/eclipse-workspace/6th sem project/SmartClass/WebContent/Assignments/" + item.getName()));
				String path = "../Assignments/" + item.getName();
				obj.uploadassigment(path, assid, stdname, rollno);
				System.out.println("success");	
				 
				
		}		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		res.sendRedirect("studentassignment.jsp");
	}
	
	
	

} 
