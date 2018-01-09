<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
  <body>
    <div id="wrapper">
      <span style="border-bottom: solid 1px black;"><font size="5">新規ユーザー登録</font></span>
      <p>ログインIDとパスワードを入力して下さい</p>
      <form action="../registservlet" method="post">
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
        <input id="submit_button1" type="submit" name="submit" value="登録" >
        <button type="button" onclick="history.back()">戻る</button>
      </form><br><br>
      </div>
  </body>
</html>
