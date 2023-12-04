
package service;


import java.util.ArrayList;
import java.util.List;
import model.Sach_Model;
import java.sql.*;


public class Sach_Service {
     List<Sach_Model> listSV;
     Connection con = null;  // biến kết nối
     PreparedStatement ps = null;  // thực thi câu lệnh
     ResultSet rs = null;   // tập kết quả truy vấn
     String sql = null; 
    
    public List<Sach_Model> getAll(){
        listSV  = new ArrayList<>();
        sql= "SELECT * FROM SACH";
            
        try{ // kết nối đc
            con=DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               Sach_Model sv = new Sach_Model(
                 rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7)
               );
               
               listSV.add(sv);
              
            }
             return listSV;
        }catch(Exception e){ //lỗi
            e.printStackTrace();  // in ra toàn bộ lỗi
            
        }
        return null;
    }
    
    public List<Sach_Model> getAllbenHoaDon(){
        listSV  = new ArrayList<>();
        sql= "SELECT MaSach,TenSach,SoLuong,GiaSach FROM SACH";
            
        try{ // kết nối đc
            con=DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               Sach_Model sv = new Sach_Model(
                 rs.getString(1), rs.getString(2), rs.getInt(3),  rs.getDouble(4)
               );
               
               listSV.add(sv);
              
            }
             return listSV;
        }catch(Exception e){ //lỗi
            e.printStackTrace();  // in ra toàn bộ lỗi
            
        }
        return null;
    }
    
    public Integer insertSach(Sach_Model s){
        Integer row = null;
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO SACH(MaSach, TenSach, TenTacGia, LoaiSach, SoLuong, NamXuatBan, GiaSach) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getLoaiSach());
            ps.setInt(5, s.getSoLuong());
            ps.setInt(6, s.getNam());
            ps.setDouble(7, s.getGia());
            
            row = ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return row;
    }
    
    
    public Integer suaSach(Sach_Model s){
        Integer row = null;
        Connection con = DBConnect.getConnection();
        String sql = "UPDATE SACH  set TenSach = ?, TenTacGia = ?, LoaiSach = ?, SoLuong = ?, NamXuatBan = ?, GiaSach = ? WHERE MaSach like ? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(7, s.getMa());
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTenTacGia());
            ps.setString(3, s.getLoaiSach());
            ps.setInt(4, s.getSoLuong());
            ps.setInt(5, s.getNam());
            ps.setDouble(6, s.getGia());
            
            row = ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return row;
    }
     
    public Integer xoa(String ma){
        Integer row = null;
        Connection con = DBConnect.getConnection();
        String sql = "Delete From HoaDonChiTiet  WHERE MaSach like ? Delete From HoaDon  WHERE MaSach like ? Delete From SACH  WHERE MaSach like ? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.setString(2, ma);
            ps.setString(3, ma);
            row = ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return row;
    }
    
    public List<Sach_Model> searchByName(String ten){
        listSV  = new ArrayList<>();
        listSV = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "SELECT * FROM SACH WHERE TenSach like ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+ten+"%");
            
            rs = ps.executeQuery();
            while(rs.next()){
               Sach_Model sv = new Sach_Model(
                 rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7)
               );
               
               listSV.add(sv);
              
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
                try {
                con.close();
                
            } 
                catch (Exception e) {
            }
                
                }
        return listSV;
        
    }
    
    public List<Sach_Model> timkiemtheoTen(String ten){
        listSV  = new ArrayList<>();
        sql= "SELECT * FROM SACH where TenSach like ?";
            
        try{ // kết nối đc
            con=DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+ten+"%");
            rs = ps.executeQuery();
            while(rs.next()){
               Sach_Model sv = new Sach_Model(
                 rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7)
               );
               
               listSV.add(sv);
              
            }
             return listSV;
        }catch(Exception e){ //lỗi
            e.printStackTrace();  // in ra toàn bộ lỗi
            
        }
        return null;
    }
}
