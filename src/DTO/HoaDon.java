package DTO;

public class HoaDon extends Phieu{
    private KhachHang khachHang;
    private boolean tinhTrang;

    public HoaDon(){
        super();
        this.khachHang = null;
    }

    public HoaDon(String maPhieu, NhanVien nhanVien, KhachHang khachHang,String ngayLap, double tongTien){
        super(maPhieu, nhanVien, ngayLap, tongTien);
        this.khachHang = khachHang;
    }

    public void setKhachHang(KhachHang khachHang){
        this.khachHang = khachHang;
    }

    public KhachHang getKhachHang(){
        return this.khachHang;
    }
    
    public void setTinhTrang(boolean tinhTrang) {
    	this.tinhTrang = tinhTrang;
    }
    
    public boolean getTinhTrang() {
    	return this.tinhTrang;
    }
}
