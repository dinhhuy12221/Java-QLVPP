package BLL;

import java.util.ArrayList;

import DTO.HoaDon;
import DTO.SanPham;

public class HoaDonBLL {
    public static boolean lapHoaDon(HoaDon hoaDon) {
    	return DAL.HoaDonDAL.themHoaDon(hoaDon);
    }
    
    public static boolean xoaHoaDon(HoaDon hoaDon) {
    	return DAL.HoaDonDAL.xoaHoaDon(hoaDon);
    }
    
    public static ArrayList<HoaDon> layDanhSachHD(){
    	return DAL.HoaDonDAL.layDanhSachHoaDon();
    }
}
