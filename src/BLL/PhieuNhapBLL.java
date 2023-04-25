package BLL;

import java.util.ArrayList;

import DAL.PhieuNhapDAL;
import DTO.ChiTietPhieu;
import DTO.PhieuNhap;

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
	public static boolean themchitietphieunhap(String mapn,ChiTietPhieu ctpn) {
		return PhieuNhapDAL.themchitietphieunhap(mapn,ctpn);
	}
	public static boolean suachitietphieunhap(ChiTietPhieu ncc) {
		return PhieuNhapDAL.suachitietphieunhap(ncc);
	}
	public static int xoachitietphieunhap(String masp) {
		return PhieuNhapDAL.xoachitietphieunhap(masp);
	}
}
