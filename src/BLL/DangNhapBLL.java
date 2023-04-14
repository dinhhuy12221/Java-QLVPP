package BLL;

import DAL.DangNhapDAL;
import DTO.TaiKhoan;

public class DangNhapBLL {
	public static boolean isLogin(TaiKhoan taiKhoan) {
		return DangNhapDAL.isLogin(taiKhoan);
	}
}
