package BLL;

import java.util.ArrayList;

import DTO.SanPham;

public class SanPhamBLL {
    public static boolean themSanPham(SanPham sanPham){
        return DAL.SanPhamDAL.themSanPham(sanPham);
    }

    public static boolean xoaSanPham(SanPham sanPham){
        return DAL.SanPhamDAL.xoaSanPham(sanPham);
    }

    public static boolean suaSanPham(SanPham sanPham){
        return DAL.SanPhamDAL.suaSanPham(sanPham);
    }
    
//    public static int laySoLuongSanPham() {
//    	return DAL.SanPhamDAL.laySoLuongSanPham();
//    }
    
    public static String taoMaSanPham() {
    	return DAL.SanPhamDAL.taoMaSanPham();
    }

    public static ArrayList<SanPham> layDanhSachSP(){
        return DAL.SanPhamDAL.layDanhSachSanPham();
    }
    
}
