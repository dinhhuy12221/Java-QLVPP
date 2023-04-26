package GUI;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BLL.NhanVienBLL;
import DTO.ChucVu;
import DTO.LoaiSanPham;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.SanPham;

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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

public class NhanVienGUI extends JPanel {
	private JTextField textFieldTenNV;
	private JTextField textFieldMANV;
	private JTextField textFieldLUONG;
	private JTextField textFieldSDT;
	private JTextField tfTimKiem;
	private JTextField textFieldDIACHI;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	JLabel lblAnhNV_1 = new JLabel("");
	
	private JButton btnThemAnh;
	private JButton btnXcNhn;
	private JButton btnHy;
	
	private byte[] anhFile;
	private String anhFilePath;
	
	private JComboBox cbMACHUCVU1 ;
	private JComboBox cbTimKiem;
	private JComboBox cbMaChucVu;

	String confirmMode = "";
	
	JDateChooser dateChooserNgaySinh;
	

	/**
	 * Create the panel.
	 */
	private ArrayList<NhanVien> danhSachNhanVien = BLL.NhanVienBLL.layDanhSachNV();
	private ArrayList<ChucVu> danhSachLoaiCV = BLL.ChucVuBLL.layDanhSachLoaiCV();
	private JTextField textFieldTenLoaiCV;


