<%-- 
    Document   : adminPage
    Created on : 30-Mar-2014, 22:10:56
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="alumini.SiteUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground Admin Access</title>
    </head>
    <body>
        <div id="container">
            
            <header><a href="adminPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="adminPage.jsp">HOME</a></div></header>

            <section>          
        <jsp:useBean id="adminUser" type="alumini.SiteUser" scope="session"/>
        <h1>Playground Admin User Access Menu</h1>
        <p><a href="adminUsers.jsp">All Users</a></p>
        <p><a href="stats.jsp">User statistics</a></p>
        <p><a href="newSchool.jsp">Add a new school</a></p>
        <p><a href="newNews.jsp">Add a new news post</a></p>
        <p><a href="LogoutAdmin.jsp">Log Out</a></p>
            </section>
        </div>
    </body>
</html>
