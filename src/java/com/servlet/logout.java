
package com.servlet;

import java.io.IOException;
import javax.servlet.http.*;

public class logout extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        res.sendRedirect("index.html");
    }
}
