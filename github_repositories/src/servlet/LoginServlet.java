//フォームから入力された値を受け取るサーブレット

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import model.LoginLogic;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//ログイン処理の実行
		Login login = new Login(id, password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		//ログイン処理の成否によって処理を分岐
		if(result) { //ログイン成功時
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/home.jsp");
			dispatcher.forward(request, response);
		} else { //ログイン失敗
			//リダイレクト
			response.sendRedirect("./jsp/error.jsp");
		}
	}
}
