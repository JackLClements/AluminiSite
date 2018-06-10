<%-- 
    Document   : reply
    Created on : 30-Mar-2014, 18:20:43
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="alumini.SiteUser"%>
<%@page import="alumini.Message"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="container">
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
        
            <section>    
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <jsp:useBean id="message" type="alumini.Message" scope="request"/>
        <form action="messageController" method="post">
            <p>Reply to ${message.fromUser}:</p>
            <input type="hidden" name="type" value="post"/>
            <input type="hidden" name="toUser" value="<% out.print(message.getFromUser()); %>"/>
            <input type="hidden" name="fromUser" value="<% out.print(message.getToUser()); %>" />
            <input type="text" name="Subject" value="RE: <% out.print(message.getSubject()); %>" />
            <input type="text" id="messageField" name="Message" />
            <input class="editButtons" id="messageSend" type="submit" value="Send"/>
        </form>
            </section>
        </div>
        </form>
    </body>
</html>
