package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}

	public static void testFindByLogin1() {
		Login login = new Login("1", "abc");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);

		if (result != null && result.getid().equals("1") && result.getpassword().equals("abc")) {
			System.out.println("testFindByLogin1 : 成功");
		} else {
			System.out.println("testFindByLogin1 : 失敗");
		}
	}

	public static void testFindByLogin2() {
		Login login = new Login("1", "def");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);

		if (result == null) {
			System.out.println("testFindByLogin2 : 成功");
		} else {
			System.out.println("testFindByLogin2 : 失敗");
		}
	}
}

