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
import model.HoaDonChiTiet_Model;
import model.NguoiDung_model;
import model.Sach_Model;

/**
 *
 * @author TIEN DUY
 */
public class DoanhThu_Service {

    List<HoaDonChiTiet_Model> listND;
    Connection con = null;  // biến kết nối
    PreparedStatement ps = null;  // thực thi câu lệnh
    ResultSet rs = null;   // tập kết quả truy vấn
    String sql = null;

    public List<HoaDonChiTiet_Model> getAll() {
        listND = new ArrayList<>();
        sql = "SELECT\n"
                + "    SACH.MaSach,\n"
                + "    SACH.TenSach,\n"
                + "    SUM(HoaDonChiTiet.Soluongmua) AS SoLuongDaBan,\n"
                + "    SUM(HoaDonChiTiet.ThanhTien) AS TongThanhTien\n"
                + "FROM\n"
                + "    SACH\n"
                + "JOIN\n"
                + "    HoaDonChiTiet ON SACH.MaSach = HoaDonChiTiet.MaSach\n"
                + "GROUP BY\n"
                + "    SACH.MaSach,\n"
                + "    SACH.TenSach;";

        try { // kết nối đc
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet_Model nd;
                nd = new HoaDonChiTiet_Model(
                        new Sach_Model(rs.getString("MaSach"), rs.getString("TenSach")),
                        new NguoiDung_model(rs.getInt(3), rs.getDouble(4))
                );

                listND.add(nd);

            }
            return listND;
        } catch (Exception e) { //lỗi
            e.printStackTrace();  // in ra toàn bộ lỗi

        }
        return null;
    }
}
