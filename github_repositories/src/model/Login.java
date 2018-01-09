package model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Login {

	private String id;			//ユーザーID
	private String password;	//パスワード

	public Login(String id, String password) {
		this.id = id;
		this.password = password;




        Charset charset = StandardCharsets.UTF_8;
        //ハッシュアルゴリズム
        String algorithm = "SHA-256";

        //ハッシュ生成処理
        byte[] bytes;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
	        String result2 = DatatypeConverter.printHexBinary(bytes);
	        this.password = result2;
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}



	public String getid() {

		return id;
	}
	public String getpassword() {

		return password;
	}


}
