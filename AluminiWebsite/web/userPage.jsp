<%-- 
    Document   : userPage
    Created on : 06-Mar-2014, 14:21:04
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page import ="java.util.*" %>
    <%@page import ="alumini.SiteUser" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "userPageCSS.css"/>
        <title>Playground - Home ${siteUser.firstName} ${siteUser.lastName}</title>
    </head>
    <body>
        
        <div id="container">
        
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <h1><jsp:getProperty name="siteUser" property="firstName"/> <jsp:getProperty name="siteUser" property="lastName"/></h1>
        <aside>
            <h3><jsp:getProperty name="siteUser" property="firstName"/> <jsp:getProperty name="siteUser" property="lastName"/></h3>
            <h5><i>${siteUser.location}</i></h5>
            <h4>${siteUser.username}</h4> 
            <img id="profileImage" src="<%if(siteUser.getImg()==null || siteUser.getImg().equals("")){out.print("profile-photo-placeholder.png");} else{out.print(siteUser.getImg());} %>" alt="image" height="250" width="250"/>
            <p><% if(siteUser.getBio() == null){
                out.print("This is a biography. It contains all the information about you that you think people might need to know! Be sure to <a href='edit.jsp'>a short description</a> to let other alumini about yourself!");
            }
            else{
                out.print(siteUser.getBio());
                out.print("</p><h6><a href='edit.jsp'>(edit)</a></h6>");
            }
                    %>
            <p>${siteUser.DOB}</p>
            <p><% if(siteUser.getGender()==null || siteUser.getGender().equals("")){%> <%} else{%> ${siteUser.gender} <%} %></p>
        </aside>
        <div id="buttons">
            <table>
                <tr>
                    <th><a href='addSchool.jsp'><div id="addSchool" class="buttons"></div></a><p>Add Schools</p></th>
                        <th><form action="schoolController" method="get">
                                <input type="hidden" name="type" value="listAllSchools" />
                                <input type="submit" class="buttons" id="allSchools" value=""/></form>
                        <p>All Schools</p>
                        </th>
                    <th><a href="schoolmates.jsp"><div id="schoolMates" class="buttons"></div></a><p>School Mates</p></th>
                </tr>
                <tr>
                    <td><a href='Inbox.jsp'><div id="inbox" class="buttons"></div></a><p>Inbox</p></td>
                    <td><a href='newsBox.jsp'><div id="button5" class="buttons"></div></a><p>News</p></td>
                    <td><a href='Logout.jsp'><div id="logOut" class="buttons"></div></a><p>Log Out</p></td>
                </tr>
            </table>
        </div>
        </div>
    </body>
</html>
