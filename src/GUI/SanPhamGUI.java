package GUI;

import DTO.LoaiSanPham;
import DTO.SanPham;
import DTO.NhaCungCap;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFileChooser;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class SanPhamGUI extends JPanel {
	private JComboBox cbMaNCC = new JComboBox();
	private JComboBox cbMaLoaiSP = new JComboBox();
	private JComboBox cbGia = new JComboBox();
	private JComboBox cbLoaiSP = new JComboBox();
	private JComboBox cbTimKiem = new JComboBox();
	
	private JButton btnXacNhan;
	private JButton btnHuy;
	private JButton btnThemAnh;
	
	private JLabel lblAnhSP = new JLabel("");
	private String filePath;
	
	private ArrayList<SanPham> danhSachSP = new ArrayList<SanPham>();
	private ArrayList<NhaCungCap> danhSachNCC = new ArrayList<NhaCungCap>();
	private ArrayList<LoaiSanPham> danhSachLSP = new ArrayList<LoaiSanPham>();
	
	private JTextField tfMaSP;
	private JTextField tfTenSP;
	private JTextField tfGiaNhap;
	private JTextField tfGiaBan;
	private JTextField tfSoLuong;
	private JTextField tfTenNCC;
	private JTable tableSanPham;
	private JTextField tfTimKiem;
	private JTextField tfGiaMin;
	private JTextField tfGiaMax;
	private JTextField tfTenLoaiSP;
	private byte[] anhFile;
	private JTextField tfChatLieu;
	private DefaultTableModel tableModel;
	
	private SanPham_LoaiSanPhamGUI lspgui = new SanPham_LoaiSanPhamGUI();
	
	String confirmMode = "";

	/**
	 * Create the panel.
	 */
	public SanPhamGUI() {
		danhSachSP = BLL.SanPhamBLL.layDanhSachSP();
		danhSachNCC = BLL.NhaCungCapBLL.layDanhSachNhaCC();
		danhSachLSP = BLL.LoaiSanPhamBLL.layDanhSachLoaiSP();
		
		setSize(new Dimension(1082,689));
		setLayout(null);
		
		JLabel lblQuanLy = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblQuanLy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLy.setBounds(103, 10, 598, 28);
		add(lblQuanLy);
		
		JPanel panelThongTinSP = new JPanel();
		panelThongTinSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTinSP.setBounds(10, 48, 769, 194);
		add(panelThongTinSP);
		panelThongTinSP.setLayout(null);
		
		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setBounds(190, 31, 113, 19);
		panelThongTinSP.add(lblMaSanPham);
		lblMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTenSanPham = new JLabel("Tên sản phẩm *");
		lblTenSanPham.setBounds(190, 60, 113, 19);
		panelThongTinSP.add(lblTenSanPham);
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGiaNhap = new JLabel("Giá nhập *");
		lblGiaNhap.setBounds(474, 90, 105, 19);
		panelThongTinSP.add(lblGiaNhap);
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGiaBan = new JLabel("Giá bán *");
		lblGiaBan.setBounds(474, 119, 105, 19);
		panelThongTinSP.add(lblGiaBan);
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSoLuongTon = new JLabel("Số lượng tồn");
		lblSoLuongTon.setBounds(474, 148, 105, 19);
		panelThongTinSP.add(lblSoLuongTon);
		lblSoLuongTon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblMaNhaCungCap = new JLabel("Mã nhà cung cấp *");
		lblMaNhaCungCap.setBounds(474, 32, 105, 19);
		panelThongTinSP.add(lblMaNhaCungCap);
		
		
		lblMaNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMaNCC.setEditable(true);
		cbMaNCC.setEnabled(false);
		cbMaNCC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(NhaCungCap ncc: danhSachNCC) {
				if(ncc.getMaNhaCC().equals(cbMaNCC.getSelectedItem().toString())) {
					tfTenNCC.setText(ncc.getTenNhaCC());
					break;
				}
			}
		}});
		
		cbMaNCC.setBounds(597, 31, 162, 21);
		Vector<String> sMaNCC = new Vector<String>();
		sMaNCC.add("");
		for(int i = 0; i < danhSachNCC.size(); i++) {
			sMaNCC.add(danhSachNCC.get(i).getMaNhaCC());
		}
		cbMaNCC.setModel(new DefaultComboBoxModel(sMaNCC));
		panelThongTinSP.add(cbMaNCC);
		
		tfMaSP = new JTextField();
		tfMaSP.setEditable(false);
		tfMaSP.setBounds(298, 32, 157, 19);
		panelThongTinSP.add(tfMaSP);
		tfMaSP.setColumns(10);
		
		tfTenSP = new JTextField();
		tfTenSP.setEditable(false);
		tfTenSP.setBounds(298, 61, 157, 19);
		panelThongTinSP.add(tfTenSP);
		tfTenSP.setColumns(10);
		
		tfGiaNhap = new JTextField();
		tfGiaNhap.setEditable(false);
		tfGiaNhap.setBounds(597, 90, 162, 19);
		panelThongTinSP.add(tfGiaNhap);
		tfGiaNhap.setColumns(10);
		
		tfGiaBan = new JTextField();
		tfGiaBan.setEditable(false);
		tfGiaBan.setBounds(597, 119, 162, 19);
		panelThongTinSP.add(tfGiaBan);
		tfGiaBan.setColumns(10);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setEditable(false);
		tfSoLuong.setBounds(597, 148, 162, 19);
		panelThongTinSP.add(tfSoLuong);
		tfSoLuong.setColumns(10);
		
		JLabel lblTenNhaCungCap = new JLabel("Tên nhà cung cấp");
		lblTenNhaCungCap.setBounds(474, 61, 105, 19);
		panelThongTinSP.add(lblTenNhaCungCap);
		lblTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		// Textfiel ten nha cc
		tfTenNCC = new JTextField();
		tfTenNCC.setOpaque(false);
		tfTenNCC.setHorizontalAlignment(SwingConstants.LEFT);
		tfTenNCC.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfTenNCC.setEditable(false);
		tfTenNCC.setBounds(597, 61, 162, 19);
		panelThongTinSP.add(tfTenNCC);
		tfTenNCC.setColumns(10);
		
		JLabel lblMaLoaiSP = new JLabel("Mã loại sản phẩm *");
		lblMaLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaLoaiSP.setBounds(190, 90, 113, 19);
		panelThongTinSP.add(lblMaLoaiSP);
		
		JLabel lblTenLoaiSP = new JLabel("Tên loại sản phẩm");
		lblTenLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenLoaiSP.setBounds(190, 118, 113, 19);
		panelThongTinSP.add(lblTenLoaiSP);
		
		tfTenLoaiSP = new JTextField();
		tfTenLoaiSP.setEditable(false);
		tfTenLoaiSP.setColumns(10);
		tfTenLoaiSP.setBounds(298, 119, 157, 19);
		panelThongTinSP.add(tfTenLoaiSP);
		cbMaLoaiSP.setEditable(true);
		cbMaLoaiSP.setEnabled(false);
		
		//CB ma loai sp
		cbMaLoaiSP.setBounds(298, 90, 157, 21);
		Vector<String> sLoaiSP = new Vector<String>();
		sLoaiSP.add("");
		for(int i = 0; i < danhSachLSP.size(); i++) {
			sLoaiSP.add(danhSachLSP.get(i).getMaLoaiSanPham());
		}
		cbMaLoaiSP.setModel(new DefaultComboBoxModel(sLoaiSP));
		cbMaLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(LoaiSanPham lsp : danhSachLSP) {
					if(lsp.getMaLoaiSanPham().equals(cbMaLoaiSP.getSelectedItem())) {
						tfTenLoaiSP.setText(lsp.getTenLoaiSanPham());
						break;
					}
				}
			}
		});
		panelThongTinSP.add(cbMaLoaiSP);
		
		JPanel panelDanhSachSP = new JPanel();
		panelDanhSachSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSachSP.setBounds(10, 330, 913, 243);
		add(panelDanhSachSP);
		panelDanhSachSP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.enableInputMethods(false);
		scrollPane.setEnabled(false);
		panelDanhSachSP.add(scrollPane);
		
		tableSanPham = new JTable();
		tableSanPham.setOpaque(false);
		tableSanPham.setFillsViewportHeight(true);
		tableSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonSanPham();
			}
		});
		tableModel = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Chất liệu" ,"M\u00E3 lo\u1EA1i SP", "T\u00EAn lo\u1EA1i SP", "M\u00E3 nh\u00E0 cung c\u1EA5p", "T\u00EAn nh\u00E0 cung c\u1EA5p", "Gi\u00E1 nh\u1EADp", "Gi\u00E1 b\u00E1n", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n"
			} 
		);
		tableSanPham.setModel(tableModel);
		scrollPane.setViewportView(tableSanPham);
		
		// Button chon anh
		btnThemAnh = new JButton("Chọn ảnh");
		btnThemAnh.setEnabled(false);
		btnThemAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonAnh();
			}
		});
		btnThemAnh.setBounds(30, 163, 104, 21);
		panelThongTinSP.add(btnThemAnh);
		
		JLabel lblChatLieu = new JLabel("Chất liệu");
		lblChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChatLieu.setBounds(190, 148, 113, 19);
		panelThongTinSP.add(lblChatLieu);
		
		tfChatLieu = new JTextField();
		tfChatLieu.setEditable(false);
		tfChatLieu.setColumns(10);
		tfChatLieu.setBounds(298, 149, 157, 19);
		panelThongTinSP.add(tfChatLieu);
		lblAnhSP.setBounds(10, 31, 154, 122);
		panelThongTinSP.add(lblAnhSP);
		lblAnhSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		// Panel chuc nang
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c  n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChucNang.setBounds(789, 48, 134, 272);
		add(panelChucNang);
		panelChucNang.setLayout(new GridLayout(0, 1, 0, 0));
		
		// Button them san pham
		JButton btnThem = new JButton("Thêm");
		panelChucNang.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSanPham();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		// Button xoa san pham
		JButton btnXoa = new JButton("Xóa");
		panelChucNang.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSanPham();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		// Button sua san pham
		JButton btnSua = new JButton("Sửa");
		panelChucNang.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSanPham();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Button nhap excel
		JButton btnNhapExcel = new JButton("Nhập Excel");
		panelChucNang.add(btnNhapExcel);
		btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Button xuat excel
		JButton btnXuatExcel = new JButton("Xuất Excel");
		panelChucNang.add(btnXuatExcel);
		btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		panelChucNang.add(btnLamMoi);
		
		// Panel tim kiem
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimKiem.setBounds(10, 245, 572, 75);
		add(panelTimKiem);
		panelTimKiem.setLayout(null);
		
		//Label tim kiem
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setBounds(10, 10, 69, 19);
		panelTimKiem.add(lblTimKiem);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Textfield tim kiem tu chon
		tfTimKiem = new JTextField();
