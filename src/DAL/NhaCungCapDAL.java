package DAL;

import java.util.ArrayList;

import DTO.NhaCungCap;

public class NhaCungCapDAL extends DatabaseAccess{
	
	public static ArrayList<NhaCungCap> layDanhSachNhaCC(){
		ArrayList<NhaCungCap> danhSachNCC = new ArrayList<NhaCungCap>();
		try {
			getConnection();
			String s = "SELECT * FROM NHA_CUNG_CAP";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(s);
			while(resultSet.next()) {
				String maNhaCC = resultSet.getString(1);
				String tenNhaCC = resultSet.getString(2);
				String diaChi = resultSet.getString(3);
				String sdt = resultSet.getString(4);
				NhaCungCap nhaCC = new NhaCungCap(maNhaCC,tenNhaCC, diaChi,sdt);
				danhSachNCC.add(nhaCC);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		closeConnection();
		return danhSachNCC;
	}
}
