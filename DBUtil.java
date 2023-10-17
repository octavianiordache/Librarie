package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBUtil {
	private static DBUtil instanta = null;
 
	private static Connection conn = null;
 
	private DBUtil() {
		buildConnection();
	}
	/**
	 * Metoda pentru obtinerea conexiunii 
	 * @return returneaza conexiune la baza de date
	 */
	public static Connection getConnection() {
		if (instanta == null) {
			instanta = new DBUtil();
		}
		return conn;
	}
 
	/**
	 * metoda pentru construirea conexiunii la baza de date
	 */
	public static void buildConnection() {
		String url = "jdbc:derby://localhost:1527/abc;create=true";
 
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed()) {
					System.out.println("JDBC Successfully connected to Derby server.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
