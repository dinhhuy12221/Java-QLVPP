package BLL;

import java.util.ArrayList;

import DTO.LoaiSanPham;

public class LoaiSanPhamBLL {
	
	public static boolean themLoaiSP(LoaiSanPham lsp) {
		return DAL.LoaiSanPhamDAL.themLoaiSP(lsp);
		
	}
	
	public static boolean xoaLoaiSP(LoaiSanPham lsp) {
		return DAL.LoaiSanPhamDAL.xoaLoaiSP(lsp);
	}
	
//	public static boolean suaLoaiSP(LoaiSanPham lsp) {
//		return DAL.LoaiSanPhamDAL.suaLoaiSP(lsp);
//	}
	
	public static ArrayList<LoaiSanPham> layDanhSachLoaiSP(){
		return DAL.LoaiSanPhamDAL.layDanhSachLoaiSP();
	}
}
