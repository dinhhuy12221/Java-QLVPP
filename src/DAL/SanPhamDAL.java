package DAL;

import java.util.ArrayList;

import BLL.SanPhamBLL;
import DTO.*;

public class SanPhamDAL extends DatabaseAccess{
    public static boolean themSanPham(SanPham sanPham) {
    	try {
			getConnection();
			String s = "INSERT INTO SAN_PHAM VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(s);
			ps.setString(1, sanPham.getMaSanPham());
			ps.setString(2, sanPham.getTenSanPham());
			ps.setString(3, sanPham.getChatLieu());
			ps.setString(4, sanPham.getLoaiSanPham().getMaLoaiSanPham());
			ps.setString(5, sanPham.getNhaCC().getMaNhaCC());
			ps.setDouble(6, sanPham.getGiaNhap());
			ps.setDouble(7, sanPham.getGiaBan());
			ps.setInt(8, 0);
			ps.setBytes(9, sanPham.getAnhSanPham());
			ps.setBoolean(10, true);
			int result = ps.executeUpdate();
			if(result > 0) {
				closeConnection();
				return true;
			}
			closeConnection();
    		return false;
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	closeConnection();
		return false;
    }

	public static boolean xoaSanPham(SanPham sanPham){
		try {
			getConnection();
			String s = "UPDATE SAN_PHAM SET TINH_TRANG = 'False' WHERE MA_SP = '" + sanPham.getMaSanPham() + "'";
			statement = conn.createStatement();
			if(statement.executeUpdate(s) > 0) {
				closeConnection();
				return true;
			}
			else{
				closeConnection();
				return false;
			}
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
			closeConnection();
    		return false;
    	}	
	}

	public static boolean suaSanPham(SanPham sanPham){
		try {
			getConnection();
			String s = "UPDATE SAN_PHAM SET TEN_SP = '"+ sanPham.getTenSanPham() +"', CHAT_LIEU = '" + sanPham.getChatLieu() + "', MA_LOAI_SP = '" + sanPham.getLoaiSanPham().getMaLoaiSanPham() + 
					"', MA_NCC = '" + sanPham.getNhaCC().getMaNhaCC() + "', GIA_NHAP = " + sanPham.getGiaNhap() + ", GIA_BAN = " + sanPham.getGiaBan() +", ANH_SAN_PHAM = (SELECT  BULKCOLUMN FROM OPENROWSET(BULK  '" + sanPham.getFilePath() +"', SINGLE_BLOB) AS x)   WHERE MA_SP = '" + sanPham.getMaSanPham() + "'";
			statement = conn.createStatement();
			if(statement.executeUpdate(s) > 0) {
				closeConnection();
				return true;
			}
			else{
				closeConnection();
				return false;
			}
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
		closeConnection();
		return false;
	}
	
	public static boolean capNhatSoLuongSP(String maSanPham, int soLuong) {
		try {
			getConnection();
			int n = 0;
    		String s = "SELECT SO_LUONG FROM SAN_PHAM WHERE MA_SP='"+maSanPham+"'";
    		statement = conn.createStatement();
    		resultSet = statement.executeQuery(s);
    		while(resultSet.next()) {
    			n = resultSet.getInt(1);
    		}
    		n -= soLuong;
    		String s1 = "UPDATE SAN_PHAM SET SO_LUONG=" + n + " WHERE MA_SP = '" + maSanPham + "'";
    		statement = conn.createStatement();
    		int i = statement.executeUpdate(s1);
    		closeConnection();
    		if (i > 0) {
    			return true;
    		} else {
    			return false;
    		}
    	} catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	closeConnection();
    	return false;
	}
	
	public static int laySoLuongSanPham() {
		int i = 0;
		try {
			getConnection();
			String s = "SELECT COUNT(*) FROM SAN_PHAM";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(s);
			while(resultSet.next()) {
				i = resultSet.getInt(1);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		closeConnection();
		return i;
	}

	public static ArrayList<SanPham> layDanhSachSanPham(){
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		try{
			getConnection();
			String s = "SELECT MA_SP, TEN_SP, CHAT_LIEU, SP.MA_LOAI_SP, NCC.MA_NCC, NCC.TEN_NCC, GIA_NHAP, GIA_BAN, SO_LUONG, ANH_SAN_PHAM "+
						"FROM SAN_PHAM SP INNER JOIN NHA_CUNG_CAP NCC " +
						"ON SP.MA_NCC = NCC.MA_NCC WHERE TINH_TRANG = 'True'";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(s);
			while(resultSet.next()){
				String maSP = resultSet.getString(1);
				String tenSP = resultSet.getString(2);
				String chatLieu = resultSet.getString(3);
				String maLoaiSP = resultSet.getString(4);
				String maNCC = resultSet.getString(5);
				String tenNCC = resultSet.getString(6);
				double giaNhap = resultSet.getDouble(7);
				double giaBan = resultSet.getDouble(8);
				int soLuong = resultSet.getInt(9);
				byte[] anhSanPham = resultSet.getBytes(10);
				String fp = "";
				LoaiSanPham loaiSP = new LoaiSanPham(maLoaiSP,"");
				NhaCungCap nhaCC = new NhaCungCap();
				nhaCC.setMaNhaCC(maNCC);nhaCC.setTenNhaCC(tenNCC);
				SanPham sanPham = new SanPham(maSP, tenSP, chatLieu, loaiSP, nhaCC, giaNhap, giaBan, soLuong, anhSanPham, fp);
				danhSachSanPham.add(sanPham);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		closeConnection();
		return danhSachSanPham;
	}
}
