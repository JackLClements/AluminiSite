/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumini;

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
@WebServlet(name = "newsController", urlPatterns = {"/newsController"})
public class newsController extends HttpServlet {

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
        //Get the session
        HttpSession session = request.getSession();
        String type = request.getParameter("type");
        //If the admin is posting news
        if(type.equals("post")){
            String newsAuthor = request.getParameter("newsAuthor");
            String title = request.getParameter("title");
            String newsContent = request.getParameter("newsContent");
            NewsPosts news = new NewsPosts(newsAuthor, title, newsContent);
            news.persist();
            request.getRequestDispatcher("adminPage.jsp").forward(request, response);
        }
        //If the user is reading news
        else if(type.equals("readNews")){
            String newsTitle = request.getParameter("title");
            NewsPosts news = NewsPosts.getNewsPost(newsTitle);
            request.setAttribute("news", news);
            request.getRequestDispatcher("readNews.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("adminPage.jsp").forward(request, response);
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
