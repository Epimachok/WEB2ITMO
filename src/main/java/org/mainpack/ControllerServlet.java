package org.mainpack;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x =  request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        if (x!=null && y!=null && r!=null){
            getServletContext().getRequestDispatcher("/check").forward(request, response);
        }
        /*else{
            request.getRequestDispatcher("/area.jsp").forward(request, response);
        }*/
    }
}