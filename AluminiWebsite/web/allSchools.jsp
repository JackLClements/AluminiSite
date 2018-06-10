<%-- 
    Document   : allSchools
    Created on : 27-Mar-2014, 16:36:25
    Author     : dha13jyu
--%>

<%@page import="java.util.*"%>
<%@page import="alumini.School"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - School Library</title>
        <style>
            .linkButton{
                background: none;
                border: none;
                color: #0066ff;
                text-decoration: underline;
                cursor: pointer;
            }
            
        </style>
    </head>
    
    <body>
        
        <div id="container">
            
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>

            <section>        
         <h1>List of all schools</h1>
        <table border="1">
            <%
                List schoolList = (List) request.getAttribute("schoolList");
                Iterator it = schoolList.iterator();
                while(it.hasNext()){
                    School school = (School) it.next();
                %>
                <tr>
                    <td><form action ="schoolController" method="get">
                            <input type="submit" class="linkButton" name="button" value="<%=school.getSchoolName()%>"/>
                            <input type="hidden" value="schoolPage" name="type"/>
                        </form></td>
                    <td><%=school.getOpened()%></td>                   
                    <td><%=school.getDescription()%></td>
                </tr>    
                <%
                }
                %>
            
            
        </table>
            </section>
        </div>
    </body>
</html>
