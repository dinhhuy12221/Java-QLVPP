package DTO;

import java.util.ArrayList;
import java.util.Date;

public class PhieuNhap extends Phieu{

    public PhieuNhap(){
        super();
    }

    public PhieuNhap(String maPhieu, NhanVien nhanVien,ArrayList<ChiTietPhieu> dsct,String ngayLap,double tongTien){
        super(maPhieu, nhanVien,dsct ,ngayLap, tongTien);
    }
}
