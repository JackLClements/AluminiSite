<%-- 
    Document   : edit
    Created on : 18-Mar-2014, 16:05:28
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@page import ="java.util.*" %>
        <%@page import ="alumini.SiteUser" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - Edit</title>
    </head>
    
    <body>
        
        <div id="container">
            
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>

            <section>        
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <h1>Edit your personal details</h1>
        <form class="editForm" action="EditController" method="post" autocomplete="on">
                <p>First Name: <input type="text" name="firstName" value="${siteUser.firstName}"/></p>
                <p>Last Name:  <input type="text" name="lastName" value="${siteUser.lastName}"/></p>
                <p>Password: <input type="password" name="password" autocomplete="off" value="${siteUser.password}"/>
                <p>Confirm Password: <input type="password" name="password2" autocomplete="off" value="${siteUser.password}"/>                
                <p>Email: <input type="text" name="email" value="${siteUser.email}"/></p>
                <input type="hidden" name="username" value="${siteUser.username}"/>
                <input type="hidden" name="type" value="accountDetails"/>
                <p><input class="editButtons" type="submit" value="Update"/></p>
        </form>
        <form class="editForm" action="EditController" method="post" autocomplete="on">
                <p>Bio: <input type="text" name="bio" value="<%if(siteUser.getBio() == null){
                out.print("This is a bio, it contains all the info you think people might need to know.");
                
                }
                else{
                    out.print(siteUser.getBio());
                }
                %>"/></p>
                <p>Profile Image (URL): <input type="text" name="img" value="<%if(siteUser.getImg() != null){
                    out.print(siteUser.getImg());
                }
                    %>"/></p>
                <p>Location: <input type="text" name="location" value="<% if(siteUser.getLocation() != null){
                    out.print(siteUser.getLocation());}
                %>"/></p>
                <p>Gender <select name="gender">
                        <option value="Male" <% if(siteUser.getGender() != null && siteUser.getGender().equals("Male")){
                        out.print("selected='selected'");}
                        %>>Male</option>
                        <option value="Female" <% if(siteUser.getGender() != null && siteUser.getGender().equals("Female")){
                        out.print("selected='selected'");}
                        %>>Female</option>
                        <option value="N/A" <% if(siteUser.getGender() != null && siteUser.getGender().equals("N/A")){
                        out.print("selected='selected'");}
                        %>>Prefer not to say</option>
                    </select></p>
                <input type="hidden" name="username" value="${siteUser.username}"/>
                <input type="hidden" name="type" value="personalDetails"/>
                <p><input class="editButtons" type="submit" value="Update"/></p>
        </form>
            </section>
        </div>
    </body>
</html>
