
package com.utility;

import java.sql.*;


public class DbConfig {
    
    public static Connection getConnection () throws ClassNotFoundException{
     String url = "jdbc:mysql://localhost:3306/loggy";
     String username = "ServletJDBC";
     String password = "servletJDBC";
     
   
   
    // driver load   -> driver.jdbc.mysql.com
    Class.forName("com.mysql.jdbc.Driver"); 
            
    // creat connection
    
    try{
       Connection conn = DriverManager.getConnection(url,username,password);
       return conn;
    }
    catch(SQLException e){
        System.out.println(e.toString());
        e.printStackTrace();
    }
    
    return null;
    
    }
}
