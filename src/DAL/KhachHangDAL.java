package DAL;

import java.util.ArrayList;
import DTO.KhachHang;

public class KhachHangDAL extends DatabaseAccess{
    public static ArrayList<KhachHang> layDanhSachKhachHang(){
    	ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
    	try {
    		getConnection();
    		String s = "SELECT MA_KH,HO_TEN,DIA_CHI,SDT,NGAY_SINH,TONG_CHI_TIEU FROM KHACH_HANG WHERE TINH_TRANG = 'True'";
    		statement = conn.createStatement();
    		resultSet = statement.executeQuery(s);
    		while(resultSet.next()) {
    			String maKH = resultSet.getString(1);
    			String hoTen = resultSet.getString(2);
    			String diaChi = resultSet.getString(3);
    			String sdt = resultSet.getString(4);
    			String ngaySinh = resultSet.getString(5);
    			double tongChiTieu = resultSet.getDouble(6);
    			KhachHang kh = new KhachHang(maKH, hoTen, diaChi, sdt, ngaySinh, tongChiTieu);
    			dskh.add(kh);
    		}
    		closeConnection();
    		return dskh;
    	} catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	closeConnection();
    	return null;
    }
    
    public static boolean capNhatChiTieu(String maKH, double tienChiTieu) {
    	try {
    		getConnection();
    		double sum = tienChiTieu;
    		String s = "SELECT TONG_CHI_TIEU FROM KHACH_HANG WHERE MA_KH='"+maKH+"'";
    		statement = conn.createStatement();
    		resultSet = statement.executeQuery(s);
    		while(resultSet.next()) {
    			sum += resultSet.getDouble(1);
    		}
    		String s1 = "UPDATE KHACH_HANG SET TONG_CHI_TIEU='"+sum+"' WHERE MA_KH = '" + maKH + "'";
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
}
