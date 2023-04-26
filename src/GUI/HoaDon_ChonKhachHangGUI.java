package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.KhachHang;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HoaDon_ChonKhachHangGUI extends JFrame{

	private JPanel contentPane;
	private JTextField tfTimKiem;
	private DefaultTableModel tModelKHChon;
	private ArrayList<KhachHang> danhSachKH = new ArrayList<KhachHang>();


	/**
	 * Create the ChonKhachHangGUI.
	 */
	public HoaDon_ChonKhachHangGUI() {
		setTitle("Chọn khách hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton btnXn = new JButton("Xác nhận");
		btnXn.setBounds(40,270,92,30);
		JButton btnHy = new JButton("Hủy");
		btnHy.setBounds(186,270,92,30);
		
		JTable khChonTable = new JTable();
		tModelKHChon = new DefaultTableModel(new Object[][] {}, new String[] {"Mã khách hàng", "Tên khách hàng"});
		khChonTable.setModel(tModelKHChon);
		JScrollPane spChonSP = new JScrollPane();
		
		
		btnXn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexCKH = khChonTable.getSelectedRow();
				if(indexCKH >= 0) {
					HoaDonGUI.tfMaKH.setText(danhSachKH.get(indexCKH).getMa());
					HoaDonGUI.tfTenKH.setText(danhSachKH.get(indexCKH).getHoTen());
					dispose();
				}
			}
		});
		
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		getContentPane().add(btnXn);getContentPane().add(btnHy);
		
		spChonSP.setViewportView(khChonTable);
		spChonSP.setBounds(10,68,301,192);;
		getContentPane().add(spChonSP);
		setSize(335,350);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setBounds(10, 26, 57, 13);
		getContentPane().add(lblTimKiem);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setBounds(77, 23, 234, 19);
		getContentPane().add(tfTimKiem);
		tfTimKiem.setColumns(10);
		tfTimKiem.getDocument().addDocumentListener((new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemKH();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemKH();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemKH();	
			}
		}));
		
		setLocationRelativeTo(null);
		
		hienThiDSKH(BLL.KhachHangBLL.layDanhSachKhachHang());
	}
	
	private void hienThiDSKH(ArrayList<KhachHang> dskh) {
		danhSachKH = dskh;
		for(KhachHang kh: danhSachKH) {
			tModelKHChon.addRow(new Object[] {kh.getMa(),kh.getHoTen()});
		}
	}
	
	private void timKiemKH() {
		tModelKHChon.setRowCount(0);
		String tenKH = tfTimKiem.getText();
		if(!tenKH.equals("")) {
			for(KhachHang kh : danhSachKH) {
				if (kh.getHoTen().toUpperCase().contains(tenKH.toUpperCase())) {
					tModelKHChon.addRow(new Object[] {kh.getMa(),kh.getHoTen()});
				}
			}
		} else {
			hienThiDSKH(BLL.KhachHangBLL.layDanhSachKhachHang());
		}
	}
}
