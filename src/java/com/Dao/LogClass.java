
package com.Dao;

import java.sql.Timestamp;


public class LogClass {
    private int id;
    private String title;
    private String shortDescription;
    private String logContent;
    private Timestamp timestamp;
  
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
 
    
 
}