	public NhanVienGUI() {
		setSize(1082,689);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh S\u00E1ch Nh\u00E2n Vi\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(286, 0, 266, 34);
		add(lblNewLabel);
		
		JPanel panelThongTinNV = new JPanel();
		panelThongTinNV.setLayout(null);
		panelThongTinNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Nhân Viên", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTinNV.setBounds(0, 31, 712, 194);
		add(panelThongTinNV);
		
		JLabel lbltenhanvien = new JLabel("Tên Nhân Viên");
		lbltenhanvien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltenhanvien.setBounds(199, 31, 98, 19);
		panelThongTinNV.add(lbltenhanvien);
		
		JLabel lblMaNhanVien = new JLabel("Mã Số Nhân Viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaNhanVien.setBounds(199, 60, 98, 19);
		panelThongTinNV.add(lblMaNhanVien);
		
		JLabel lblMaCHUCVU = new JLabel("Mã Chức Vụ ");
		lblMaCHUCVU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaCHUCVU.setBounds(461, 32, 98, 19);
		panelThongTinNV.add(lblMaCHUCVU);
		
		cbMaChucVu = new JComboBox();
		cbMaChucVu.setEnabled(false);
		cbMaChucVu.setBounds(570, 31, 132, 21);
		panelThongTinNV.add(cbMaChucVu);
		Vector<String> sLoaiCV = new Vector<String>();
		sLoaiCV.add("");
		for(int i = 0; i < danhSachLoaiCV.size(); i++) {
			sLoaiCV.add(danhSachLoaiCV.get(i).getMaChucVu());
		}
		cbMaChucVu.setModel(new DefaultComboBoxModel(sLoaiCV));
		cbMaChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(ChucVu lcv : danhSachLoaiCV) {
					if(lcv.getMaChucVu().equals(cbMaChucVu.getSelectedItem())) {
						textFieldTenLoaiCV.setText(lcv.getTenChucVu());
						break;
					}
				}
			}
		});
	
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setEditable(false);
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setBounds(307, 32, 132, 19);
		panelThongTinNV.add(textFieldTenNV);
		
		textFieldMANV = new JTextField();
		textFieldMANV.setEditable(false);
		textFieldMANV.setColumns(10);
		textFieldMANV.setBounds(307, 61, 132, 19);
		panelThongTinNV.add(textFieldMANV);
		
		JLabel lblTenNhaCungCap = new JLabel("Lương");
		lblTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenNhaCungCap.setBounds(461, 90, 99, 19);
		panelThongTinNV.add(lblTenNhaCungCap);
		
		textFieldLUONG = new JTextField();
		textFieldLUONG.setOpaque(false);
		textFieldLUONG.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLUONG.setEditable(false);
		textFieldLUONG.setColumns(10);
		textFieldLUONG.setAlignmentX(0.0f);
		textFieldLUONG.setBounds(570, 90, 132, 19);
		panelThongTinNV.add(textFieldLUONG);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiaChi.setBounds(199, 90, 98, 19);
		panelThongTinNV.add(lblDiaChi);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT.setBounds(199, 118, 104, 19);
		panelThongTinNV.add(lblSDT);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setEditable(false);
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(307, 119, 132, 19);
		panelThongTinNV.add(textFieldSDT);
		
		
		lblAnhNV_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAnhNV_1.setBounds(10, 20, 162, 132);
		panelThongTinNV.add(lblAnhNV_1);
		
		btnThemAnh = new JButton("Thêm Ảnh");
		btnThemAnh.setEnabled(false);
		btnThemAnh.setBounds(37, 163, 104, 21);
		panelThongTinNV.add(btnThemAnh);
		btnThemAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonAnh();
			}
		});
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgaySinh.setBounds(199, 148, 104, 19);
		panelThongTinNV.add(lblNgaySinh);
		
		textFieldDIACHI = new JTextField();
		textFieldDIACHI.setEditable(false);
		textFieldDIACHI.setColumns(10);
		textFieldDIACHI.setBounds(307, 90, 132, 19);
		panelThongTinNV.add(textFieldDIACHI);
		
		JLabel lblMaNhaCungCap_1 = new JLabel("Tên Chức Vụ ");
		lblMaNhaCungCap_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaNhaCungCap_1.setBounds(461, 60, 98, 19);
		panelThongTinNV.add(lblMaNhaCungCap_1);
		
		textFieldTenLoaiCV = new JTextField();
		textFieldTenLoaiCV.setOpaque(false);
		textFieldTenLoaiCV.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTenLoaiCV.setEditable(false);
		textFieldTenLoaiCV.setColumns(10);
		textFieldTenLoaiCV.setAlignmentX(0.0f);
		textFieldTenLoaiCV.setBounds(570, 60, 132, 19);
		panelThongTinNV.add(textFieldTenLoaiCV);
		
		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
		dateChooserNgaySinh.setEnabled(false);
		dateChooserNgaySinh.setBounds(307, 148, 132, 19);
		panelThongTinNV.add(dateChooserNgaySinh);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c  n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChucNang.setBounds(722, 31, 134, 272);
		add(panelChucNang);
		panelChucNang.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnThm);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNV();
			}
		});
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnXa);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNV();
			}
		});
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnSa);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNV();
			}
		});
		
		JButton btnNhpExel = new JButton("Nhập excel");
		btnNhpExel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnNhpExel);
		
		JButton btnXutExcel = new JButton("Xuất excel");
		btnXutExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelChucNang.add(btnXutExcel);
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setLayout(null);
		panelTimKiem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimKiem.setBounds(0, 228, 534, 75);
		add(panelTimKiem);
		
		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTmKim.setBounds(10, 10, 69, 19);
		panelTimKiem.add(lblTmKim);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setColumns(10);
		tfTimKiem.setBounds(318, 11, 206, 19);
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
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(544, 228, 134, 75);
		add(panel_1);
		
		btnXcNhn = new JButton("Xác Nhận");
		btnXcNhn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXcNhn.setEnabled(false);
		btnXcNhn.setBounds(10, 10, 103, 23);
		panel_1.add(btnXcNhn);
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		
		btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHy.setEnabled(false);
		btnHy.setBounds(10, 43, 103, 23);
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
		panelDanhSachSP.setBounds(10, 331, 856, 243);
		add(panelDanhSachSP);
		panelDanhSachSP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		panelDanhSachSP.add(scrollPane);
		
		table = new JTable();
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
					"Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ" ,"Số Điện Thoại", "Ngày Sinh", "Mã Chức vụ", "Lương"
				} 
			);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		hienThiDanhSachNV(danhSachNhanVien);
	}
	////chuc nang//////////////////////////////////////////////////////////
	private void hienThiDanhSachNV(ArrayList<NhanVien> dsnv) {
		tableModel.setRowCount(0);
		danhSachNhanVien = dsnv;
		for(NhanVien nv : danhSachNhanVien){
			String[] NhanVien = {nv.getMa(),nv.getHoTen(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.getChucVu().getMaChucVu(),nv.getLuong()+""};
			tableModel.addRow(NhanVien);
		}
	}


private void chonNhanVien() {
	int i = table.getSelectedRow();
	if(i >= 0) {
		try {
			textFieldTenNV.setText(table.getValueAt(i, 1)+"");
			textFieldMANV.setText(table.getValueAt(i, 0)+"");
			textFieldDIACHI.setText(table.getValueAt(i, 2)+"");
			textFieldSDT.setText(table.getValueAt(i, 3)+"");
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(i, 4)+"");
			dateChooserNgaySinh.setDate(d);
			cbMaChucVu.setSelectedItem(table.getValueAt(i, 5)+"");
			textFieldLUONG.setText(table.getValueAt(i, 6)+"");
			if(danhSachNhanVien.get(i).getAnhNhanVien()!=null) {
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(danhSachNhanVien.get(i).getAnhNhanVien()).getImage().getScaledInstance(lblAnhNV_1.getWidth(), lblAnhNV_1.getHeight(), Image.SCALE_SMOOTH));
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
	String maNV = textFieldMANV.getText();
	String tenNV = textFieldTenNV.getText();
	String diachi = textFieldDIACHI.getText();
	String maCV = (String) cbMaChucVu.getSelectedItem();
	String tenCV = textFieldTenLoaiCV.getText();
	String SDT = textFieldSDT.getText();
	Date d;
	String ngaysinh = "";
	try {
		d = new SimpleDateFormat("yyyy-MM-dd").parse(dateChooserNgaySinh.getDate().toString());
		ngaysinh = d.toString();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(ngaysinh);
	double LUONG = Double.parseDouble(textFieldLUONG.getText().toString());
	byte[] anhNV = anhFile;
	ChucVu loaiCV= new ChucVu(maCV,tenCV);
	NhanVien NhanVien = new NhanVien(maNV, tenNV, diachi, SDT ,ngaysinh,loaiCV,LUONG,anhNV,anhFilePath);
	return NhanVien;
}
// Xoa thong tin trong textfield
private void refresh() {
	textFieldMANV.setText("");
	textFieldTenNV.setText("");
	textFieldDIACHI.setText("");
	textFieldSDT.setText("");
	dateChooserNgaySinh.setDate(null);;
	textFieldLUONG.setText("");
	lblAnhNV_1.setIcon(null);
}

// enable cho textfield 
private void isEnable(boolean i) {
	textFieldTenNV.setEditable(i);
	textFieldDIACHI.setEditable(i);
	textFieldSDT.setEditable(i);
	dateChooserNgaySinh.setEnabled(i);
	textFieldLUONG.setEditable(i);
	btnThemAnh.setEnabled(i);
	btnHy.setEnabled(true);
	btnXcNhn.setEnabled(true);
	cbMaChucVu.setEnabled(i);
}
private String taoMaNhanVien() {
	int i = BLL.NhanVienBLL.laySoLuongNhanVien();
	return "NV" + (i+1);
}
// Xac nhan
private void xacNhan() {
	if(confirmMode == "Them") {
		try {
			String maNV = taoMaNhanVien();
			NhanVien NhanVien = themVaSua();
			NhanVien.setMa(maNV);
			int c = JOptionPane.showConfirmDialog(null, "Xác Nhận Thêm Nhân Viên", "Xác Nhận", JOptionPane.YES_NO_OPTION);
			if(c == 0 && BLL.NhanVienBLL.themNhanVien(NhanVien)) {
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
private void chonAnh() {
	try {
		JFileChooser fc = new JFileChooser("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\nhan_vien");
		fc.setDialogTitle("Chọn ảnh");
		fc.showOpenDialog(new SanPhamGUI());
		File file = fc.getSelectedFile();
		anhFilePath = file.getAbsolutePath();
		if(anhFilePath != null) {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(anhFilePath).getImage().getScaledInstance(lblAnhNV_1.getWidth(), lblAnhNV_1.getHeight(), Image.SCALE_SMOOTH));
			lblAnhNV_1.setIcon(imageIcon);
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
//Tim kiem san pham
private void timKiemNV() {
	try {
		ArrayList<NhanVien> danhSachNhanVien1 = new ArrayList<NhanVien>();
		ArrayList<NhanVien> danhSachNhanVien2 = null;
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
