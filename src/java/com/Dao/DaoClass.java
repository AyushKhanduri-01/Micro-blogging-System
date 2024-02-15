
package com.Dao;

import java.sql.*;
import com.utility.DbConfig;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
public class DaoClass implements DaoInterface {

   
    public boolean addLog(LogClass user) {
        try(Connection conn = DbConfig.getConnectionLogData()){
            String title = user.getTitle();
            String logContent = user.getLogContent();
            Timestamp timestamp = user.getTimestamp();
            String shortDescription = user.getShortDescription();
            int id = user.getId();
         
            
            if(id == -1){
             String query = "insert into logs(title,logcontent,timestamp,shortDescription) values (?,?,?,?)";
      
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, title);
            pstm.setString(2, logContent);
            pstm.setTimestamp(3,timestamp);
            pstm.setString(4, shortDescription);
            
            int row = pstm.executeUpdate();
            
            return row > 0;
            }
            else{
             String query = "update logs set title = ?, logcontent=?,timestamp = ?, shortDescription = ? where id = ?";
      
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, title);
            pstm.setString(2, logContent);
            pstm.setTimestamp(3,timestamp);
            pstm.setString(4, shortDescription);
            pstm.setInt(5,id);
            
            int row = pstm.executeUpdate();
            
            return row > 0;
            }
            
           
            
            
            
      
        } catch (Exception e) { 
           System.out.println("Error adding log: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<LogClass> getLogs() {
        ArrayList<LogClass> resultList = new ArrayList<>();
       try(Connection conn = DbConfig.getConnectionLogData()){
           
          String query = "select * from logs order by timestamp desc";
          
          PreparedStatement pstm = conn.prepareStatement(query);
          ResultSet  rs = pstm.executeQuery();
          
          while(rs.next()){
              String title = rs.getString("title");
              String logContent = rs.getString("logContent");
              String shortDescription = rs.getString("shortDescription");
              int id  = rs.getInt("id");
              Timestamp timestamp= rs.getTimestamp("timestamp");
              
              LogClass lc = new LogClass();
              
              lc.setTitle(title);
              lc.setId(id);
              lc.setLogContent(logContent);
              lc.setShortDescription(shortDescription);
              lc.setTimestamp(timestamp);
              
              resultList.add(lc);
              
              
          }
          return resultList;
           
       }
       catch(Exception e){
           System.out.println("Error :  "+ e.toString());
           e.printStackTrace();
           return resultList;
           
       }
    }

    @Override
    public boolean deleteLog(int id) {
       try(Connection conn = DbConfig.getConnectionLogData()){
          String query = "delete from logs where id = ? ";
          PreparedStatement pstm = conn.prepareStatement(query);
          pstm.setInt(1, id);
          
          int row = pstm.executeUpdate();
          return row > 0;
       }
       catch(Exception e){
           e.printStackTrace();
           return false;
    }
   
}

    
    
    @Override
    public boolean isValid(userClass uc) {
        try(Connection conn = DbConfig.getConnectionUserData()){
            String email = uc.getEmail();
            String password = uc.getPassword();
            
            String query = "Select * from users where email = ? and password = ?";
            try (PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setString(1, email);
            pstm.setString(2, password);

            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    return true; 
                }
            }
        }
           
        }catch(Exception e){
            e.printStackTrace();
           return false;
      }
        return false;
    }

    @Override
    public boolean addUser(userClass uc) {
         try(Connection conn = DbConfig.getConnectionUserData()){
             String username = uc.getUsername();
             String email = uc.getEmail();
             String password = uc.getPassword();
             
             String query = "insert into users values (?,?,?)";
             PreparedStatement pstm = conn.prepareStatement(query);
             pstm.setString(1,email);
             pstm.setString(2, password);
             pstm.setString(3, username);
             
             int row = pstm.executeUpdate();
             return row > 0;
             
         }
         catch(Exception e){
             e.printStackTrace();
             return false;
         }
    }
}