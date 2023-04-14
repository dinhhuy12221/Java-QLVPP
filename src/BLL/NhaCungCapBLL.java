package BLL;

import java.util.ArrayList;

import DTO.NhaCungCap;

public class NhaCungCapBLL {
    public static ArrayList<NhaCungCap> layDanhSachNhaCC(){
    	return DAL.NhaCungCapDAL.layDanhSachNhaCC();
    }
}
