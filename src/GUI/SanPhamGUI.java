package GUI;

import DTO.LoaiSanPham;
import DTO.SanPham;
import DTO.NhaCungCap;
import DTO.NhanVien;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

import java.math.*;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.DropMode;

public class SanPhamGUI extends JPanel {
	JComboBox cbMaNCC = new JComboBox();
	JComboBox cbMaLoaiSP = new JComboBox();
	JComboBox cbGia = new JComboBox();
	JComboBox cbLoaiSP = new JComboBox();
	JComboBox cbTimKiem = new JComboBox();
	JButton btnXacNhan;
	JButton btnHuy;
	JButton btnThemAnh;
	
	JLabel lblAnhSP = new JLabel("");
	
	private ArrayList<SanPham> danhSachSanPham = BLL.SanPhamBLL.layDanhSachSP();
	private ArrayList<NhaCungCap> danhSachNhaCC = BLL.NhaCungCapBLL.layDanhSachNhaCC();
	private ArrayList<LoaiSanPham> danhSachLoaiSP = BLL.LoaiSanPhamBLL.layDanhSachLoaiSP();
	
	private JTextField tfMaSP;
	private JTextField tfTenSP;
	private JTextField tfGiaNhap;
	private JTextField tfGiaBan;
	private JTextField tfSoLuong;
	private JTextField tfTenNCC;
	private JTable tableSanPham;
	private JTextField tfTimKiem;
	private JTextField tfTu;
	private JTextField tfDen;
	private JTextField tfTenLoaiSP;
	private byte[] anhFile;
	private JTextField tfChatLieu;
	private DefaultTableModel tableModel;
	
	String confirmMode = "";

