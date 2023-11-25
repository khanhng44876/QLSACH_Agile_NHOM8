package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NguoiDung_model;
import model.Sach_Model;

/**
 *
 * @author TIEN DUY
 */
public class NguoiDung_Service {

    List<NguoiDung_model> listND;
    Connection con = null;  // biến kết nối
    PreparedStatement ps = null;  // thực thi câu lệnh
    ResultSet rs = null;   // tập kết quả truy vấn
    String sql = null;

    public List<NguoiDung_model> getAll() {
        listND = new ArrayList<>();
        sql = "SELECT hd.MaHoaDon,s.MaSach,s.TenSach,hd.Soluongmua,hd.DiaChi,hd.SDT,(hd.Soluongmua * s.GiaSach) as ThanhTien FROM HoaDon hd join SACH s on s.MaSach = hd.MaSach";

        try { // kết nối đc
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung_model nd = new NguoiDung_model(
                        rs.getInt(1),
                        new Sach_Model(rs.getString("MaSach"), rs.getString("TenSach")),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)
                );

                listND.add(nd);

            }
            return listND;
        } catch (Exception e) { //lỗi
            e.printStackTrace();  // in ra toàn bộ lỗi

        }
        return null;
    }

    public Integer insertHoaDon(NguoiDung_model nd) {
        Integer row = null;
        con = DBConnect.getConnection();
        sql = "INSERT INTO HoaDon VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            
            pr.setString(1, nd.getS().getMa());
            pr.setString(2, nd.getS().getTenSach());
            pr.setInt(3, nd.getSoluongmua());
            pr.setString(4, nd.getDiachi());
            pr.setString(5, nd.getSdt());
            pr.setDouble(6, nd.getThanhtien());  // Chỉnh sửa đây: thêm dấu chấm phẩy

            row = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            row = null;
        }
        return row;
    }

    public Integer deleteHoaDon(String ma) {
        Integer row = null;
        con = DBConnect.getConnection();
        sql = "DELETE FROM HoaDon WHERE MaSach like ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ma);

            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    
}
