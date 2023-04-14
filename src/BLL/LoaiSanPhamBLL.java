package BLL;

import java.util.ArrayList;

import DTO.LoaiSanPham;

public class LoaiSanPhamBLL {
	public static ArrayList<LoaiSanPham> layDanhSachLoaiSP(){
		return DAL.LoaiSanPhamDAL.layDanhSachLoaiSP();
	}
}