//		tfTimKiem.getDocument().addDocumentListener((new DocumentListener() {
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				timKiemSP();
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				timKiemSP();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				timKiemSP();	
//			}
//		}));
		tfTimKiem.setBounds(318, 11, 244, 19);
		panelTimKiem.add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setBounds(20, 39, 27, 19);
		panelTimKiem.add(lblLoc);
		lblLoc.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		cbGia.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				timKiemSP();
//			}
//		});
		
		cbGia.setBounds(57, 39, 84, 21);
		panelTimKiem.add(cbGia);
		cbGia.setModel(new DefaultComboBoxModel(new String[] {"", "Giá nhập", "Giá bán"}));
		
		tfGiaMin = new JTextField();
//		tfGiaMin.getDocument().addDocumentListener((new DocumentListener() {
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				timKiemSP();
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				timKiemSP();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				timKiemSP();	
//			}
//		}));
		tfGiaMin.setBounds(151, 42, 84, 19);
		panelTimKiem.add(tfGiaMin);
		tfGiaMin.setColumns(10);
		
		tfGiaMax = new JTextField();
//		tfGiaMax.getDocument().addDocumentListener((new DocumentListener() {
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				timKiemSP();
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				timKiemSP();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				timKiemSP();	
//			}
//		}));
		tfGiaMax.setBounds(264, 40, 84, 19);
		panelTimKiem.add(tfGiaMax);
		tfGiaMax.setColumns(10);
		
		JLabel lblDauNgang = new JLabel("-");
		lblDauNgang.setEnabled(false);
		lblDauNgang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDauNgang.setBounds(245, 42, 9, 13);
		panelTimKiem.add(lblDauNgang);
		
		// Combobox tim kiem theo loai san pham
		cbLoaiSP = new JComboBox();
