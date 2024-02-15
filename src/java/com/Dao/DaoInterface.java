
package com.Dao;

import java.util.ArrayList;


public interface DaoInterface {
    boolean addLog(LogClass user);
    
    ArrayList <LogClass> getLogs();
    
    boolean deleteLog(int id);
}
