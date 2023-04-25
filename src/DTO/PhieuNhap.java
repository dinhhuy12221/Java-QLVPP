package DTO;

import java.util.ArrayList;

public class PhieuNhap extends Phieu{
    private NhaCungCap nhaCungCap;

    public PhieuNhap(){
        super();
        this.nhaCungCap = null;
    }

    public PhieuNhap(String maPhieu, NhanVien nhanVien,ArrayList<ChiTietPhieu> dsct, NhaCungCap nhaCungCap,String ngayLap, double tongTien){
        super(maPhieu, nhanVien,dsct ,ngayLap, tongTien);
        this.nhaCungCap = nhaCungCap;
    }

    public void setNhaCC(NhaCungCap nhaCungCap){
        this.nhaCungCap = nhaCungCap;
    }

    public NhaCungCap getNhaCC(){
        return this.nhaCungCap;
    }
}
