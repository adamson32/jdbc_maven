
package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
    private static final String DB_DRIVER_CLASS="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_USERNAME="adam";
	private static final String DB_PASSWORD="adam";
	private static final String DB_URL ="jdbc:sqlserver://LAPTOP-442E11CB\\SQLEXPRESS:1433;databaseName=company;selectMethod=cursor;encrypt=false";
	
	private static Connection connection = null;
	static{
		try {
			Class.forName(DB_DRIVER_CLASS);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return connection;
	}
}
