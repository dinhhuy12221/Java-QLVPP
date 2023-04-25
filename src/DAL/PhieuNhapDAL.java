package DAL;
import java.util.*;
import DTO.PhieuNhap;
import DTO.SanPham;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.ChiTietPhieu;
import java.sql.*;


public class PhieuNhapDAL extends DatabaseAccess{
	//LẤY DANH SÁCH PHIẾU NHẬP TỪ CSDL
    public static ArrayList<PhieuNhap> laydanhsachphieunhap(){
    	ArrayList<PhieuNhap> DSPN = new ArrayList<PhieuNhap>();
    	try {
    		getConnection();
    		Statement stmt = conn.createStatement();
    		String sql = "select * from phieu_nhap";
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			String mapn = rs.getString(1);
    			String mancc = rs.getString(2);
    			String manv = rs.getString(3);
    			String ngaylap = rs.getString(4);
    			double tongtien = rs.getInt(5);
    			
    			//do vị trí thứ 2 và 3 là 1 đối tượng nên phải tạo riêng
    			NhaCungCap ncc = new NhaCungCap();
    			ncc.setMaNhaCC(mancc);
    			NhanVien nv = new NhanVien();
    			nv.setMa(manv);
    			PhieuNhap pn = new PhieuNhap(mapn,nv,PhieuNhapDAL.laychitietphieunhap(mapn),ncc,ngaylap,tongtien);
    			DSPN.add(pn);
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	} finally {
    		closeConnection();
    	}
    	
    	return DSPN;
    }
    
    //LẤY CHI TIẾT PHIẾU NHẬP
    public static ArrayList<ChiTietPhieu> laychitietphieunhap(String mapn){
    	ArrayList<ChiTietPhieu> CTPN = new ArrayList<ChiTietPhieu>();
    	try {
    		getConnection();
    		Statement stmt = conn.createStatement();
    		String sql = "select * from ct_phieu_nhap where ma_pn='"+mapn+"'";
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			ChiTietPhieu ctpn = new ChiTietPhieu();
    			SanPham sp = new SanPham();
    			sp.setMaSanPham(rs.getString(2));
    			sp.setGiaNhap(rs.getDouble(3));
    			sp.setSoLuong(rs.getInt(4));
    			ctpn.setThanhTien(rs.getDouble(5));
    			CTPN.add(ctpn);
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	} finally {
    		closeConnection();
    	}
    	return CTPN;
    }
    
    //THÊM PHIẾU NHẬP
    public static boolean themphieunhap(PhieuNhap pn) {
    	boolean rs = false;
    	try {
    		getConnection();
    		Statement stmt = conn.createStatement();
    		
    		String sql = "insert into phieu_nhap values(?,?,?,?,?)";
    		ps = conn.prepareStatement(sql);//ps là prepared statement, TRIM XÓA HẾT KHOẢNG TRẮNG
    		ps.setString(1, pn.getMaPhieu().trim());
    		ps.setString(2, pn.getNhaCC().getMaNhaCC().trim());
    		ps.setString(3, pn.getNhanVien().getMa().trim());
    		ps.setString(4, pn.getNgayLap().trim());
    		ps.setDouble(5, pn.getTongTien());
    		if(ps.executeUpdate()>=1) {
				rs = true;
			}
    	} catch(Exception e) {
    		System.out.println(e);
    	} finally {
    		closeConnection();
    	}
    	return rs;
    }
    
    //XÓA PHIẾU NHẬP
    public static int xoaphieunhap(String mapn) {
		int dem=0;
		try {
			getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from phieu_nhap where ma_pn='"+mapn+"'";
			dem = stmt.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			closeConnection();
		}
		return dem;
	}
    
    //SỬA PHIẾU NHẬP
    public static boolean suaphieunhap(PhieuNhap pn) {
    	boolean dem =false;
    	try {
    		getConnection();
    		Statement stmt = conn.createStatement();
    		String sql ="update phieu_nhap set ma_ncc='"
    					+ pn.getNhaCC().getMaNhaCC() +"', ma_nv='"
    					+ pn.getNhanVien().getMa() +"', ngay_lap='"
    					+ pn.getNgayLap()+"', tong_tien='"
    					+ pn.getTongTien()+"' where ma_pn='"+pn.getMaPhieu()+"'";
    		int temp = stmt.executeUpdate(sql);
    		if(temp>=1)
    			dem = true;
    	} catch(Exception e) {
    		System.out.println(e);
    	} finally {
    		closeConnection();
    	}
    	return dem;
    }
    
