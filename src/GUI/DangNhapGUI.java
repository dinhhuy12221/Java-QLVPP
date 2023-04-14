package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;

import BLL.DangNhapBLL;
import DTO.TaiKhoan;
import DTO.ChucVu;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class DangNhapGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfTenDangNhap;
	private JPasswordField tfMatKhau;

	/**
	 * Create the frame.
	 */
	public DangNhapGUI() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 387);
		setLocationRelativeTo(contentPane);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenDangNhap.setBounds(126, 102, 101, 31);
		contentPane.add(lblTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatKhau.setBounds(126, 159, 101, 31);
		contentPane.add(lblMatKhau);
		
		JLabel lblDangNhap = new JLabel("Đăng nhập");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDangNhap.setBounds(10, 29, 588, 31);
		contentPane.add(lblDangNhap);
		
		tfTenDangNhap = new JTextField();
		tfTenDangNhap.setBounds(267, 110, 164, 19);
		contentPane.add(tfTenDangNhap);
		tfTenDangNhap.setColumns(10);
		
		tfMatKhau = new JPasswordField();
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(267, 167, 164, 19);
		contentPane.add(tfMatKhau);
		
		// Button dang nhap
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDangNhap = tfTenDangNhap.getText();
				String matKhau = String.valueOf(tfMatKhau.getPassword());
				if (DangNhapBLL.isLogin(new TaiKhoan(tenDangNhap,"",new ChucVu(),matKhau,""))) {
					 JOptionPane.showMessageDialog(new DangNhapGUI(),"Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					 new GiaoDienGUI();
					 setVisible(false);
				}
				else{
					 JOptionPane.showMessageDialog(new DangNhapGUI(),"Đăng nhập thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDangNhap.setBounds(228, 230, 101, 31);
		contentPane.add(btnDangNhap);
	}
}
