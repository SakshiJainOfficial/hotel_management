package com.universal.model;

import com.universal.Service.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO 
{

    public CustomerDAO() {
    }
    public boolean login(CustomerDTO  cdto) throws SQLException
    {
    boolean b=false;
    Connection cn=GetConnection.getConnection();
  try {
            PreparedStatement pst=cn.prepareStatement("Select * from `Registration` where  `userMobile`=? and  `Password`=?");
            pst.setString(1,cdto.getMobile());
            pst.setString(2,cdto.getPassword());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            b=true;
            }} 
    catch (SQLException ex) {
              }
return b;
    }
    
    public boolean signUp(CustomerDTO  cdto) throws SQLException
    {
    boolean b=false;
    Connection con=GetConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("INSERT INTO `Registration`(`userName`, `userMail`, `userMobile`, `Password`)VaLUES (?,?,?,?)");
            pst.setString(1,cdto.getName());
            pst.setString(2,cdto.getEmail());
            pst.setString(3,cdto.getMobile());
            pst.setString(4,cdto.getPassword());
            int b1=pst.executeUpdate();
            if(b1>0)
                b=true;
      return b;
    }
}
