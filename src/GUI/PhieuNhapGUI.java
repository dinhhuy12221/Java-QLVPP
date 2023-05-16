package GUI;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.table.*;

import DAL.NhaCungCapDAL;
import DAL.PhieuNhapDAL;

import java.util.*;
import DTO.PhieuNhap;
import DTO.TaiKhoan;
import DTO.ChiTietPhieu;
import DTO.NhaCungCap;
import DTO.NhanVien;
import GUI.PhieuNhap_KhungSanPhamGUI;
import com.toedter.calendar.JDateChooser;

public class PhieuNhapGUI extends JPanel {
	private JTextField textFieldMaPN;
	private JTextField textFieldTongtien;
	private JTextField textFieldtimmapn;
	private JTextField textFieldtimngaytao;
	
	private JTable DSPhieuNhap;
	public static JTable CTPhieuNhap;
	private DefaultTableModel modelDSPhieuNhap;
	private DefaultTableModel modelCTPhieuNhap;
	private JButton Buttonttpnxacnhan;
//	private JButton BtnXuatphieu;
	private JTextField textFieldMaNV;
	private JTextField tfCTPNMaSP;
	private JTextField tfCTPNDongia;
	private JTextField tfCTPNSoluong;
	private JTextField tfCTPNThanhtien;
	private String modexacnhan;
	
	JDateChooser dcNgayTao = new JDateChooser();
	SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	//của thêm phiếu nhập
	/*private JFrame f2;
	private JTable DSSanPhamDangCo;
	private DefaultTableModel modelDSSanPham;
	private JLabel jl;
	private JButton add,dell;*/
	//
	/**
	 * Create the panel.
	 */
	public PhieuNhapGUI(TaiKhoan taiKhoan) {
		setBackground(new Color(240, 240, 240));
		setSize(1269,679);
		setLayout(null);
				//KHUNG THÔNG TIN PHIẾU NHẬP
		JPanel panelttPhieuNhap = new JPanel();
		panelttPhieuNhap.setBorder(new TitledBorder(null, "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelttPhieuNhap.setBounds(10, 50, 398, 294);
		add(panelttPhieuNhap);
		panelttPhieuNhap.setLayout(null);
		
		//LABEL MÃ PHIẾU NHẬP
		JLabel LabelMaPN = new JLabel("Mã phiếu nhập:");
		LabelMaPN.setBounds(10, 20, 88, 15);
		LabelMaPN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelttPhieuNhap.add(LabelMaPN);
		
		//LABEL NGÀY TẠO
		JLabel LabelNgaytao = new JLabel("Ngày tạo:");
		LabelNgaytao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNgaytao.setBounds(10, 56, 88, 13);
		panelttPhieuNhap.add(LabelNgaytao);
		
		//LABEL TỔNG TIỀN
		JLabel LabelTongtien = new JLabel("Tổng tiền:");
		LabelTongtien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelTongtien.setBounds(10, 99, 68, 13);
		panelttPhieuNhap.add(LabelTongtien);
		
		//LABEL MÃ NHÂN VIÊN
		JLabel LabelMaNV = new JLabel("Nhân viên phụ trách:");
		LabelMaNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelMaNV.setBounds(10, 140, 120, 13);
		panelttPhieuNhap.add(LabelMaNV);
		
		//TEXTFIELD MÃ NHÂN VIÊN
		textFieldMaNV = new JTextField(taiKhoan.getTenDangNhap());
		textFieldMaNV.setEditable(false);
		textFieldMaNV.setBounds(131, 140, 144, 19);
		panelttPhieuNhap.add(textFieldMaNV);
		textFieldMaNV.setColumns(10);
		
		//TEXTFIELD MÃ PHIẾU NHẬP
		textFieldMaPN = new JTextField();
		textFieldMaPN.setEditable(false);
		textFieldMaPN.setBounds(110, 20, 165, 19);
		panelttPhieuNhap.add(textFieldMaPN);
		textFieldMaPN.setColumns(10);
		
		//TEXTFIELD TỔNG TIỀN
		textFieldTongtien = new JTextField();
		textFieldTongtien.setText("0");
		textFieldTongtien.setEditable(false);
		textFieldTongtien.setBounds(110, 99, 165, 19);
		panelttPhieuNhap.add(textFieldTongtien);
		textFieldTongtien.setColumns(10);
		
		//BUTTON XÁC NHẬN TẠO/SỬA THÔNG TIN PHIẾU NHẬP VÀ SỰ KIỆN
		Buttonttpnxacnhan = new JButton("Xác nhận");
		Buttonttpnxacnhan.setEnabled(false);
		Buttonttpnxacnhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Buttonttpnxacnhan.setBounds(137, 224, 122, 42);
		panelttPhieuNhap.add(Buttonttpnxacnhan);
		Buttonttpnxacnhan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xacnhanttPhieuNhap(evt,taiKhoan);
			}
		});
		
