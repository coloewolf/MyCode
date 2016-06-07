package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConn {
	
	private static String url = "jdbc:mysql://localhost:3306/testreport";
	private static String user = "root";
	private static String password = "root";
	
	public static Connection conn;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static Statement st;
 	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
}
