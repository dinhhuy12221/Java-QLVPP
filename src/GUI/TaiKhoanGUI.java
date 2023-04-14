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

public class TaiKhoanGUI extends JPanel {
	private JTextField tfTenNhanVien;
	private JTable table;
	private JComboBox cbTrangThai = new JComboBox();
	private JButton btnHuy;
	private JButton btnXacNhan;
	
	private String status = "";
	
	private DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "Tên chức vụ","M\u1EADt kh\u1EA9u", "Tr\u1EA1ng th\u00E1i"
			});
	
	private ArrayList<TaiKhoan> dstk = BLL.TaiKhoanBLL.layDanhSachTaiKhoan();
	private JTextField tfMaNhanVien;
	private JTextField tfMatKhau;
	private JTextField tfChucVu;

	/**
	 * Create the panel.
	 */
	public TaiKhoanGUI() {
		setSize(880,585);
		setLayout(null);
		
		JLabel lblQunLTi = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQunLTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLTi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLTi.setBounds(10, 10, 856, 28);
		add(lblQunLTi);
		
		JPanel panelThongTinTK = new JPanel();
		panelThongTinTK.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinTK.setBounds(10, 56, 269, 189);
		add(panelThongTinTK);
		panelThongTinTK.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setBounds(10, 25, 98, 19);
		panelThongTinTK.add(lblMaNhanVien);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setBounds(10, 54, 98, 19);
		panelThongTinTK.add(lblTenNhanVien);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfTenNhanVien = new JTextField();
		tfTenNhanVien.setEditable(false);
		tfTenNhanVien.setBounds(118, 55, 132, 19);
		panelThongTinTK.add(tfTenNhanVien);
		tfTenNhanVien.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
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
		cbTrangThai.setBounds(118, 150, 132, 21);
		panelThongTinTK.add(cbTrangThai);
		
		tfMaNhanVien = new JTextField();
		tfMaNhanVien.setEditable(false);
		tfMaNhanVien.setColumns(10);
		tfMaNhanVien.setBounds(118, 26, 132, 19);
		panelThongTinTK.add(tfMaNhanVien);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setEditable(false);
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(118, 114, 132, 19);
		panelThongTinTK.add(tfMatKhau);
		
		JLabel lbChucVu = new JLabel("Chức vụ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbChucVu.setBounds(10, 83, 98, 19);
		panelThongTinTK.add(lbChucVu);
		
		tfChucVu = new JTextField();
		tfChucVu.setEditable(false);
		tfChucVu.setColumns(10);
		tfChucVu.setBounds(118, 84, 132, 19);
		panelThongTinTK.add(tfChucVu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 56, 534, 496);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chonTaiKhoan();
			}
		});
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
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
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(182, 355, 123, 75);
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
		
		hienThiDanhSachTK( BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
	}
	
	private void hienThiDanhSachTK(ArrayList<TaiKhoan> dstk) {
		this.dstk = dstk;
		tableModel.setRowCount(0);
		for (TaiKhoan tk : this.dstk) {
			tableModel.addRow(new Object[] {tk.getTenDangNhap(), tk.getChucVu().getTenChucVu(),tk.getMatKhau(), tk.getTinhTrang()});
		}
	}
	
	private void them() {
		refresh();
		tfMatKhau.setEditable(true);
		cbTrangThai.setEnabled(true);
		table.setEnabled(false);
		status = "Them";
		JFrame frame = new JFrame("Chọn nhân viên để tạo tài khoản");
		JButton btnXn = new JButton("Xác nhận");
		btnXn.setBounds(170,270,100,30);
		JButton btnHy = new JButton("Hủy");
		btnHy.setBounds(270,270,100,30);
		
		JTable nvTable = new JTable();
		DefaultTableModel nvTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Mã nhân viên", "Tên nhân viên", "Chức vụ"});
		nvTable.setModel(nvTableModel);
		JScrollPane nvSP = new JScrollPane();
		
		ArrayList<NhanVien> dsnv = BLL.TaiKhoanBLL.layDanhSachNVChuaCoTK();
		for(NhanVien nv: dsnv) {
			nvTableModel.addRow(new Object[] {nv.getMa(),nv.getHoTen(),nv.getChucVu().getTenChucVu()});
		}
		
		nvTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = nvTable.getSelectedRow();
				if (i >= 0) {
					btnXn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							tfMaNhanVien.setText(dsnv.get(i).getMa());
							tfTenNhanVien.setText(dsnv.get(i).getHoTen());
							tfChucVu.setText(dsnv.get(i).getChucVu().getTenChucVu());
							frame.dispose();
						}
					});
				}
			}
		});
		
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status = "";
				refresh();
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(btnXn);frame.getContentPane().add(btnHy);
		
		nvSP.setViewportView(nvTable);
		nvSP.setBounds(10,10,500,240);;
		frame.getContentPane().add(nvSP);
		frame.setSize(550,350);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	private void xoa() {
		table.setEnabled(true);
		tfMatKhau.setEditable(false);
		cbTrangThai.setEditable(false);
		status = "Xoa";
	}
	
	private void sua() {
		table.setEnabled(true);
		tfMatKhau.setEditable(true);
		cbTrangThai.setEnabled(true);
		status = "Sua";
	}
	
	private TaiKhoan layThongTinTK() {
		TaiKhoan tk = new TaiKhoan();
		tk.setTenDangNhap(tfMaNhanVien.getText());
		tk.setMatKhau(tfMatKhau.getText());
		tk.setTinhTrang(cbTrangThai.getSelectedItem().toString());
		return tk;
	}
	
	private void xacNhan() {
		try {
			if(status == "Them") {
				TaiKhoan tk = layThongTinTK();
				int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận tạo tài khoản ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(c == 0 && BLL.TaiKhoanBLL.themTaiKhoan(tk)) {
					JOptionPane.showMessageDialog(new GiaoDienGUI(), "Tạo thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
				}
				else JOptionPane.showMessageDialog(new GiaoDienGUI(), "Tạo thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(status == "Xoa") {
				TaiKhoan tk = layThongTinTK();
				int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận xóa tài khoản ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(c == 0 && BLL.TaiKhoanBLL.xoaTaiKhoan(tk)) {
					JOptionPane.showMessageDialog(new GiaoDienGUI(), "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
				}
				else JOptionPane.showMessageDialog(new GiaoDienGUI(), "Xóa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(status == "Sua") {
				TaiKhoan tk = layThongTinTK();
				int c = JOptionPane.showConfirmDialog(new GiaoDienGUI(), "Xác nhận sửa tài khoản ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(c == 0 && BLL.TaiKhoanBLL.suaTaiKhoan(tk)) {
					JOptionPane.showMessageDialog(new GiaoDienGUI(), "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					hienThiDanhSachTK(BLL.TaiKhoanBLL.layDanhSachTaiKhoan());
				}
				else JOptionPane.showMessageDialog(new GiaoDienGUI(), "Sửa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			refresh();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void refresh() {
		table.setEnabled(true);
		tfMaNhanVien.setText("");;
		tfTenNhanVien.setText("");
		tfChucVu.setText("");
		tfMatKhau.setText("");
		tfMatKhau.setEditable(false);
		cbTrangThai.setEnabled(false);
	}
	
	private void chonTaiKhoan() {
		int i = table.getSelectedRow();
		if (i >=0 ) {
			tfMaNhanVien.setText(dstk.get(i).getTenDangNhap());
			tfTenNhanVien.setText(dstk.get(i).getTenNhanVien());
			tfChucVu.setText(dstk.get(i).getChucVu().getTenChucVu());
			tfMatKhau.setText(dstk.get(i).getMatKhau());
			
			cbTrangThai.setSelectedItem(dstk.get(i).getTinhTrang());
		}
	}
}
