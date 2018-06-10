<%-- 
    Document   : adminUsers
    Created on : 31-Mar-2014, 16:13:32
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="alumini.SiteUser"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground Admin Panel - Userbase</title>
    </head>
    <body>
        <div id="container">
            
            <header><a href="adminPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="adminPage.jsp">HOME</a></div></header>

            <section>         
        <jsp:useBean id="adminUser" type="alumini.SiteUser" scope="session"/>
        <h1>Playground - Current Userbase</h1>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Location</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Messages Sent</th>
                <th>Messages Received</th>
            </tr>
            <%
                ArrayList<SiteUser> users = SiteUser.getAllUsers();
                for(SiteUser i: users){
                    
                %>
                <tr>
                    <td><%out.print(i.getUsername()); %></td>
                    <td><% out.print(i.getFirstName() + " " + i.getLastName());%></td>                   
                    <td><% out.print(i.getDOB()); %></td>
                    <td><% out.print(i.getLocation()); %></td>
                    <td><% out.print(i.getGender()); %></td>
                    <td><% out.print(i.getEmail()); %></td>
                    <td><% out.print(i.getNoOfMessages());%></td>
                    <td><% out.print(i.getSentMessages());%></td>
                </tr>    
                <%
                }
                %>
        </table>
            </section>
        </div>
    </body>
</html>