		//BUTTON XUẤT PHIẾU NHẬP
//		BtnXuatphieu = new JButton("Xuất phiếu");
//		BtnXuatphieu.setEnabled(false);
//		BtnXuatphieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		BtnXuatphieu.setBounds(211, 226, 127, 41);
//		panelttPhieuNhap.add(BtnXuatphieu);
		
		dcNgayTao.setEnabled(false);
		dcNgayTao.setDateFormatString("dd-MM-yyyy HH:mm");
		dcNgayTao.setDate(Calendar.getInstance().getTime());
//		dcNgayTao.setMaxSelectableDate(Calendar.getInstance().getTime());
		dcNgayTao.setBounds(108, 56, 167, 20);
		panelttPhieuNhap.add(dcNgayTao);
		
//		BtnXuatphieu.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				xuatttPhieuNhap(evt);
//			}
//		});
		
		
		
				//KHUNG QUẢN LÝ PHIẾU NHẬP
		JPanel panelQLphieunhap = new JPanel();
		panelQLphieunhap.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Qu\u1EA3n l\u00FD phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelQLphieunhap.setBounds(10, 351, 398, 106);
		add(panelQLphieunhap);
		panelQLphieunhap.setLayout(new GridLayout(0, 1, 0, 0));
		
		//BUTTON TẠO PHIẾU NHẬP
		JButton ButtonTao = new JButton("Tạo phiếu nhập");
		ButtonTao.setIcon(new ImageIcon("image/icon/plus.png"));
		ButtonTao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLphieunhap.add(ButtonTao);
		ButtonTao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				themPhieuNhap(evt, taiKhoan);
			}
		});
		
		//BUTTON XUẤT DANH SÁCH PHIẾU NHẬP
