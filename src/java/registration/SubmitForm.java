package registration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BunnyRailgun
 */
public class SubmitForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Save data from form into a bean
        HttpSession session = request.getSession(true);
        FormBean fb = (FormBean) session.getAttribute("fb");
        if(fb == null){
            //Create a new bean if it doesn't exist already
            fb = new FormBean();
            session.setAttribute("fb", fb);
        }
        //Set values
        System.out.println("Query: " + request.getQueryString());
        fb.setFName(request.getParameter("FName"));
        fb.setLName(request.getParameter(("LName")));
        fb.setUserId(request.getParameter("UserID"));
        fb.setPassword(request.getParameter("Password"));
        fb.setRePassword(request.getParameter("RePassword"));
        fb.setAlias(request.getParameter("alias"));
        fb.setCountry(request.getParameter("country"));
        fb.setCity(request.getParameter("City"));
        fb.setLanguage(request.getParameter("Language"));
        fb.setSecurityQues(request.getParameter("SecurityQues"));
        fb.setSecurityAns(request.getParameter("SecurityAns"));
        fb.setCustomQuestion(request.getParameter("custom_question"));
        
        //Forward to debug
        RequestDispatcher rd = request.getRequestDispatcher("debugdata.jsp"); 
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
