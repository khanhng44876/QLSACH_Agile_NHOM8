/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Sach_Model;
import view.Sach_View;

/**
 *
 * @author TIEN DUY
 */
public class Account_Sevice {
    List<Sach_Model> listAcc;
     Connection con = null;  // biến kết nối
     PreparedStatement ps = null;  // thực thi câu lệnh
     ResultSet rs = null;   // tập kết quả truy vấn
     String sql = null;
     
     public Integer insertAcc(Account acc){
        Integer row = null;
        con = DBConnect.getConnection();
        sql = "INSERT INTO ACCOUNT VALUES(?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getPassWord());
            ps.setString(3, acc.getConfirmPwd());
            
            
            row = ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return row;
    }
    
     
}
