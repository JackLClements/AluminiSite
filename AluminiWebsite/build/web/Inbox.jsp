<%-- 
    Document   : Inbox
    Created on : 30-Mar-2014, 15:47:10
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="alumini.SiteUser"%>
<%@page import="alumini.Message"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - Inbox</title>
    </head>
    
    <body>
        <div id="container">
            
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>

            <section>
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <h1>${siteUser.username}'s Inbox</h1>
         <table border="1">
             <tr>
                 <td>From:</td>
                 <td>Subject:</td>
                 <td>Date Sent:</td>
             </tr>
            <%
                String user = siteUser.getUsername();
                ArrayList<Message> msg1 = Message.userInbox(user);
                for(Message i: msg1){
                %>
                <tr>
                    <td><% 
                    boolean msgRead = i.getMessageRead();
                    if (msgRead == true){out.print(i.getFromUser() + " (read)");
                    } 
                    else{
                        out.print(i.getFromUser());
                    } %>
                    </td>
                    <td><form action ="messageController" method="get">
                            <input type="submit" class="editButtons" id="schoolMatesButton" name="button" value="<% out.print(i.getSubject());%>"/>
                            <input type='hidden' value="<% out.print(i.getMessageID()); %>" name='ID'/>
                            <input type="hidden" value="readMessage" name="type"/>
                        </form></td>
                    <td><% out.print(i.getDate()); %></td>
                    <td><form action="messageController" method="get">
                            <input type="hidden" name="ID"  value="<% out.print(i.getMessageID()); %>"/>
                            <input type="hidden" value="delete" name="type"/>
                            <input class="editButtons" id="schoolMatesButton" type="submit" value="Delete"/>
                        </form></td> 
                </tr>    
                <%
                }
                %>
            
            
        </table>
                <a href="newMessage.jsp">Compose a new message</a>
            </section>
        </div>
    </body>
</html>
