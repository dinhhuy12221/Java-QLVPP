package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DTO.NhanVien;
import DTO.SanPham;
import DTO.LoaiSanPham;
import DTO.KhachHang;
import DTO.ChiTietPhieu;
import DTO.HoaDon;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javafx.scene.control.DatePicker;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class HoaDonGUI extends JPanel {
	private int indexCKH;
	
	private JTextField tfMaKH;
	private JTextField tfTenKH;
	private JTextField tfTimKiem;
	private JTextField tfSoLuong;
	
	private DefaultTableModel tModelDSSPChon;
	private DefaultTableModel tModelDSSP;
	private DefaultTableModel tModelDSHD;
	
	private JTable tableDSSPChon;
	private JTable tableDSHD;
	private JTable tableDSSP;

	private ArrayList<SanPham> danhSachSPChon = new ArrayList<SanPham>();
	private ArrayList<SanPham> danhSachSP = new ArrayList<SanPham>();
	private ArrayList<HoaDon> danhSachHD = BLL.HoaDonBLL.layDanhSachHD();
	
	private KhachHang khachHang = new KhachHang();
	/**
	 * Create the panel.
	 */
	public HoaDonGUI() {
		setSize(1082,689);
		setLayout(null);
		
		JLabel lblQunLHa = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLHa.setBounds(10, 10, 860, 28);
		lblQunLHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHa.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblQunLHa);
		
		JPanel panelDanhSachHD = new JPanel();
		panelDanhSachHD.setBounds(10, 382, 1051, 297);
		panelDanhSachHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelDanhSachHD);
		
		JScrollPane scrollPaneDSHD = new JScrollPane();
		scrollPaneDSHD.setEnabled(false);
		scrollPaneDSHD.setBounds(6, 15, 1035, 229);
		scrollPaneDSHD.enableInputMethods(false);
		panelDanhSachHD.setLayout(null);
		panelDanhSachHD.add(scrollPaneDSHD);
		
		tModelDSHD = new DefaultTableModel(new Object[][] {}, new String[] {"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên",  "Ngày lập", "Tổng tiền" , "Trạng thái"});
		tableDSHD = new JTable();
		tableDSHD.setModel(tModelDSHD);
		scrollPaneDSHD.setViewportView(tableDSHD);
		
		
		JPanel panelThongTinHD = new JPanel();
		panelThongTinHD.setBounds(792, 53, 269, 148);
		panelThongTinHD.setLayout(null);
		panelThongTinHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin l\u1EADp h\u00F3a \u0111\u01A1n", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelThongTinHD);
		
		JLabel lblMaKhachHang = new JLabel("Mã khách hàng");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaKhachHang.setBounds(10, 78, 98, 19);
		panelThongTinHD.add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKhachHang.setBounds(10, 107, 98, 19);
		panelThongTinHD.add(lblTenKhachHang);
		
		tfMaKH = new JTextField();
		tfMaKH.setEditable(false);
		tfMaKH.setColumns(10);
		tfMaKH.setBounds(118, 79, 132, 19);
		panelThongTinHD.add(tfMaKH);
		
		tfTenKH = new JTextField();
		tfTenKH.setEditable(false);
		tfTenKH.setColumns(10);
		tfTenKH.setBounds(118, 108, 132, 19);
		panelThongTinHD.add(tfTenKH);
		
		JButton btnChonKhachHang = new JButton("Chọn khách hàng\r\n");
		btnChonKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonKhachHang(e);
			}
		});
		btnChonKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonKhachHang.setBounds(10, 23, 115, 19);
		panelThongTinHD.add(btnChonKhachHang);
		
		JPanel panelDSSPChon = new JPanel();
		panelDSSPChon.setBounds(10, 53, 434, 254);
		panelDSSPChon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EA3n ph\u1EA9m ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelDSSPChon);
		panelDSSPChon.setLayout(null);
		
		JScrollPane scrollPaneSanPham = new JScrollPane();
		scrollPaneSanPham.setBounds(6, 15, 417, 204);
		panelDSSPChon.add(scrollPaneSanPham);
		
		tModelDSSPChon = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
				}
			);
		tableDSSPChon = new JTable();
		tableDSSPChon.setModel(tModelDSSPChon);
		scrollPaneSanPham.setViewportView(tableDSSPChon);
		
		JButton btnXoaSanPham = new JButton("Xóa sản phẩm");
		btnXoaSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableDSSPChon.getSelectedRow();
				if(i >=0 ) { 
					SanPham sp = danhSachSPChon.remove(i);
					hienThiDSSPChon(danhSachSPChon);
					for (SanPham sanPham : danhSachSP)
						if(sanPham.getMaSanPham().equals(sp.getMaSanPham()))
							sanPham.setSoLuong(sanPham.getSoLuong() + sp.getSoLuong());
					hienThiDSSP(danhSachSP);
				}
			}
		});
		btnXoaSanPham.setBounds(86, 229, 95, 19);
		panelDSSPChon.add(btnXoaSanPham);
		btnXoaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 317, 534, 45);
		add(panel);
		panel.setLayout(null);
		
		JComboBox cbTimKiem = new JComboBox();
		cbTimKiem.setModel(new DefaultComboBoxModel(new String[] {"", "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Tên khách hàng", "Tên nhân viên"}));
		cbTimKiem.setBounds(10, 21, 109, 14);
		panel.add(cbTimKiem);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setBounds(139, 19, 182, 19);
		panel.add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loaiTimKiem = cbTimKiem.getSelectedItem().toString();
				String tenTimKiem = tfTimKiem.getText();
				timKiemHoaDon(loaiTimKiem, tenTimKiem);
			}
		});
		btnTimKiem.setBounds(347, 18, 85, 21);
		panel.add(btnTimKiem);
		
		JButton btnHuyTimKiem = new JButton("Hủy");
		btnHuyTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDSHD(BLL.HoaDonBLL.layDanhSachHD());
				tfTimKiem.setText("");
			}
		});
		btnHuyTimKiem.setBounds(439, 18, 85, 21);
		panel.add(btnHuyTimKiem);
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemChiTietHoaDon();
			}
		});
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXemChiTiet.setBounds(459, 254, 132, 33);
		panelDanhSachHD.add(btnXemChiTiet);
		
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBounds(848, 246, 95, 19);
		add(btnLapHoaDon);
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lapHoaDon();
			}
		});
		btnLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JPanel panelDSSP = new JPanel();
		panelDSSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDSSP.setBounds(454, 53, 328, 246);
		add(panelDSSP);
		panelDSSP.setLayout(null);
		
		JScrollPane spDSSP = new JScrollPane();
		spDSSP.setBounds(10, 20, 308, 185);
		panelDSSP.add(spDSSP);
		
		tableDSSP = new JTable();
		spDSSP.setViewportView(tableDSSP);
		tModelDSSP = new DefaultTableModel(new Object [][] {},new String [] {"Tên sản phẩm", "Đơn giá" ,"Số lượng"});
		tableDSSP.setModel(tModelDSSP);
		spDSSP.setViewportView(tableDSSP);
		
		JButton btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setBounds(201, 217, 95, 19);
		panelDSSP.add(btnThemSP);
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSanPham();
			}
		});
		btnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(20, 220, 61, 13);
		panelDSSP.add(lblSoLuong);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setBounds(91, 215, 52, 19);
		panelDSSP.add(tfSoLuong);
		tfSoLuong.setColumns(10);
		
		hienThiDSHD(BLL.HoaDonBLL.layDanhSachHD());
		hienThiDSSP(BLL.SanPhamBLL.layDanhSachSP());
	}
	
	//--------------------------------CHUC NANG---------------------------------------
	
	private void themSanPham() {
		try {
			if (! tfSoLuong.getText().trim().equals("")) {
				int soLuongSP = Integer.parseInt(tfSoLuong.getText().trim());
				int i = tableDSSP.getSelectedRow();
				if (soLuongSP <= danhSachSP.get(i).getSoLuong() && soLuongSP > 0 && i >= 0) {
					boolean checked = true;
					for (SanPham item: danhSachSPChon) 
						if (item.getMaSanPham().equals(danhSachSP.get(i).getMaSanPham())){
							checked = false;
							break;
						}
					if(checked) {
						SanPham sp = new SanPham();
						sp.setMaSanPham(danhSachSP.get(i).getMaSanPham());
						sp.setSoLuong(soLuongSP);
						sp.setGiaBan(danhSachSP.get(i).getGiaBan());
						danhSachSPChon.add(sp);
						hienThiDSSPChon(danhSachSPChon);
						
						// Xoa di sp da chon 
						danhSachSP.get(i).setSoLuong(danhSachSP.get(i).getSoLuong() - sp.getSoLuong());
						hienThiDSSP(danhSachSP);
						
						tfSoLuong.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null, "Sản phẩm đã được chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
//		JTable spChonTable = new JTable();
//		DefaultTableModel spChonTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Mã san pham", "Tên san pham", "Ma loai san pham","Ten loai san pham","Don gia", "So luong ton"});
//		spChonTable.setModel(spChonTableModel);
//		JScrollPane spChonSP = new JScrollPane();
//		
//		ArrayList<SanPham> dssp = BLL.SanPhamBLL.layDanhSachSP();
//		
//		for(SanPham sp: dssp) {
//			spChonTableModel.addRow(new Object[] {sp.getMaSanPham(),sp.getTenSanPham(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(), sp.getGiaBan(), sp.getSoLuong()});
//		}
//
//		
//		spChonTable.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				indexCSP = spChonTable.getSelectedRow();
//			}
//		});
//		
//		btnXn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					if (! tfSoLuong.getText().trim().equals("")) {
//						int soLuongSP = Integer.parseInt(tfSoLuong.getText().trim());
//						if (soLuongSP <= dssp.get(indexCSP).getSoLuong() && soLuongSP > 0) {
//							SanPham sp = dssp.get(indexCSP);
//							sp.setSoLuong(soLuongSP);
//							danhSachSP.add(sp);
//							hienThiDSSP(danhSachSP);
//							frame.dispose();
//						} else {
//							JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//						}
//					}
//				} catch(Exception ex) {
//				System.out.println(ex.getMessage());
//				}
//			}
//		});
		
//		btnHy.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//			}
//		});
//		
//		frame.getContentPane().add(btnXn);frame.getContentPane().add(btnHy);
//		frame.getContentPane().add(tfSoLuong);frame.getContentPane().add(lbSoLuongSP);
//		
//		spChonSP.setViewportView(spChonTable);
//		spChonSP.setBounds(10,10,650,240);;
//		frame.getContentPane().add(spChonSP);
//		frame.setSize(700,350);
//		frame.setResizable(false);
//		frame.getContentPane().setLayout(null);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
	}

	
	private void chonKhachHang(ActionEvent e) {
		ChonKhachHangGUI ckh = new ChonKhachHangGUI();
		ckh.setVisible(true);
	}
	
	private void hienThiDSSPChon(ArrayList<SanPham> dssp) {
		danhSachSPChon = dssp;
		tModelDSSPChon.setRowCount(0);
		for(SanPham sp: danhSachSPChon) {
			tModelDSSPChon.addRow(new Object[] {sp.getMaSanPham(),sp.getTenSanPham(),sp.getGiaBan(),sp.getSoLuong()});
		}
	}
	
	private void hienThiDSSP(ArrayList<SanPham> dssp) {
		danhSachSP = dssp;
		tModelDSSP.setRowCount(0);
		for(SanPham sp: dssp) {
			tModelDSSP.addRow(new Object[] {sp.getTenSanPham(),sp.getGiaBan(),sp.getSoLuong()});
		}
	}

	
	private void lapHoaDon() {
		KhachHang khachHang = new KhachHang();
		khachHang.setMa(tfMaKH.getText());
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMa("NV1");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String ngayLap = dtf.format(now).toString();
		
		double tongTien = 0;
		ArrayList<ChiTietPhieu> dsct = new ArrayList<ChiTietPhieu>();
		for(SanPham sp: danhSachSPChon) {
			double thanhTien = sp.getGiaBan() * sp.getSoLuong();
			ChiTietPhieu ctp = new ChiTietPhieu(sp, thanhTien);
			dsct.add(ctp);
			tongTien += thanhTien;
		}
		
		HoaDon hoaDon = new HoaDon("",khachHang,nhanVien,dsct,ngayLap,tongTien, false);
		int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận lập hóa đơn ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
		if(c == 0 && BLL.HoaDonBLL.lapHoaDon(hoaDon)) {
			JOptionPane.showMessageDialog(new GiaoDienGUI(), "Lap hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			hienThiDSHD(BLL.HoaDonBLL.layDanhSachHD());
		}
		else JOptionPane.showMessageDialog(new GiaoDienGUI(), "Lập hóa đơn không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void xemChiTietHoaDon() {
		JFrame frame = new JFrame("Chi tiết hóa đơn");
		JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(300,300,100,30);
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JTable CTHDTable = new JTable();
		DefaultTableModel CTHDTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Mã sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"});
		CTHDTable.setEnabled(false);
		
		CTHDTable.setModel(CTHDTableModel);
		JScrollPane CTHDSP = new JScrollPane();
		try {
			int i = tableDSHD.getSelectedRow();
			if(i >= 0) {
				for (ChiTietPhieu ctp : danhSachHD.get(i).getDSCT()) {
					CTHDTableModel.addRow(new Object [] {ctp.getSanPham().getMaSanPham(), ctp.getSanPham().getGiaBan(),ctp.getSanPham().getSoLuong(),ctp.getThanhTien()});
				}
			}
			JLabel lbTongTien = new JLabel("Tổng tiền: " + danhSachHD.get(i).getTongTien());
			lbTongTien.setBounds(500,250,120,50);
			JLabel lbMaKH = new JLabel();
			lbMaKH.setText("Mã khách hàng: " + danhSachHD.get(i).getKhachHang().getMa());
			lbMaKH.setBounds(10,10,150,40);
			JLabel lbTenKH = new JLabel();
			lbTenKH.setText("Tên khách hàng: " + danhSachHD.get(i).getKhachHang().getHoTen());
			lbTenKH.setBounds(10,50,250,40);
			JLabel lbMaNV = new JLabel();
			lbMaNV.setText("Mã nhân viên: " + danhSachHD.get(i).getNhanVien().getMa());
			lbMaNV.setBounds(10,90,150,40);
			JLabel lbTenNV = new JLabel();
			lbTenNV.setText("Tên nhân viên: " + danhSachHD.get(i).getNhanVien().getHoTen());
			lbTenNV.setBounds(10,130,250,40);
			JLabel lbNgayLap = new JLabel();
			lbNgayLap.setText("Ngày lập: " + danhSachHD.get(i).getNgayLap());
			lbNgayLap.setBounds(10,170,250,40);
			
			frame.getContentPane().add(lbTongTien);
			frame.getContentPane().add(lbMaKH);
			frame.getContentPane().add(lbTenKH);
			frame.getContentPane().add(lbMaNV);
			frame.getContentPane().add(lbTenNV);
			frame.getContentPane().add(lbNgayLap);
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		frame.getContentPane().add(btnDong);
		
		CTHDSP.setViewportView(CTHDTable);
		CTHDSP.setBounds(350,10,300,250);;
		frame.getContentPane().add(CTHDSP);
		frame.setSize(700,400);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void hienThiDSHD(ArrayList<HoaDon> danhSachHD) {
		tModelDSHD.setRowCount(0);
		for (HoaDon hoaDon: danhSachHD) {
			String trangThai = "";
			if(hoaDon.getTrangThai()) trangThai = "Đã thanh toán";
			else trangThai = "Chưa thanh toán";
			tModelDSHD.addRow(new Object[] {hoaDon.getMaPhieu(),hoaDon.getKhachHang().getMa(), hoaDon.getNhanVien().getMa(), hoaDon.getNgayLap(), hoaDon.getTongTien(), trangThai});
		}
	}
	
	private void timKiemHoaDon(String loaiTimKiem, String tenTimKiem) {
		ArrayList<HoaDon> danhSachHD1 = new ArrayList<HoaDon>();
		switch(loaiTimKiem){
		case "Mã hóa đơn":
			for (HoaDon hd: danhSachHD) {
				if (hd.getMaPhieu().equals(tenTimKiem.toUpperCase())) {
					danhSachHD1.add(hd);
				}
			}
			break;
		case "Mã khách hàng":
			for (HoaDon hd: danhSachHD) {
				if (hd.getKhachHang().getMa().equals(tenTimKiem.toUpperCase())) {
					danhSachHD1.add(hd);
				}
			}
			break;
		case "Mã nhân viên":
			for (HoaDon hd: danhSachHD) {
				if (hd.getNhanVien().getMa().equals(tenTimKiem.toUpperCase())) {
					danhSachHD1.add(hd);
				}
			}
			break;
		case "Tên khách hàng":
			for (HoaDon hd: danhSachHD) {
				if (hd.getKhachHang().getHoTen().equals(tenTimKiem.toUpperCase())) {
					danhSachHD1.add(hd);
				}
			}
			break;
		case "Tên nhân viên":for (HoaDon hd: danhSachHD) {
			if (hd.getNhanVien().getHoTen().equals(tenTimKiem.toUpperCase())) {
				danhSachHD1.add(hd);
			}
		}
			break;
		}
		hienThiDSHD(danhSachHD1);
	}
}
