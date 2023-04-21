//package DAL;
//
//import java.util.ArrayList;
//
//import DTO.NhanVien;
//
//public class NhanVienDAL extends DatabaseAccess{
//	public static ArrayList<NhanVien> layDanhSachNhanVien(){
//    	ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
//    	try {
//    		getConnection();
//    		String s = "SELECT MA_KH,HO_TEN,DIA_CHI,SDT,NGAY_SINH,CHUC_VU FROM KHACH_HANG WHERE TINH_TRANG = 'True'";
//    		statement = conn.createStatement();
//    		resultSet = statement.executeQuery(s);
//    		while(resultSet.next()) {
//    			String maKH = resultSet.getString(1);
//    			String hoTen = resultSet.getString(2);
//    			String diaChi = resultSet.getString(3);
//    			String sdt = resultSet.getString(4);
//    			String ngaySinh = resultSet.getString(5);
//    			
//    			double tongChiTieu = resultSet.getDouble(7);
//    			NhanVien nv = new NhanVien(maKH, hoTen, diaChi, sdt, ngaySinh,  ,tongChiTieu);
//    			dsnv.add(nv);
//    		}
//    		closeConnection();
//    		return dsnv;
//    	} catch(Exception ex) {
//    		System.out.println(ex.getMessage());
//    	}
//    	closeConnection();
//    	return null;
//    }
//}
