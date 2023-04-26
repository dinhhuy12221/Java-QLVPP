package BLL;

import java.util.ArrayList;

import DTO.HoaDon;

public class ThongKeBLL {
	public static ArrayList<ArrayList<String>> layDoanhThu(){
		return DAL.ThongKeDAL.layDoanhThu();
	}
	
	public static ArrayList<ArrayList<String>> layChiTieu(){
		return DAL.ThongKeDAL.layChiTieu();
	}
}
