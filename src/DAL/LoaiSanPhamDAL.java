package DAL;

import java.util.ArrayList;

import DTO.LoaiSanPham;

public class LoaiSanPhamDAL extends DatabaseAccess{
	public static ArrayList<LoaiSanPham> layDanhSachLoaiSP(){
		ArrayList<LoaiSanPham> danhSachLoaiSP = new ArrayList<LoaiSanPham>();
		try {
			getConnection();
			String s = "SELECT * FROM LOAI_SP";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(s);
			while(resultSet.next()) {
				String maLoaiSP = resultSet.getString(1);
				String tenLoaiSP = resultSet.getString(2);
				LoaiSanPham loaiSP =  new LoaiSanPham(maLoaiSP,tenLoaiSP);
				danhSachLoaiSP.add(loaiSP);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		closeConnection();
		return danhSachLoaiSP;
	}
}
