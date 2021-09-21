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

import DAO.subjectmodel;


@WebServlet("/jsp/addmaterialsvideo")
public class addmaterialsvideo extends HttpServlet {
	public String path;
	public String topic;
	public String subid;
	public String subname;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	
	{
		try {
			HttpSession ses = req.getSession();
			ServletFileUpload sp = new ServletFileUpload(new DiskFileItemFactory());
			
			subid = ses.getAttribute("subid").toString();	
			subname = ses.getAttribute("subname").toString();
			List<FileItem> multi = sp.parseRequest(req);
			
			for(FileItem item:multi) {		
				if (item.isFormField()) {
				    
					topic = item.getString();
				    
				}
				else{
				path = "../StudyMaterials/Videos/"+ item.getName();
				gothere();//it call the gothere method add the path and topic of the file 
							//this is used incase of multiple files as we need all the files details to be stored in database
				item.write(new File("C:/Users/krypto kevin/eclipse-workspace/6th sem project/SmartClass/WebContent/StudyMaterials/Videos/" + item.getName()));
				
				System.out.println("success");}
		}	
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		res.sendRedirect("../jsp/studymaterialscall");
	}
	
	public void gothere() throws SQLException  //method to store the files details into the database
	{
		subjectmodel obj = new subjectmodel();
		obj.uploadvideomaterials(subid, subname, path, topic);
	}
}
