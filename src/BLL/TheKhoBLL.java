package BLL;

import java.util.ArrayList;

import DAL.TheKhoDAL;
import DTO.ChiTietPhieu;
import DTO.Phieu;
import DTO.TheKho;

public class TheKhoBLL {
	public static boolean capNhatTheKho(String maPhieu, String ngayLap,ChiTietPhieu ctp) {
		return TheKhoDAL.capNhatTheKho(maPhieu,ngayLap,ctp);
	}
	
	public static ArrayList<TheKho> layTheKho(String maSP){
		return TheKhoDAL.layTheKho(maSP);
	}
}
