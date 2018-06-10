package alumini;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import alumini.SiteUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dha13jyu
 */
@WebServlet(urlPatterns = {"/EditController"})
public class EditController extends HttpServlet {

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
        HttpSession session = request.getSession();
        String type = request.getParameter("type");
        if(type.equals("accountDetails")){
            
             String username = request.getParameter("username");
             String firstName = request.getParameter("firstName");
             String lastName = request.getParameter("lastName");
             String password = request.getParameter("password");
             String email = request.getParameter("email");
             
             SiteUser user1 = SiteUser.getUser(username);
             user1.setFirstName(firstName);
             user1.setLastName(lastName);
             user1.setPassword(password);
             user1.setEmail(email);
             
             user1.editAccount();
             
             session.setAttribute("siteUser", user1);
             request.getRequestDispatcher("userPage.jsp").forward(request, response);
            
        }
        else if(type.equals("personalDetails")){
             String username = request.getParameter("username");
             String bio = request.getParameter("bio");
             String img = request.getParameter("img");
             String location = request.getParameter("location");
             String gender = request.getParameter("gender");
             
             SiteUser user1 = SiteUser.getUser(username);
             user1.setBio(bio);
             user1.setImg(img);
             user1.setLocation(location);
             user1.setGender(gender);
             
             user1.editBio();
             
             session.setAttribute("siteUser", user1);
             request.getRequestDispatcher("userPage.jsp").forward(request, response);
             
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
