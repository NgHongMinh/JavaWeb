package MyConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static String jdbcURL ="jdbc:mysql://localhost:3306/web?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "12345678";
	
	public static Connection getConnection() {
		Connection connection = null;
	
		try {		
			Class.forName("com.mysql.jdbc.Driver");		
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
    