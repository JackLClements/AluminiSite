<%-- 
    Document   : newsBox
    Created on : 31-Mar-2014, 20:40:24
    Author     : dha13jyu
--%>

<%@page import="alumini.NewsPosts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="alumini.SiteUser"%>
<%@page import="alumini.Message"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - News Box</title>
    </head>
    <body>
        <div id="container">
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
        
            <section>   
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <h1>News Box</h1>
        <table border="1">
             <tr>
                 <td>Date:</td>
                 <td>Author:</td>
                 <td>Title:</td>
             </tr>
             <% ArrayList<NewsPosts> news = NewsPosts.userNews();
             for(NewsPosts i: news){
                 %> <tr> 
                     <td> <% out.print(i.getNewsDate());%></td>
                     <td> <% out.print(i.getNewsAuthor());%></td>
                     <td> <form action="newsController" method="get">
                         <input type="hidden" value="readNews" name="type"/>   
                          <input type='hidden' value="<% out.print(i.getNewsTitle()); %>" name='title'/>
                         <input class="editButtons" id="schoolMatesButton" type="submit" name="button" value="<% out.print(i.getNewsTitle());%>"/></form></td>
                 </tr> <%
             } %>
        </table>
            </section>
        </div>
    </body>
</html>
