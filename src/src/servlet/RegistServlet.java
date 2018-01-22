package servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import dao.UserDAO;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");



		//ハッシュ生成前にバイト配列に置き換える際のCharset
        Charset charset = StandardCharsets.UTF_8;
        //ハッシュアルゴリズム
        String algorithm = "SHA-256";

        //ハッシュ生成処理
        byte[] bytes;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
	        String result2 = DatatypeConverter.printHexBinary(bytes);

			UserDAO dao = new UserDAO();

			int result = dao.regUser(id, result2);

        	//入力値チェック
			if(id != null && id.length() != 0) {
	        	request.setAttribute("username", id);
	        	request.getRequestDispatcher("/jsp/registconfirm.jsp").forward(request, response);
			} else {
				//リダイレクト
				response.sendRedirect("./jsp/registerror.jsp");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
