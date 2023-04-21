package DTO;

import java.util.ArrayList;

public class PhieuXuat extends Phieu{
    public PhieuXuat(){
        super();
    }

    public PhieuXuat(String maPhieu, NhanVien nhanVien, ArrayList<ChiTietPhieu> dsct,String ngayLap, double tongTien){
        super(maPhieu, nhanVien, dsct, ngayLap, tongTien);
    }
}
