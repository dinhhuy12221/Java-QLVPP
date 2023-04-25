//package GUI;
//
//import javax.swing.JPanel;
//
//public class PhieuNhapGUI extends JPanel {
//
//	/**
//	 * Create the panel.
//	 */
//	public PhieuNhapGUI() {
//		setSize(880,585);
//		setLayout(null);
//	}
//
//}

package GUI;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

import BLL.PhieuNhapBLL;
import DAL.PhieuNhapDAL;

import java.util.*;
import DTO.PhieuNhap;
import DTO.SanPham;
import DTO.ChiTietPhieu;
import DTO.NhaCungCap;
import DTO.NhanVien;

public class PhieuNhapGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaPN;
	private JTextField textFieldMaNCC;
	private JTextField textFieldNgaytao;
	private JTextField textFieldTongtien;
	private JTextField textFieldtimmapn;
	private JTextField textFieldtimngaytao;
	
	private JTable DSPhieuNhap;
	private JTable CTPhieuNhap;
	private DefaultTableModel modelDSPhieuNhap;
	private DefaultTableModel modelCTPhieuNhap;
	private JButton Buttonttpnxacnhan;
	private JButton Buttonttpnxuat;
	private JTextField textFieldMaNV;
	private JTextField tfCTPNMaSP;
	private JTextField tfCTPNDongia;
	private JTextField tfCTPNSoluong;
	private JTextField tfCTPNThanhtien;
	private String modexacnhan;

	private JButton btnThemSP, btnXoaSP, btnSuaSP, btnOKSP;
	/**
	 * Create the panel.
	 */
	public PhieuNhapGUI() {
		setSize(1082,689);
		setLayout(null);
		
				//TIÊU ĐỀ
		JLabel LabelTieuDe = new JLabel("PHIẾU NHẬP");
		LabelTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		LabelTieuDe.setBounds(330, 15, 206, 46);
		add(LabelTieuDe);
				//KHUNG THÔNG TIN PHIẾU NHẬP
		JPanel panelttPhieuNhap = new JPanel();
		panelttPhieuNhap.setBorder(new TitledBorder(null, "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelttPhieuNhap.setBounds(10, 50, 398, 192);
		add(panelttPhieuNhap);
		panelttPhieuNhap.setLayout(null);
		
		//LABEL MÃ PHIẾU NHẬP
		JLabel LabelMaPN = new JLabel("Mã phiếu nhập:");
		LabelMaPN.setBounds(10, 20, 88, 15);
		LabelMaPN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelttPhieuNhap.add(LabelMaPN);
		
		//LABEL MÃ NHÀ CUNG CẤP
		JLabel LabelMaNCC = new JLabel("Mã nhà cung cấp:");
		LabelMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelMaNCC.setBounds(10, 50, 105, 13);
		panelttPhieuNhap.add(LabelMaNCC);
		
		//LABEL NGÀY TẠO
		JLabel LabelNgaytao = new JLabel("Ngày tạo:");
		LabelNgaytao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNgaytao.setBounds(10, 80, 88, 13);
		panelttPhieuNhap.add(LabelNgaytao);
		
		//LABEL TỔNG TIỀN
		JLabel LabelTongtien = new JLabel("Tổng tiền:");
		LabelTongtien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelTongtien.setBounds(10, 110, 68, 13);
		panelttPhieuNhap.add(LabelTongtien);
		
		//LABEL MÃ NHÂN VIÊN
		JLabel LabelMaNV = new JLabel("Nhân viên phụ trách:");
		LabelMaNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelMaNV.setBounds(10, 140, 120, 13);
		panelttPhieuNhap.add(LabelMaNV);
		
		//TEXTFIELD MÃ NHÂN VIÊN
		textFieldMaNV = new JTextField();
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
		
		//TEXTFIELD MÃ NHÀ CC
		textFieldMaNCC = new JTextField();
		textFieldMaNCC.setEditable(false);
		textFieldMaNCC.setBounds(110, 50, 165, 19);
		panelttPhieuNhap.add(textFieldMaNCC);
		textFieldMaNCC.setColumns(10);
		
		//TEXTFIELD NGÀY TẠO
		textFieldNgaytao = new JTextField();
		textFieldNgaytao.setEditable(false);
		textFieldNgaytao.setBounds(110, 80, 165, 19);
		panelttPhieuNhap.add(textFieldNgaytao);
		textFieldNgaytao.setColumns(10);
		
		//TEXTFIELD TỔNG TIỀN
		textFieldTongtien = new JTextField();
		textFieldTongtien.setEditable(false);
		textFieldTongtien.setBounds(110, 110, 165, 19);
		panelttPhieuNhap.add(textFieldTongtien);
		textFieldTongtien.setColumns(10);
		
		//BUTTON XÁC NHẬN TẠO/SỬA THÔNG TIN PHIẾU NHẬP VÀ SỰ KIỆN
		Buttonttpnxacnhan = new JButton("Xác nhận");
		Buttonttpnxacnhan.setEnabled(false);
		Buttonttpnxacnhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Buttonttpnxacnhan.setBounds(285, 30, 105, 42);
		panelttPhieuNhap.add(Buttonttpnxacnhan);
		Buttonttpnxacnhan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xacnhanttPhieuNhap(evt);
			}
		});
		
		//BUTTON XUẤT PHIẾU NHẬP
		Buttonttpnxuat = new JButton("Xuất phiếu");
		Buttonttpnxuat.setEnabled(false);
		Buttonttpnxuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Buttonttpnxuat.setBounds(285, 70, 105, 41);
		panelttPhieuNhap.add(Buttonttpnxuat);
		
		Buttonttpnxuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xuatttPhieuNhap(evt);
			}
		});
		
		
		
				//KHUNG QUẢN LÝ PHIẾU NHẬP
		JPanel panelQLphieunhap = new JPanel();
		panelQLphieunhap.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Qu\u1EA3n l\u00FD phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelQLphieunhap.setBounds(10, 252, 398, 212);
		add(panelQLphieunhap);
		panelQLphieunhap.setLayout(new GridLayout(0, 1, 0, 0));
		
		//BUTTON TẠO PHIẾU NHẬP
		JButton ButtonTao = new JButton("Tạo phiếu nhập");
		ButtonTao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLphieunhap.add(ButtonTao);
		ButtonTao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				themPhieuNhap(evt);
			}
		});
		
		//BUTTON SỬA PHIẾU NHẬP
		JButton ButtonSua = new JButton("Sửa phiếu nhập/Thêm chi tiết phiếu nhập");
		ButtonSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLphieunhap.add(ButtonSua);
		ButtonSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				suaPhieuNhap(evt);
			}
		});
		
		//BUTTON XÓA PHIẾU NHẬP
		JButton ButtonXoa = new JButton("Xóa phiếu nhập");
		ButtonXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLphieunhap.add(ButtonXoa);
		ButtonXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xoaPhieuNhap(evt);
			}
		});
		
		//BUTTON XUẤT DANH SÁCH PHIẾU NHẬP
		JButton ButtonXuatds = new JButton("Xuất danh sách phiếu nhập");
		ButtonXuatds.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLphieunhap.add(ButtonXuatds);
		ButtonXuatds.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xuatdsPhieuNhap(evt);
			}
		});
		
				//KHUNG BẢNG DANH SÁCH PHIẾU NHẬP
		JPanel panelDSphieu = new JPanel();
		panelDSphieu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDSphieu.setBounds(418, 50, 452, 192);
		add(panelDSphieu);
		panelDSphieu.setLayout(new GridLayout(0, 1, 0, 0));
		
		//SCROLLPANE VÀ BẢNG CỦA DANH SÁCH PHIẾU NHẬP
		JScrollPane scrollPaneDSphieu = new JScrollPane();
		scrollPaneDSphieu.setEnabled(false);
		panelDSphieu.add(scrollPaneDSphieu);
		
		DSPhieuNhap=new JTable();
		modelDSPhieuNhap=new DefaultTableModel();
		modelDSPhieuNhap.addColumn("Mã phiếu nhập");
		modelDSPhieuNhap.addColumn("Mã nhà cung cấp");
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
		panelCTphieu.setBounds(418, 252, 452, 212);
		add(panelCTphieu);
		panelCTphieu.setLayout(new GridLayout(0, 1, 0, 0));
		
		//SCROLLPANE VÀ BẢNG CỦA CHI TIẾT PHIẾU NHẬP
		JScrollPane scrollPaneCTphieu = new JScrollPane();
		scrollPaneCTphieu.setEnabled(false);
		panelCTphieu.add(scrollPaneCTphieu);
		
		CTPhieuNhap=new JTable();
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
		panelTimphieu.setBounds(10, 469, 398, 106);
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
		ButtonTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonTim.setBounds(281, 23, 85, 50);
		panelTimphieu.add(ButtonTim);
		
		ButtonTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xacnhantimkiemPhieuNhap(evt);
			}
		});
		
		//BUTTON REFRESH
		JButton Buttonttpnrefresh = new JButton("Refresh");
		Buttonttpnrefresh.setBounds(138, 25, 79, 25);
		add(Buttonttpnrefresh);
		Buttonttpnrefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Buttonttpnrefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				refreshPN();
			}
		});
		
				//KHUNG CHỈNH SỬA CHI TIẾT PHIẾU
		JPanel panelChiTietPhieu = new JPanel();
		panelChiTietPhieu.setBorder(new TitledBorder(null, "Ch\u1EC9nh s\u1EEDa chi ti\u1EBFt phi\u1EBFu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChiTietPhieu.setBounds(418, 469, 452, 106);
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
		labelCTPNDongia.setBounds(180, 20, 45, 13);
		panelChiTietPhieu.add(labelCTPNDongia);
		
		//LABEL SỐ LƯỢNG SẢN PHẨM
		JLabel labelCTPNSoluong = new JLabel("Số lượng:");
		labelCTPNSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCTPNSoluong.setBounds(10, 50, 56, 13);
		panelChiTietPhieu.add(labelCTPNSoluong);
		
		//LABEL THÀNH TIỀN
		JLabel labelCTPNThanhTien = new JLabel("Thành tiền:");
		labelCTPNThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCTPNThanhTien.setBounds(180, 50, 70, 13);
		panelChiTietPhieu.add(labelCTPNThanhTien);
		
		//TEXTFIELD MÃ SẢN PHẨM
		tfCTPNMaSP = new JTextField();
		tfCTPNMaSP.setEditable(false);
		tfCTPNMaSP.setBounds(89, 18, 80, 19);
		panelChiTietPhieu.add(tfCTPNMaSP);
		tfCTPNMaSP.setColumns(10);
		
		//TEXTFIELD ĐƠN GIÁ
		tfCTPNDongia = new JTextField();
		tfCTPNDongia.setEditable(false);
		tfCTPNDongia.setBounds(230, 18, 115, 19);
		panelChiTietPhieu.add(tfCTPNDongia);
		tfCTPNDongia.setColumns(10);
		
		//TEXTFIELD SỐ LƯỢNG SẢN PHẨM
		tfCTPNSoluong = new JTextField();
		tfCTPNSoluong.setEditable(false);
		tfCTPNSoluong.setBounds(65, 50, 104, 19);
		panelChiTietPhieu.add(tfCTPNSoluong);
		tfCTPNSoluong.setColumns(10);
		
		//TEXTFIELD THÀNH TIỀN CỦA SẢN PHẨM
		tfCTPNThanhtien = new JTextField();
		tfCTPNThanhtien.setEditable(false);
		tfCTPNThanhtien.setBounds(245, 50, 100, 19);
		panelChiTietPhieu.add(tfCTPNThanhtien);
		tfCTPNThanhtien.setColumns(10);
		
		//NÚT THÊM SẢN PHẨM VÀO CSDL
		btnThemSP = new JButton("Thêm");
		btnThemSP.setEnabled(false);
		btnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThemSP.setBounds(10, 75, 95, 21);
		panelChiTietPhieu.add(btnThemSP);
		btnThemSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				themchitietphieunhap(evt);
			}
		});
		
		//NÚT XÓA SẢN PHẨM TRONG CƠ SỞ DỮ LIỆU
		btnXoaSP = new JButton("Xóa");
		btnXoaSP.setEnabled(false);
		btnXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaSP.setBounds(115, 75, 85, 21);
		panelChiTietPhieu.add(btnXoaSP);
		btnXoaSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xoachitietphieunhap(evt);
			}
		});
		
		//NÚT SỬA SẢN PHẨM TRONG CSDL
		btnSuaSP = new JButton("Sửa");
		btnSuaSP.setEnabled(false);
		btnSuaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuaSP.setBounds(210, 76, 85, 21);
		panelChiTietPhieu.add(btnSuaSP);
		btnSuaSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				suachitietphieunhap(evt);
			}
		});
		
		//NÚT XÁC NHẬN KHI ĐÃ THÊM XONG HAY SỬA XÓA. KẾT THÚC LUÔN BẢNG
		btnOKSP = new JButton("OK");
		btnOKSP.setEnabled(false);
		btnOKSP.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnOKSP.setBounds(355, 17, 80, 80);
		panelChiTietPhieu.add(btnOKSP);
		btnOKSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				refreshPN();
			}
		});
		
		
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
			String mancc = pn.getNhaCC().getMaNhaCC();
			String manv = pn.getNhanVien().getMa();
			String ngaytao = pn.getNgayLap();
			double tongtien = pn.getTongTien();
			Object[] row = {mapn,mancc,manv,ngaytao,tongtien};
			modelDSPhieuNhap.addRow(row);
		}
	}
	
	//LOAD CHI TIẾT PHIẾU NHẬP
	private void loadchitietphieunhap(String mapn) {
		ArrayList<ChiTietPhieu> arr = new ArrayList<ChiTietPhieu>();
		arr = PhieuNhapBLL.laychitietphieunhap(mapn);
		
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
	private void xacnhanttPhieuNhap(ActionEvent evt) {
		String mapn = textFieldMaPN.getText();
		String mancc = textFieldMaNCC.getText();
		String manv = textFieldMaNV.getText();
		String ngaytao = textFieldNgaytao.getText();
		Double tongtien = Double.valueOf(textFieldTongtien.getText());
		NhaCungCap ncc = new NhaCungCap();
		ncc.setMaNhaCC(mancc);
		NhanVien nv = new NhanVien();
		nv.setMa(manv);
		PhieuNhap pn = new PhieuNhap(mapn,nv,new ArrayList<ChiTietPhieu>(),ncc,ngaytao,tongtien);
		
		if(	textFieldMaNCC.getText().trim().equals("") || //HÀM TRIM() XÓA HẾT KHOẢNG TRẮNG
			textFieldMaPN.getText().trim().equals("") ||
			textFieldMaNV.getText().trim().equals("") ||
			textFieldNgaytao.getText().trim().equals("") ||
			textFieldTongtien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
		}
		else {
			if(modexacnhan=="them") {
				if(PhieuNhapDAL.themphieunhap(pn))
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				else
					JOptionPane.showMessageDialog(this, "Thêm thất bại");
			}
			if(modexacnhan=="sua") {
				if(PhieuNhapDAL.suaphieunhap(pn))
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				else
					JOptionPane.showMessageDialog(this, "Sửa thành công");
			}
			refreshPN();
		}
	}
	
	//HÀM NÚT XUẤT THÔNG TIN PHIẾU NHẬP
	private void xuatttPhieuNhap(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Xuất phiếu...tít.títt.tít");
	}
	
	//HÀM RESET THÔNG TIN PHIẾU NHẬP
	private void refreshPN() {
		textFieldMaPN.setText("");
		textFieldMaNCC.setText("");
		textFieldNgaytao.setText("");
		textFieldTongtien.setText("");
		textFieldMaNV.setText("");
		
		textFieldtimmapn.setText("");
		textFieldtimngaytao.setText("");
		//CHO NÚT XÁC NHẬN VÀ XUẤT PHIẾU TRỞ LẠI THÀNH FALSE
		Buttonttpnxacnhan.setEnabled(false);
		Buttonttpnxuat.setEnabled(false);
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
		trangthainhapcuachinhsua(0);
	}
	
	//HÀM SETTOOLTIPTEXT CHO Ô JTEXTFIELD CỦA THÔNG TIN PHIẾU NHẬP
	public void chinhtooltip(int i) {
		if(i==1) {	//TẠO TOOLTIP
			textFieldMaNCC.setToolTipText(textFieldMaNCC.getText());//tạo ghi chú cho nó ghi dòng quá dài
			textFieldMaPN.setToolTipText(textFieldMaPN.getText());
			textFieldNgaytao.setToolTipText(textFieldNgaytao.getText());
			textFieldTongtien.setToolTipText(textFieldTongtien.getText());
			textFieldMaNV.setToolTipText(textFieldMaNV.getText());
		}else {
			textFieldMaNCC.setToolTipText(null);//tạo ghi chú cho nó ghi dòng quá dài
			textFieldMaPN.setToolTipText(null);
			textFieldNgaytao.setToolTipText(null);
			textFieldTongtien.setToolTipText(null);
			textFieldMaNV.setToolTipText(null);
		}
	}
		
	//HÀM CHỈNH TRẠNG THÁI CHO Ô JTEXTFIELD CỦA THÔNG TIN PHIẾU NHẬP
	public void chinhtrangthainhap(int i) {
		if(i==1) {
			textFieldMaNCC.setEditable(true);
			textFieldMaPN.setEditable(true);
			textFieldNgaytao.setEditable(true);
			textFieldTongtien.setEditable(true);
			textFieldMaNV.setEditable(true);
		} else {
			textFieldMaNCC.setEditable(false);
			textFieldMaPN.setEditable(false);
			textFieldNgaytao.setEditable(false);
			textFieldTongtien.setEditable(false);
			textFieldMaNV.setEditable(false);
		}
	}
	
	//HÀM NÚT TẠO/THÊM PHIẾU NHẬP
	private void themPhieuNhap(ActionEvent evt) {
		chinhtrangthainhap(1);
		Buttonttpnxacnhan.setEnabled(true);
		Buttonttpnxuat.setEnabled(true);
		textFieldMaPN.setEnabled(true);
		modexacnhan="them";
		
		//bảng chỉnh sửa chi tiết
		trangthainhapcuachinhsua(0);
	}
	
	//HÀM NÚT SỬA PHIẾU NHẬP
	private void suaPhieuNhap(ActionEvent evt) {
		chinhtrangthainhap(1);
		Buttonttpnxacnhan.setEnabled(true);
		textFieldMaPN.setEnabled(false);
		Buttonttpnxuat.setEnabled(false);
		modexacnhan="sua";
		
		//bảng chỉnh sửa chi tiết
		trangthainhapcuachinhsua(1);
	}
	
	//HÀM NÚT XÓA PHIẾU NHẬP
	private void xoaPhieuNhap(ActionEvent evt) {
		int vitri = DSPhieuNhap.getSelectedRow();
		if(vitri>=0) {
			int i = PhieuNhapDAL.xoaphieunhap(modelDSPhieuNhap.getValueAt(vitri, 0).toString());
			if(i==1) 
				JOptionPane.showMessageDialog(this, "Xóa thành công");
			else
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			refreshPN();
		} else {
			JOptionPane.showMessageDialog(this, "lỗi lấy dữ liệu/chưa chọn mục tiêu");
		}
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
			textFieldMaNCC.setText(modelDSPhieuNhap.getValueAt(i, 1).toString());
			textFieldMaNV.setText(modelDSPhieuNhap.getValueAt(i, 2).toString());
			textFieldNgaytao.setText(modelDSPhieuNhap.getValueAt(i, 3).toString());
			textFieldTongtien.setText(modelDSPhieuNhap.getValueAt(i, 4).toString());
			chinhtooltip(1);
			
			if(CTPhieuNhap.getRowCount()>=0) {
				loadchitietphieunhap(modelDSPhieuNhap.getValueAt(i, 0).toString());
			}
		}
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
			String ma_ncc = pn.getNhaCC().getMaNhaCC();
			String ma_nv = pn.getNhanVien().getMa();
			String ngay_tao = pn.getNgayLap();
			double tong_tien = pn.getTongTien();
			Object[] row = {ma_pn,ma_ncc,ma_nv,ngay_tao,tong_tien};
			modelDSPhieuNhap.addRow(row);
		}
		loadchitietphieunhap(mapn);
	}
	
	
	
	
	//HÀM CHỈNH TRẠNG THÁI CỦA JTEXTFIELD VÀ BUTTON CỦA CHỈNH SỬA CHI TIẾT PHIẾU NHẬP
	private void trangthainhapcuachinhsua(int i) {
		if(i==1) {
			tfCTPNMaSP.setEditable(true);
			tfCTPNDongia.setEditable(true);
			tfCTPNSoluong.setEditable(true);
			tfCTPNThanhtien.setEditable(true);
			
			btnThemSP.setEnabled(true);
			btnXoaSP.setEnabled(true);
			btnSuaSP.setEnabled(true);
			btnOKSP.setEnabled(true);
		} else {
			tfCTPNMaSP.setEditable(false);
			tfCTPNDongia.setEditable(false);
			tfCTPNSoluong.setEditable(false);
			tfCTPNThanhtien.setEditable(false);
			
			btnThemSP.setEnabled(false);
			btnXoaSP.setEnabled(false);
			btnSuaSP.setEnabled(false);
			btnOKSP.setEnabled(false);
		}
	}
	//HÀM THÊM VÀ SỬA CHI TIẾT SẢN PHẨM
	public void chitietphieunhap(String mode) {
		String mapn = textFieldMaPN.getText();
		String masp = tfCTPNMaSP.getText();
		String dongia = tfCTPNDongia.getText();
		String soluong = tfCTPNSoluong.getText();
		String thanhtien = tfCTPNThanhtien.getText();
		SanPham sp = new SanPham();
		sp.setMaSanPham(masp);
		sp.setGiaNhap(Double.valueOf(dongia));
		sp.setSoLuong(Integer.valueOf(soluong));
		ChiTietPhieu ctpn = new ChiTietPhieu(sp, Double.valueOf(thanhtien));
		
		if(	tfCTPNMaSP.getText().trim().equals("") || //HÀM TRIM() XÓA HẾT KHOẢNG TRẮNG
			tfCTPNDongia.getText().trim().equals("") ||
			tfCTPNSoluong.getText().trim().equals("") ||
			tfCTPNThanhtien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
		}
		else {
			if(mode=="them") {
				if(PhieuNhapBLL.themchitietphieunhap(mapn,ctpn))
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				else
					JOptionPane.showMessageDialog(this, "Thêm thất bại");
			}
			if(mode=="sua") {
				if(PhieuNhapBLL.suachitietphieunhap(ctpn))
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				else
					JOptionPane.showMessageDialog(this, "Sửa thành công");
			}
			
			//reset bảng lại để hiển thị
			modelCTPhieuNhap.setRowCount(0);
			loadchitietphieunhap(mapn);
		}
	}
	public void themchitietphieunhap(ActionEvent evt) {
		String mode = "them";
		chitietphieunhap(mode);
	}
	public void suachitietphieunhap(ActionEvent evt) {
		String mode = "sua";
		chitietphieunhap(mode);
	}
	//HÀM XÓA PHIẾU NHẬP
	private void xoachitietphieunhap(ActionEvent evt) {
		int vitri = CTPhieuNhap.getSelectedRow();
		if(vitri>=0) {
			int i = PhieuNhapDAL.xoachitietphieunhap(modelCTPhieuNhap.getValueAt(vitri, 0).toString());
			if(i==1) 
				JOptionPane.showMessageDialog(this, "Xóa thành công");
			else
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			
			//reset bảng lại để hiển thị
			modelCTPhieuNhap.setRowCount(0);
			loadchitietphieunhap(textFieldMaPN.getText());
		} else {
			JOptionPane.showMessageDialog(this, "lỗi lấy dữ liệu/chưa chọn mục tiêu");
		}
	}
}
