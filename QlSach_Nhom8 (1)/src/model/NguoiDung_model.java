package model;

/**
 *
 * @author TIEN DUY
 */
public class NguoiDung_model {

    private int maHoaDon;
    private Sach_Model s;
    private int soluongmua;
    private String diachi;
    private String sdt;
    private double thanhtien;

    public Object[] todataRow() {
        return new Object[]{
            maHoaDon, s.getMa(), s.getTenSach(), soluongmua, diachi, sdt, getThanhtien()
        };
    }

    public NguoiDung_model(int maHoaDon, Sach_Model s, int soluongmua, String diachi, String sdt,double thanhtien) {
        this.maHoaDon = maHoaDon;
        this.s = s;
        this.soluongmua = soluongmua;
        this.diachi = diachi;
        this.sdt = sdt;
        this.thanhtien = thanhtien;
    }

    public NguoiDung_model() {
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Sach_Model getS() {
        return s;
    }

    public void setS(Sach_Model s) {
        this.s = s;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    

    public double getThanhtien() {
        thanhtien = s.getGia() * soluongmua;
        String formattedDiemTB = String.format("%.1f", thanhtien);
        String diemTBFormatted = formattedDiemTB.replace(",", ".");
        return Double.parseDouble(diemTBFormatted);
    }
    
    

}
