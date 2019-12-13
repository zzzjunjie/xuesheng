<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>数码商城后台</title>
    <link rel="stylesheet" href="css/normalize.css">
</head>
<% Object error = request.getAttribute("error");
if(error!=null){
%><script>alert("登陆账号或者密码错误~");</script><%
}%>
<body>

<div class="login">
    <h1>学生信息后台管理</h1>
    <form method="post" action="/AdminServlet">
        <input type="text" id="name" name="u" placeholder="用户名" required="required"/>
        <input type="password" id="password" name="p" placeholder="密码" required="required"/>
        <div id="radio"style="color: #FFF;">
            <input type="radio" name="POW" value="1" title="学生" checked style="width: min-content;color: #FFF" >学生
            <input type="radio" name="POW" value="2" title="老师"style="width: min-content;color: #FFF" >老师
        </div>
        <button type="submit" class="btn btn-primary btn-block btn-large">登录</button>
    </form>
</div>
<script src="js/jquery/jQuery-2.2.0.min.js"></script>

    <c:if test="${requestScope.error}==400">
    <script>
        alert("账号或者密码错误!");
    </script>
    </c:if>

</body>
</html>
