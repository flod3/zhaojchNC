<%@ page import="com.yonyou.dao.BaseDAO" %>
<%@ page import="com.yonyou.POJO.MenuVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yonyou.POJO.SuperVO" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/27
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
        <div id="head">

        </div>
        <div id="leftlist">
            <table>
                <%
                    BaseDAO dao=new BaseDAO("MySql");
                    ArrayList<SuperVO> volist=dao.getVOwithCase(MenuVO.class," father_menu='~'");
                    for(SuperVO vo:volist){
                        MenuVO menuVO=(MenuVO)vo;

                        %>
                <tr>
                    <td>
                        <%=menuVO.getName()%>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>
        <div id="main">

        </div>
</body>
</html>
