<%-- 
    Document   : readNews
    Created on : 31-Mar-2014, 21:18:09
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="alumini.SiteUser"%>
<%@page import="alumini.NewsPosts"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - Read News</title>
    </head>
    <body>
        <div id="container">
            
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
            <section>         
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <jsp:useBean id="news" type="alumini.NewsPosts" scope="request"/>
        <h1>${news.newsTitle} - Posted on ${news.newsDate}</h1>
        <h2><i>${news.newsAuthor}</i></h2>
        <p>${news.newsContent}</p>
            </section>
        </div>
    </body>
</html>
