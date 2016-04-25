<%@ page import="com.yongming.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/23/16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script>
        sessionStorage.setItem("Page2Visited", "True");
    </script>
    <title>Title</title>
</head>
<body>

<table>
    <%
        List<UsersEntity> list = (List<UsersEntity>) session.getAttribute("list");
        Iterator<UsersEntity> iter = list.iterator();
    %>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>真实姓名</th>
        <th>年龄</th>
        <th>地址</th>
        <th>手机号码</th>
    </tr>
    <tr>
        <%
            int i = 0;
            while(iter.hasNext()){
                UsersEntity user = (UsersEntity)iter.next();
        %>
        <tr>
            <td>
                <p>
                    <%=user.getId()%>
                </p>
            </td>
            <td>
                <p>
                    <%=user.getUserName()%>
                </p>
            </td>
            <td>
                <p>
                    <%=user.getRealName()%>
                </p>
            </td>
            <td>
                <p>
                    <%=user.getAge()%>
                </p>
            </td>
            <td>
                <p>
                    <%=user.getAddress()%>
                </p>
            </td>
            <td>
                <p>
                    <%=user.getPhoneNum()%>
                </p>
            </td>
            <td>
                <a href="userDelete?user.id=<%=user.getId()%>">删除</a>
            </td>
        </tr>
        <%
            i++;
            }
        %>


</table>
</body>
</html>
