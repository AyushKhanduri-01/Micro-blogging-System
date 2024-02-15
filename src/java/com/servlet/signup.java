
package com.servlet;

import com.Dao.userClass;
import com.Dao.DaoClass;
import java.io.IOException;

import javax.servlet.http.*;

public class signup extends HttpServlet {
    
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        userClass  uc = new userClass();
        uc.setEmail(email);
        uc.setUsername(username);
        uc.setPassword(password);
        
        DaoClass dao = new DaoClass();
        
        if(dao.addUser(uc)){
            res.sendRedirect("index.html");
        }
        else{
            res.sendRedirect("signup.html");
        }
    }
}
