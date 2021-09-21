package DAO;
import java.sql.*;

public class database {

public Connection con;
public void connect()  
{
	String user = "root";
	String pass = "casteil_143";
	String  url = "jdbc:mysql://localhost:3306/smartclass";
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,user,pass);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}}


}
