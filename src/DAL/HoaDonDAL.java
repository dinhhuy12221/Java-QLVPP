package DAL;

import java.util.ArrayList;

import DTO.ChiTietPhieu;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;

public class HoaDonDAL extends DatabaseAccess{
    public static boolean themHoaDon(HoaDon hoaDon) {
    	try {
    		hoaDon.setMaPhieu(taoMaHoaDon());
    		getConnection();
    		String s = "INSERT INTO HOA_DON VALUES(?,?,?,?,?,?,'True')";
    		ps = conn.prepareStatement(s);
    		ps.setString(1, hoaDon.getMaPhieu());
    		ps.setString(2, hoaDon.getKhachHang().getMa());
    		ps.setString(3, hoaDon.getNhanVien().getMa());
    		ps.setString(4, hoaDon.getNgayLap());
    		ps.setDouble(5, hoaDon.getTongTien());
    		ps.setBoolean(6, false);
    		int i = ps.executeUpdate();
    		
    		for(ChiTietPhieu ctp: hoaDon.getDSCT()) {
	    		String s1 = "INSERT INTO CT_HOA_DON VALUES(?,?,?,?,?)";
	    		ps = conn.prepareStatement(s1);
	    		ps.setString(1, hoaDon.getMaPhieu());
	    		ps.setString(2, ctp.getSanPham().getMaSanPham());
	    		ps.setDouble(3, ctp.getSanPham().getGiaBan());
	    		ps.setInt(4, ctp.getSanPham().getSoLuong());
	    		ps.setDouble(5, ctp.getThanhTien());
	    		ps.executeUpdate();
    		}
    		System.out.println("Cap nhat chi tiet thanh cong");
    		
    		if (i > 0) {
    			closeConnection();
    			if (KhachHangDAL.capNhatChiTieu(hoaDon.getKhachHang().getMa(), hoaDon.getTongTien())) System.out.println("Cap nhat tong chi tieu thanh cong");
    			for (ChiTietPhieu ctp : hoaDon.getDSCT()) {
    				if (SanPhamDAL.capNhatSoLuongSP(ctp.getSanPham().getMaSanPham(), ctp.getSanPham().getSoLuong())) System.out.println("Cap nhat so luong thanh cong");
    			}
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
    		String s = "UPDATE HOA_DON SET TINH_TRANG = 'False' WHERE MA_HD = '" + hoaDon.getMaPhieu() + "'";
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
    		String s = "UPDATE HOA_DON SET TRANG_THAI = '" + hoaDon.getTrangThai() + "' WHERE MA_HD = '" + hoaDon.getMaPhieu() + "'";
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
    
    public static ArrayList<HoaDon> layDanhSachHoaDon(){
    	ArrayList<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();
    	try {
    		getConnection();
    		String s1 = "SELECT * FROM HOA_DON";
    		statement = conn.createStatement();
    		resultSet = statement.executeQuery(s1);
    		while(resultSet.next()) {
    			String maHD = resultSet.getString(1);
    			String maKH = resultSet.getString(2);
    			String maNV = resultSet.getString(3);
    			String ngayLap = resultSet.getString(4);
    			double tongTien = resultSet.getDouble(5);
    			boolean trangThai = resultSet.getBoolean(6);
    			
    			String s2 = "SELECT MA_SP, DON_GIA, SO_LUONG, THANH_TIEN FROM CT_HOA_DON WHERE MA_HD = '" + maHD + "'";
    			statement = conn.createStatement();
        		resultSet1 = statement.executeQuery(s2);
        		ArrayList<ChiTietPhieu> dsct = new ArrayList<ChiTietPhieu>();
        		while(resultSet1.next()) {
        			String maSP = resultSet1.getString(1);
        			double donGia = resultSet1.getDouble(2);
        			int soLuong = resultSet1.getInt(3);
        			double thanhTien = resultSet1.getDouble(4);
        			
        			SanPham sanPham = new SanPham();
        			sanPham.setMaSanPham(maSP);
        			sanPham.setGiaBan(donGia);
        			sanPham.setSoLuong(soLuong);
        			
        			ChiTietPhieu ctp = new ChiTietPhieu(sanPham,thanhTien);
        			dsct.add(ctp);
        		}
        		String s3 = "SELECT KH.HO_TEN, NV.HO_TEN FROM KHACH_HANG KH, NHAN_VIEN NV WHERE KH.MA_KH = '" +maKH+ "' AND NV.MA_NV = '" +maNV+ "'";
        		statement = conn.createStatement();
        		String tenKH = ""; String tenNV = "";
        		resultSet1 = statement.executeQuery(s3);
        		while(resultSet1.next()) {
        			tenKH= resultSet1.getString(1);
        			tenNV = resultSet1.getString(2);
        		}
        		KhachHang khachHang = new KhachHang();
        		khachHang.setMa(maKH);khachHang.setHoTen(tenKH);
        		NhanVien nhanVien = new NhanVien();
        		nhanVien.setMa(maNV);nhanVien.setHoTen(tenNV);
    			HoaDon hoaDon = new HoaDon(maHD, khachHang, nhanVien, dsct, ngayLap, tongTien, trangThai);
    			danhSachHoaDon.add(hoaDon);
    		}
    		return danhSachHoaDon;
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	finally {
    		closeConnection();
    	}
    	return null;
    }
    
    private static String taoMaHoaDon() {
    	int i = 0;
		try {
			getConnection();
			String s = "SELECT COUNT(MA_HD) FROM HOA_DON";
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
		return "HD" + (i+1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
