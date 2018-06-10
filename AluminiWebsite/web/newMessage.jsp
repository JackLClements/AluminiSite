<%-- 
    Document   : newMessage
    Created on : 30-Mar-2014, 18:51:02
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
        <script>function validateMsg(){
            var message = document.forms["msg"]["Message"].value;
            if(message.length > 160){
                alert("Message length must not exceed 160 Characters");
                return false;
            }
        }</script>
        <title>Playground - Send Message</title>

    </head>
    
    <body>
        <div id="container">
            
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
            <section>
                <h1>Send New Message</h1>
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <form class="messageForm" name="msg" action="messageController" method="post" onsubmit="return validateMsg();">
            <p>Send to:
            <input type="hidden" name="type" value="post"/>
            <input type="hidden" name="fromUser" value="<% out.print(siteUser.getUsername()); %>"/>
            <input id="toField" type="text" name="toUser"/>
            Subject:
            <input id="subjectField" type="text" name="Subject" />
            <p>Message:</p>
            <input id="messageField" type="text" name="Message" />

            <p>
            <input class="editButtons" id="messageSend" type="submit" value="Send"/>
            </p>
        </form>
            </section>
        </div>
    </body>
</html>
