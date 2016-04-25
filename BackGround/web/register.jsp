<%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/22/16
  Time: 05:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>My JSP 'register.jsp' starting page</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<s:form action="userRegisterAction.action" id="register" onsubmit="return validate_form(this);">

    <input type="text" class="form-control input" id="userName" name="userName" placeholder="输入用户名">
    <input type="password" class="form-control input" id="password" name="password" placeholder="输入密码">
    <input type="password" class="form-control input" id="password2" name="confirmPassword" placeholder="输入密码">

    <input type="text" class="form-control input" id="address" name="address" placeholder="地址">
    <input type="text" class="form-control input" id="realName" name="realName" placeholder="真实姓名">
    <input type="text" class="form-control input" id="phoneNum" name="phoneNum" placeholder="手机号">
    <input type="number" class="form-control input" id="age" name="age" placeholder="年龄">

    <s:submit value="注册"/>
</s:form>


<script src="http://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js"/>
<script src="check.js" ></script>

</body>
</html>
