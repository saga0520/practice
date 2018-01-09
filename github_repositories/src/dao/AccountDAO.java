//データベースにアクセスするクラス

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	public Account findByLogin(Login login) {

		Connection conn = null;
		Account account = null;

		//使用するドライバークラスを読み込む
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//データベースとの接続
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:pdborcl","saga","pass");

			//SQL文を準備
			String sql = ("select * from emp where id=  ? and name = ?");
			PreparedStatement pstatement = conn.prepareStatement(sql);
			pstatement.setString(1, login.getid());
			pstatement.setString(2, login.getpassword());

			//SQL文を実行し、結果表を取得
			ResultSet rs = pstatement.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("NAME");

				account = new Account(id, password);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}

}


