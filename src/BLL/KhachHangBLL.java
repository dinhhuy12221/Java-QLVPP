package BLL;
import DTO.KhachHang;

import java.util.ArrayList;

import DAL.KhachHangDAL;

public class KhachHangBLL {
    public static ArrayList<KhachHang> layDanhSachKhachHang(){
    	return DAL.KhachHangDAL.layDanhSachKhachHang();
    }
}
