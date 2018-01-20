package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDAO {

	private static Connection getConnection() {


		//使用するドライバークラスを読み込む
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//データベースへ接続
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:pdborcl","saga","pass");
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private static void allClose(PreparedStatement statement, Connection connection) {
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	static Connection conn = null;
	static PreparedStatement statement = null;

	public int regUser(String id, String password) {
	       int result = 0;

	       try {
	    	   conn = getConnection();
	    	 //insert文の準備
	           statement = conn.prepareStatement("INSERT INTO EMP(ID, NAME) VALUES(?, ?)");
	         //INSERT文の「?」に使用する値を設定しSQL文を完成
	           statement.setString(1, id);
	           statement.setString(2, password);
	         //INSERT文を実行
	           result = statement.executeUpdate();

	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           allClose(statement, conn);
	       }
	       return result;
	}
}

