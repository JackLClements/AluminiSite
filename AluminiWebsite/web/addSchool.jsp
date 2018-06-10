<%-- 
    Document   : addSchool
    Created on : 20-Mar-2014, 14:02:08
    Author     : dha13jyu
--%>

<%@page import="alumini.SchoolAttended"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page import ="java.util.*" %>
    <%@page import ="alumini.School" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - Add School history</title>
    </head>
    
    <body>
        
        <div id="container">
            
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
            
            <section>        
        <h1>Add a school</h1>
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <form action='schoolController' method='post'>
            <input type="hidden" name="username" value="${siteUser.username}"/>
            School: <select name='schools'>
                <% 
                    String [] schoolList = School.getAllSchools();
                    for(String s: schoolList){
                        %> <option value='<% out.print(s); %>'> <% out.print(s); %> </option><%
                    }
                %>
            </select>
            Enrolled: <select name="enrolled">
                <% 
                    
                for(int i = 1940; i < 2015; i++){
                %> <option value='<% out.print(i); %>'> <% out.print(i); %> </option> <%
                }
                
                
                %>
            </select>
            Graduated: <select name="graduated">
                <% 
                for(int i = 1941; i < 2015; i++){
                %> <option value='<% out.print(i); %>'> <% out.print(i); %> </option> <%
                }
                
                
                %>
            </select>
            <input type="hidden" name="type" value="addSchool"/>
            <p><input type="submit" value="Add to Schools"/></p>
        </form>
             <table border="1">
            <tr>
                <th>School</th>
                <th>Year Attended</th> 
                <th>Year Graduated</th>
            </tr>
             <% String newname = siteUser.getUsername();
                ArrayList<SchoolAttended> schools = SchoolAttended.getUserSchools(newname);
             for(SchoolAttended i: schools){
                String edit1 = i.getSchool();
                int edit2 = i.getStartDate();
                int edit3 = i.getEndDate();
             %><tr><td><%out.print(edit1); %></td>
             <td><%out.print(edit2); %></td>
             <td><%out.print(edit3); %></td>
             <td><form action="deleteController" method="post">
                  <input type="hidden" name="username" value="${siteUser.username}"/>
                  <input type="hidden" name="school" value="<%out.print(edit1); %>"/>
                  <input type="hidden" name="startDate" value="<%out.print(edit2); %>"/>
                  <input type="hidden" name="endDate" value="<%out.print(edit3); %>"/>
                  <input type="submit" value="Delete"/>   
                 </form></td></tr><%
                }
             %> 
        </table>
        
        <p>Is your school/college/university not on this list? <a href="mailto:admin@playground.com?Subject=Request%20to%20add%20a%20a%20site" target="_top">
Send us an email</a> and we'll endeavour to update as soon as possible.</p>
            </section>
        </div>
    </body>
</html>
