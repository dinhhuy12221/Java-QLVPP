package DTO;

import java.util.ArrayList;
import java.util.Date;

public class HoaDon extends Phieu{
    private KhachHang khachHang;

    public HoaDon(){
        super();
        this.khachHang = new KhachHang();
    }

    public HoaDon(String maPhieu, KhachHang khachHang,NhanVien nhanVien, ArrayList<ChiTietPhieu> dsct,String ngayLap, double tongTien){
        super(maPhieu, nhanVien, dsct, ngayLap, tongTien);
        this.khachHang = khachHang;
    }

    public void setKhachHang(KhachHang khachHang){
        this.khachHang = khachHang;
    }

    public KhachHang getKhachHang(){
        return this.khachHang;
    }
   
}
