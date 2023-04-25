package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import DTO.TaiKhoan;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class GiaoDienGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GiaoDienGUI(TaiKhoan taiKhoan) {
		setResizable(false);
		setTitle("Giao diện quản lý");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDanhMuc = new JPanel();
		panelDanhMuc.setBorder(new TitledBorder(null, "DANH M\u1EE4C", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelDanhMuc.setBounds(10, 10, 167, 585);
		contentPane.add(panelDanhMuc);
		panelDanhMuc.setLayout(null);
		
		JPanel panelGiaoDien = new JPanel();
		panelGiaoDien.setSize(new Dimension(1082,689));
		panelGiaoDien.setBounds(187, 10, 1082,689);
		contentPane.add(panelGiaoDien);
		panelGiaoDien.setLayout(null);
		
		CardLayout cl = new CardLayout();
		panelGiaoDien.setLayout(cl);
		panelGiaoDien.add(new JPanel());
		panelGiaoDien.add(new SanPhamGUI(), "SanPham");
		panelGiaoDien.add(new NhanVienGUI(), "NhanVien");
		panelGiaoDien.add(new KhachHangGUI(), "KhacHang");
		panelGiaoDien.add(new NhaCungCapGUI(), "NhaCungCap");
		panelGiaoDien.add(new HoaDonGUI(), "HoaDon");
		panelGiaoDien.add(new PhieuNhapGUI(), "PhieuNhap");
		panelGiaoDien.add(new PhieuXuatGUI(), "PhieuXuat");
		panelGiaoDien.add(new TaiKhoanGUI(), "TaiKhoan");
		panelGiaoDien.add(new ThongKeGUI(), "ThongKe");
		
		JButton btnSanPham = new JButton("SẢN PHẨM");
		btnSanPham.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				cl.show(panelGiaoDien, "SanPham");
			}
		});
		btnSanPham.setBounds(10, 23, 147, 43);
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "NhanVien");
			}
		});
		btnNhanVien.setBounds(10, 76, 147, 43);
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "KhachHang");
			}
		});
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhachHang.setBounds(10, 129, 147, 43);
		
		JButton btnNhaCC = new JButton("NHÀ CUNG CẤP");
		btnNhaCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "NhaCungCap");
			}
		});
		btnNhaCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhaCC.setBounds(10, 182, 147, 43);
		
		JButton btnHoaDon = new JButton("HÓA ĐƠN");
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "HoaDon");
			}
		});
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoaDon.setBounds(10, 238, 147, 43);
		
		JButton btnNhapHang = new JButton("NHẬP HÀNG");
		btnNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "PhieuNhap");
			}
		});
		btnNhapHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhapHang.setBounds(10, 296, 147, 43);
		
		JButton btnXuatHang = new JButton("XUẤT HÀNG");
		btnXuatHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "PhieuXuat");
			}
		});
		btnXuatHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatHang.setBounds(10, 353, 147, 43);
		
		JButton btnTaiKhoan = new JButton("TÀI KHOẢN");
		btnTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "TaiKhoan");
			}
		});
		btnTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTaiKhoan.setBounds(10, 412, 147, 43);
		
		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "ThongKe");
			}
		});
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThongKe.setBounds(10, 472, 147, 43);
		
//		if("BANHANG".equals(taiKhoan.getChucVu().getMaChucVu())) {
//			panelDanhMuc.add(btnKhachHang);
//			panelDanhMuc.add(btnHoaDon);
//		} else if("THUKHO".equals(taiKhoan.getChucVu().getMaChucVu())) {
//			panelDanhMuc.add(btnSanPham);
//			panelDanhMuc.add(btnNhapHang);
//			panelDanhMuc.add(btnXuatHang);
//		} else if("QUANLY".equals(taiKhoan.getChucVu().getMaChucVu())) {
//			panelDanhMuc.add(btnSanPham);
//			panelDanhMuc.add(btnNhanVien);
//			panelDanhMuc.add(btnKhachHang);
//			panelDanhMuc.add(btnNhaCC);
//			panelDanhMuc.add(btnHoaDon);
//			panelDanhMuc.add(btnNhapHang);
//			panelDanhMuc.add(btnXuatHang);
//			panelDanhMuc.add(btnTaiKhoan);
//			panelDanhMuc.add(btnThongKe);
//		}
		
		panelDanhMuc.add(btnSanPham);
		panelDanhMuc.add(btnNhanVien);
		panelDanhMuc.add(btnKhachHang);
		panelDanhMuc.add(btnNhaCC);
		panelDanhMuc.add(btnHoaDon);
		panelDanhMuc.add(btnNhapHang);
		panelDanhMuc.add(btnXuatHang);
		panelDanhMuc.add(btnTaiKhoan);
		panelDanhMuc.add(btnThongKe);
	}
}