	/**
	 * Create the panel.
	 */
	public SanPhamGUI() {
		setSize(new Dimension(880, 585));
		setLayout(null);
		
		JLabel lblQuanLy = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblQuanLy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLy.setBounds(103, 10, 598, 28);
		add(lblQuanLy);
		
		JPanel panelThongTinSP = new JPanel();
		panelThongTinSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTinSP.setBounds(10, 48, 712, 194);
		add(panelThongTinSP);
		panelThongTinSP.setLayout(null);
		
		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setBounds(199, 31, 98, 19);
		panelThongTinSP.add(lblMaSanPham);
		lblMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
		lblTenSanPham.setBounds(199, 60, 98, 19);
		panelThongTinSP.add(lblTenSanPham);
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGiaNhap = new JLabel("Giá nhập");
		lblGiaNhap.setBounds(461, 90, 86, 19);
		panelThongTinSP.add(lblGiaNhap);
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGiaBan = new JLabel("Giá bán");
		lblGiaBan.setBounds(461, 119, 86, 19);
		panelThongTinSP.add(lblGiaBan);
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSoLuongTon = new JLabel("Số lượng tồn");
		lblSoLuongTon.setBounds(461, 148, 86, 19);
		panelThongTinSP.add(lblSoLuongTon);
		lblSoLuongTon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblMaNhaCungCap = new JLabel("Mã nhà cung cấp");
		lblMaNhaCungCap.setBounds(461, 32, 98, 19);
		panelThongTinSP.add(lblMaNhaCungCap);
		
		
		lblMaNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMaNCC.setEditable(true);
		cbMaNCC.setEnabled(false);
		cbMaNCC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(NhaCungCap ncc: danhSachNhaCC) {
				if(ncc.getMaNhaCC().equals(cbMaNCC.getSelectedItem().toString())) {
					tfTenNCC.setText(ncc.getTenNhaCC());
					break;
				}
			}
		}});
		
		cbMaNCC.setBounds(570, 31, 132, 21);
		Vector<String> sMaNCC = new Vector<String>();
		sMaNCC.add("");
		for(int i = 0; i < danhSachNhaCC.size(); i++) {
			sMaNCC.add(danhSachNhaCC.get(i).getMaNhaCC());
		}
		cbMaNCC.setModel(new DefaultComboBoxModel(sMaNCC));
		panelThongTinSP.add(cbMaNCC);
		
		tfMaSP = new JTextField();
		tfMaSP.setEditable(false);
		tfMaSP.setBounds(307, 32, 132, 19);
		panelThongTinSP.add(tfMaSP);
		tfMaSP.setColumns(10);
		
		tfTenSP = new JTextField();
		tfTenSP.setEditable(false);
		tfTenSP.setBounds(307, 61, 132, 19);
		panelThongTinSP.add(tfTenSP);
		tfTenSP.setColumns(10);
		
		tfGiaNhap = new JTextField();
		tfGiaNhap.setEditable(false);
		tfGiaNhap.setBounds(570, 90, 132, 19);
		panelThongTinSP.add(tfGiaNhap);
		tfGiaNhap.setColumns(10);
		
		tfGiaBan = new JTextField();
		tfGiaBan.setEditable(false);
		tfGiaBan.setBounds(570, 119, 132, 19);
		panelThongTinSP.add(tfGiaBan);
		tfGiaBan.setColumns(10);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setEditable(false);
		tfSoLuong.setBounds(570, 148, 132, 19);
		panelThongTinSP.add(tfSoLuong);
		tfSoLuong.setColumns(10);
		
		JLabel lblTenNhaCungCap = new JLabel("Tên nhà cung cấp");
		lblTenNhaCungCap.setBounds(461, 61, 99, 19);
		panelThongTinSP.add(lblTenNhaCungCap);
		lblTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		// Textfiel ten nha cc
		tfTenNCC = new JTextField();
		tfTenNCC.setOpaque(false);
		tfTenNCC.setHorizontalAlignment(SwingConstants.LEFT);
		tfTenNCC.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfTenNCC.setEditable(false);
		tfTenNCC.setBounds(570, 61, 132, 19);
		panelThongTinSP.add(tfTenNCC);
		tfTenNCC.setColumns(10);
		
		JLabel lblMaLoaiSP = new JLabel("Mã loại sản phẩm");
		lblMaLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaLoaiSP.setBounds(199, 90, 98, 19);
		panelThongTinSP.add(lblMaLoaiSP);
		
		JLabel lblTenLoaiSP = new JLabel("Tên loại sản phẩm");
		lblTenLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenLoaiSP.setBounds(199, 118, 104, 19);
		panelThongTinSP.add(lblTenLoaiSP);
		
		tfTenLoaiSP = new JTextField();
		tfTenLoaiSP.setEditable(false);
		tfTenLoaiSP.setColumns(10);
		tfTenLoaiSP.setBounds(307, 119, 132, 19);
		panelThongTinSP.add(tfTenLoaiSP);
		cbMaLoaiSP.setEditable(true);
		cbMaLoaiSP.setEnabled(false);
		
		//CB ma loai sp
		cbMaLoaiSP.setBounds(307, 90, 132, 21);
		Vector<String> sLoaiSP = new Vector<String>();
		sLoaiSP.add("");
		for(int i = 0; i < danhSachLoaiSP.size(); i++) {
			sLoaiSP.add(danhSachLoaiSP.get(i).getMaLoaiSanPham());
		}
		cbMaLoaiSP.setModel(new DefaultComboBoxModel(sLoaiSP));
		cbMaLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(LoaiSanPham lsp : danhSachLoaiSP) {
					if(lsp.getMaLoaiSanPham().equals(cbMaLoaiSP.getSelectedItem())) {
						tfTenLoaiSP.setText(lsp.getTenLoaiSanPham());
						break;
					}
				}
			}
		});
		panelThongTinSP.add(cbMaLoaiSP);
		lblAnhSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblAnhSP.setBounds(10, 20, 162, 132);
		panelThongTinSP.add(lblAnhSP);
		
		JPanel panelDanhSachSP = new JPanel();
		panelDanhSachSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSachSP.setBounds(10, 330, 856, 243);
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
		btnThemAnh.setBounds(37, 163, 104, 21);
		panelThongTinSP.add(btnThemAnh);
		
		JLabel lblChatLieu = new JLabel("Chất liệu");
		lblChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChatLieu.setBounds(199, 148, 104, 19);
		panelThongTinSP.add(lblChatLieu);
		
		tfChatLieu = new JTextField();
		tfChatLieu.setEditable(false);
		tfChatLieu.setColumns(10);
		tfChatLieu.setBounds(307, 149, 132, 19);
		panelThongTinSP.add(tfChatLieu);
		
		// Panel chuc nang
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c  n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChucNang.setBounds(732, 48, 134, 272);
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
		
		// Panel tim kiem
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimKiem.setBounds(10, 245, 534, 75);
		add(panelTimKiem);
		panelTimKiem.setLayout(null);
		
		//Label tim kiem
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setBounds(10, 10, 69, 19);
		panelTimKiem.add(lblTimKiem);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Textfield tim kiem tu chon
		tfTimKiem = new JTextField();
		tfTimKiem.getDocument().addDocumentListener((new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemSP();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemSP();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemSP();	
			}
		}));
		tfTimKiem.setBounds(318, 11, 206, 19);
		panelTimKiem.add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setBounds(20, 39, 27, 19);
		panelTimKiem.add(lblLoc);
		lblLoc.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemSP();
			}
		});
		
		cbGia.setBounds(57, 39, 84, 21);
		panelTimKiem.add(cbGia);
		cbGia.setModel(new DefaultComboBoxModel(new String[] {"", "Giá nhập", "Giá bán"}));
		
		tfTu = new JTextField();
		tfTu.getDocument().addDocumentListener((new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemSP();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemSP();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemSP();	
			}
		}));
		tfTu.setBounds(151, 42, 105, 19);
		panelTimKiem.add(tfTu);
		tfTu.setColumns(10);
		
		tfDen = new JTextField();
		tfDen.getDocument().addDocumentListener((new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemSP();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemSP();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemSP();	
			}
		}));
		tfDen.setBounds(280, 41, 105, 19);
		panelTimKiem.add(tfDen);
		tfDen.setColumns(10);
		
		JLabel lblDauNgang = new JLabel("-");
		lblDauNgang.setEnabled(false);
		lblDauNgang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDauNgang.setBounds(266, 43, 9, 13);
		panelTimKiem.add(lblDauNgang);
		
		// Combobox tim kiem theo loai san pham
		cbLoaiSP = new JComboBox();
		cbLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemSP();
			}
		});
		cbLoaiSP.setModel(new DefaultComboBoxModel(new String[] {"", "Bút viết", "Tài liệu", "Tập giấy", "Văn phòng phẩm"}));
		cbLoaiSP.setBounds(76, 11, 109, 21);
		panelTimKiem.add(cbLoaiSP);
		
		// Combobox tim kiem theo ma sp, ten sp, ma ncc, ten ncc
		cbTimKiem = new JComboBox();
		cbTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemSP();
			}
		});
		cbTimKiem.setBounds(195, 10, 113, 21);
		cbTimKiem.setModel(new DefaultComboBoxModel(new String[] {"", "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Tên nhà cung cấp"}));
		panelTimKiem.add(cbTimKiem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(599, 245, 123, 75);
		add(panel_1);
		panel_1.setLayout(null);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setEnabled(false);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXacNhan.setBounds(10, 10, 103, 23);
		panel_1.add(btnXacNhan);
		
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
		panel_1.add(btnHuy);
		
		JButton btnLoaiSP = new JButton("Loại sản phẩm");
		btnLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quanLyLoaiSP();
			}
		});
		btnLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoaiSP.setBounds(732, 10, 134, 29);
		add(btnLoaiSP);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		hienThiDanhSachSP(danhSachSanPham);
	}
	
	//------------------------------CHUC NANG----------------------------//
	
	//Hien thi danh sach san pham
	private void hienThiDanhSachSP(ArrayList<SanPham> danhSachSanPham) {
		tableModel.setRowCount(0);
		for(SanPham sp : danhSachSanPham){
			String[] sanPham = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getChatLieu(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(),sp.getNhaCC().getMaNhaCC(),sp.getNhaCC().getTenNhaCC(),sp.getGiaNhap()+"",sp.getGiaBan()+"",sp.getSoLuong()+""};
			tableModel.addRow(sanPham);
		}
	}
	
	//Tim kiem san pham
	private void timKiemSP() {
		try {
			ArrayList<SanPham> danhSachSanPham1 = new ArrayList<SanPham>();
			ArrayList<SanPham> danhSachSanPham2 = null;
//			ArrayList<SanPham> danhSachSanPham3 = null;
			
			// cbLoaiSP
			String loaiSP = cbLoaiSP.getSelectedItem() + "";
			if(!loaiSP.equals("")) {
				tableModel.setRowCount(0);
				for(SanPham sp : danhSachSanPham) {
					if(loaiSP.equals(sp.getLoaiSanPham().getTenLoaiSanPham())) {
						String[] sanPham = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getChatLieu(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(),sp.getNhaCC().getMaNhaCC(),sp.getNhaCC().getTenNhaCC(),sp.getGiaNhap()+"",sp.getGiaBan()+"",sp.getSoLuong()+""};
						tableModel.addRow(sanPham);
						danhSachSanPham1.add(sp);
					}
				}
			}
			
			// cbTimKiem
			int loaiTimKiem = cbTimKiem.getSelectedIndex();
			String timKiem = tfTimKiem.getText().toLowerCase();
			if(loaiTimKiem != 0) {
				if(!loaiSP.equals("")) {
					danhSachSanPham2 = danhSachSanPham1;
				}
				else {
					danhSachSanPham2 = BLL.SanPhamBLL.layDanhSachSP();
				}
				tableModel.setRowCount(0);
				for(SanPham sp : danhSachSanPham2) {
					boolean check = false;
					if(loaiTimKiem == 1 && sp.getMaSanPham().toLowerCase().contains(timKiem)) check = true;
					else if(loaiTimKiem == 2 && sp.getTenSanPham().toLowerCase().contains(timKiem)) check = true;
					else if(loaiTimKiem == 3 && sp.getNhaCC().getMaNhaCC().toLowerCase().contains(timKiem)) check = true;
					else if(loaiTimKiem == 4 && sp.getNhaCC().getTenNhaCC().toLowerCase().contains(timKiem)) check = true;
					if(check == true) {
						String[] sanPham = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getChatLieu(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(),sp.getNhaCC().getMaNhaCC(),sp.getNhaCC().getTenNhaCC(),sp.getGiaNhap()+"",sp.getGiaBan()+"",sp.getSoLuong()+""};
						tableModel.addRow(sanPham);
					}
				}
				if(tfTimKiem.getText().equals("")) {
					hienThiDanhSachSP(danhSachSanPham2);
				}
			}
			
//			int loaiGiaSP = cbGia.getSelectedIndex();
//			if(loaiGiaSP != 0 && !tfTu.getText().toString().equals("") && !tfDen.getText().toString().equals("")) {
//				if(!loaiSP.equals("")) danhSachSanPham3 = danhSachSanPham1;
//				else if(loaiTimKiem != 0) danhSachSanPham3 = danhSachSanPham2;
//				else danhSachSanPham3 = danhSachSanPham;
//				tableModel.setRowCount(0);
//				double giaDau = Double.parseDouble(tfTu.getText());
//				double giaCuoi = Double.parseDouble(tfDen.getText());
//				for(SanPham sp : danhSachSanPham3) {
//					boolean check = false;
//					if(loaiGiaSP == 1 && sp.getGiaNhap() >= giaDau && sp.getGiaNhap() <= giaCuoi) check = true;
//					else if(loaiGiaSP == 2 && sp.getGiaBan() >= giaDau && sp.getGiaBan() <= giaCuoi) check = true;
//					if(check == true) {
//						String[] sanPham = {sp.getMaSanPham(),sp.getTenSanPham(),sp.getChatLieu(),sp.getLoaiSanPham().getMaLoaiSanPham(),sp.getLoaiSanPham().getTenLoaiSanPham(),sp.getNhaCC().getMaNhaCC(),sp.getNhaCC().getTenNhaCC(),sp.getGiaNhap()+"",sp.getGiaBan()+"",sp.getSoLuong()+""};
//						tableModel.addRow(sanPham);
//					}
//				}
//				
//			}
		}
		catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		
		
//		if(tfTimKiem.getText().equals("")) {
//			hienThiDanhSachSP(danhSachSanPham);
//		}
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
		LoaiSanPham loaiSP = new LoaiSanPham(maLoaiSP,tenLoaiSP);
		NhaCungCap nhaCC = new NhaCungCap();
		nhaCC.setMaNhaCC(maNCC);nhaCC.setTenNhaCC(tenNCC);
		SanPham sanPham = new SanPham(maSP, tenSP, chatLieu, loaiSP ,nhaCC,giaNhap,giaBan,soLuong,anhSanPham);
		return sanPham;
	}
	
	// Xac nhan
	private void xacNhan() {
		if(confirmMode == "Them") {
			try {
				SanPham sanPham = themVaSua();
				sanPham.setMaSanPham(taoMaSanPham());
				int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận thêm sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(c == 0 && BLL.SanPhamBLL.themSanPham(sanPham)) {
					JOptionPane.showMessageDialog(new GiaoDienGUI(), "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else JOptionPane.showMessageDialog(new GiaoDienGUI(), "Thêm không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if(confirmMode == "Xoa") {
			try {
				int i = tableSanPham.getSelectedRow();
				if(i>=0) {
					int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận xóa sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.SanPhamBLL.xoaSanPham(danhSachSanPham.get(i))) {
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
				int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận sửa sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(c == 0 && BLL.SanPhamBLL.suaSanPham(sanPham)) {
					JOptionPane.showMessageDialog(new GiaoDienGUI(), "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else JOptionPane.showMessageDialog(new GiaoDienGUI(), "Sửa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		refresh();
		hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
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
	
	private void chonAnh() {
		try {
			JFileChooser fc = new JFileChooser("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\san_pham");
			fc.setDialogTitle("Chọn ảnh");
			fc.showOpenDialog(new SanPhamGUI());
			File file = fc.getSelectedFile();
			String filePath = file.getAbsolutePath();
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
	}
	
	private void chonSanPham() {
		int i = tableSanPham.getSelectedRow();
		if(i >= 0) {
			try {
				tfMaSP.setText(tableModel.getValueAt(i, 0)+"");
				tfTenSP.setText(tableModel.getValueAt(i, 1)+"");
				tfChatLieu.setText(tableModel.getValueAt(i, 2)+"");
				cbMaLoaiSP.setSelectedItem(tableModel.getValueAt(i, 3)+"");
				tfTenLoaiSP.setText(tableModel.getValueAt(i, 4)+"");
				cbMaNCC.setSelectedItem(tableModel.getValueAt(i, 5)+"");
				tfTenNCC.setText(tableModel.getValueAt(i, 6)+"");
				tfGiaNhap.setText(tableModel.getValueAt(i, 7)+"");
				tfGiaBan.setText(tableModel.getValueAt(i, 8)+"");
				tfSoLuong.setText(tableModel.getValueAt(i, 9)+"");
				if(danhSachSanPham.get(i).getAnhSanPham()!=null) {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(danhSachSanPham.get(i).getAnhSanPham()).getImage().getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH));
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
