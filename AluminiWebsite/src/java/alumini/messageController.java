/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumini;

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
 *
 * @author dha13jyu
 */
@WebServlet(name = "messageController", urlPatterns = {"/messageController"})
public class messageController extends HttpServlet {

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
        //Temporary arraylist for storing messages
        //ArrayList implementation now deprecated
        ArrayList<Message> messages = new ArrayList<Message>();
        response.setContentType("text/html;charset=UTF-8");
        //Get session
        HttpSession session = request.getSession();
        String type = request.getParameter("type");
        if(type.equals("readMessage")){
            int ID = Integer.parseInt(request.getParameter("ID"));
            Message newMsg = Message.getMessage(ID);
            Message.isRead(ID);
            request.setAttribute("message", newMsg);
            request.getRequestDispatcher("readMessage.jsp").forward(request, response);
        }
        else if(type.equals("reply")){
            int ID = Integer.parseInt(request.getParameter("ID"));
            Message newMsg = Message.getMessage(ID);
            request.setAttribute("message", newMsg);
            request.getRequestDispatcher("reply.jsp").forward(request, response);
        }
        else if(type.equals("delete")){
            int ID = Integer.parseInt(request.getParameter("ID"));
            Message newMsg = Message.getMessage(ID);
            newMsg.delete();
            request.getRequestDispatcher("Inbox.jsp").forward(request, response);
        }
        else if(type.equals("post")){
            String fromUser = request.getParameter("fromUser");
            String toUser = request.getParameter("toUser");
            String subject = request.getParameter("Subject");
            String message = request.getParameter("Message");
            Message msg = new Message(fromUser, toUser, subject, message);
            msg.persist();
            request.getRequestDispatcher("Inbox.jsp").forward(request, response);
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
