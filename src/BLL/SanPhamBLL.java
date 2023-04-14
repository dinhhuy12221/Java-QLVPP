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
    
    public static int laySoLuongSanPham() {
    	return DAL.SanPhamDAL.laySoLuongSanPham();
    }

    public static ArrayList<SanPham> layDanhSachSP(){
        ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
        danhSachSanPham = DAL.SanPhamDAL.layDanhSachSanPham();
        return danhSachSanPham;
    }
    
}
