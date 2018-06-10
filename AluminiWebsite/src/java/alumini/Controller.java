/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumini;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 *
 * @author dha13jyu
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

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
        String type = request.getParameter("type");
        if(type.equals("logIn")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            //Establish session
            HttpSession session = request.getSession(true);
             
            //Code that checks if the username and password match an account
            //Should be SiteUser method
            //Note - 11/03/14, is this neccesary? Using SQL, these two details should provide validation enough
            
            //Another method that takes username and password, then gets SQL info
            //Including data from fields
            SiteUser user1 = SiteUser.checkLogIn(username, password);
            if(user1 == null){
               request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            if(user1.getUsername().equals("admin")){
                session.setAttribute("adminUser", user1);
                request.getRequestDispatcher("adminPage.jsp").forward(request, response);
            }
            else{
                //Forward data to servlet
                //request.setAttribute("siteUser", user1);
                session.setAttribute("siteUser", user1);
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
            }
            
        }
        else if(type.equals("signUp")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String dOB = request.getParameter("DOB");
            String email = request.getParameter("email");
            
            SiteUser user1 = new SiteUser(username, password, firstName, lastName, dOB, email);
            
            //METHOD TO PERIST USER TO DB
            user1.persist();
           
            //Create session w/ cookie
            //Still to do
            
            //Establish session
            HttpSession session = request.getSession(true);
            
            session.setAttribute("siteUser", user1);
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
