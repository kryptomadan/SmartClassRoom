package DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import extraclasses.AssigmnetAvailable;
import extraclasses.DocumentMaterials;
import extraclasses.VideoMaterials;
import extraclasses.meetdetails;

public class subjectmodel {
database obj = new database();
public ArrayList<meetdetails> objs = new ArrayList<meetdetails>();
public ArrayList<AssigmnetAvailable> showassobj = new ArrayList<AssigmnetAvailable>();
public ArrayList<VideoMaterials> showvideomaterials = new ArrayList<VideoMaterials>();
public ArrayList<DocumentMaterials> showdocumentmaterials = new ArrayList<DocumentMaterials>();
public String subname;

public void addmeetinglink(String subid,String link,String tid,String topic,String dandt) throws SQLException
{
	obj.connect();
	
	String query="insert into subjectmeeting values(?,?,?,?,?)";
	
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, subid);
	stm.setString(2, tid);
	stm.setString(3, link);
	stm.setString(4, topic);
	stm.setString(5, dandt);
	stm.executeUpdate();

}
	
	public void showmeetinglink(String tid,String subid) throws SQLException
	{
		obj.connect();
		
		String query="select * from subjectmeeting where SubjectID=? and TeacherID =?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		stm.setString(2, tid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			objs.add(new meetdetails(rs.getString(4), rs.getString(5), rs.getString(3), rs.getString(2), rs.getString(1)));
		}
		
	}

	public void showsubjectname(String subid) throws SQLException
	{
		obj.connect();
		String query="select * from subjects where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			subname=rs.getString(2);
		}
		
	}
	
	public void addassigment(String subid,String subname,String tid,String assid ,String desc,String dandt,String topic) throws SQLException
	{
		obj.connect();		
		String sec = getsection(subid);
		
		String query ="select * from assigment where AssigmentID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1,"AS"+assid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			changeassid(subid,subname,tid,assid,desc,dandt,topic);
		}
		else {
			String query2="insert into assigment values(?,?,?,?,?,?,?,?)";
			PreparedStatement stm2 = obj.con.prepareStatement(query2);
			stm2.setString(1, subid);
			stm2.setString(2, subname);
			stm2.setString(3, sec);
			stm2.setString(4, tid);
			stm2.setString(5, "AS"+assid);
			stm2.setString(6, dandt);
			stm2.setString(7, desc);
			stm2.setString(8, topic);
			stm2.executeUpdate();
		}
		
	}

	public String getsection(String subid) throws SQLException
	{
		obj.connect();
		String query="select * from subjects where SubjectID=?";
		PreparedStatement stm =obj.con.prepareStatement(query);
		stm.setString(1,subid);
		ResultSet rs= stm.executeQuery();
		while(rs.next())
		{
			return rs.getString(4);
		}
		 return null;
	}
	
	public void changeassid(String subid,String subname,String tid,String assid,String desc,String dandt,String topic) throws SQLException
	{
		int asid = (int)(Math.random()*(4000-1500+1)+1500);
		String assignmentid = String.valueOf(asid);
		addassigment(subid,subname,tid,assignmentid,desc,dandt,topic);
	}
	
	
	public void showassigmnets(String subid) throws SQLException
	{
		obj.connect();
		String query ="select * from assigment where SubjectID=?";
		
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			showassobj.add(new AssigmnetAvailable(rs.getString(8),rs.getNString(7),rs.getString(6),rs.getString(5)));
		}	
	}
	
	
	public void uploadassigment(String path,String assid,String stdname,String roll) throws SQLException, ParseException
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		String dandt = dtf.format(now); //submission time
		String duetime = getassignmentduetime(assid); //to get the duetime
		Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(duetime);  
		Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dandt);  
		 
		int comp = date1.compareTo(date2); // this return negative value if assignment is done late
		 
		if(comp>0)
		{
			// if assigmnet is done late
			obj.connect();
			String query = "insert into assigmentlist values(?,?,?,?,?)";
			PreparedStatement stm = obj.con.prepareStatement(query);
			stm.setString(1, assid);
			stm.setNString(2, path);
			stm.setString(3, roll);
			stm.setString(4, stdname);
			stm.setString(5, "yes");
			stm.executeUpdate();
		}
		else if(comp<0)
		{
			// if assignmnet is done at time
			obj.connect();
			String query = "insert into assigmentlist values(?,?,?,?,?)";
			PreparedStatement stm = obj.con.prepareStatement(query);
			stm.setString(1, assid);
			stm.setNString(2, path);
			stm.setString(3, roll);
			stm.setString(4, stdname);
			stm.setString(5, "no");
			stm.executeUpdate();
		}
		else {
			// if assignmnet is done at time
			obj.connect();
			String query = "insert into assigmentlist values(?,?,?,?,?)";
			PreparedStatement stm = obj.con.prepareStatement(query);
			stm.setString(1, assid);
			stm.setNString(2, path);
			stm.setString(3, roll);
			stm.setString(4, stdname);
			stm.setString(5, "no");
			stm.executeUpdate();
		}
					
	}
	
	public String getassignmentduetime(String assid) throws SQLException
	{
		obj.connect();
		String query ="select * from assigment where AssigmentID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
		return rs.getString(6);
		}
		return null;
	}
	
	public boolean checkdonelate(String assid) throws SQLException
	{
		obj.connect();
		String query="select * from assigmentlist where AssigmentID=? and Donelate=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assid);
		stm.setString(2, "yes");
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
	}
	
	
	public void uploadmaterials(String subid,String subname,String path,String topic) throws SQLException
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String dandt = dtf.format(now);
		
		
		obj.connect();
		String query = "insert into studymaterials values (?,?,?,?,?)";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		stm.setString(2, subname);
		stm.setNString(3, path);
		stm.setNString(4, topic);
		stm.setString(5, dandt);
		stm.executeUpdate();
		
	}
	
	public void uploadvideomaterials(String subid,String subname,String path,String topic)  throws SQLException
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String dandt = dtf.format(now);
		
		
		obj.connect();
		String query = "insert into studymaterialsvideo values (?,?,?,?,?)";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		stm.setString(2, subname);
		stm.setNString(3, path);
		stm.setNString(4, topic);
		stm.setString(5, dandt);
		stm.executeUpdate();
	}
	
	public void showvidoematerials(String subid) throws SQLException
	{
		
		obj.connect();
		String query="select * from studymaterialsvideo where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next())
		{
			showvideomaterials.add(new VideoMaterials(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}		
	}
	public void showdocumentmaterials(String subid) throws SQLException
	{
		
		obj.connect();
		String query="select * from studymaterials where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next())
		{
			showdocumentmaterials.add(new DocumentMaterials(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}		
	}
	
	public void removesubject(String subid) throws SQLException, IOException
	{
		obj.connect();
		String query= " delete from subjects where SubjectID=?";
		
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		stm.executeUpdate();
		
		removesubjectmaterials(subid);
	}
	
	public void removesubjectmaterials(String subid) throws SQLException, IOException
	{
		obj.connect();
		String query = "select * from studymaterials where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			String path = rs.getString(3);
			if(path.substring(0, 3).equals("../"))
			{
			Files.deleteIfExists(Paths.get("C:/Users/krypto kevin/eclipse-workspace/6th sem project/SmartClass/WebContent/"+path.substring(3)));
			}else {
				continue;
			}
		}
		
		String query2 = "delete from studymaterials where SubjectID =?";
		PreparedStatement stm2 = obj.con.prepareStatement(query2);
		stm2.setString(1, subid);
		stm2.executeUpdate();
		
		//for video materials
		String query3 = "select * from studymaterialsvideo where SubjectID=?";
		PreparedStatement stm3 = obj.con.prepareStatement(query3);
		stm3.setString(1, subid);
		ResultSet rs2 = stm3.executeQuery();
		while(rs2.next())
		{
			String path = rs2.getString(3);
			
			Files.deleteIfExists(Paths.get("C:/Users/krypto kevin/eclipse-workspace/6th sem project/SmartClass/WebContent/"+path.substring(3)));
		}
		
		String query4 = "delete from studymaterialsvideo where SubjectID =?";
		PreparedStatement stm4 = obj.con.prepareStatement(query4);
		stm4.setString(1, subid);
		stm4.executeUpdate();
		
		removesubjectassi(subid);
	}
	
	public void removesubjectassi(String subid) throws SQLException, IOException
	{
		obj.connect();
		String query = "select * from assigment where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			String assid = rs.getString(5);
			removeassimentmaterial(assid);
		}
		
		String query2 = "delete from assigment where SubjectID=?";
		PreparedStatement stm2 = obj.con.prepareStatement(query2);
		stm2.setString(1, subid);
		stm2.executeUpdate();
		
		removesubjectclass(subid);
	
	}
	
	public void removeassimentmaterial(String assid) throws SQLException, IOException
	{
		obj.connect();
		String query = "select * from assigmentlist where AssigmentID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			String path = rs.getString(2);
			Files.deleteIfExists(Paths.get("C:/Users/krypto kevin/eclipse-workspace/6th sem project/SmartClass/WebContent/"+path.substring(3)));
		}
		
		String query2 = "delete from assigmentlist where AssigmentID=?";
		PreparedStatement stm2 = obj.con.prepareStatement(query2);
		stm2.setString(1, assid);
		stm2.executeUpdate();
	}
	
	public void removesubjectclass(String subid) throws SQLException
	{
		obj.connect();
		
		String query = "delete from subjectmeeting where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		stm.executeUpdate();
		
	}
	
}//end of class
