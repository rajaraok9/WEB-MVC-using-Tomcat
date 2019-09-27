package com.nc.utils;

import java.sql.Connection;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;  
public class DBConnection {
	static Connection con=null;
     public static Connection getConnection(){  
          try{  
      
        	  Context initContext = new InitialContext();
      		Context envContext  = (Context)initContext.lookup("java:/comp/env");
      		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
        	  
             
              con=ds.getConnection();
               return con;  
          }catch(Exception e){  
               e.printStackTrace();  
          }  
          return null;  
     }       
}  