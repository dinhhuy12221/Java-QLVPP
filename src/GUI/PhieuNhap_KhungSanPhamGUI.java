package GUI;
import javax.swing.*;
import javax.swing.table.*;

import BLL.PhieuNhapBLL;
import BLL.TheKhoBLL;
import DAL.PhieuNhapDAL;

import java.util.*;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.*;
import DTO.SanPham;
import DTO.ChiTietPhieu;
import DTO.PhieuNhap;

public class PhieuNhap_KhungSanPhamGUI extends JFrame{
	private JTable DSSP;
	private DefaultTableModel modelDSSP;
	private JTable DSSPPN;
	private DefaultTableModel modelDSSPPN;
	
	private JTextField tfSLnhap;
	private JTextField tfMaSP;	//bảng sản phẩm hiện có là sản phẩm thôi, luusp là để cho lưu vào chi tiết phiếu
	private ArrayList<SanPham> sphienco = new ArrayList<SanPham>();
	private ArrayList<ChiTietPhieu> luusp = new ArrayList<ChiTietPhieu>();
	
	private JButton btnThem, btnXoa, btnXacnhan;
	private PhieuNhap phieuNhap = new PhieuNhap();
	public PhieuNhap_KhungSanPhamGUI(PhieuNhap pn) {
		phieuNhap=pn;
		
		//setVisible(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(300,200,704,500);
		
		//LABEL NHẬP SẢN PHẨM
		JLabel lblNhapSP = new JLabel("NHẬP SẢN PHẨM");
		lblNhapSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapSP.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNhapSP.setBounds(10, 0, 668, 46);
		getContentPane().add(lblNhapSP);
		
				//KHUNG BẢNG SẢN PHẨM HIỆN CÓ
		JPanel panelSPhienco = new JPanel();
		panelSPhienco.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m hi\u1EC7n c\u00F3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSPhienco.setBounds(10, 37, 330, 344);
		getContentPane().add(panelSPhienco);
		panelSPhienco.setLayout(new GridLayout(0, 1, 0, 0));
		
		//JSCROLLPANE CHỨA BẢNG SẢN PHẨM VÀ TABLE
		JScrollPane scrollPaneSP = new JScrollPane();
		scrollPaneSP.setEnabled(false);
		panelSPhienco.add(scrollPaneSP);
		
		DSSP = new JTable();
		modelDSSP = new DefaultTableModel();
		modelDSSP.addColumn("Mã sản phẩm");
		modelDSSP.addColumn("Tên sản phẩm");
		modelDSSP.addColumn("Giá nhập");
		modelDSSP.addColumn("Số lượng");
		DSSP.setModel(modelDSSP);
		scrollPaneSP.setViewportView(DSSP);
		DSSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				nhanvaomotdongdssp(0);
			}
			
		});
		
				//KHUNG BẢNG SẢN PHẨM CỦA PHIẾU NHẬP
		JPanel panelPhieunhap = new JPanel();
		panelPhieunhap.setBorder(new TitledBorder(null, "Phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPhieunhap.setBounds(350, 37, 330, 344);
		getContentPane().add(panelPhieunhap);
		panelPhieunhap.setLayout(new GridLayout(1, 0, 0, 0));
		
		//SCROLLPANE CHỨA BẢNG SP PHIẾU NHẬP VÀ TABLE
		JScrollPane scrollPanePN = new JScrollPane();
		scrollPanePN.setEnabled(false);
		panelPhieunhap.add(scrollPanePN);
		
		DSSPPN= new JTable();
		modelDSSPPN = new DefaultTableModel();
		modelDSSPPN.addColumn("Mã sản phẩm");
		modelDSSPPN.addColumn("Giá nhập");
		modelDSSPPN.addColumn("Số lượng");
		DSSPPN.setModel(modelDSSPPN);
		scrollPanePN.setViewportView(DSSPPN);
		DSSPPN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				nhanvaomotdongdssp(1);
			}
			
		});
		
		//LABEL SỐ LƯỢNG NHẬP
		JLabel lblSLnhap = new JLabel("Số lượng nhập:");
		lblSLnhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSLnhap.setBounds(10, 430, 84, 13);
		getContentPane().add(lblSLnhap);
		
		//JTEXTFIELD SỐ LƯỢNG NHẬP
		tfSLnhap = new JTextField();
		tfSLnhap.setBounds(104, 430, 96, 19);
		getContentPane().add(tfSLnhap);
		tfSLnhap.setColumns(10);
		
		//LABEL MÃ SẢN PHẨM
		JLabel lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaSP.setBounds(10, 403, 84, 13);
		getContentPane().add(lblMaSP);
		
		//JTEXTFIELD MÃ SẢN PHẨM
		tfMaSP = new JTextField();
		tfMaSP.setEditable(false);
		tfMaSP.setColumns(10);
		tfMaSP.setBounds(104, 401, 96, 19);
		getContentPane().add(tfMaSP);
		
		//NÚT THÊM SẢN PHẨM VÀO BẢNG PHIẾU NHẬP
		btnThem = new JButton("Thêm");
		btnThem.setBounds(271, 403, 100, 30);
		getContentPane().add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themspvaophieunhap();
			}
		});
		
		//NÚT XÓA SẢN PHẨM VÀO BẢNG PHIẾU NHẬP
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(387, 403, 100, 30);
		getContentPane().add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaspkhoiphieunhap();
			}
		});
		
		//NÚT XÁC NHẬN ĐỂ LUU SẢN PHẨM
		btnXacnhan = new JButton("Xác nhận");
		btnXacnhan.setBounds(530, 403, 130, 50);
		getContentPane().add(btnXacnhan);
		btnXacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taophieunhap();
			}
		});
		
		loadsphienco();
		loadspdaco();
	}
	
			
	
	
	
	
			//HÀM
	//LOAD DANH SÁCH SẢN PHẨM HIỆN CÓ
	public void loadsphienco() {
		//ArrayList<SanPham> sphienco = new ArrayList<SanPham>();
		sphienco = BLL.SanPhamBLL.layDanhSachSP();
		
		for(int i=0; i<sphienco.size();i++) {
			SanPham sp = sphienco.get(i);
			
			String masp = sp.getMaSanPham();
			String tensp = sp.getTenSanPham();
			double gianhap = sp.getGiaNhap();
			int soluong = sp.getSoLuong();
			Object [] row = {masp,tensp,gianhap,soluong};
			modelDSSP.addRow(row);
		}
	}
	
	//LOAD DANH SÁCH TRƯỚC ĐÓ VÀO
	public void loadspdaco() {
		//ArrayList<ChiTietPhieu> luusp = new ArrayList<ChiTietPhieu>();
//		luusp = PhieuNhapDAL.laychitietphieunhap(mapn);
		modelDSSPPN.setRowCount(0);
		
		for(int i=0;i<luusp.size();i++) {
			ChiTietPhieu ctp = luusp.get(i);
			
			String masp = ctp.getSanPham().getMaSanPham();
			double gianhap = ctp.getSanPham().getGiaNhap();
			int soluong = ctp.getSanPham().getSoLuong();
			Object [] row = {masp,gianhap,soluong};
			modelDSSPPN.addRow(row);
		}
	}
	
	//NHẤN VÀO 1 DÒNG TRONG BẢNG
	public void nhanvaomotdongdssp(int mode) {
		int i=0;
		if(mode==0) {
			i = DSSP.getSelectedRow();
		}
		if(mode==1) {
			i = DSSPPN.getSelectedRow();
		}
		tfMaSP.setText(modelDSSP.getValueAt(i, 0).toString());
	}
	
	//RESET BẢNG SẢN PHẨM CỦA PHIẾU NHẬP
	public void resetsppn() {
		//reset bảng
		tfMaSP.setText("");
		tfSLnhap.setText("");
		modelDSSPPN.setRowCount(0);
		loadspdaco();
	}
	
	//NÚT THÊM SẢN PHẨM
	public void themspvaophieunhap() {
		if(tfSLnhap.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập số lượng nhập hàng");
		} else {
			int vitri = DSSP.getSelectedRow();		//lấy vị trí đang đc chọn trong bảng sphc để lấy dữ liệu
			if(vitri >= 0)
			for(ChiTietPhieu ctp : luusp) {
				if(ctp.getSanPham().getMaSanPham().equals(sphienco.get(vitri).getMaSanPham())) {
					JOptionPane.showMessageDialog(this, "Sản phẩm đã được chọn");
					return;
				} 
			}
			String masp = modelDSSP.getValueAt(vitri, 0).toString();	//lấy dữ liệu từ cái bảng đó để lát thêm vào csdl	
			Double dongia = Double.parseDouble(modelDSSP.getValueAt(vitri, 2).toString());
			int soluong = Integer.parseInt(tfSLnhap.getText());
			double thanhtien = dongia*soluong;
			
			SanPham sp = new SanPham();
			sp.setMaSanPham(masp);
			sp.setGiaNhap(dongia);
			sp.setSoLuong(soluong);
			
			ChiTietPhieu temp = new ChiTietPhieu(sp,thanhtien); 
			luusp.add(temp);
			loadspdaco();
		}
	}
	
	//NÚT XÓA SẢN PHẨM
	public void xoaspkhoiphieunhap() {
		int i = DSSPPN.getSelectedRow();	//lấy dòng đang được chọn trong bảng rồi xóa nó trong model của bảng
		if(i >= 0) {
//			String masp = DSSPPN.getValueAt(i, 0).toString();
			luusp.remove(i);
			loadspdaco();
	//		PhieuNhapDAL.xoachitietphieunhap(masp);
//			resetsppn();
	//		PhieuNhapDAL.capnhapthanhtien(mapn);//cập nhập lại thành tiền
		}
	}
	
	public void taophieunhap() 
	{
		if(luusp.size() > 0) {
			phieuNhap.setDSCT(luusp);
			int checked = 0;
			if (PhieuNhapBLL.themphieunhap(phieuNhap))
			for (ChiTietPhieu temp: luusp) {
				if(PhieuNhapBLL.themchitietphieunhap(temp,phieuNhap.getMaPhieu()) &&
				PhieuNhapBLL.capnhapthanhtien(phieuNhap.getMaPhieu()) &&
				PhieuNhapBLL.capnhapsoluongsanpham(phieuNhap.getMaPhieu(), temp.getSanPham().getMaSanPham())
				) checked += 1;
			}
			if(checked == luusp.size()) {
				boolean checked2 = true;
				for(ChiTietPhieu ctp: phieuNhap.getDSCT()) {
					if(!TheKhoBLL.capNhatTheKho(phieuNhap.getMaPhieu(),phieuNhap.getNgayLap(),ctp)) {
						checked2 = false;
						break;
					}
				}
				if(checked2)JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thành công");
				else JOptionPane.showMessageDialog(this, "Thêm phiếu nhập không thành công");
				dispose();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
		}
	}
}