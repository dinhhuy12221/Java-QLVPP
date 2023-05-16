package GUI;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import DTO.ChucVu;
import DTO.NhanVien;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

public class NhanVienGUI extends JPanel {
	private JTextField tfTenNV;
	private JTextField tfMaNV;
	private JTextField tfLuong;
	private JTextField tfSoDT;
	private JTextField tfTimKiem;
	private JTextField tfDiaChi;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	JLabel lblAnhNV_1 = new JLabel("");
	
	private JButton btnThemAnh;
	private JButton btnXcNhn;
	private JButton btnHy;
	
	private String anhFilePath="";
	
	private JComboBox cbMACHUCVU1 ;
	private JComboBox cbTimKiem;
	private JComboBox cbChucVu = new JComboBox();;

	String confirmMode = "";
	
	JDateChooser dcNgaySinh;
	
	

	/**
	 * Create the panel.
	 */
	private ArrayList<NhanVien> danhSachNhanVien = BLL.NhanVienBLL.layDanhSachNV();
	private ArrayList<ChucVu> danhSachLoaiCV = BLL.ChucVuBLL.layDanhSachLoaiCV();


	public NhanVienGUI() {
		setBackground(new Color(240, 240, 240));
		setSize(1269,679);
		setLayout(null);
		
		JPanel panelThongTinNV = new JPanel();
		panelThongTinNV.setLayout(null);
		panelThongTinNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Nhân Viên", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTinNV.setBounds(0, 30, 625, 292);
		add(panelThongTinNV);
		
		JLabel lbltenhanvien = new JLabel("Tên Nhân Viên");
		lbltenhanvien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltenhanvien.setBounds(263, 32, 98, 19);
		panelThongTinNV.add(lbltenhanvien);
		
		JLabel lblMaNhanVien = new JLabel("Mã Số Nhân Viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaNhanVien.setBounds(263, 61, 98, 19);
		panelThongTinNV.add(lblMaNhanVien);
		
		JLabel lbChucVu = new JLabel("Chức Vụ ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbChucVu.setBounds(263, 180, 98, 19);
		panelThongTinNV.add(lbChucVu);
		
		cbChucVu.setEnabled(false);
		cbChucVu.setBounds(372, 179, 226, 21);
		AutoCompleteDecorator.decorate(cbChucVu);
		panelThongTinNV.add(cbChucVu);
//		cbMaChucVu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for(ChucVu lcv : danhSachLoaiCV) {
//					if(lcv.getMaChucVu().equals(cbMaChucVu.getSelectedItem())) {
//						textFieldTenLoaiCV.setText(lcv.getTenChucVu());
//						break;
//					}
//				}
//			}
//		});
//	
		
		tfTenNV = new JTextField();
		tfTenNV.setEditable(false);
		tfTenNV.setColumns(10);
		tfTenNV.setBounds(371, 33, 227, 19);
		panelThongTinNV.add(tfTenNV);
		
		tfMaNV = new JTextField();
		tfMaNV.setEditable(false);
		tfMaNV.setColumns(10);
		tfMaNV.setBounds(371, 62, 227, 19);
		panelThongTinNV.add(tfMaNV);
		
		JLabel lblTenNhaCungCap = new JLabel("Lương");
		lblTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenNhaCungCap.setBounds(263, 210, 99, 19);
		panelThongTinNV.add(lblTenNhaCungCap);
		
		tfLuong = new JTextField();
		tfLuong.setOpaque(false);
		tfLuong.setHorizontalAlignment(SwingConstants.LEFT);
		tfLuong.setEditable(false);
		tfLuong.setColumns(10);
		tfLuong.setAlignmentX(0.0f);
		tfLuong.setBounds(372, 210, 226, 19);
		panelThongTinNV.add(tfLuong);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiaChi.setBounds(263, 91, 98, 19);
		panelThongTinNV.add(lblDiaChi);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT.setBounds(263, 119, 104, 19);
		panelThongTinNV.add(lblSDT);
		
		tfSoDT = new JTextField();
		tfSoDT.setEditable(false);
		tfSoDT.setColumns(10);
		tfSoDT.setBounds(371, 120, 227, 19);
		panelThongTinNV.add(tfSoDT);
		
		
		lblAnhNV_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAnhNV_1.setBounds(26, 33, 200, 216);
		panelThongTinNV.add(lblAnhNV_1);
		
		btnThemAnh = new JButton("Thêm Ảnh");
		btnThemAnh.setEnabled(false);
		btnThemAnh.setBounds(61, 260, 104, 21);
		panelThongTinNV.add(btnThemAnh);
		btnThemAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonAnh();
			}
		});
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgaySinh.setBounds(263, 149, 104, 19);
		panelThongTinNV.add(lblNgaySinh);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setEditable(false);
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(371, 91, 227, 19);
		panelThongTinNV.add(tfDiaChi);
		
