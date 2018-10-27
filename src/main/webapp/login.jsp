
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢淫界面</title>
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <script type="text/javascript" src="js/login.js"></script>


</head>
<body>
    <div id="main">
        <span style="font-size:20px; ">账户登录</span>
        <br>
        <hr>
        <br>
        <input type="text" class="normal_input" placeholder="账号" id="username"> <br> <br>
        <input type="text" class="normal_input" placeholder="密码" id="password"> <br> &nbsp;
        <input type="checkbox" id="rememberme"> <label for="rememberme">记住老子</label> <br> <br>
        <input type="button" value="登录" onclick="check()">
    </div>
</body>
</html>
