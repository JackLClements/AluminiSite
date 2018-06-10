<%-- 
    Document   : stats
    Created on : 31-Mar-2014, 16:31:26
    Author     : dha13jyu
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="alumini.SiteUser"%>
<%@page import="alumini.SchoolAttended"%>
<%@page import="alumini.School"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground Admin Panel - Statistics</title>
    </head>
    <body>
        <div id="container">
            
            <header><a href="adminPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="adminPage.jsp">HOME</a></div></header>

            <section>        
        <h1>User Statistics</h1>
        <p>Total Users - <% int users = SiteUser.getNumOfUsers();
                out.print(users);  %> </p>
        <p>Total Schools - <%out.print(School.getSchools()); %></p>
        
        <% 
                    String [] schoolList = School.getAllSchools();
                    for(String s: schoolList){
                        %><h2><b><%out.print(s);%></b></h2>
        <table border="1">
            <tr>
            <th>Username</th>
            <th>Name</th>
            <th>Year Attended</th> 
            <th>Year Graduated</th>
            </tr>
        <%
                        ArrayList<SchoolAttended> schools = SchoolAttended.getSchoolAlumini(s);
                        for(SchoolAttended i: schools){
                            String edit1 = i.getUsername();
                            int edit2 = i.getStartDate();
                            int edit3 = i.getEndDate();
                            SiteUser user1 = SiteUser.getUser(edit1);
                            String name1 = user1.getFirstName();
                            String name2 = user1.getLastName();
                            %> <tr><td><%out.print(edit1);%></td>
                               <td><%out.print(name1); %> <%out.print(name2); %></td>
                               <td><%out.print(edit2); %></td>
                               <td><%out.print(edit3); %></td>
                               </tr><%
                    }
                        %>
                        </table>
                        <%
                 }
                %>
                
            </section>
        </div>
               
    </body>
</html>