//		JButton ButtonXuatds = new JButton("Xuất danh sách phiếu nhập");
//		ButtonXuatds.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		panelQLphieunhap.add(ButtonXuatds);
//		ButtonXuatds.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				xuatdsPhieuNhap(evt);
//			}
//		});
		
				//KHUNG BẢNG DANH SÁCH PHIẾU NHẬP
		JPanel panelDSphieu = new JPanel();
		panelDSphieu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDSphieu.setBounds(418, 50, 841, 241);
		add(panelDSphieu);
		panelDSphieu.setLayout(new GridLayout(0, 1, 0, 0));
		
		//SCROLLPANE VÀ BẢNG CỦA DANH SÁCH PHIẾU NHẬP
		JScrollPane scrollPaneDSphieu = new JScrollPane();
		scrollPaneDSphieu.setEnabled(false);
		panelDSphieu.add(scrollPaneDSphieu);
		
		DSPhieuNhap=new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DSPhieuNhap.getTableHeader().setReorderingAllowed(false);
		DSPhieuNhap.setRowHeight(30);
		DSPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		modelDSPhieuNhap=new DefaultTableModel();
		modelDSPhieuNhap.addColumn("Mã phiếu nhập");
		modelDSPhieuNhap.addColumn("Mã nhân viên");
		modelDSPhieuNhap.addColumn("Ngày tạo");
		modelDSPhieuNhap.addColumn("Tổng tiền");
		DSPhieuNhap.setModel(modelDSPhieuNhap);
		scrollPaneDSphieu.setViewportView(DSPhieuNhap);
		
		DSPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				chonPhieuNhap(evt);
			}
		});
		
				//KHUNG BẢNG CHI TIẾT PHIẾU NHẬP
		JPanel panelCTphieu = new JPanel();
		panelCTphieu.setBorder(new TitledBorder(null, "Chi ti\u1EBFt phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCTphieu.setBounds(418, 297, 841, 212);
		add(panelCTphieu);
		panelCTphieu.setLayout(new GridLayout(0, 1, 0, 0));
		
		//SCROLLPANE VÀ BẢNG CỦA CHI TIẾT PHIẾU NHẬP
		JScrollPane scrollPaneCTphieu = new JScrollPane();
		scrollPaneCTphieu.setEnabled(false);
		panelCTphieu.add(scrollPaneCTphieu);
		
		CTPhieuNhap=new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		CTPhieuNhap.getTableHeader().setReorderingAllowed(false);
		CTPhieuNhap.setRowHeight(30);
		CTPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		modelCTPhieuNhap=new DefaultTableModel();
		modelCTPhieuNhap.addColumn("Mã sản phẩm");
		modelCTPhieuNhap.addColumn("Đơn giá");
		modelCTPhieuNhap.addColumn("Số lượng");
		modelCTPhieuNhap.addColumn("Thành tiền");
		CTPhieuNhap.setModel(modelCTPhieuNhap);
		scrollPaneCTphieu.setViewportView(CTPhieuNhap);
		
		CTPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				chonchitietphieunhap(evt);
			}
			
		});
		
				//KHUNG TÌM KIẾM PHIẾU NHẬP
		JPanel panelTimphieu = new JPanel();
		panelTimphieu.setBorder(new TitledBorder(null, "T\u00ECm phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimphieu.setBounds(10, 520, 398, 106);
		add(panelTimphieu);
		panelTimphieu.setLayout(null);
		
		//LABEL TÌM THEO MÃ PHIẾU NHẬP
		JLabel LabelMaPN1 = new JLabel("Mã phiếu nhập:");
		LabelMaPN1.setBounds(10, 25, 81, 15);
		LabelMaPN1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTimphieu.add(LabelMaPN1);
		
		//LABEL TÌM THEO NGÀY TẠO
		JLabel LabelNgaytao1 = new JLabel("Ngày tạo:");
		LabelNgaytao1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNgaytao1.setBounds(10, 60, 88, 13);
		panelTimphieu.add(LabelNgaytao1);
		
		//TEXTFIELD CHO TÌM THEO MÃ PHIẾU NHẬP VÀ NGÀY TẠO
		textFieldtimmapn = new JTextField();
		textFieldtimmapn.setBounds(101, 24, 138, 19);
		panelTimphieu.add(textFieldtimmapn);
		textFieldtimmapn.setColumns(10);
		
		textFieldtimngaytao = new JTextField();
		textFieldtimngaytao.setBounds(101, 58, 138, 19);
		panelTimphieu.add(textFieldtimngaytao);
		textFieldtimngaytao.setColumns(10);
		
		//BUTTON XÁC NHẬN TÌM KIẾM
		JButton ButtonTim = new JButton("Xác nhận");
		ButtonTim.setIcon(new ImageIcon("image/icon/check-mark.png"));
		ButtonTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonTim.setBounds(271, 23, 117, 50);
		panelTimphieu.add(ButtonTim);
		
		ButtonTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xacnhantimkiemPhieuNhap(evt);
			}
		});
		
		//BUTTON REFRESH
		JButton Buttonttpnrefresh = new JButton("Refresh");
		Buttonttpnrefresh.setIcon(new ImageIcon("image/icon/refresh.png"));
		Buttonttpnrefresh.setBounds(10, 468, 102, 42);
		add(Buttonttpnrefresh);
		Buttonttpnrefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Buttonttpnrefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				refreshPN(taiKhoan);
			}
		});
		
				//KHUNG CHỈNH SỬA CHI TIẾT PHIẾU
		JPanel panelChiTietPhieu = new JPanel();
		panelChiTietPhieu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChiTietPhieu.setBounds(418, 520, 452, 106);
		add(panelChiTietPhieu);
		panelChiTietPhieu.setLayout(null);
		
		//LABEL MÃ SẢN PHẨM
		JLabel labelCTPNMaSP = new JLabel("Mã sản phẩm:");
		labelCTPNMaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCTPNMaSP.setBounds(10, 20, 83, 13);
		panelChiTietPhieu.add(labelCTPNMaSP);
		
		//LABEL ĐƠN GIÁ
		JLabel labelCTPNDongia = new JLabel("Đơn giá:");
		labelCTPNDongia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCTPNDongia.setBounds(230, 21, 45, 13);
		panelChiTietPhieu.add(labelCTPNDongia);
		
		//LABEL SỐ LƯỢNG SẢN PHẨM
		JLabel labelCTPNSoluong = new JLabel("Số lượng:");
		labelCTPNSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCTPNSoluong.setBounds(10, 50, 56, 13);
		panelChiTietPhieu.add(labelCTPNSoluong);
		
		//LABEL THÀNH TIỀN
		JLabel labelCTPNThanhTien = new JLabel("Thành tiền:");
		labelCTPNThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCTPNThanhTien.setBounds(230, 51, 70, 13);
		panelChiTietPhieu.add(labelCTPNThanhTien);
		
		//TEXTFIELD MÃ SẢN PHẨM
		tfCTPNMaSP = new JTextField();
		tfCTPNMaSP.setEditable(false);
		tfCTPNMaSP.setBounds(89, 18, 120, 19);
		panelChiTietPhieu.add(tfCTPNMaSP);
		tfCTPNMaSP.setColumns(10);
		
		//TEXTFIELD ĐƠN GIÁ
		tfCTPNDongia = new JTextField();
		tfCTPNDongia.setEditable(false);
		tfCTPNDongia.setBounds(302, 18, 129, 19);
		panelChiTietPhieu.add(tfCTPNDongia);
		tfCTPNDongia.setColumns(10);
		
		//TEXTFIELD SỐ LƯỢNG SẢN PHẨM
		tfCTPNSoluong = new JTextField();
		tfCTPNSoluong.setEditable(false);
		tfCTPNSoluong.setBounds(89, 47, 120, 19);
		panelChiTietPhieu.add(tfCTPNSoluong);
		tfCTPNSoluong.setColumns(10);
		
		//TEXTFIELD THÀNH TIỀN CỦA SẢN PHẨM
		tfCTPNThanhtien = new JTextField();
		tfCTPNThanhtien.setEditable(false);
		tfCTPNThanhtien.setBounds(302, 48, 129, 19);
		panelChiTietPhieu.add(tfCTPNThanhtien);
		tfCTPNThanhtien.setColumns(10);
