<%-- 
    Document   : Logout
    Created on : 13-Mar-2014, 17:49:55
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="java.util.*" %>
        <%@page import="alumini.SiteUser"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - Log Out?</title>
    </head>
    <body>
        <div id="container">
            <header><a href="adminPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="adminPage.jsp">HOME</a></div></header>
               
            <section>         
        <h1>Confirm Logout Page</h1>
         <jsp:useBean id="adminUser" type="alumini.SiteUser" scope="session"/>
         <h2>${adminUser.username}, are you sure you wish to logout?</h2>
        <p><a href="Logout">Confirm Logout</a></p>
        <% String thing = adminUser.getUsername();
            
            if(thing.equals("admin")){ %><p><a href="adminPage.jsp">back to page</a></p> <% }
            else{
                %><p><a href="userPage.jsp">back to page</a></p> <%
    }%>
            </section>
        </div>
    </body>
</html>
