//package BLL;
//
//import java.util.ArrayList;
//
//import DTO.NhaCungCap;
//
//public class NhaCungCapBLL {
//    public static ArrayList<NhaCungCap> layDanhSachNhaCC(){
//    	return DAL.NhaCungCapDAL.layDanhSachNhaCC();
//    }
//}

package BLL;

import java.util.ArrayList;
import DAL.NhaCungCapDAL;
import DTO.NhaCungCap;
import DTO.SanPham;

public class NhaCungCapBLL {
    public static ArrayList<NhaCungCap> layDanhSachNhaCC(){
    	return NhaCungCapDAL.layDanhSachNhaCC();
    }
    public static ArrayList<SanPham> laySanPhamCuaNhaCC(String mancc){
    	return NhaCungCapDAL.laySanPhamCuaNhaCC(mancc);
    }
    public static int laysoluongspcuanhacc(String mancc) {
    	return NhaCungCapDAL.laysoluongspcuanhacc(mancc);
    }
    public static boolean themnhacungcap(NhaCungCap ncc) {
    	return NhaCungCapDAL.themnhacungcap(ncc);
    }
    public static int xoanhacungcap(String mancc) {
    	return NhaCungCapDAL.xoanhacungcap(mancc);
    }
    public static boolean suanhacungcap(NhaCungCap ncc) {
    	return NhaCungCapDAL.suanhacungcap(ncc);
    }
    public static ArrayList<NhaCungCap> timtheomancc(String mancc, String tenncc) {
    	return NhaCungCapDAL.timtheomancc(mancc,tenncc);
    }
    public static String taoMaNhaCC() {
    	return DAL.NhaCungCapDAL.taoMaNhaCC();
    }
}
/*ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
        danhSachSanPham = DAL.SanPhamDAL.layDanhSachSanPham();
        return danhSachSanPham;
        layDanhSachNhaCC()*/

