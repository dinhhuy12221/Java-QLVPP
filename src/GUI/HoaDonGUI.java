package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
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

public class HoaDonGUI extends JPanel {
	private JTable tableDSHD;
	private DefaultTableModel tableModelDSHD;
	private JTextField tfMaKhachHang;
	private JTextField tfTenKhachHang;
	private JTextField textField;
	private JTextField textField_1;
	
	private DatePicker datePicker;
	private JTable tableSanPham;

	/**
	 * Create the panel.
	 */
	public HoaDonGUI() {
		setSize(880,634);
		setLayout(null);
		
		JLabel lblQunLHa = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLHa.setBounds(10, 10, 860, 28);
		add(lblQunLHa);
		
		JPanel panelDanhSachHD = new JPanel();
		panelDanhSachHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDanhSachHD.setBounds(10, 381, 853, 243);
		add(panelDanhSachHD);
		panelDanhSachHD.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPaneDSHD = new JScrollPane();
		scrollPaneDSHD.setEnabled(false);
		scrollPaneDSHD.enableInputMethods(false);
		panelDanhSachHD.add(scrollPaneDSHD);
		
		tableModelDSHD = new DefaultTableModel(new Object[][] {}, new String[] {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày lập", "Tổng tiền"});
		tableDSHD = new JTable();
		tableDSHD.setModel(tableModelDSHD);
		scrollPaneDSHD.setViewportView(tableDSHD);
		
		JPanel panelThongTinHD = new JPanel();
		panelThongTinHD.setLayout(null);
		panelThongTinHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin l\u1EADp h\u00F3a \u0111\u01A1n", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTinHD.setBounds(384, 48, 276, 225);
		add(panelThongTinHD);
		
		JLabel lblMaKhachHang = new JLabel("Mã khách hàng");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaKhachHang.setBounds(10, 78, 98, 19);
		panelThongTinHD.add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKhachHang.setBounds(10, 107, 98, 19);
		panelThongTinHD.add(lblTenKhachHang);
		
		tfMaKhachHang = new JTextField();
		tfMaKhachHang.setEditable(false);
		tfMaKhachHang.setColumns(10);
		tfMaKhachHang.setBounds(118, 79, 132, 19);
		panelThongTinHD.add(tfMaKhachHang);
		
		tfTenKhachHang = new JTextField();
		tfTenKhachHang.setEditable(false);
		tfTenKhachHang.setColumns(10);
		tfTenKhachHang.setBounds(118, 108, 132, 19);
		panelThongTinHD.add(tfTenKhachHang);
		
		JLabel lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgayLap.setBounds(10, 195, 104, 19);
		panelThongTinHD.add(lblNgayLap);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaNhanVien.setBounds(10, 136, 98, 19);
		panelThongTinHD.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenNhanVien.setBounds(10, 165, 98, 19);
		panelThongTinHD.add(lblTenNhanVien);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(118, 137, 132, 19);
		panelThongTinHD.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(118, 166, 132, 19);
		panelThongTinHD.add(textField_1);
		
		JButton btnChonKhachHang = new JButton("Chọn khách hàng\r\n");
		btnChonKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonKhachHang.setBounds(10, 23, 98, 28);
		panelThongTinHD.add(btnChonKhachHang);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(670, 48, 116, 120);
		add(panel);
		panel.setLayout(null);
		
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBounds(10, 24, 99, 36);
		panel.add(btnLapHoaDon);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(10, 71, 99, 36);
		panel.add(btnHuy);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 48, 364, 254);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPaneSanPham = new JScrollPane();
		scrollPaneSanPham.setBounds(6, 15, 352, 204);
		panel_1.add(scrollPaneSanPham);
		
		tableSanPham = new JTable();
		tableSanPham.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
			}
		));
		scrollPaneSanPham.setViewportView(tableSanPham);
		
		JButton btnxoaSanPham = new JButton("Xóa sản phẩm");
		btnxoaSanPham.setBounds(121, 225, 95, 19);
		panel_1.add(btnxoaSanPham);
		btnxoaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setBounds(16, 225, 95, 19);
		panel_1.add(btnThemSP);
		btnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 9));
	}
}
