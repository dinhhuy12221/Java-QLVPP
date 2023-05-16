//package BLL;
//import DTO.KhachHang;
//
//import java.util.ArrayList;
//
//import DAL.KhachHangDAL;
//
//public class KhachHangBLL {
//    public static ArrayList<KhachHang> layDanhSachKhachHang(){
//    	return DAL.KhachHangDAL.layDanhSachKhachHang();
//    }
//}

package BLL;
import DTO.KhachHang;

import java.util.ArrayList;

import DAL.KhachHangDAL;

public class KhachHangBLL {
    public static ArrayList<KhachHang> layDanhSachKhachHang(){
    	return DAL.KhachHangDAL.layDanhSachKhachHang();
    }
//    public static boolean capNhatChiTieu(String maKH, double tongChiTieu) {
//    	return DAL.KhachHangDAL.capNhatChiTieu(maKH, tongChiTieu);
//    }
    public static String taoMaKhachHang() {
    	return DAL.KhachHangDAL.taoMaKhachHang();
    }
    public static boolean themKhachHang(KhachHang KhachHang){
        return DAL.KhachHangDAL.themKhachHang(KhachHang);
    }
    public static boolean xoaKhachHang(KhachHang KhachHang){
        return DAL.KhachHangDAL.xoaKhachHang(KhachHang);
    }
    public static boolean SuaKhachHang(KhachHang KhachHang){
        return DAL.KhachHangDAL.SuaKhachHang(KhachHang);
    }
//    public static int laySoLuongKhachHang() {
//    	return DAL.KhachHangDAL.laySoLuongKhachHang();
//    }
}
