<%-- 
    Document   : newNews
    Created on : 31-Mar-2014, 20:22:57
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground Admin Panel - Add News</title>
    </head>
    <body>
        <div id="container">
            
            <header><a href="adminPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="adminPage.jsp">HOME</a></div></header>
            <section>    
        <jsp:useBean id="adminUser" type="alumini.SiteUser" scope="session"/>
        <form action="newsController" method="post">
            <p>Title</p>
            <input type="hidden" name="type" value="post"/>
            <input type="hidden" name="newsAuthor" value="<% out.print(adminUser.getUsername()); %>"/>
            <input type="text" name="title"/>
            <p>Content:</p>
            <textarea rows="4" cols="50" name="newsContent"></textarea>
            <p>
            <input type="submit" value="Send"/>
            </p>
        </form>
            </section>
        </div>
    </body>
</html>
