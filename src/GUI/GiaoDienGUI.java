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
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.FlowLayout;
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
		setBounds(100, 100, 1276, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDanhMuc = new JPanel();
		panelDanhMuc.setBorder(null);
		panelDanhMuc.setBounds(0, 83, 186, 618);
		contentPane.add(panelDanhMuc);
		
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
		btnSanPham.setBorder(null);
		btnSanPham.setBackground(new Color(0, 153, 255));
		btnSanPham.setForeground(new Color(255, 255, 255));
		btnSanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSanPham.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSanPham.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				cl.show(panelGiaoDien, "SanPham");
			}
		});
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.setBorder(null);
		btnNhanVien.setBackground(new Color(0, 153, 255));
		btnNhanVien.setForeground(new Color(255, 255, 255));
		btnNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "NhanVien");
			}
		});
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.setBorder(null);
		btnKhachHang.setBackground(new Color(0, 153, 255));
		btnKhachHang.setForeground(new Color(255, 255, 255));
		btnKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "KhachHang");
			}
		});
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNhaCC = new JButton("NHÀ CUNG CẤP");
		btnNhaCC.setBorder(null);
		btnNhaCC.setBackground(new Color(0, 153, 255));
		btnNhaCC.setForeground(new Color(255, 255, 255));
		btnNhaCC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNhaCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "NhaCungCap");
			}
		});
		btnNhaCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnHoaDon = new JButton("HÓA ĐƠN");
		btnHoaDon.setBorder(null);
		btnHoaDon.setBackground(new Color(0, 153, 255));
		btnHoaDon.setForeground(new Color(255, 255, 255));
		btnHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "HoaDon");
			}
		});
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNhapHang = new JButton("NHẬP HÀNG");
		btnNhapHang.setBorder(null);
		btnNhapHang.setBackground(new Color(0, 153, 255));
		btnNhapHang.setForeground(new Color(255, 255, 255));
		btnNhapHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "PhieuNhap");
			}
		});
		btnNhapHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnXuatHang = new JButton("XUẤT HÀNG");
		btnXuatHang.setBorder(null);
		btnXuatHang.setBackground(new Color(0, 153, 255));
		btnXuatHang.setForeground(new Color(255, 255, 255));
		btnXuatHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXuatHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "PhieuXuat");
			}
		});
		btnXuatHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnTaiKhoan = new JButton("TÀI KHOẢN");
		btnTaiKhoan.setBorder(null);
		btnTaiKhoan.setBackground(new Color(0, 153, 255));
		btnTaiKhoan.setForeground(new Color(255, 255, 255));
		btnTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "TaiKhoan");
			}
		});
		btnTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.setBorder(null);
		btnThongKe.setBackground(new Color(0, 153, 255));
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelGiaoDien, "ThongKe");
			}
		});
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelDanhMuc.setLayout(new GridLayout(0, 1, 0, 0));
		
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
