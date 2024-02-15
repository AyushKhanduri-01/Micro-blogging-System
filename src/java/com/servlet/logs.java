
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import java.sql.*;
import com.utility.DbConfig;
import com.Dao.DaoClass;
import com.Dao.LogClass;





public class logs extends HttpServlet{
     DaoClass doa = new DaoClass();
    
     
     
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
          HttpSession session = req.getSession();
         int id = Integer.parseInt(req.getParameter("id"));
         
         if(doa.deleteLog(id)){
             session.setAttribute("result","Your Log succesfully Deleted.");
             res.sendRedirect("feed.jsp");
         }
         else{
             session.setAttribute("result","Error : Failed to delete log.");
             res.sendRedirect("feed.jsp");
         }
         
     }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
         HttpSession session = req.getSession();
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String title = req.getParameter("title");
        String logContent = req.getParameter("logContent");
        String shortDescription = req.getParameter("shortDescription");
        int id = Integer.parseInt(req.getParameter("logId"));
        
        
        
        LogClass user = new LogClass();
        user.setTitle(title);
        user.setLogContent(logContent);
        user.setTimestamp(new Timestamp(System.currentTimeMillis()));
        user.setShortDescription(shortDescription);
        user.setId(id);
        
        
        
       if(doa.addLog(user)){
         session.setAttribute("email","Your Log succesfully Saved.");
          res.sendRedirect("feed.jsp");
       } 
       else {  
           session.setAttribute("email", "Error : Failed to save log.");
           res.sendRedirect("feed.jsp");
        }      
    }
}
