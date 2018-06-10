<%-- 
    Document   : userView
    Created on : 29-Mar-2014, 18:02:19
    Author     : dha13jyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="alumini.SiteUser"%>
<%@page import="alumini.SchoolAttended"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "userPageCSS.css"/>
        <title>Playground - ${viewUser.username}'s Profile</title>
    </head>
    
    <body>
        <div id="container">
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
                    
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <jsp:useBean id="viewUser" type="alumini.SiteUser" scope="request"/>
        
        <aside id="userView">
        <p>${viewUser.username}</p>
        <p>${viewUser.firstName} ${viewUser.lastName}</p>
        <img id="profileImage" src="<%if(viewUser.getImg()==null || viewUser.getImg().equals("")){out.print("profile-photo-placeholder.png");} else{out.print(viewUser.getImg());} %>" alt="image" height="250" width="250"/>
        <p>${viewUser.bio}</p>
        </aside>
        
        <section>
        <h2>Classmates</h2>
          <table border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>School</th>
                <th>Year Attended</th> 
                <th>Year Graduated</th>
            </tr>
             <% String newname = viewUser.getUsername();
                ArrayList<SchoolAttended> classmates = SchoolAttended.getSchoolmates(newname);
             for(SchoolAttended i: classmates){
                String edit4 = i.getUsername();
                String edit1 = i.getSchool();
                int edit2 = i.getStartDate();
                int edit3 = i.getEndDate();
                SiteUser tempUser = SiteUser.getUser(edit4);
                String name1 = tempUser.getFirstName();
                String name2 = tempUser.getLastName();
                %><tr><td>
                        <form action ="matesController" method="get">
                        <input class="editbuttons"  id="schoolMatesButton" type="submit" name="button" value="<%out.print(edit4);%>"/>
                        <input type="hidden" value="userPage" name="type"/>
                        </form>
                    </td>
                    <td><%out.print(name1);%> <%out.print(name2);%></td>
             <td><%out.print(edit1); %></td>
             <td><%out.print(edit2); %></td>
             <td><%out.print(edit3); %></td></tr><%
                }
             %> 
        </table>
        </section>
        </div>
    </body>
</html>
