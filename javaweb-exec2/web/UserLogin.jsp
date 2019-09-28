<%--
  Created by IntelliJ IDEA.
  User: kehan
  Date: 2019/9/27
  Time: 上午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF">
<h1 align="center">User Login</h1>
<hr>
<p>
    <b>User information:</b>
</p>
<form method="post" action="Login.do">
    <table width="500" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="100">User name:</td>
            <td width="431"><input type="text" name="name"></td>
        </tr>
        <tr>
            <td width="100">Password:</td>
            <td width="431"><input type="password" name="password">
            </td>
        </tr>
    </table>
    <hr>
    <p>
        <input type="submit" name="btn_submit" value="Login"> <input
            type="reset" name="btn_reset" value="Reset">
    </p>
</form>
<p>&nbsp;</p>
</body>
</html>

<%
    int cookies_cnt = 0;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("name")) {
                cookies_cnt += 1;
            }
            if (cookies[i].getName().equals("password")) {
                cookies_cnt += 1;
            }
        }

        System.out.println(cookies_cnt);
        if (cookies_cnt == 2) {
            response.sendRedirect("Login.do");
        }
    }
%>