//		cbLoaiSP.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				timKiemSP();
//			}
//		});
		cbLoaiSP.setModel(new DefaultComboBoxModel(new String[] {"", "Bút viết", "Tài liệu", "Tập giấy", "Văn phòng phẩm"}));
		cbLoaiSP.setBounds(76, 11, 109, 21);
		panelTimKiem.add(cbLoaiSP);
		
		// Combobox tim kiem theo ma sp, ten sp, ma ncc, ten ncc
		cbTimKiem = new JComboBox();
//		cbTimKiem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				timKiemSP();
//			}
//		});
		cbTimKiem.setBounds(195, 10, 113, 21);
		cbTimKiem.setModel(new DefaultComboBoxModel(new String[] {"", "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Tên nhà cung cấp"}));
		panelTimKiem.add(cbTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemSP();
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.setBounds(358, 40, 92, 23);
		panelTimKiem.add(btnTimKiem);
		
		JButton btnHuyTimKiem = new JButton("Hủy");
		btnHuyTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
			}
		});
		btnHuyTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHuyTimKiem.setBounds(470, 40, 92, 23);
		panelTimKiem.add(btnHuyTimKiem);
		
		JPanel panelThucHien = new JPanel();
		panelThucHien.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThucHien.setBounds(618, 245, 123, 75);
		add(panelThucHien);
		panelThucHien.setLayout(null);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setEnabled(false);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXacNhan.setBounds(10, 10, 103, 23);
		panelThucHien.add(btnXacNhan);
		
		// Button huy
		btnHuy = new JButton("Hủy");
		btnHuy.setEnabled(false);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
				tableSanPham.setEnabled(true);
				isEnable(false);
				btnXacNhan.setEnabled(false);
				btnHuy.setEnabled(false);
				confirmMode = "";
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHuy.setBounds(10, 43, 103, 23);
		panelThucHien.add(btnHuy);
		
		JButton btnLoaiSP = new JButton("Loại sản phẩm");
		btnLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quanLyLoaiSP();
			}
		});
		btnLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoaiSP.setBounds(789, 13, 134, 29);
		add(btnLoaiSP);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
	}
	
	//------------------------------CHUC NANG----------------------------//
	
	//Hien thi danh sach san pham
	private void hienThiDanhSachSP(ArrayList<SanPham> dssp) {
		tableModel.setRowCount(0);
		danhSachSP = dssp;
		for(SanPham sp : danhSachSP){
			String[] sanPham = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getChatLieu(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(),sp.getNhaCC().getMaNhaCC(),sp.getNhaCC().getTenNhaCC(),sp.getGiaNhap()+"",sp.getGiaBan()+"",sp.getSoLuong()+""};
			tableModel.addRow(sanPham);
		}
	}
	
	//Tim kiem san pham
	private void timKiemSP() {
		String loaiSP = "";
		int loaiTimKiem = 0;
		String loaiGia = "";
		String timKiem = "";
		double giaMin = 0;
		double giaMax = 0;
		
		ArrayList<Integer> itemIndexes = new ArrayList<Integer>();
		
		try {
			if(!tfTimKiem.getText().trim().equals("")) {
				timKiem = tfTimKiem.getText().toString();
			}
			
			if(!cbLoaiSP.getSelectedItem().toString().equals("")) {
				loaiSP = cbLoaiSP.getSelectedItem().toString();
				itemIndexes.add(1); 
			}
			if(! cbTimKiem.getSelectedItem().toString().equals("")) {
				loaiTimKiem = cbTimKiem.getSelectedIndex();
				itemIndexes.add(2);
			}
			if (! cbGia.getSelectedItem().toString().equals("")) {
				loaiGia = cbGia.getSelectedItem().toString();
				if(! (tfGiaMin.getText().trim().equals("") && tfGiaMax.getText().trim().equals(""))) {
					try {
						giaMin = Double.parseDouble(tfGiaMin.getText().trim());
						giaMax = Double.parseDouble(tfGiaMax.getText().trim());
						itemIndexes.add(3);
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Giá nhập hoặc giá bán không hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			danhSachSP = BLL.SanPhamBLL.layDanhSachSP();
			
			tableModel.setRowCount(0);
			
			for (SanPham sp : danhSachSP) {
				boolean check = true;
				for(int i : itemIndexes) {
					switch(i) {
					case 1:
						if(!loaiSP.equals(sp.getLoaiSanPham().getTenLoaiSanPham())) check = false;
						break;
					case 2:
						switch(loaiTimKiem) {
							case 1:
//								System.out.println(sp.getMaSanPham() + timKiem.toUpperCase());
								if(! sp.getMaSanPham().toUpperCase().contains(timKiem.toUpperCase())) check = false;
								break;
							case 2:
								if(! sp.getTenSanPham().toUpperCase().contains(timKiem.toUpperCase())) check = false;
								break;
							case 3:
								if(! sp.getNhaCC().getMaNhaCC().toUpperCase().contains(timKiem.toUpperCase())) check = false;
								break;
							case 4:
								if(! sp.getNhaCC().getTenNhaCC().toUpperCase().contains(timKiem.toUpperCase())) check = false;
								break;
							default:
								break;
						}
						break;
					case 3:
						if(loaiGia.equals("Giá nhập")) {
							if(!(giaMin <= sp.getGiaNhap() && sp.getGiaNhap() <= giaMax)) check = false;
						} else if(loaiGia.equals("Giá bán")) {
							if(!(giaMin <= sp.getGiaBan() && sp.getGiaBan() <= giaMax)) check = false;
						} 
						break;
					default:
						break;
					}
				}
				if (check) {
					String[] sanPham = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getChatLieu(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(),sp.getNhaCC().getMaNhaCC(),sp.getNhaCC().getTenNhaCC(),sp.getGiaNhap()+"",sp.getGiaBan()+"",sp.getSoLuong()+""};
					tableModel.addRow(sanPham);
				}
			}
		}
		catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	
	//Dieu chinh de them san pham
	private void themSanPham() {
		isEnable(true);
		tableSanPham.setEnabled(false);
		refresh();
		confirmMode = "Them";
	}
	
	// Dieu chinh de xoa san pham
	private void xoaSanPham() {
		isEnable(false);
		tableSanPham.setEnabled(true);
		confirmMode = "Xoa";
	}
	
	// Dieu chinh de sua san pham
	private void suaSanPham() {
		isEnable(true);
		tableSanPham.setEnabled(true);
		confirmMode = "Sua";
	}	
	
	// Them va sua san pham code tuong tu
	private SanPham themVaSua() {
		String maSP = tfMaSP.getText();
		String tenSP = tfTenSP.getText();
		String chatLieu = tfChatLieu.getText();
		String maLoaiSP = (String) cbMaLoaiSP.getSelectedItem();
		String tenLoaiSP = tfTenLoaiSP.getText();
		String maNCC = (String) cbMaNCC.getSelectedItem();
		String tenNCC = tfTenNCC.getText();
		double giaNhap = Double.parseDouble(tfGiaNhap.getText().toString());
		double giaBan = Double.parseDouble(tfGiaBan.getText().toString());
		int soLuong = 0;
		byte[] anhSanPham = anhFile;
		String fp = filePath; 
		LoaiSanPham loaiSP = new LoaiSanPham(maLoaiSP,tenLoaiSP);
		NhaCungCap nhaCC = new NhaCungCap();
		nhaCC.setMaNhaCC(maNCC);nhaCC.setTenNhaCC(tenNCC);
		SanPham sanPham = new SanPham(maSP, tenSP, chatLieu, loaiSP ,nhaCC,giaNhap,giaBan,soLuong,anhSanPham,fp);
		return sanPham;
	}
	
	// Xac nhan
	private void xacNhan() {
		if(kiemTraThongTinSP()) {
			if(confirmMode == "Them" ) {
				try {
					SanPham sanPham = themVaSua();
					sanPham.setMaSanPham(taoMaSanPham());
					int c = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.SanPhamBLL.themSanPham(sanPham)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "Thêm không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			else if(confirmMode == "Xoa") {
				try {
					int i = tableSanPham.getSelectedRow();
					if(i>=0) {
						int c = JOptionPane.showConfirmDialog(null, "Xác nhận xóa sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
						if(c == 0 && BLL.SanPhamBLL.xoaSanPham(danhSachSP.get(i))) {
							JOptionPane.showMessageDialog(new SanPhamGUI(), "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else JOptionPane.showMessageDialog(new SanPhamGUI(), "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
			else if(confirmMode == "Sua") {
				try {
					SanPham sanPham = themVaSua();
					sanPham.setSoLuong(Integer.parseInt(tfSoLuong.getText()));
					int c = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.SanPhamBLL.suaSanPham(sanPham)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "Sửa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			refresh();
			hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
		} 
	}
	
	private boolean kiemTraThongTinSP() {
		if(tfTenSP.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên sản phẩm không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if(cbMaLoaiSP.getSelectedItem().equals(null)){
			JOptionPane.showMessageDialog(null, "Mã loại sản phẩm chưa chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if(cbMaNCC.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(null, "Mã nhà cung cấp chưa chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if(!tfGiaNhap.getText().equals("") && !tfGiaBan.getText().equals("")) {
			if(!(tfGiaNhap.getText().matches("[0-9].+") && tfGiaBan.getText().matches("[0-9].+"))) {
				JOptionPane.showMessageDialog(null, "Giá tiền không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else {
				return true;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	// Xoa thong tin trong textfield
	private void refresh() {
		tfMaSP.setText("");
		tfTenSP.setText("");
		tfTenLoaiSP.setText("");
		tfChatLieu.setText("");
		tfTenNCC.setText("");
		tfGiaNhap.setText("");
		tfGiaBan.setText("");
		tfSoLuong.setText("");
		lblAnhSP.setIcon(null);
	}
	
	// enable cho textfield 
	private void isEnable(boolean i) {
		btnXacNhan.setEnabled(true);
		btnHuy.setEnabled(true);
		btnThemAnh.setEnabled(i);
		tfTenSP.setEditable(i);
		cbMaLoaiSP.setEnabled(i);
		tfChatLieu.setEditable(i);
		cbMaNCC.setEnabled(i);
		tfGiaNhap.setEditable(i);
		tfGiaBan.setEditable(i);
	}
	
	private void lamMoi() {
		hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
		danhSachNCC = BLL.NhaCungCapBLL.layDanhSachNhaCC();
		danhSachLSP = BLL.LoaiSanPhamBLL.layDanhSachLoaiSP();
		
		Vector<String> sLoaiSP = new Vector<String>();
		sLoaiSP.add("");
		for(int i = 0; i < danhSachLSP.size(); i++) {
			sLoaiSP.add(danhSachLSP.get(i).getMaLoaiSanPham());
		}
		cbMaLoaiSP.setModel(new DefaultComboBoxModel(sLoaiSP));
		
		Vector<String> sMaNCC = new Vector<String>();
		sMaNCC.add("");
		for(int i = 0; i < danhSachNCC.size(); i++) {
			sMaNCC.add(danhSachNCC.get(i).getMaNhaCC());
		}
		cbMaNCC.setModel(new DefaultComboBoxModel(sMaNCC));
	}
	
	private void chonAnh() {
		try {
			JFileChooser fc = new JFileChooser("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\san_pham");
			fc.setDialogTitle("Chọn ảnh");
			fc.showOpenDialog(new SanPhamGUI());
			File file = fc.getSelectedFile();
			filePath = file.toString();
			if(filePath != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH));
				lblAnhSP.setIcon(imageIcon);
				FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int readNum;
				while((readNum = fis.read(buf)) != -1) {
					bos.write(buf, 0, readNum);
				}
				anhFile = bos.toByteArray();
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void quanLyLoaiSP() {
		if(!lspgui.isVisible()) lspgui.setVisible(true);
	}
	
	private void chonSanPham() {
		int i = tableSanPham.getSelectedRow();
		if(i >= 0) {
			try {
				tfMaSP.setText(danhSachSP.get(i).getMaSanPham());
				tfTenSP.setText(danhSachSP.get(i).getTenSanPham());
				tfChatLieu.setText(danhSachSP.get(i).getChatLieu());
				cbMaLoaiSP.setSelectedItem(danhSachSP.get(i).getLoaiSanPham().getMaLoaiSanPham());
				tfTenLoaiSP.setText(danhSachSP.get(i).getLoaiSanPham().getTenLoaiSanPham());
				cbMaNCC.setSelectedItem(danhSachSP.get(i).getNhaCC().getMaNhaCC());
				tfTenNCC.setText(danhSachSP.get(i).getNhaCC().getTenNhaCC());
				tfGiaNhap.setText(danhSachSP.get(i).getGiaNhap()+ "");
				tfGiaBan.setText(danhSachSP.get(i).getGiaBan()+ "");
				tfSoLuong.setText(danhSachSP.get(i).getSoLuong() + "");
				if(danhSachSP.get(i).getAnhSanPham()!=null) {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(danhSachSP.get(i).getAnhSanPham()).getImage().getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH));
					lblAnhSP.setIcon(imageIcon);
				}
				else lblAnhSP.setIcon(null);
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
	
	private String taoMaSanPham() {
		int i = BLL.SanPhamBLL.laySoLuongSanPham();
		return "SP" + (i+1);
	}
	
	// Khóa textfield để tránh sửa đổi
	private void enableTextField(boolean i) {
		tfTenSP.setEnabled(i);
		tfChatLieu.setEnabled(i);
		cbMaLoaiSP.setEnabled(i);
		cbMaNCC.setEnabled(i);
		tfGiaNhap.setEnabled(i);
		tfGiaBan.setEnabled(i);
	}
}
