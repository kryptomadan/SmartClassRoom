package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public class model {
database obj = new database();
public String name;
public String sem;
public String section;
public String rollnumber;


public boolean checkstudent(String roll) throws SQLException
{
	obj.connect();
	String query = "select *  from eligiblestudents where Rollno=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, roll);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		
		return true;
	}
	
	return false;

}
public boolean checkduplicate(String roll) throws SQLException
{
	obj.connect();
	String query="select * from studentcredentials where Rollno=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, roll);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		return true;
	}
	return false;
	
}


public void register(String roll,String usr,String pass,String clas,String email,String sec)
{
	obj.connect();
	
	String query="insert into studentcredentials values(?,?,?)";
	String query2="select *  from eligiblestudents where Rollno=?";
	
	//for adding student credentials into the database
	try {
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, roll);
		stm.setString(2, usr);
		stm.setString(3, pass);
		stm.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	//for adding student details into the student database
	try {
	PreparedStatement stm2 = obj.con.prepareStatement(query2);
	stm2.setString(1, roll);
	ResultSet rs = stm2.executeQuery();
	if(rs.next())
	{
		String name = rs.getString(2);
		addstudentdetails(roll,name,clas,email,sec);
	}} catch (SQLException e) {
		e.printStackTrace();
	}
}


public boolean checkteacher(String tid) throws SQLException
{
obj.connect();
String query = "select * from teachers where TeacherID=?";

PreparedStatement stm = obj.con.prepareStatement(query);
stm.setString(1, tid);
ResultSet rs = stm.executeQuery();
if(rs.next())
{
return true;	
}
return false;
}

public boolean checkteacherdup(String tid) throws SQLException
{
	obj.connect();
	String query = "select * from teachercredentials where TeacherID=?";

	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, tid);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
	return true;	
	}
	return false;
}

public void registerteacher(String tid,String usr,String pass)
{
obj.connect();
String query="insert into teachercredentials values(?,?,?)";

try {
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, tid);
	stm.setString(2, usr);
	stm.setString(3, pass);
	stm.executeUpdate();
} catch (SQLException e) {
	
	e.printStackTrace();
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

public void addstudentdetails(String roll,String name,String clas,String email,String sec) throws SQLException
{
	obj.connect();
	
	String query= "insert into students values(?,?,?,?,?)";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, roll);
	stm.setString(2, name);
	stm.setString(3, clas);
	stm.setString(4, sec);
	stm.setString(5, email);
	stm.executeUpdate();
}

public boolean teacherlogin(String usr,String pass) throws SQLException
{
	obj.connect();
	String query= "select * from teachercredentials where Username=? and Password=?";
	
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

public String teacherid(String usr,String pass) throws SQLException 
{
	obj.connect();
	String query ="select * from teachercredentials where Username=? and Password=? ";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, usr);
	stm.setString(2, pass);
	ResultSet rs = stm.executeQuery();
	if(rs.next())
	{
		String id = rs.getString(1);
		return id;
	}

	return null;
	
}

}//end of class 

