package model;

/**
 *
 * @author TIEN DUY
 */
public class HoaDonChiTiet_Model {

    long id;
    Sach_Model s;
    NguoiDung_model nd;
    String hinhthucThanhToan;

    public Object[] toDataRow() {
        return new Object[]{
            id, s.getMa(), s.getTenSach(), nd.getSoluongmua(), nd.getDiachi(), nd.getSdt(), nd.getThanhtien(), hinhthucThanhToan
        };
    }

    public HoaDonChiTiet_Model(long id, NguoiDung_model nd, String hinhthucThanhToan) {
        this.id = id;
        this.nd = nd;
        this.hinhthucThanhToan = hinhthucThanhToan;
    }

    

    public HoaDonChiTiet_Model(long id, Sach_Model s, NguoiDung_model nd, String hinhthucThanhToan) {
        this.id = id;
        this.s = s;
        this.nd = nd;
        this.hinhthucThanhToan = hinhthucThanhToan;
    }

    public HoaDonChiTiet_Model() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sach_Model getS() {
        return s;
    }

    public void setS(Sach_Model s) {
        this.s = s;
    }

    public NguoiDung_model getNd() {
        return nd;
    }

    public void setNd(NguoiDung_model nd) {
        this.nd = nd;
    }

    public String getHinhthucThanhToan() {
        return hinhthucThanhToan;
    }

    public void setHinhthucThanhToan(String hinhthucThanhToan) {
        this.hinhthucThanhToan = hinhthucThanhToan;
    }

}
