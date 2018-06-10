<%-- 
    Document   : index
    Created on : 05-Mar-2014, 17:11:41
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "indexCSS.css"/>
        <title>Playground - The Social Network for Alumini</title>
    </head>
    <body>
        <script src="validationScript.js"></script>
        <div id="container">
            <div class="slideShow"></div>
        <!--Content to be added inc. cookie for login, persistence for site sessions. -->
        
        <header>
            <img src ="SiteLogo1.png" height="120" id="siteLogo1" alt="site logo"/>
        </header>
        
        <section class="nameLater">
        <form action ="Controller" method ="post">
            <p>Username: <input type ="text" name="username"/></p>
            <p>Password <input type="password" name="password"/></p>
            <input type="hidden" name="type" value="logIn"/>
            <p><input class="buttons" type="submit" value="Login"/></p>
        </form>
        </section>
        
        <aside class="nameLater">
        <form action="Controller" method="post" autocomplete="on" name="registration" onsubmit="return validateForm();">
                <p>First Name: <input type="text" name="firstName" placeholder="First name"/></p>
                <p>Last Name:  <input type="text" name="lastName"/></p>
                <p>Username: <input type="text" name="username"/></p>
                <p>Password: <input type="password" name="password" autocomplete="off"/>
                <p>Confirm Password: <input type="password" name="password2" autocomplete="off"/>
                <p>Date of Birth: <input type="date" name="DOB"/></p>                
                <p>Email: <input type="text" name="email"/></p>
                <input type="hidden" name="type" value="signUp"/>
                <p><input class="buttons" type="submit" value="Register"/></p>
        </form>
        </aside>
        </div>
    </body>
</html>
