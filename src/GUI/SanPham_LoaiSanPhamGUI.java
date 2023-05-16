//package GUI;
//
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import javax.swing.SwingConstants;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JTextField;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JScrollPane;
//import java.awt.GridLayout;
//import javax.swing.JTable;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import DTO.LoaiSanPham;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class SanPham_LoaiSanPhamGUI extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField tfMaLSP;
//	private JTextField tfTenLSP;
//	private JTable tableDSLSP;
//	private DefaultTableModel tModelDSLSP;
//	
//	private ArrayList<LoaiSanPham> danhSachLSP = new ArrayList<LoaiSanPham>();
//	
//	String xacNhanMode = "";
//
//	/**
//	 * Create the frame.
//	 */
//	public SanPham_LoaiSanPhamGUI() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setLocationRelativeTo(null);
//		setBounds(100, 100, 583, 451);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel panelThongTinLSP = new JPanel();
//		panelThongTinLSP.setBorder(new TitledBorder(null, "Th\u00F4ng tin lo\u1EA1i s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panelThongTinLSP.setBounds(10, 48, 530, 102);
//		contentPane.add(panelThongTinLSP);
//		panelThongTinLSP.setLayout(null);
//		
//		JLabel lblMaLoaiSP = new JLabel("Mã loại sản phẩm");
//		lblMaLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblMaLoaiSP.setBounds(10, 30, 111, 22);
//		panelThongTinLSP.add(lblMaLoaiSP);
//		
//		tfMaLSP = new JTextField();
//		tfMaLSP.setEditable(false);
//		tfMaLSP.setBounds(123, 33, 155, 19);
//		panelThongTinLSP.add(tfMaLSP);
//		tfMaLSP.setColumns(10);
//		
//		JLabel lblTenLoaiSP = new JLabel("Tên loại sản phẩm");
//		lblTenLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTenLoaiSP.setBounds(10, 70, 111, 22);
//		panelThongTinLSP.add(lblTenLoaiSP);
//		
//		tfTenLSP = new JTextField();
//		tfTenLSP.setEditable(false);
//		tfTenLSP.setColumns(10);
//		tfTenLSP.setBounds(123, 73, 155, 19);
//		panelThongTinLSP.add(tfTenLSP);
//		
//		JLabel lblQuanLy = new JLabel("QUẢN LÝ LOẠI SẢN PHẨM");
//		lblQuanLy.setHorizontalAlignment(SwingConstants.CENTER);
//		lblQuanLy.setFont(new Font("Tahoma", Font.BOLD, 20));
//		lblQuanLy.setBounds(10, 10, 530, 28);
//		contentPane.add(lblQuanLy);
//		
//		JPanel panelChucNang = new JPanel();
//		panelChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panelChucNang.setLayout(null);
//		panelChucNang.setBounds(10, 160, 530, 54);
//		contentPane.add(panelChucNang);
//		
//		JButton btnThem = new JButton("Thêm");
//		btnThem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				them();
//			}});
//		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnThem.setBounds(24, 23, 85, 21);
//		panelChucNang.add(btnThem);
//		
//		JButton btnXoa = new JButton("Xóa");
//		btnXoa.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				xoa();
//			}
//		});
//		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnXoa.setBounds(119, 23, 85, 21);
//		panelChucNang.add(btnXoa);
//		
//		JButton btnSua = new JButton("Sửa");
//		btnSua.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				sua();
//			}
//		});
//		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnSua.setBounds(214, 23, 85, 21);
//		panelChucNang.add(btnSua);
//		
//		JButton btnXacNhan = new JButton("Xác nhận");
//		btnXacNhan.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				xacNhan();
//			}
//		});
//		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnXacNhan.setBounds(341, 24, 85, 21);
//		panelChucNang.add(btnXacNhan);
//		
//		JButton btnHuy = new JButton("Hủy");
//		btnHuy.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				huy();
//			}
//		});
//		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnHuy.setBounds(436, 24, 85, 21);
//		panelChucNang.add(btnHuy);
//		
//		JPanel panelDSLSP = new JPanel();
//		panelDSLSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch lo\u1EA1i s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panelDSLSP.setBounds(10, 224, 530, 188);
//		contentPane.add(panelDSLSP);
//		panelDSLSP.setLayout(new GridLayout(0, 1, 0, 0));
//		
//		JScrollPane spDSLSP = new JScrollPane();
//		panelDSLSP.add(spDSLSP);
//		
//		tableDSLSP = new JTable();
//		tableDSLSP.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				chonLoaiSP();
//			}
//		});
//		spDSLSP.setRowHeaderView(tableDSLSP);
//		tModelDSLSP = new DefaultTableModel(new Object[][] {}, new String [] {"Mã loại sản phẩm", "Tên loại sản phẩm"});
//		tableDSLSP.setModel(tModelDSLSP);
//		spDSLSP.setViewportView(tableDSLSP);
//		
//		hienThiDanhSachLSP(BLL.LoaiSanPhamBLL.layDanhSachLoaiSP());
//	}
//	
//	//----------------------CHUC NANG---------------------
//	
//	private void hienThiDanhSachLSP(ArrayList<LoaiSanPham> dssp) {
//		tModelDSLSP.setRowCount(0);
//		danhSachLSP = dssp;
//		for (LoaiSanPham lsp : danhSachLSP) {
//			String [] loaiSP = {lsp.getMaLoaiSanPham(), lsp.getTenLoaiSanPham()};
//			tModelDSLSP.addRow(loaiSP);
//		}
//	}
//	
//	private void chonLoaiSP() {
//		int i = tableDSLSP.getSelectedRow();
//		if (i >= 0) {
//			tfMaLSP.setText(danhSachLSP.get(i).getMaLoaiSanPham());
//			tfTenLSP.setText(danhSachLSP.get(i).getTenLoaiSanPham());
//		}
//	}
//	
//	private void lamMoi() {
//		SanPhamGUI.hienThiDanhSachSP(BLL.SanPhamBLL.layDanhSachSP());
//		danhSachLSP = BLL.LoaiSanPhamBLL.layDanhSachLoaiSP();
//		
//		Vector<String> sLoaiSP = new Vector<String>();
//		sLoaiSP.add("");
//		for(int i = 0; i < danhSachLSP.size(); i++) {
//			sLoaiSP.add(danhSachLSP.get(i).getMaLoaiSanPham());
//		}
//		SanPhamGUI.cbMaLoaiSP.setModel(new DefaultComboBoxModel(sLoaiSP));
//		SanPhamGUI.cbLoaiSP.setModel(new DefaultComboBoxModel(sLoaiSP));
//		SanPhamGUI.cbMaLoaiSP.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for(LoaiSanPham lsp : danhSachLSP) {
//					if(lsp.getMaLoaiSanPham().equals(SanPhamGUI.cbMaLoaiSP.getSelectedItem())) {
//						SanPhamGUI.tfTenLoaiSP.setText(lsp.getTenLoaiSanPham());
//						break;
//					}
//				}
//			}
//		});
//	}
//	
//	private void them() {
//		refresh();
//		tfMaLSP.setEditable(true);
//		tfTenLSP.setEditable(true);
//		tableDSLSP.setEnabled(false);
//		
//		xacNhanMode = "Them";
//	}
//	
//	private void sua() {
//		tfMaLSP.setEditable(true);
//		tfTenLSP.setEditable(true);
//		tableDSLSP.setEnabled(true);
//		
//		xacNhanMode = "Sua";
//	}
//	
//	private void xoa() {
//		tfMaLSP.setEditable(false);
//		tfTenLSP.setEditable(false);
//		tableDSLSP.setEnabled(true);
//		
//		xacNhanMode = "Xoa";
//	}
//	
//	private void huy() {
//		refresh();
//		tableDSLSP.setEnabled(true);
//	}
//	
//	private void refresh() {
//		tfMaLSP.setText("");
//		tfTenLSP.setText("");
//	}
//	
//	private void xacNhan() {
//		if(xacNhanMode == "Them") {
//			xacNhanThem();
//			hienThiDanhSachLSP(BLL.LoaiSanPhamBLL.layDanhSachLoaiSP());
//		} else if(xacNhanMode == "Xoa") {
//			xacNhanXoa();
//			hienThiDanhSachLSP(BLL.LoaiSanPhamBLL.layDanhSachLoaiSP());
//		} else if(xacNhanMode == "Sua") {
//			xacNhanSua();
//			hienThiDanhSachLSP(BLL.LoaiSanPhamBLL.layDanhSachLoaiSP());
//		}
//	}
//	private void xacNhanThem() {
//		try {
//			String maLSP = tfMaLSP.getText();
//			String tenLSP = tfTenLSP.getText();
//			LoaiSanPham lsp = new LoaiSanPham(maLSP,tenLSP);
//			int c = JOptionPane.showConfirmDialog(null, "Xác nhận thêm loại sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
//			if(c == 0 && BLL.LoaiSanPhamBLL.themLoaiSP(lsp)) {
//				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//				lamMoi();
//			} else {
//				JOptionPane.showMessageDialog(null, "Thêm không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//			}
//		} catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//	
//	private void xacNhanXoa() {
//		try {
//			String maLSP = tfMaLSP.getText();
//			LoaiSanPham lsp = new LoaiSanPham(maLSP,"");
//			int c = JOptionPane.showConfirmDialog(null, "Xác nhận xóa loại sản phẩm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
//			if(c == 0 && BLL.LoaiSanPhamBLL.xoaLoaiSP(lsp)) {
//				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//			} else {
//				JOptionPane.showMessageDialog(null, "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//			}
//		} catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}	
//	}
//	
//	private void xacNhanSua() {
//		try {
//			
//		} catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//}
//	
