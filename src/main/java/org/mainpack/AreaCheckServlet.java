package org.mainpack;
import beans.AnswerBean;
import beans.Tablebean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class AreaCheckServlet extends HttpServlet{
    public AnswerBean ansbean = new AnswerBean();
    public Tablebean tablebean = new Tablebean();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String X =  request.getParameter("x");
        String Y = request.getParameter("y");
        String R = request.getParameter("r");

        Locale locale = new Locale("en", "US");
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

        if (X!=null && Y!=null && R!=null){
            try {
                float x = Float.parseFloat(request.getParameter("x"));
                float y = Float.parseFloat(request.getParameter("y"));
                float r = Float.parseFloat(request.getParameter("r"));
                ansbean.setX(x);
                ansbean.setY(y);
                ansbean.setR(r);
                if (checkData(x, y, r)) {
                    tablebean.addX(x);
                    tablebean.addR(r);
                    tablebean.addY(y);
                    if (checkArea(x,y,r)) {
                        ansbean.setAns(messages.getString("ans_hit"));
                        tablebean.addAns(messages.getString("ans_hit"));
                    }else{
                        ansbean.setAns(messages.getString("ans_miss"));
                        tablebean.addAns(messages.getString("ans_miss"));
                    }
                } else {
                    ansbean.setAns(messages.getString("ans_bad"));
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            } finally {
                ServletContext sc = getServletContext();
                sc.setAttribute("ansbean", ansbean);
                sc.setAttribute("tablebean", tablebean);
                PrintWriter wr = response.getWriter();
                wr.println("{"+"\"url\":"+"\"./answer.jsp\""+"}");
                //response.sendRedirect(request.getContextPath() + "/answer.jsp");
            }
        }
    }
    private boolean checkData(float x, float y, float r){
        return -3 <= x && x <= 5 && -5 <= y && y <= 5 && 1 <= r && r <= 5;
    }
    public boolean checkArea(float x, float y, float r){
        if (x>0 && y>0){
            return false;
        } else if (x<=0 && y>=0) {
            return x * x + y * y <= r * r;
        } else if (x<=0 && y<=0) {
            return x >= -r && y >= -(r / 2);
        } else if (x>=0 && y<=0) {
            return y>=2*x-r;
        }
        return false;
    }
}
