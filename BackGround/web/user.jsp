<%@ page import="com.yongming.entity.UsersEntity" %><%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/24/16
  Time: 02:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        sessionStorage.setItem("Page2Visited", "True");
    </script>
    <title>Title</title>
</head>
<body>

<%
    UsersEntity user = (UsersEntity) session.getAttribute("user");
%>
<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>真实姓名</th>
        <th>年龄</th>
        <th>地址</th>
        <th>手机号码</th>
    </tr>

    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getRealName()%></td>
        <td><%=user.getAge()%></td>
        <td><%=user.getAddress()%></td>
        <td><%=user.getPhoneNum()%></td>
    </tr>
</table>
</body>
</html>
