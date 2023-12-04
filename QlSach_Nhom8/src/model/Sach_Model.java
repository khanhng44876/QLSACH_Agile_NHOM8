
package model;


public class Sach_Model {
    private String ma;
    private String tenSach;
    private String tenTacGia;
    private String loaiSach;
    private Integer soLuong;
    private Integer nam;
    private double gia;

    public Sach_Model() {
    }

    public Sach_Model(String ma, String tenSach, double gia) {
        this.ma = ma;
        this.tenSach = tenSach;
        this.gia = gia;
    }

    
    public Sach_Model(String ma, String tenSach, Integer soLuong, double gia) {
        this.ma = ma;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public Sach_Model(String ma, String tenSach) {
        this.ma = ma;
        this.tenSach = tenSach;
    }

    
    
    public Sach_Model(String ma, String tenSach, String tenTacGia, String loaiSach, Integer soLuong, Integer nam, double gia) {
        this.ma = ma;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.loaiSach = loaiSach;
        this.soLuong = soLuong;
        this.nam = nam;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getNam() {
        return nam;
    }

    public void setNam(Integer nam) {
        this.nam = nam;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            this.ma, this.tenSach, this.tenTacGia, this.loaiSach, this.soLuong, this.nam, this.gia
                
        };
    }

    public Object[] toDataRowbenHoaDon(){
        return new Object[]{
            this.ma, this.tenSach, this.soLuong, this.gia
                
        };
    }
    
    @Override
    public String toString() {
        return "Sach_Model{" + "ma=" + ma + ", tenSach=" + tenSach + ", tenTacGia=" + tenTacGia + ", loaiSach=" + loaiSach + ", soLuong=" + soLuong + ", nam=" + nam + ", gia=" + gia + '}';
    }
    
           
}
