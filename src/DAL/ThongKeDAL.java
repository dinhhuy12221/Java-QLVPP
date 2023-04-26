package DAL;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class ThongKeDAL extends DatabaseAccess{
	public static ArrayList<ArrayList<String>> layDoanhThu(){
		ArrayList<ArrayList<String>> danhSachDoanhThu = new ArrayList<ArrayList<String>>();
		try {
			getConnection();
			String s = "SELECT NGAY_LAP, SUM(TONG_TIEN) FROM HOA_DON WHERE TINH_TRANG='True' GROUP BY NGAY_LAP ORDER BY NGAY_LAP ASC";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(s);
			while(resultSet.next()) {
				String ngayLap = resultSet.getString(1);
				String doanhThu = resultSet.getString(2);
				ArrayList<String> array = new ArrayList<String>();
				array.add(ngayLap);array.add(doanhThu);
				danhSachDoanhThu.add(array);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		closeConnection();
		return danhSachDoanhThu;
	}
	
	public static ArrayList<ArrayList<String>> layChiTieu(){
		ArrayList<ArrayList<String>> danhSachChiTieu = new ArrayList<ArrayList<String>>();
		try {
			getConnection();
			String s = "SELECT NGAY_LAP, SUM(TONG_TIEN) FROM PHIEU_NHAP GROUP BY NGAY_LAP ORDER BY NGAY_LAP ASC";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(s);
			while(resultSet.next()) {
				String ngayLap = resultSet.getString(1);
				String chiTieu = resultSet.getString(2);
				ArrayList<String> array = new ArrayList<String>();
				array.add(ngayLap);array.add(chiTieu);
				danhSachChiTieu.add(array);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		closeConnection();
		return danhSachChiTieu;
	}
}
