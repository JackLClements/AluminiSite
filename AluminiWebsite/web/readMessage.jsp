<%-- 
    Document   : readMessage
    Created on : 30-Mar-2014, 17:43:43
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
        <title>Playground message - </title>
    </head>
    <body>
        <div id="container">
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
        
            <section>          
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <jsp:useBean id="message" type="alumini.Message" scope="request"/>
        <% SiteUser user1 = SiteUser.getUser(message.getFromUser()); %>
        <img src="<%if(user1.getImg()==null || user1.getImg().equals("")){out.print("profile-photo-placeholder.png");} else{out.print(user1.getImg());} %>" alt="image" height="100" width="100"/>
        <p><b>From:</b>${message.fromUser}</p>
        <p><b>Subject:</b>${message.subject}</p>
        <p><b>Message:</b></p>
        <p>${message.message}</p>
        
        <form action ="messageController" method="get">
                            <input type="submit" class="linkButton" name="button" value="Reply"/>
                            <input type='hidden' value="<% out.print(message.getMessageID()); %>" name='ID'/>
                            <input type="hidden" value="reply" name="type"/>
        </form>
            </section>
        </div>
    </body>
</html>
