<%-- 
    Document   : newSchool
    Created on : 31-Mar-2014, 16:36:04
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Add a school</title>
    </head>
    <body>
        <div id="container">
            
            <header><a href="adminPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="adminPage.jsp">HOME</a></div></header>
            <section>             
        <h1>Add a school</h1>
        <form class="editForm" action="schoolController" method="post">
                <p>School Name: <input type="text" name="schoolName"/></p>
                <p>Opened: <input type="number" name="opened"/></p>
                <p>Description: <input type="text" name="description"/></p>
                <p>Image: <input type="text" name="image"/>
                <p>Website: <input type="text" name="website"/>
                <p>Location: <input type="text" name="location"/></p>                
                <p>Latitude: <input type="text" name="latitude"/></p>
                <p>Longitude: <input type="text" name="longitude"/></p>
                <input type="hidden" name="type" value="newSchool"/>
                <p><input type="submit" value="Register"/></p>
        </form>
            </section>
        </div>
    </body>
</html>
