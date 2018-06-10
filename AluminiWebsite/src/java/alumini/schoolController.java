package alumini;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Deals with all school based data
 * @author dha13jyu
 */
@WebServlet(urlPatterns = {"/schoolController"})
public class schoolController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Get Session
        HttpSession session = request.getSession();
        String type = request.getParameter("type");
        //Code for adding a user to the schoolAttended
        if(type.equals("addSchool")){
            String school = request.getParameter("schools");
            int yearJoined = Integer.parseInt(request.getParameter("enrolled"));
            int yearLeft = Integer.parseInt(request.getParameter("graduated"));
            if(yearLeft < yearJoined){
                request.getRequestDispatcher("addSchool.jsp").forward(request, response);
            }
            else{
                String username = request.getParameter("username");
                SchoolAttended school1 = new SchoolAttended(username, school, yearJoined, yearLeft);
                school1.persist();
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
                
            }
        }
        //List of all schools
        else if(type.equals("listAllSchools")){
            ArrayList schoolList = School.returnAll();
            request.setAttribute("schoolList", schoolList);
            request.getRequestDispatcher("allSchools.jsp").forward(request, response);
        }
        //personal page of each school
        else if(type.equals("schoolPage")){
            String school = request.getParameter("button");
            School school1 = School.getSchool(school);
            request.setAttribute("schoolPage", school1);
            request.getRequestDispatcher("schoolPage.jsp").forward(request, response);
        }
        //Adding a new school to the database
        else if(type.equals("newSchool")){
            String schoolName = request.getParameter("schoolName");
            int opened = Integer.parseInt(request.getParameter("opened"));
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String website = request.getParameter("website");
            String location = request.getParameter("location");
            String latitude = request.getParameter("latitude");
            String longitude = request.getParameter("longitude");
            School newSchool = new School(schoolName, opened, description, image, website, location, latitude, longitude);
            newSchool.persist();
            request.getRequestDispatcher("adminPage.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("userPage.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