		dcNgaySinh = new JDateChooser();
		dcNgaySinh.setDateFormatString("dd-MM-yyyy");
		dcNgaySinh.setEnabled(false);
		dcNgaySinh.setBounds(371, 149, 227, 19);
		dcNgaySinh.setMaxSelectableDate(Calendar.getInstance().getTime());
		panelThongTinNV.add(dcNgaySinh);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c  n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChucNang.setBounds(692, 30, 134, 272);
		add(panelChucNang);
		panelChucNang.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setIcon(new ImageIcon("image/icon/plus.png"));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnThm);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNV();
			}
		});
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon("image/icon/bin.png"));
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnXa);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNV();
			}
		});
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon("image/icon/edit.png"));
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnSa);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNV();
			}
		});
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setLayout(null);
		panelTimKiem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimKiem.setBounds(10, 333, 615, 44);
		add(panelTimKiem);
		
		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmKim.setBounds(10, 10, 69, 19);
		panelTimKiem.add(lblTmKim);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setColumns(10);
		tfTimKiem.setBounds(318, 11, 287, 19);
		panelTimKiem.add(tfTimKiem);
		tfTimKiem.getDocument().addDocumentListener((new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemNV();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemNV();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemNV();	
			}
		}));
		
		cbMACHUCVU1 = new JComboBox();
		cbMACHUCVU1.setBounds(76, 11, 109, 21);
		panelTimKiem.add(cbMACHUCVU1);
		cbMACHUCVU1.addItem("");
		cbMACHUCVU1.addItem("Quản lý");
		cbMACHUCVU1.addItem("Bán hàng");
		cbMACHUCVU1.addItem("Thủ kho");
		cbMACHUCVU1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNV();
			}
		});
		
		cbTimKiem = new JComboBox();
		cbTimKiem.setBounds(195, 10, 113, 21);
		panelTimKiem.add(cbTimKiem);
		cbTimKiem.addItem("");
		cbTimKiem.addItem("Tên nhân viên");
		cbTimKiem.addItem("mã nhân viên");
		cbTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNV();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(692, 313, 134, 75);
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnXcNhn = new JButton("Xác Nhận");
		btnXcNhn.setIcon(new ImageIcon("image/icon/check-mark.png"));
		btnXcNhn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXcNhn.setEnabled(false);
		panel_1.add(btnXcNhn);
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		
		btnHy = new JButton("Hủy");
		btnHy.setIcon(new ImageIcon("image/icon/close.png"));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHy.setEnabled(false);
		panel_1.add(btnHy);
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				hienThiDanhSachNV(BLL.NhanVienBLL.layDanhSachNV());
				table.setEnabled(true);
				isEnable(false);
				btnXcNhn.setEnabled(false);
				btnHy.setEnabled(false);
				confirmMode = "";
			}
		});
		
		JPanel panelDanhSachSP = new JPanel();
		panelDanhSachSP.setBorder(new TitledBorder(null, "Danh Sách Nhân Viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSachSP.setBounds(10, 388, 1249, 280);
		add(panelDanhSachSP);
		panelDanhSachSP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		panelDanhSachSP.add(scrollPane);
		
		table = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setColumnHeaderView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonNhanVien();
			}
		});
		tableModel = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ" ,"Số Điện Thoại", "Ngày Sinh", "Chức vụ", "Lương"
				} 
			) {
			@Override 
			public boolean isCellEditable(int row,int height) {
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(30);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		loadChucVuVaoCB();
		hienThiDanhSachNV(danhSachNhanVien);
	}
	////chuc nang//////////////////////////////////////////////////////////
	private void hienThiDanhSachNV(ArrayList<NhanVien> dsnv) {
		tableModel.setRowCount(0);
		danhSachNhanVien = dsnv;
		for(NhanVien nv : danhSachNhanVien){
			String[] NhanVien = {nv.getMa(),nv.getHoTen(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.getChucVu().getTenChucVu(),nv.getLuong()+""};
			tableModel.addRow(NhanVien);
		}
	}
	
	private void loadChucVuVaoCB() {
		Vector<String> sLoaiCV = new Vector<String>();
		sLoaiCV.add("-Chức vụ-");
		for(int i = 0; i < danhSachLoaiCV.size(); i++) {
			sLoaiCV.add(danhSachLoaiCV.get(i).getTenChucVu());
		}
		cbChucVu.setModel(new DefaultComboBoxModel(sLoaiCV));
	}


	private void chonNhanVien() {
		int i = table.getSelectedRow();
		if(i >= 0) {
			try {
				tfTenNV.setText(danhSachNhanVien.get(i).getHoTen());
				tfMaNV.setText(danhSachNhanVien.get(i).getMa());
				tfDiaChi.setText(danhSachNhanVien.get(i).getDiaChi());
				tfSoDT.setText(danhSachNhanVien.get(i).getSoDienThoai());
				Date d = new SimpleDateFormat("dd-MM-yyyy").parse(danhSachNhanVien.get(i).getNgaySinh());
				dcNgaySinh.setDate(d);
				cbChucVu.setSelectedItem(danhSachNhanVien.get(i).getChucVu().getTenChucVu());
				tfLuong.setText(danhSachNhanVien.get(i).getLuong() + "");
				if(danhSachNhanVien.get(i).getAnhFilePath()!="") {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon("image/nhan_vien/" + danhSachNhanVien.get(i).getAnhFilePath()).getImage().getScaledInstance(lblAnhNV_1.getWidth(), lblAnhNV_1.getHeight(), Image.SCALE_SMOOTH));
					lblAnhNV_1.setIcon(imageIcon);
				}
				
				else {lblAnhNV_1.setIcon(null);}
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}	
	private void themNV() {
		isEnable(true);
		table.setEnabled(false);
		refresh();
		confirmMode = "Them";
	}
	
	// Dieu chinh de xoa san pham
	private void xoaNV() {
		isEnable(false);
		table.setEnabled(true);
		confirmMode = "Xoa";
	}
	
	// Dieu chinh de sua san pham
	private void suaNV() {
		isEnable(true);
		table.setEnabled(true);
		confirmMode = "Sua";
	}	
	private NhanVien themVaSua() {
		String maNV = tfMaNV.getText();
		String tenNV = tfTenNV.getText();
		String diachi = tfDiaChi.getText();
		String maCV = danhSachLoaiCV.get(cbChucVu.getSelectedIndex() - 1).getMaChucVu();
	//	String tenCV = textFieldTenLoaiCV.getText();
		String SDT = tfSoDT.getText();
		String ngaysinh = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if(dcNgaySinh.getDate() != null) {
			try {
				ngaysinh = sdf.format(dcNgaySinh.getDate());
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		double LUONG = Double.parseDouble(tfLuong.getText().toString().trim().equals("") ? "0" : tfLuong.getText().toString());
		ChucVu loaiCV= new ChucVu();
		loaiCV.setMaChucVu(maCV);
		NhanVien NhanVien = new NhanVien(maNV, tenNV, diachi, SDT ,ngaysinh,loaiCV,LUONG,anhFilePath);
		return NhanVien;
	}
	// Xoa thong tin trong textfield
	private void refresh() {
		tfMaNV.setText("");
		tfTenNV.setText("");
		tfDiaChi.setText("");
		tfSoDT.setText("");
		dcNgaySinh.setDate(null);;
		tfLuong.setText("");
		lblAnhNV_1.setIcon(null);
	}
	
	// enable cho textfield 
	private void isEnable(boolean i) {
		tfTenNV.setEditable(i);
		tfDiaChi.setEditable(i);
		tfSoDT.setEditable(i);
		dcNgaySinh.setEnabled(i);
		tfLuong.setEditable(i);
		btnThemAnh.setEnabled(i);
		btnHy.setEnabled(true);
		btnXcNhn.setEnabled(true);
		cbChucVu.setEnabled(i);
	}
	// Kiem tra thong tin
	private boolean kiemTraThongTinNV() {
		if(tfTenNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if(cbChucVu.getSelectedIndex() == 0 || cbChucVu.getSelectedItem().toString().trim().equals("")){
			JOptionPane.showMessageDialog(null, "Mã loại chức vụ chưa chọn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} return true;
	}
	
	// Xac nhan
	private void xacNhan() {
		if(kiemTraThongTinNV()) {
			if(confirmMode == "Them") {
				try {
					NhanVien nhanVien = themVaSua();
					int c = JOptionPane.showConfirmDialog(null, "Xác Nhận Thêm Nhân Viên", "Xác Nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.NhanVienBLL.themNhanVien(nhanVien)) {
						JOptionPane.showMessageDialog(null, "Thêm Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "Thêm Không Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			else if(confirmMode == "Xoa") {
				try {
					int i = table.getSelectedRow();
					if(i>=0) {
						int c = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa Nhân Viên ?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
						if(c == 0 && BLL.NhanVienBLL.xoaNhanVien(danhSachNhanVien.get(i))) {
							JOptionPane.showMessageDialog(new SanPhamGUI(), "Xóa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else JOptionPane.showMessageDialog(new SanPhamGUI(), "Xóa không thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
			else if(confirmMode == "Sua") {
				try {
					NhanVien NhanVien = themVaSua();
					int c = JOptionPane.showConfirmDialog(null, "Xác Nhận Sửa Nhân Viên", "Xác Nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.NhanVienBLL.SuaNhanVien(NhanVien)) {
						JOptionPane.showMessageDialog(null, "Sửa thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "Sửa không thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			refresh();
			hienThiDanhSachNV(BLL.NhanVienBLL.layDanhSachNV());
		}
	}
	
	private void chonAnh() {
		try {
			JFileChooser fc = new JFileChooser("image/nhan_vien");
			fc.setDialogTitle("Chọn ảnh");
			fc.showOpenDialog(new SanPhamGUI());
			File file = fc.getSelectedFile();
			anhFilePath = file.getName();
			if(anhFilePath != null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon("image/nhan_vien/" + anhFilePath).getImage().getScaledInstance(lblAnhNV_1.getWidth(), lblAnhNV_1.getHeight(), Image.SCALE_SMOOTH));
				lblAnhNV_1.setIcon(imageIcon);
			}
		}
		catch(Exception ex) {
	//		System.out.println(ex.getMessage());
		}
	}
	//Tim kiem san pham
	private void timKiemNV() {
		try {
			ArrayList<NhanVien> danhSachNhanVien1 = new ArrayList<NhanVien>();
			ArrayList<NhanVien> danhSachNhanVien2 = new ArrayList<NhanVien>();
	//		ArrayList<SanPham> danhSachSanPham3 = null;
			
			// cbLoaichucvu
			String loaiNV = cbMACHUCVU1.getSelectedItem() + "";
			if(!loaiNV.equals("")) {
				tableModel.setRowCount(0);
				for(NhanVien nv : danhSachNhanVien) {
					if(loaiNV.equals(nv.getChucVu().getTenChucVu())) {
						String[] NhanVien = {nv.getMa(),nv.getHoTen(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.getChucVu().getMaChucVu(),nv.getLuong()+""};
						tableModel.addRow(NhanVien);
						danhSachNhanVien1.add(nv);
					}
				}
			} else {
				hienThiDanhSachNV(BLL.NhanVienBLL.layDanhSachNV());
			}
			
			// cbTimKiem
			int loaiTimKiem = cbTimKiem.getSelectedIndex();
			String timKiem = tfTimKiem.getText().toLowerCase();
			if(loaiTimKiem != 0) {
				if(!loaiNV.equals("")) {
					danhSachNhanVien2 = danhSachNhanVien1;
				}
				else {
					danhSachNhanVien2 = danhSachNhanVien;
				}
				tableModel.setRowCount(0);
				for(NhanVien nv : danhSachNhanVien2) {
					boolean check = false;
					if(loaiTimKiem == 1 && nv.getHoTen().toLowerCase().contains(timKiem)) check = true;
					else if(loaiTimKiem == 2 && nv.getMa().toLowerCase().contains(timKiem)) check = true;
					if(check == true) {
						String[] NhanVien = {nv.getMa(),nv.getHoTen(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.getChucVu().getMaChucVu(),nv.getLuong()+""};
						tableModel.addRow(NhanVien);
					}
				}
				if(tfTimKiem.getText().equals("")) {
					hienThiDanhSachNV(danhSachNhanVien2);
				}
			}
		}
		catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		
		
	//	if(tfTimKiem.getText().equals("")) {
	//		hienThiDanhSachSP(danhSachSanPham);
	//	}
	}
	}
