package BLL;

import java.util.ArrayList;

import DTO.NhanVien;
import DTO.TaiKhoan;

public class TaiKhoanBLL {
    public static boolean themTaiKhoan(TaiKhoan taiKhoan) {
    	return DAL.TaiKhoanDAL.themTaiKhoan(taiKhoan);
    }
    
    public static boolean xoaTaiKhoan(TaiKhoan taiKhoan) {
    	return DAL.TaiKhoanDAL.xoaTaiKhoan(taiKhoan);
    }
    
    public static boolean suaTaiKhoan(TaiKhoan taiKhoan) {
    	return DAL.TaiKhoanDAL.suaTaiKhoan(taiKhoan);
    }
    
    public static ArrayList<TaiKhoan> layDanhSachTaiKhoan(){
    	return DAL.TaiKhoanDAL.layDanhSachTaiKhoan();
    }
    
    public static ArrayList<NhanVien> layDanhSachNVChuaCoTK(){
    	return DAL.TaiKhoanDAL.layDanhSachNVChuaCoTK();
    }
}
