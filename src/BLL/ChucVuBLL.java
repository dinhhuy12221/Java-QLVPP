package BLL;

import java.util.ArrayList;

import DTO.ChucVu;

public class ChucVuBLL {
	public static ArrayList<ChucVu> layDanhSachLoaiCV(){
		return DAL.ChucVuDAL.layDanhSachLoaiCV();
	}
}
