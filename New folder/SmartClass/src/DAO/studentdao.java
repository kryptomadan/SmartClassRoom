package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//its a DAO of the studentpart workings
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import Home.subjectclass;
import extraclasses.meetdetails;
import extraclasses.viewassignments;

public class studentdao 
{
	database obj = new database();
	public ArrayList<subjectclass> stdsubobj = new ArrayList<subjectclass>();
	public ArrayList<meetdetails> stdmeetobj = new ArrayList<meetdetails>();
	public ArrayList<viewassignments> viewassobj = new ArrayList<viewassignments>();
	public String stdname ;
	public String assipath;
	public String secandsem;
	public int onetimepassword;
	public String otprollno;
	
	public void getsecandsem(String roll) throws SQLException
	{
		obj.connect();
		String query=" select * from students where Rollno=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, roll);
		ResultSet rs  = stm.executeQuery();
		if(rs.next())
		{
			String sec = rs.getString(4);
			String classs= rs.getString(3);
			secandsem = classs+" "+sec;
			stdname = rs.getString(2);
			showsubjectstudent(sec,classs);
		}
				
		
	}
	
	public void showsubjectstudent(String sec,String classs) throws SQLException	
	{
		obj.connect();
		String query="select * from subjects where Class=? and Section=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, classs);
		stm.setString(2, sec);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			stdsubobj.add( new subjectclass(rs.getString(2),rs.getString(1)) );
		}
		
		
	}

	public boolean studentlogin(String usr,String pass) throws SQLException
	{
		obj.connect();
		String query="select * from studentcredentials where Username=? and Password=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usr);
		stm.setString(2, pass);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
		return true;
		}
		
		return false;
	}
	
	public String setrollno(String usr,String pass) throws SQLException
	{
		obj.connect();
		String query="select * from studentcredentials where Username=? and Password=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usr);
		stm.setString(2, pass);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return rs.getString(1);
		}
		return null;
	}
	
	public void showstudentmeeting(String subid) throws SQLException
	{
		obj.connect();
		String query = "select * from subjectmeeting where SubjectID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			stdmeetobj.add(new meetdetails(rs.getString(4),rs.getString(5),rs.getString(3),rs.getString(2),rs.getString(1)));
		}
	}
	
	public void viewassignments(String assid) throws SQLException
	{
		obj.connect();
		String query="select * from assigmentlist where AssigmentID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
		viewassobj.add(new viewassignments(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		
	}	
	
	public boolean checkasii(String assid,String roll) throws SQLException
	{
		obj.connect();
		String query="select * from assigmentlist where AssigmentID=? and Rollno=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assid);
		stm.setString(2, roll);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		
		
		return false;
	}
	
	public void showstdassi(String assid,String roll) throws SQLException
	{
		obj.connect();
		String query="select * from assigmentlist where AssigmentID=? and Rollno=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assid);
		stm.setString(2, roll);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			assipath = rs.getString(2);
		}
	}
	
	
	public boolean checkemailforotp(String email) throws SQLException
	{
		obj.connect();
		String query = "select * from students where Email=?";
		
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, email);
		
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			
			System.out.print("found");
			otprollno=rs.getString(1);
			sendotp(email);
			return true;
			
		}
		
		return false;
	}
	
	public void sendotp(String email)
	{
		onetimepassword = (int)(Math.random()*(2000-1500+1)+1500);
		
		
		
		
		String subject = "Forgot Password";
		String msg = "your otp to change your password is:"+" "+onetimepassword;
		
		final String user = "smartclassklebca@gmail.com";
				
		final String password = "smartclass123";
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();  
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.setProperty("mail.smtp.host", host); 
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.transport.protocol", "smtp");  
		
		Session session = Session.getDefaultInstance(props,  
				 new javax.mail.Authenticator() {  
				  protected PasswordAuthentication getPasswordAuthentication() 
				  {  
				   return new PasswordAuthentication(user,password);  
				   }  
				}); 
		
		try {  
			
			 MimeMessage message = new MimeMessage(session);  
			 message.setFrom(new InternetAddress(user));  
			 message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
			 message.setSubject(subject);  
			 message.setText(msg);  
			   
			 
			 Transport.send(message);  
			  
			 System.out.println("Done");  
			  
			 } catch (MessagingException e) {  
			    throw new RuntimeException(e);  
			 }  
		
		
	}
	
	public void changepassword(String rollno,String pass) throws SQLException
	{
		obj.connect();
		String query="update studentcredentials set Password=? where Rollno=?";
		PreparedStatement stm =obj.con.prepareStatement(query);
		stm.setString(1, pass);
		stm.setString(2, rollno);
		stm.executeUpdate();
	}
}// end of the class

