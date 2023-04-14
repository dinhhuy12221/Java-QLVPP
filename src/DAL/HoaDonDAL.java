package DAL;

import java.util.ArrayList;

import DTO.HoaDon;

public class HoaDonDAL extends DatabaseAccess{
    public static boolean themHoaDon(HoaDon hoaDon) {
    	try {
    		getConnection();
    		String s = "INSERT INTO HOA_DON VALUES(?,?,?,?,?,?)";
    		ps = conn.prepareStatement(s);
    		ps.setString(1, hoaDon.getMaPhieu());
    		ps.setString(2, hoaDon.getKhachHang().getMa());
    		ps.setString(3, hoaDon.getNhanVien().getMa());
    		ps.setString(4, "");
    		ps.setDouble(5, hoaDon.getTongTien());
    		ps.setBoolean(6, hoaDon.getTinhTrang());
    		int i = ps.executeUpdate();
    		if (i > 0) {
    			closeConnection();
    			return true;
    		}
    		else {
    			closeConnection();
    			return false;
    		}
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	finally {
    		closeConnection();
    	}
    	return false;
    }
    
    public static boolean xoaHoaDon(HoaDon hoaDon) {
    	try {
    		getConnection();
    		String s = "DELETE FROM HOA_DON WHERE = '" + hoaDon.getMaPhieu() +"'";
    		statement = conn.createStatement();
    		int i = statement.executeUpdate(s);
    		if (i > 0) {
    			closeConnection();
    			return true;
    		}
    		else {
    			closeConnection();
    			return false;
    		}
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	finally {
    		closeConnection();
    	}
    	return false;
    }
    
    public static boolean suaHoaDon(HoaDon hoaDon) {
    	try {
    		getConnection();
    		String s = "UPDATE HOA_DON SET TINH_TRANG = '" + hoaDon.getTinhTrang() + "' WHERE MA_HD = '" + hoaDon.getMaPhieu() + "'";
    		statement = conn.createStatement();
    		int i = statement.executeUpdate(s);
    		if (i > 0) {
    			closeConnection();
    			return true;
    		}
    		else {
    			closeConnection();
    			return false;
    		}
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	finally {
    		closeConnection();
    	}
    	return false;
    }
    
//    public static ArrayList<HoaDon> layDanhSachHoaDon(){
//    	ArrayList<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();
//    	try {
//    		getConnection();
//    		String s = "SELECT * FROM HOA_DON"
//    	}
//    	catch(Exception ex) {
//    		System.out.println(ex.getMessage());
//    	}
//    	finally {
//    		closeConnection();
//    	}
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
