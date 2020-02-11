/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phillip Obiora
 */
public class ShoppingListServlet extends HttpServlet {
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
        // get session
        HttpSession session = request.getSession();
        String isLoggedIn = (String) session.getAttribute("user");
        String action = request.getParameter("action");
        
        if(action == null){
            // Redirect to login servlet
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
        }
        else{
            // If user is logging out
            if(action.equals("logout")){
                // Invalidate Session
                session.invalidate();
                // Let user know hes been locked out
                request.setAttribute("message", "You have successfully logged out");
                // Redirect to login servlet
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response); 
            }
            else if(isLoggedIn != null){
                // Redirect to login servlet
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response); 
            }
            else{
                // Redirect to login servlet
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
            }
        }
        
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
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        
        // Create sesison
        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("itemList");
        
        // If action is register
        if(action.equals("register")){
            // Set a session attribute to username
            session.setAttribute("user", username);
            // Forward user to shopping list jsp
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
        }
        else if(action.equals("add")){
             // Check if list is empty then create a new list
            if(items == null){
                ArrayList<String> newList =  new ArrayList<>();
                // Add item to Arraylist
                newList.add(item);
                // Add item list to session
                session.setAttribute("itemList", newList);

            }
            else{
                // Add item to Arraylist
                items.add(item);
                // Add item list to session
                session.setAttribute("itemList", items);

            }
            // Forward user to shopping list jsp
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
        }
        else if(action.equals("delete")){
            // Delete item from list
            items.remove(item);
            // Add item list to session
            session.setAttribute("itemList", items);
            // Forward user to shopping list jsp
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
        }
        else{
            // Do nothing
        }
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
