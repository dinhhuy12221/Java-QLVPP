package BLL;
import java.util.ArrayList;

import DTO.NhanVien;
import DTO.SanPham;


public class NhanVienBLL {
    public static ArrayList<NhanVien> layDanhSachNV(){
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
        danhSachNhanVien = DAL.NhanVienDAL.layDanhSachNhanVien();
        return danhSachNhanVien;
    }
//    public static int laySoLuongNhanVien() {
//    	return DAL.NhanVienDAL.laySoLuongNhanVien();
//    }
    public static boolean themNhanVien(NhanVien nhanvien){
        return DAL.NhanVienDAL.themNhanVien(nhanvien);
    }
    public static boolean xoaNhanVien(NhanVien nhanvien){
        return DAL.NhanVienDAL.xoaNhanVien(nhanvien);
    }
    public static boolean SuaNhanVien(NhanVien nhanvien){
        return DAL.NhanVienDAL.SuaNhanVien(nhanvien);
    }
}
