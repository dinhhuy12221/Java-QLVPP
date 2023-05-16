package BLL;

import java.util.ArrayList;

import DAL.PhieuNhapDAL;
import DTO.ChiTietPhieu;
import DTO.PhieuNhap;
import DTO.SanPham;

public class PhieuNhapBLL {
	public static ArrayList<PhieuNhap> laydanhsachphieunhap(){
		return PhieuNhapDAL.laydanhsachphieunhap();
	}
	public static ArrayList<ChiTietPhieu> laychitietphieunhap(String mapn){
		return PhieuNhapDAL.laychitietphieunhap(mapn);
	}
	public static boolean themphieunhap(PhieuNhap pn) {
		return PhieuNhapDAL.themphieunhap(pn);
	}
	public static int xoaphieunhap(String mapn) {
		return PhieuNhapDAL.xoaphieunhap(mapn);
	}
	public static boolean suaphieunhap(PhieuNhap pn) {
		return PhieuNhapDAL.suaphieunhap(pn);
	}
	public static ArrayList<PhieuNhap> timkiemphieunhap(String mapn, String ngaytao){
		return PhieuNhapDAL.timkiemphieunhap(mapn, ngaytao);
	}
	public static boolean themchitietphieunhap(ChiTietPhieu pn, String mapn) {
		return PhieuNhapDAL.themchitietphieunhap(pn,mapn);
	}
	public static boolean suachitietphieunhap(ChiTietPhieu ncc) {
		return PhieuNhapDAL.suachitietphieunhap(ncc);
	}
	public static int xoachitietphieunhap(String masp) {
		return PhieuNhapDAL.xoachitietphieunhap(masp);
	}
	public static boolean capnhapthanhtien(String mapn) {
		return PhieuNhapDAL.capnhapthanhtien(mapn);
	}
	public static boolean capnhapsoluongsanpham(String mapn, String masp) {
		return PhieuNhapDAL.capnhapsoluongsanpham(mapn, masp);
	}
	//CHO KHUNG SẢN PHẨM
	public static ArrayList<SanPham> laysanphamhienco(String mancc){
		return PhieuNhapDAL.laysanphamhienco(mancc);
	}
	
	public static String taomaphieunhap() {
		return DAL.PhieuNhapDAL.taomaphieunhap();
	}
	
}
