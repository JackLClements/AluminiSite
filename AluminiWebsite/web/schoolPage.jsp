<%-- 
    Document   : schoolPage
    Created on : 27-Mar-2014, 18:33:35
    Author     : dha13jyu
--%>

<%@page import="alumini.SiteUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="alumini.SchoolAttended"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" type= "text/css" href= "miscPagesCSS.css"/>
        <title>Playground - School ${schoolPage.schoolName}</title>
        <%@page import ="java.util.*" %>
        <%@page import ="alumini.School" %>
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
            <div class="aboveHeader"></div>
            <header><a href="userPage.jsp"><img src="SiteLogo2.png" height="60" id="siteLogo2" alt="siteLogo"/></a><div id='homeButton'><a id='home' href="userPage.jsp">HOME</a></div></header>
               
            <section>
        <jsp:useBean id="siteUser" type="alumini.SiteUser" scope="session"/>
        <jsp:useBean id="schoolPage" type="alumini.School" scope="request"/>
         <h1>${schoolPage.schoolName}</h1>
         <p>Location: ${schoolPage.location}</p>
         <img src="${schoolPage.image}" alt="school_photo" height="250" width="500"/>
         <p>${schoolPage.description}</p>
         <p>Opened - ${schoolPage.opened}</p>
         <div class="googleMap" style="height:500px;width:600px;overflow:hidden;"><style scoped type="text/css" media="screen" >.gm-style img{max-width: none; background:none !important;}.gm-style-iw{height:auto !important; color:#000000; display:block; white-space:nowrap; width:auto !important; line-height:18px; overflow:hidden !important;}</style><script type="text/javascript" src="http://maps.google.com/maps/api/js?v=3&amp;sensor=false"></script><div style="height:500px;width:600px;overflow:hidden;"><div id="gmap_canvas" style="height:500px; width:600px;"></div><a href="http://www.embed-google-map.com/wordpress/" class="map-data">embed-google-map.com</a></div><script type="text/javascript">function init_map(){var myOptions = {zoom:14,center:new google.maps.LatLng(${schoolPage.latitude}, ${schoolPage.longnitude}),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(${schoolPage.latitude}, ${schoolPage.longnitude})}); infowindow = new google.maps.InfoWindow({content:"<span style='height:auto !important; display:block; white-space:nowrap; overflow:hidden !important;'><strong style='font-weight:400;'>${schoolPage.schoolName}</strong><br>${schoolPage.location}<br></span>" }); google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);}); infowindow.open(map,marker);}google.maps.event.addDomListener (window, "load", init_map);</script></div>
         <a href="${schoolPage.website}">${schoolPage.website}</a>
         
          <table border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Year Attended</th> 
                <th>Year Graduated</th>
            </tr>
             <% String school = schoolPage.getSchoolName();
                ArrayList<SchoolAttended> schools = SchoolAttended.getSchoolAlumini(school);
             for(SchoolAttended i: schools){
                String edit1 = i.getUsername();
                int edit2 = i.getStartDate();
                int edit3 = i.getEndDate();
                SiteUser user1 = SiteUser.getUser(edit1);
                String name1 = user1.getFirstName();
                String name2 = user1.getLastName();
                %><tr><td><form action ="matesController" method="get">
                    <input type="submit" class="editButtons" id="schoolMatesButton" name="button" value="<%out.print(edit1);%>"/>
                    <input type="hidden" value="userPage" name="type"/>
                        </form></td>
                 <td><%out.print(name1); %> <%out.print(name2); %></td>
             <td><%out.print(edit2); %></td>
             <td><%out.print(edit3); %></td></tr><%
                }
             %> 
        </table>
            </section>
        </div>
    </body>
</html>
