package DTO;

import java.util.ArrayList;

public class HoaDon extends Phieu{
    private KhachHang khachHang;
    private boolean trangThai;

    public HoaDon(){
        super();
        this.khachHang = null;
        this.trangThai = false;
    }

    public HoaDon(String maPhieu, KhachHang khachHang,NhanVien nhanVien, ArrayList<ChiTietPhieu> dsct,String ngayLap, double tongTien, boolean trangThai){
        super(maPhieu, nhanVien, dsct, ngayLap, tongTien);
        this.khachHang = khachHang;
        this.trangThai = trangThai;
    }

    public void setKhachHang(KhachHang khachHang){
        this.khachHang = khachHang;
    }

    public KhachHang getKhachHang(){
        return this.khachHang;
    }
   
    public void setTrangThai(boolean trangThai) {
    	this.trangThai = trangThai;
    }
    
    public boolean getTrangThai() {
    	return this.trangThai;
    }
}