    //TÌM KIẾM PHIẾU NHẬP
    public static ArrayList<PhieuNhap> timkiemphieunhap(String mapn, String ngaytao){
    	ArrayList<PhieuNhap> arr = new ArrayList<PhieuNhap>();
    	try {
    		getConnection();
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from phieu_nhap where ma_pn='"+mapn+"' and ngay_lap='"+ngaytao+"'");
			if(mapn.equals(""))
				rs = stmt.executeQuery("select * from phieu_nhap where ngay_lap='"+ngaytao+"'");
			if(ngaytao.equals(""))
				rs = stmt.executeQuery("select * from phieu_nhap where ma_pn='"+mapn+"'");
			
			while(rs.next()) {
				String ma_pn = rs.getString(1);
				String ma_ncc = rs.getString(2);
				String ma_nv = rs.getString(3);
				String ngay_lap = rs.getString(4);
				Double tong_tien = rs.getDouble(5);
				//do vị trí thứ 2 và 3 là 1 đối tượng nên phải tạo riêng
    			NhaCungCap ncc = new NhaCungCap();
    			ncc.setMaNhaCC(ma_ncc);
    			NhanVien nv = new NhanVien();
    			nv.setMa(ma_nv);
				PhieuNhap temp = new PhieuNhap(ma_pn,nv,PhieuNhapDAL.laychitietphieunhap(mapn),ncc,ngay_lap,tong_tien);
				arr.add(temp);
			}
    	} catch(Exception e) {
    		System.out.println(e);
    	} finally {
    		closeConnection();
    	}
    	return arr;
    }
    
    		//PHẦN CHI TIẾT PHIẾU NHẬP
    //THÊM CHI TIẾT PHIẾU NHẬP
    public static boolean themchitietphieunhap(String mapn, ChiTietPhieu ctpn) {
    	boolean rs = false;
    	try {
    		getConnection();
    		String sql = "insert into ct_phieu_nhap values(?,?,?,?,?)";
    		ps = conn.prepareStatement(sql);//ps là prepared statement, TRIM XÓA HẾT KHOẢNG TRẮNG
    		
    		ps.setString(1, mapn.trim());
    		ps.setString(2, ctpn.getSanPham().getMaSanPham().trim());
    		ps.setDouble(3, ctpn.getSanPham().getGiaNhap());
    		ps.setInt(4, ctpn.getSanPham().getSoLuong());
    		ps.setDouble(5, ctpn.getThanhTien());
    		if(ps.executeUpdate()>=1) {
				rs = true;
			}
    	} catch(Exception e) {
    		System.out.println(e);
    	} finally {
    		closeConnection();
    	}
    	return rs;
    }
    //SỬA CHI TIẾT PHIẾU NHẬP
    public static boolean suachitietphieunhap(ChiTietPhieu ctpn) {
		boolean dem=false;
		try {
			getConnection();	//HÀM TRIM() XÓA HẾT KHOẢNG TRẮNG
			Statement stmt = conn.createStatement();
			String sql = "update ct_phieu_nhap set don_gia='"+ctpn.getSanPham().getGiaNhap()+"', so_luong='"+ctpn.getSanPham().getSoLuong()+"', thanh_tien='"+ctpn.getThanhTien()+"' where ma_sp='"+ctpn.getSanPham().getMaSanPham()+"'";
			int temp = stmt.executeUpdate(sql);
			if(temp>=1)
				dem=true;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			closeConnection();
		}
		return dem;
	}
    //XÓA CHI TIẾT PHIẾU NHẬP
    public static int xoachitietphieunhap(String masp) {
		int dem=0;
		try {
			getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from ct_phieu_nhap where ma_sp='"+masp+"'";
			dem = stmt.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			closeConnection();
		}
		return dem;
	}
}
