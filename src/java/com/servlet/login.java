
package com.servlet;

import com.Dao.DaoClass;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.userClass;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import javax.servlet.http.HttpSession;
public class login extends HttpServlet{
    DaoClass dao = new DaoClass();
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
      
        HttpSession session11 = req.getSession();
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
   
        userClass uc = new userClass();
        uc.setEmail(email);
        uc.setPassword(password);
        if(dao.isValid(uc)){          
            session11.setAttribute("email",email);
            res.sendRedirect("feed.jsp");
        }
        else{
             res.sendRedirect("index.html");        }
        
        
        
        
    }
    
}
