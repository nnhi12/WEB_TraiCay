package Util;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBC {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url = "jdbc:mysql://localhost:3306/dtdm?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			String username = "root";
			String password = "Nhi@2003";

			conn = DriverManager.getConnection(url, username, password);
			
			//System.out.println("Connection successfully!");
		} catch (SQLException e) {
			System.out.println("Connection error...");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null) {
				System.out.println("Close connection!");
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Date getSQLDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
}
