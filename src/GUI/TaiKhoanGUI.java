package GUI;

import DTO.NhanVien;
import DTO.TaiKhoan;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class TaiKhoanGUI extends JPanel {
	
	private JComboBox cbTrangThai = new JComboBox();
	
	private JButton btnHuy;
	private JButton btnXacNhan;
	
	private JTable tableDSTK;
	private DefaultTableModel tModelDSTK = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "Tên chức vụ","M\u1EADt kh\u1EA9u", "Tr\u1EA1ng th\u00E1i"
			});
	private DefaultTableModel tModelDSNV;
	
	private JTextField tfTenNhanVien;
	private JTextField tfMaNhanVien;
	private JTextField tfMatKhau;
	private JTextField tfChucVu;

	private ArrayList<TaiKhoan> dstk = BLL.TaiKhoanBLL.layDanhSachTaiKhoan();
	ArrayList<NhanVien> danhSachNV =  new ArrayList<NhanVien>();
	
	private String status = "";
	private JTable tableDSNV;
	/**
	 * Create the panel.
	 */
	public TaiKhoanGUI() {
		setSize(1082,689);
		setLayout(null);
		
		JLabel lblQunLTi = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQunLTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLTi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLTi.setBounds(10, 10, 856, 28);
		add(lblQunLTi);
		
		JPanel panelThongTinTK = new JPanel();
		panelThongTinTK.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinTK.setBounds(10, 56, 298, 189);
		add(panelThongTinTK);
		panelThongTinTK.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên *");
		lblMaNhanVien.setBounds(10, 25, 98, 19);
		panelThongTinTK.add(lblMaNhanVien);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên *");
		lblTenNhanVien.setBounds(10, 54, 98, 19);
		panelThongTinTK.add(lblTenNhanVien);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfTenNhanVien = new JTextField();
		tfTenNhanVien.setEditable(false);
		tfTenNhanVien.setBounds(118, 55, 170, 19);
		panelThongTinTK.add(tfTenNhanVien);
		tfTenNhanVien.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu *");
		lblMatKhau.setBounds(10, 113, 98, 19);
		panelThongTinTK.add(lblMatKhau);
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrangThai.setBounds(10, 150, 98, 19);
		panelThongTinTK.add(lblTrangThai);
		
		cbTrangThai = new JComboBox();
		cbTrangThai.setEnabled(false);
		cbTrangThai.setModel(new DefaultComboBoxModel(new String[] {"", "Mở khóa", "Khóa"}));
		cbTrangThai.setBounds(118, 150, 170, 21);
		panelThongTinTK.add(cbTrangThai);
		
		tfMaNhanVien = new JTextField();
		tfMaNhanVien.setEditable(false);
		tfMaNhanVien.setColumns(10);
		tfMaNhanVien.setBounds(118, 26, 170, 19);
		panelThongTinTK.add(tfMaNhanVien);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setEditable(false);
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(118, 114, 170, 19);
		panelThongTinTK.add(tfMatKhau);
		
		JLabel lbChucVu = new JLabel("Chức vụ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbChucVu.setBounds(10, 83, 98, 19);
		panelThongTinTK.add(lbChucVu);
		
		tfChucVu = new JTextField();
		tfChucVu.setEditable(false);
		tfChucVu.setColumns(10);
		tfChucVu.setBounds(118, 84, 170, 19);
		panelThongTinTK.add(tfChucVu);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNang.setBounds(10, 247, 298, 98);
		add(panelChucNang);
		panelChucNang.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setBounds(10, 30, 85, 38);
		panelChucNang.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setBounds(105, 30, 85, 38);
		panelChucNang.add(btnXoa);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setBounds(200, 30, 85, 38);
		panelChucNang.add(btnSua);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(318, 255, 123, 90);
		add(panel_1);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXacNhan.setBounds(10, 10, 103, 23);
		panel_1.add(btnXacNhan);
		
		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				status = "";
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHuy.setBounds(10, 43, 103, 23);
		panel_1.add(btnHuy);
		
		JPanel panelDSTK = new JPanel();
		panelDSTK.setBorder(new TitledBorder(null, "Danh s\u00E1ch t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDSTK.setBounds(10, 355, 543, 203);
		add(panelDSTK);
		panelDSTK.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane spDSTK = new JScrollPane();
		panelDSTK.add(spDSTK);
		
		tableDSTK = new JTable();
		tableDSTK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonTaiKhoan();
			}
		});
		tableDSTK.setModel(tModelDSTK);
		spDSTK.setViewportView(tableDSTK);
		
		JPanel panelDSNV = new JPanel();
		panelDSNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E2n vi\u00EAn ch\u01B0a m\u1EDF t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDSNV.setBounds(318, 56, 487, 189);
		add(panelDSNV);
		panelDSNV.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane spDSNV = new JScrollPane();
		panelDSNV.add(spDSNV);
		
		tableDSNV = new JTable();
		tableDSNV.setEnabled(false);
		tableDSNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonNhanVien();
			}
		});
		spDSNV.setViewportView(tableDSNV);
		tModelDSNV = new DefaultTableModel(new Object[][] {}, new String[] {"Mã nhân viên", "Tên nhân viên", "Chức vụ"});
		tableDSNV.setModel(tModelDSNV);
		
		hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
		hienThiDanhSachNV(BLL.TaiKhoanBLL.layDanhSachNVChuaCoTK());
	}
	
	// --------------------------------CHUC NANG -----------------------------------------
	
	private void hienThiDanhSachTK(ArrayList<TaiKhoan> dstk) {
		this.dstk = dstk;
		tModelDSTK.setRowCount(0);
		for (TaiKhoan tk : this.dstk) {
			tModelDSTK.addRow(new Object[] {tk.getTenDangNhap(), tk.getChucVu().getMaChucVu(),tk.getMatKhau(), tk.getTinhTrang()});
		}
	}
	
	private void hienThiDanhSachNV(ArrayList<NhanVien> dsnv) {
		this.danhSachNV = dsnv;
		tModelDSNV.setRowCount(0);
		for(NhanVien nv: dsnv) {
			tModelDSNV.addRow(new Object[] {nv.getMa(),nv.getHoTen(),nv.getChucVu().getMaChucVu()});
		}
	}
		
	private void chonNhanVien() {
		int i = tableDSNV.getSelectedRow();
		if(i >= 0) {
			tfMaNhanVien.setText(danhSachNV.get(i).getMa());
			tfTenNhanVien.setText(danhSachNV.get(i).getHoTen());
			tfChucVu.setText(danhSachNV.get(i).getChucVu().getMaChucVu());
		}
	}
	
	private void them() {
		refresh();
		tfMatKhau.setEditable(true);
		cbTrangThai.setEnabled(true);
		tableDSTK.setEnabled(false);
		tableDSNV.setEnabled(true);
		status = "Them";
		
		
//		
//		JTable nvTable = new JTable();
//		DefaultTableModel nvTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Mã nhân viên", "Tên nhân viên", "Chức vụ"});
//		nvTable.setModel(nvTableModel);
//		JScrollPane nvSP = new JScrollPane();
//		
//		ArrayList<NhanVien> dsnv = BLL.TaiKhoanBLL.layDanhSachNVChuaCoTK();
//		for(NhanVien nv: dsnv) {
//			nvTableModel.addRow(new Object[] {nv.getMa(),nv.getHoTen(),nv.getChucVu().getTenChucVu()});
//		}
//		
//		nvTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int i = nvTable.getSelectedRow();
//				if (i >= 0) {
//						public void actionPerformed(ActionEvent e) {
//							
//						}
//					});
//				}
//			}
//		})
	}
		

	
	private void xoa() {
		refresh();
		tableDSTK.setEnabled(true);
		tfMatKhau.setEditable(false);
		cbTrangThai.setEditable(false);
		tableDSNV.setEnabled(false);
		status = "Xoa";
	}
	
	private void sua() {
		refresh();
		tableDSTK.setEnabled(true);
		tfMatKhau.setEditable(true);
		cbTrangThai.setEnabled(true);
		tableDSNV.setEnabled(false);
		status = "Sua";
	}
	
	private boolean kiemTraThongTinTK() {
		if(!tfMaNhanVien.getText().trim().equals("")) {
			if(!tfMatKhau.getText().trim().equals("")) {
				if(!cbTrangThai.getSelectedItem().equals("")) {
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn trạng thái tài khoản", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return false;
					}
			} else {
				JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} 
		}else {
			JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	private TaiKhoan layThongTinTK() {
		TaiKhoan tk = new TaiKhoan();
		tk.setTenDangNhap(tfMaNhanVien.getText());
		tk.setMatKhau(tfMatKhau.getText());
		tk.setTinhTrang(cbTrangThai.getSelectedItem().toString());
		return tk;
	}
	
	private void xacNhan() {
		if(kiemTraThongTinTK()) {
			try {
				if(status == "Them") {
					TaiKhoan tk = layThongTinTK();
					int c = JOptionPane.showConfirmDialog(null, "Xác nhận tạo tài khoản ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.TaiKhoanBLL.themTaiKhoan(tk)) {
						JOptionPane.showMessageDialog(null, "Tạo thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
					}
					else JOptionPane.showMessageDialog(null, "Tạo thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status == "Xoa") {
					TaiKhoan tk = layThongTinTK();
					int c = JOptionPane.showConfirmDialog(null, "Xác nhận xóa tài khoản ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.TaiKhoanBLL.xoaTaiKhoan(tk)) {
						JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
					}
					else JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status == "Sua") {
					TaiKhoan tk = layThongTinTK();
					int c = JOptionPane.showConfirmDialog(null, "Xác nhận sửa tài khoản ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(c == 0 && BLL.TaiKhoanBLL.suaTaiKhoan(tk)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
					}
					else JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				refresh();
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
			hienThiDanhSachNV(BLL.TaiKhoanBLL.layDanhSachNVChuaCoTK());
		}
	}
	
	private void refresh() {
		tableDSTK.setEnabled(true);
		tfMaNhanVien.setText("");;
		tfTenNhanVien.setText("");
		tfChucVu.setText("");
		tfMatKhau.setText("");
		tfMatKhau.setEditable(false);
		cbTrangThai.setEnabled(false);
	}
	
	private void chonTaiKhoan() {
		int i = tableDSTK.getSelectedRow();
		if (i >=0 ) {
			tfMaNhanVien.setText(dstk.get(i).getTenDangNhap());
			tfTenNhanVien.setText(dstk.get(i).getTenNhanVien());
			tfChucVu.setText(dstk.get(i).getChucVu().getMaChucVu());
			tfMatKhau.setText(dstk.get(i).getMatKhau());
			cbTrangThai.setSelectedItem(dstk.get(i).getTinhTrang());
		}
	}
}
