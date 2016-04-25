<%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/21/16
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Welcome</title>
    <script>
      sessionStorage.setItem("Page2Visited", "True");
    </script>
      <link href="style.css" rel="stylesheet" type="text/css">
      <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>

  <s:actionerror/>
  <s:property value="message"/>
  <a href="register.jsp">注册</a>
  <hr/>
  请您登录:
  <s:form  action="userLoginAction.action" >


    <input type="text" class="form-control input" name="userName" placeholder="输入用户名">
    <input type="password" class="form-control input" name="password" placeholder="输入密码">
      <s:submit value="提交"/>
  </s:form>
  <hr/>

  <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
  <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

  </body>
</html>
