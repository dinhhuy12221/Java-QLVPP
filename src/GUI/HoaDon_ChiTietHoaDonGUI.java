//package GUI;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//import DTO.ChiTietPhieu;
//import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import javax.swing.border.TitledBorder;
//
//public class HoaDon_ChiTietHoaDonGUI extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField tfMaKH;
//	private JTextField tfTenKH;
//	private JTextField tfTenNV;
//	private JTextField tfMaNV;
//	private JTextField tfTongTien;
//	
//	JTable tableCTHD = new JTable();
//	DefaultTableModel tModelCTHD;
//	JScrollPane spCTHD;
//	
//	
//	public int index;
//	private JTextField tfMaHD;
//	private JTextField tfNgayLap;
//
//	/**
//	 * Create the 
//	 */
//	public HoaDon_ChiTietHoaDonGUI() {
//		setTitle("Chi tiết hóa đơn");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		JButton btnDong = new JButton("Đóng");
//		btnDong.setBounds(279,323,100,30);
//		btnDong.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
//		getContentPane().add(btnDong);
//		
//		tModelCTHD = new DefaultTableModel(new Object[][] {}, new String[] {"Mã sản phẩm", "Tên sản phẩm","Đơn giá", "Số lượng", "Thành tiền"});;
//		setSize(700,400);
//		setResizable(false);
//		getContentPane().setLayout(null);
//		
//		tfMaKH = new JTextField(HoaDonGUI.danhSachHD.get(index).getKhachHang().getMa());
//		tfMaKH.setEditable(false);
//		tfMaKH.setBounds(122, 80, 55, 19);
//		getContentPane().add(tfMaKH);
//		tfMaKH.setColumns(10);
//		
//		tfTenKH = new JTextField(HoaDonGUI.danhSachHD.get(index).getKhachHang().getHoTen());
//		tfTenKH.setEditable(false);
//		tfTenKH.setColumns(10);
//		tfTenKH.setBounds(122, 120, 150, 19);
//		getContentPane().add(tfTenKH);
//		
//		tfTenNV = new JTextField(HoaDonGUI.danhSachHD.get(index).getNhanVien().getHoTen());
//		tfTenNV.setEditable(false);
//		tfTenNV.setColumns(10);
//		tfTenNV.setBounds(122, 200, 150, 19);
//		getContentPane().add(tfTenNV);
//		
//		tfMaNV = new JTextField(HoaDonGUI.danhSachHD.get(index).getNhanVien().getMa());
//		tfMaNV.setEditable(false);
//		tfMaNV.setColumns(10);
//		tfMaNV.setBounds(122, 160, 55, 19);
//		getContentPane().add(tfMaNV);
//		
//		JLabel lbTongTien = new JLabel("Tổng tiền");
//		lbTongTien.setBounds(10,286,87,13);
//		JLabel lbMaKH = new JLabel();
//		lbMaKH.setText("Mã khách hàng");
//		lbMaKH.setBounds(10,79,87,20);
//		
//		JLabel lbTenKH = new JLabel();
//		lbTenKH.setText("Tên khách hàng");
//		lbTenKH.setBounds(10,119,102,20);
//		
//		JLabel lbMaNV = new JLabel();
//		lbMaNV.setText("Mã nhân viên");
//		lbMaNV.setBounds(10,159,87,20);
//		
//		JLabel lbTenNV = new JLabel();
//		lbTenNV.setText("Tên nhân viên");
//		lbTenNV.setBounds(10,199,87,20);
//		
//		JLabel lbNgayLap = new JLabel();
//		lbNgayLap.setText("Ngày lập");
//		lbNgayLap.setBounds(10,239,87,20);
//		
//		getContentPane().add(lbTongTien);
//		getContentPane().add(lbMaKH);
//		getContentPane().add(lbTenKH);
//		getContentPane().add(lbMaNV);
//		getContentPane().add(lbTenNV);
//		getContentPane().add(lbNgayLap);
//		
//		tfTongTien = new JTextField(HoaDonGUI.danhSachHD.get(index).getTongTien() + "");
//		tfTongTien.setEditable(false);
//		tfTongTien.setColumns(10);
//		tfTongTien.setBounds(122, 283, 150, 19);
//		getContentPane().add(tfTongTien);
//		
//		JPanel panelSanPham = new JPanel();
//		panelSanPham.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m mua", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panelSanPham.setBounds(301, 22, 375, 282);
//		getContentPane().add(panelSanPham);
//		panelSanPham.setLayout(new BorderLayout(0, 0));
//		tableCTHD.setEnabled(false);
//		
//		tableCTHD.setModel(tModelCTHD);
//		spCTHD = new JScrollPane();
//		panelSanPham.add(spCTHD);
//		
//		spCTHD.setViewportView(tableCTHD);
//		
//		tfMaHD = new JTextField(HoaDonGUI.danhSachHD.get(index).getMaPhieu());
//		tfMaHD.setEditable(false);
//		tfMaHD.setColumns(10);
//		tfMaHD.setBounds(122, 35, 55, 19);
//		getContentPane().add(tfMaHD);
//		
//		JLabel lbMaHD = new JLabel();
//		lbMaHD.setText("Mã hóa đơn");
//		lbMaHD.setBounds(10, 34, 87, 20);
//		getContentPane().add(lbMaHD);
//		
//		tfNgayLap = new JTextField(HoaDonGUI.danhSachHD.get(index).getNgayLap());
//		tfNgayLap.setEditable(false);
//		tfNgayLap.setColumns(10);
//		tfNgayLap.setBounds(122, 240, 150, 19);
//		getContentPane().add(tfNgayLap);
//				
//		setLocationRelativeTo(null);
//	}
//	
//	public void hienThiCTHD() {
//		try {
//			if(index >= 0) {
//				for (ChiTietPhieu ctp : HoaDonGUI.danhSachHD.get(index).getDSCT()) {
//					tModelCTHD.addRow(new Object [] {ctp.getSanPham().getMaSanPham(), ctp.getSanPham().getTenSanPham(),ctp.getSanPham().getGiaBan(),ctp.getSanPham().getSoLuong(),ctp.getThanhTien()});
//				}
//			}
//			
//		} catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//}
