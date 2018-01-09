<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ログイン画面</title>
    <link rel="stylesheet" href="css/login.css" type="text/css" />
  </head>

  <body>
    <div id="wrapper">
      <h1>ようこそ！</h1>
      <p>ログインIDとパスワードを入力して下さい</p>
      <form action="loginservlet" method="post">
        <table border="1">
          <tbody>
            <tr>
              <th>ログインID</th>
              <td><input type="text" name="id"></td>
            </tr>
            <tr>
              <th>パスワード</th>
              <td><input type="password" name="password"></td>
            </tr>
          </tbody>
        </table><br>
        <input id="submit_button1" type="submit" name="submit" value="ログイン" >
      </form><br><br>
            <form action="jsp/registration.jsp" method="post">
        <input id="submit_button2" type="submit" name="submit" value="ユーザー新規登録" >
      </form>
    </div>
  </body>
</html>
