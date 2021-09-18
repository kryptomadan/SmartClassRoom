package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Home.subjectclass;
import extraclasses.updates;

public class model2 {

	database obj = new database();
	
	public ArrayList<subjectclass> subs = new ArrayList<subjectclass>();
	public ArrayList<updates> update = new ArrayList<updates>();
	public String tname;
	
	public void sbidchanging(String subname,String subid,String clas,String sec,String tid) throws SQLException
	{
		int sbid = (int)(Math.random()*(2000-1500+1)+1500);
		subid = String.valueOf(sbid);
		addsubject(subname, subid, clas, sec, tid);
	}
	
	public void addsubject(String subname,String subid,String clas,String sec,String tid) throws SQLException
	{
		obj.connect();
		
		String query="select * from subjects where SubjectID=? ";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, subid);
		ResultSet rs = stm.executeQuery();
		if(rs.next()) {
			sbidchanging(subname, subid, clas, sec, tid); //this is to check for the duplicate subid 
		}													//if number exist new number is generate continuously until there is no duplication
		else {
			
			String query2 = "insert into subjects values(?,?,?,?,?)";
			PreparedStatement stm2 =obj.con.prepareStatement(query2);
			stm2.setString(1, "SUB"+subid);
			stm2.setString(2, subname);
			stm2.setString(3, clas);
			stm2.setString(4, sec);
			stm2.setString(5, tid);
			stm2.executeUpdate();
		}
		
	}

	public void teachersubjects(String tid) throws SQLException
	{
		obj.connect();
		
		String query = "select * from subjects where TeacherID=? ";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, tid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			
			subs.add(new subjectclass(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4),rs.getString(1))); //appending the class and section to the subject itself
						
		}
		getteachername(tid);
	}
	
	public void getteachername(String tid) throws SQLException
	{
		obj.connect();
		String query="select * from teachers where TeacherID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, tid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			tname = rs.getString(2);
		}
	}
	
	
	public void getupdates() throws SQLException
	{
		obj.connect();
		String query ="select * from updates";
		PreparedStatement stm = obj.con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			update.add(new updates(rs.getString(3),rs.getString(2)));
		}
		
	}
	
	public void addupdates(String tname,String topic,String path) throws SQLException
	{
		obj.connect();
		String query ="insert into updates values(?,?,?) ";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, tname);
		stm.setString(2, path);
		stm.setString(3, topic);
		stm.executeUpdate();
		
		
	}
}//end of class