//		btnSuaSP.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				suachitietphieunhap(evt);
//			}
//		});
		
		
		//LOAD PHIẾU NHẬP///////////////////////////////////
		loadphieunhap();
		////////////////////////////////////////////////////
		
	}
	
	
	
	
	
	
	
	
			//PHẦN HÀM VÀ CHỨC NĂNG SỰ KIỆN
	//HÀM NẠP CSDL VÀO BẢNG PHIEUNHAP
	private void loadphieunhap() {
		ArrayList<PhieuNhap> arr = new ArrayList<PhieuNhap>();
		arr = PhieuNhapDAL.laydanhsachphieunhap();
		
		for(int i=0;i< arr.size();i++) {
			PhieuNhap pn = arr.get(i);
			
			String mapn = pn.getMaPhieu();
			String manv = pn.getNhanVien().getMa();
			String ngaytao = pn.getNgayLap();
			double tongtien = pn.getTongTien();
			Object[] row = {mapn,manv,ngaytao,tongtien};
			modelDSPhieuNhap.addRow(row);
		}
	}
	
	//LOAD CHI TIẾT PHIẾU NHẬP
	private void loadchitietphieunhap(String mapn) {
		ArrayList<ChiTietPhieu> arr = new ArrayList<ChiTietPhieu>();
		arr = PhieuNhapDAL.laychitietphieunhap(mapn);
		
		for(int i=0;i<arr.size();i++) {
			ChiTietPhieu ctpn = arr.get(i);
			
			//String mpn = ctpn.getMaPhieu();
			String masp = ctpn.getSanPham().getMaSanPham();
			Double dongia = ctpn.getSanPham().getGiaNhap();
			int soluong = ctpn.getSanPham().getSoLuong();
			Double thanhtien = ctpn.getThanhTien();
			Object[] row = {masp,dongia,soluong,thanhtien};
			modelCTPhieuNhap.addRow(row);
		}
	}
	
	
	//HÀM NÚT XÁC NHẬN TẠO/SỬA THÔNG TIN PHIẾU NHẬP VÀ SỰ KIỆN
	private void xacnhanttPhieuNhap(ActionEvent evt, TaiKhoan taiKhoan) {
		String mapn = textFieldMaPN.getText();
		String manv = taiKhoan.getTenDangNhap();
		String ngaytao = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		if(dcNgayTao.getDate() != null) {
			try {
				ngaytao = sdf.format(dcNgayTao.getDate());
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		Double tongtien = Double.valueOf(textFieldTongtien.getText());
		NhanVien nv = new NhanVien();
		nv.setMa(manv);
		PhieuNhap pn = new PhieuNhap(mapn,nv,null,ngaytao,tongtien);
		
		if(	 //HÀM TRIM() XÓA HẾT KHOẢNG TRẮNG
			textFieldMaPN.getText().trim().equals("") ||
			textFieldMaNV.getText().trim().equals("") ||
			dcNgayTao.getDate() == null ||
			textFieldTongtien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
		}
		else {
			if(modexacnhan=="them") {
				PhieuNhap_KhungSanPhamGUI themsp = new PhieuNhap_KhungSanPhamGUI(pn);
				themsp.setVisible(true); 
			}
			if(modexacnhan=="sua") {
				if(PhieuNhapDAL.suaphieunhap(pn))
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				else
					JOptionPane.showMessageDialog(this, "Sửa thành công");
			}
		}
		refreshPN(taiKhoan);
	}
	
	
	
	//HÀM NÚT XUẤT THÔNG TIN PHIẾU NHẬP
//	private void xuatttPhieuNhap(ActionEvent evt) {
//		JOptionPane.showMessageDialog(this, "Xuất phiếu...tít.títt.tít");
//		refreshPN();
//	}
	
	//HÀM RESET THÔNG TIN PHIẾU NHẬP
	private void refreshPN(TaiKhoan taiKhoan) {
		textFieldMaPN.setText(BLL.PhieuNhapBLL.taomaphieunhap());
		dcNgayTao.setDate(Calendar.getInstance().getTime());
		textFieldTongtien.setText("0");
		
		textFieldtimmapn.setText("");
		textFieldtimngaytao.setText("");
		//CHO NÚT XÁC NHẬN VÀ XUẤT PHIẾU TRỞ LẠI THÀNH FALSE
		Buttonttpnxacnhan.setEnabled(false);
//		BtnXuatphieu.setEnabled(false);
		//CLEAR BẢNG PHIẾU NHẬP
		modelDSPhieuNhap.setRowCount(0);
		loadphieunhap();
		//CLEAR BẢNG CHI TIẾT PHIẾU NHẬP
		modelCTPhieuNhap.setRowCount(0);
		//chỉnh tooltip
		chinhtooltip(0);
		//chỉnh trạng thái jtextfield
		chinhtrangthainhap(0);
		//chỉnh trạng thái bảng chỉnh sửa chi tiết phiếu nhập
//		trangthainhapcuachinhsua(0);
	}
	
	//HÀM SETTOOLTIPTEXT CHO Ô JTEXTFIELD CỦA THÔNG TIN PHIẾU NHẬP
	public void chinhtooltip(int i) {
		if(i==1) {	//TẠO TOOLTIP
			//tạo ghi chú cho nó ghi dòng quá dài
			textFieldMaPN.setToolTipText(textFieldMaPN.getText());
			textFieldTongtien.setToolTipText(textFieldTongtien.getText());
			textFieldMaNV.setToolTipText(textFieldMaNV.getText());
		}else {
			//tạo ghi chú cho nó ghi dòng quá dài
			textFieldMaPN.setToolTipText(null);
			textFieldTongtien.setToolTipText(null);
			textFieldMaNV.setToolTipText(null);
		}
	}
		
	//HÀM CHỈNH TRẠNG THÁI CHO Ô JTEXTFIELD CỦA THÔNG TIN PHIẾU NHẬP
	public void chinhtrangthainhap(int i) {
		if(i==1) {
//			textFieldMaNCC.setEditable(true);
			dcNgayTao.setEnabled(true);
			DSPhieuNhap.setEnabled(false);
//			textFieldMaNV.setEditable(true);
//			textFieldTongtien.setEditable(true);
		} else {
//			textFieldMaNCC.setEditable(false);
			dcNgayTao.setEnabled(false);
			DSPhieuNhap.setEnabled(true);
//			textFieldMaNV.setEditable(false);
//			textFieldTongtien.setEditable(false);
		}
	}
	
	//HÀM NÚT TẠO/THÊM PHIẾU NHẬP
	private void themPhieuNhap(ActionEvent evt, TaiKhoan taiKhoan) {
		chinhtrangthainhap(1);
		Buttonttpnxacnhan.setEnabled(true);
//		BtnXuatphieu.setEnabled(true);
		textFieldMaPN.setText(BLL.PhieuNhapBLL.taomaphieunhap());
		textFieldMaNV.setText(taiKhoan.getTenDangNhap());
		textFieldTongtien.setText("0");
		modexacnhan="them";
		
		//bảng chỉnh sửa chi tiết
//		trangthainhapcuachinhsua(0);
	}
	
	//HÀM NÚT XUẤT DS PHIẾU NHẬP
	private void xuatdsPhieuNhap(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Xuất danh sách..tít.tít.tít.tít");
	}
	
	//HÀM SỰ KIỆN KHI CLICK VÀO BẢNG DS PHIẾU NHẬP
	private void chonPhieuNhap(MouseEvent evt) {
		modelCTPhieuNhap.setRowCount(0);
		int i = DSPhieuNhap.getSelectedRow();
		if(i>=0) {//nếu có dòng tồn tại thì làm
			textFieldMaPN.setText(modelDSPhieuNhap.getValueAt(i, 0).toString());
			textFieldMaNV.setText(modelDSPhieuNhap.getValueAt(i, 1).toString());
			Date d1 = null;
			try {
				d1 = d.parse(modelDSPhieuNhap.getValueAt(i, 2) + "");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dcNgayTao.setDate(d1);
			textFieldTongtien.setText(modelDSPhieuNhap.getValueAt(i, 3).toString());
			chinhtooltip(1);
			
			if(CTPhieuNhap.getRowCount()>=0) {
				loadchitietphieunhap(modelDSPhieuNhap.getValueAt(i, 0).toString());
			}
		}
//		BtnXuatphieu.setEnabled(true);
	}
	
	//HÀM SỰ KIỆN KHI CLICK VÀO BẢNG CT PHIẾU NHẬP
	private void chonchitietphieunhap(MouseEvent evt) {
		int i = CTPhieuNhap.getSelectedRow();
		if(i>=0) {
			tfCTPNMaSP.setText(modelCTPhieuNhap.getValueAt(i, 0).toString());
			tfCTPNDongia.setText(modelCTPhieuNhap.getValueAt(i, 1).toString());
			tfCTPNSoluong.setText(modelCTPhieuNhap.getValueAt(i, 2).toString());
			tfCTPNThanhtien.setText(modelCTPhieuNhap.getValueAt(i, 3).toString());
		}
	}
	
	//HÀM NÚT XÁC NHẬN TÌM KIẾM
	private void xacnhantimkiemPhieuNhap(ActionEvent evt) {
		modelDSPhieuNhap.setRowCount(0);	//XÓA TOÀN BỘ DÒNG TRONG DANH SÁCH CÓ XÀI CÁI MODEL NÀY
		modelCTPhieuNhap.setRowCount(0);
		//tạo 1 danh sách bao gồm thứ được chọn
		String mapn = textFieldtimmapn.getText();
		String ngaytao = textFieldtimngaytao.getText();
		ArrayList<PhieuNhap> arr =new ArrayList<PhieuNhap>();
		arr = PhieuNhapDAL.timkiemphieunhap(mapn, ngaytao);
		
		for(int i=0;i<arr.size();i++) {
			PhieuNhap pn = arr.get(i);
			
			String ma_pn = pn.getMaPhieu();
			String ma_nv = pn.getNhanVien().getMa();
			String ngay_tao = pn.getNgayLap();
			double tong_tien = pn.getTongTien();
			Object[] row = {ma_pn,ma_nv,ngay_tao,tong_tien};
			modelDSPhieuNhap.addRow(row);
		}
		loadchitietphieunhap(mapn);
	}
	
	
	
	
	//HÀM CHỈNH TRẠNG THÁI CỦA JTEXTFIELD VÀ BUTTON CỦA CHỈNH SỬA CHI TIẾT PHIẾU NHẬP
//	private void trangthainhapcuachinhsua(int i) {
//		if(i==1) {
//			btnSuaSP.setEnabled(true);
//		} else {
//			btnSuaSP.setEnabled(false);
//		}
//	}
	//HÀM THÊM VÀ SỬA CHI TIẾT SẢN PHẨM
//	public void suachitietphieunhap(ActionEvent evt) {
//		PhieuNhap_KhungSanPhamGUI themsp = new PhieuNhap_KhungSanPhamGUI(textFieldMaPN.getText());
//		themsp.setVisible(true);
//	}
}
