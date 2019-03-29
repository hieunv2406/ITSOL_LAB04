package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:oracle12c";
//	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String USER = "c##hieunv";
	private static final String PASS = "123456";

	public static Connection openConnection() {

		Connection conn = null;
		try {
			System.out.println("connecting...");
//			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			if (conn != null) {
				System.out.println("connected");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connection false");
		}
		return conn;
	}

	public static void closeConnection(Connection conn, PreparedStatement pstm) {
		if (conn != null) {
			try {
				conn.close();

				if (conn == null) {
					System.out.println("Da dong ket noi!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//			conn = ConnectionDB.openConnection();
//			if (conn != null) {
//				System.out.println("succ");
//			}
//		} catch (Exception e) {
//			System.out.println("false");
//			e.printStackTrace();
//		}
//	}
}
