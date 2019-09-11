package com.universal.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection 
{
    public static Connection getConnection(){
     try
     {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","abhi","abhi");
      return con;
      }
     catch(ClassNotFoundException | SQLException ex)
     {
         System.out.println(ex.getMessage());
     }
        return null;
    }
}
