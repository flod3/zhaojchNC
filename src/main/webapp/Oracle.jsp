<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="org.springframework.beans.factory.BeanFactory" %>
<%@ page import="com.yonyou.dao.ConnectDatabase" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.yonyou.dao.ConnectDatabase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello wroldddd</h1>
<%

    BeanFactory factory=null;
    factory=new ClassPathXmlApplicationContext("applicationContext.xml");
    ConnectDatabase connectOracle=(ConnectDatabase)factory.getBean("ConnectOracle");
    Connection conn=connectOracle.getConnection();
    PreparedStatement preparedStatement=null;
    preparedStatement=conn.prepareStatement("select * from org_orgs order by ts desc");
    ResultSet resultSet=preparedStatement.executeQuery();


%>

    <table cellspacing="0" border="1">
        <%
            int i=0;
            while(resultSet.next()){
                %>   <tr>

        <%
                for(int j=1;j<resultSet.getMetaData().getColumnCount();j++){
                    %>
        <td nowrap>
        <%= resultSet.getString(j)%>
        </td>
        <%
            }
        %>
            </tr>

        <%

            }
        %>
    </table>

</body>
</html>
