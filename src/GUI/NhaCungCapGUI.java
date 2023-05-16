package GUI;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import DTO.NhaCungCap;
import BLL.NhaCungCapBLL;
import DAL.NhaCungCapDAL;
import DTO.SanPham;

public class NhaCungCapGUI extends JPanel {
	private JTextField textFieldMaNCC;
	private JTextField textFieldTenNCC;
	private JTextField textFieldDCNCC;
	private JTextField textFieldSDTNCC;
	private JTextField textFieldtimkiem1;
	private JTextField textFieldtimkiem2;

	private JTable DSNhaCC;
	private JTable DSSanPham;
	private DefaultTableModel modelDSNhaCC;
	private DefaultTableModel modelDSSanPham;
	private JLabel LabelSL;
	private JButton ButtonXacnhan1;
	private String modexacnhan;
	/**
	 * Create the panel.
	 */
	public NhaCungCapGUI() {
		setBackground(new Color(240, 240, 240));
		setSize(1269,679);
		setLayout(null);
		
				//TẠO KHUNG THÔNG TIN NHÀ CUNG CẤP
		JPanel panelttNCC = new JPanel();
		panelttNCC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelttNCC.setBounds(10, 50, 487, 247);
		add(panelttNCC);
		panelttNCC.setLayout(null);
		
		//TEXTFIELD VÀ LABEL CỦA MÃ NHÀ CC
		textFieldMaNCC = new JTextField();
		textFieldMaNCC.setEditable(false);
		textFieldMaNCC.setBounds(115, 25, 362, 19);
		panelttNCC.add(textFieldMaNCC);
		textFieldMaNCC.setColumns(10);
		
		JLabel LabelMaNCC = new JLabel("Mã nhà cung cấp:");
		LabelMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelMaNCC.setBounds(10, 27, 108, 13);
		panelttNCC.add(LabelMaNCC);
		
		//TEXTFIELD VÀ LABEL CỦA TÊN NHÀ CC
		textFieldTenNCC = new JTextField();
		textFieldTenNCC.setEditable(false);
		textFieldTenNCC.setColumns(10);
		textFieldTenNCC.setBounds(116, 59, 361, 19);
		panelttNCC.add(textFieldTenNCC);
		
		JLabel LabelTenNCC = new JLabel("Tên nhà cung cấp:");
		LabelTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelTenNCC.setBounds(10, 62, 108, 13);
		panelttNCC.add(LabelTenNCC);
		
		//TEXTFIELD VÀ LABEL CỦA ĐỊA CHỈ NHÀ CC
		JLabel LabelDCNCC = new JLabel("Địa chỉ:");
		LabelDCNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelDCNCC.setBounds(10, 97, 108, 13);
		panelttNCC.add(LabelDCNCC);
		
		textFieldDCNCC = new JTextField();
		textFieldDCNCC.setEditable(false);
		textFieldDCNCC.setColumns(10);
		textFieldDCNCC.setBounds(53, 95, 424, 19);
		panelttNCC.add(textFieldDCNCC);
		
		//TEXTFIELD VÀ LABEL CỦA SĐT
		JLabel LabelSDTNCC = new JLabel("Số điện thoại:");
		LabelSDTNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelSDTNCC.setBounds(10, 133, 108, 13);
		panelttNCC.add(LabelSDTNCC);
		
		textFieldSDTNCC = new JTextField();
		textFieldSDTNCC.setEditable(false);
		textFieldSDTNCC.setColumns(10);
		textFieldSDTNCC.setBounds(91, 131, 386, 19);
		panelttNCC.add(textFieldSDTNCC);
		
		//LABEL HIỂN THỊ SỐ SẢN PHẨM HIỆN TẠI CỦA NCC ĐANG CÓ TRONG CỬA HÀNG
		JLabel LabelSPhoptac = new JLabel("Số sản phẩm đang hợp tác:");
		LabelSPhoptac.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelSPhoptac.setBounds(10, 170, 160, 13);
		panelttNCC.add(LabelSPhoptac);
		
		LabelSL = new JLabel();
		LabelSL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelSL.setBounds(166, 170, 45, 13);
		panelttNCC.add(LabelSL);
		
		//NÚT XÁC NHẬN TRONG KHUNG THÔNG TIN NHÀ CC ĐỂ TẠO NHÀ CC MỚI/SỬA
		ButtonXacnhan1 = new JButton("Xác nhận");
		ButtonXacnhan1.setIcon(new ImageIcon("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\icon\\check-mark.png"));
		ButtonXacnhan1.setEnabled(false);
		ButtonXacnhan1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonXacnhan1.setBounds(309, 188, 157, 48);
		panelttNCC.add(ButtonXacnhan1);
		ButtonXacnhan1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xacnhannhacc(evt);
			}
		});
		
				//KHUNG QUẢN LÝ NHÀCC
		JPanel panelQLNCC = new JPanel();
		panelQLNCC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Qu\u1EA3n l\u00FD nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelQLNCC.setBounds(10, 307, 487, 163);
		add(panelQLNCC);
		panelQLNCC.setLayout(new GridLayout(0, 1, 0, 0));
		
		//NÚT THÊM
		JButton ButtonThem = new JButton("Thêm nhà cung cấp");
		ButtonThem.setIcon(new ImageIcon("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\icon\\plus.png"));
		ButtonThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLNCC.add(ButtonThem);
		ButtonThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				themnhacc(evt);
			}
		});
		
		//NÚT XÓA
		JButton ButtonXoa = new JButton("Xóa nhà cung cấp");
		ButtonXoa.setIcon(new ImageIcon("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\icon\\bin.png"));
		ButtonXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLNCC.add(ButtonXoa);
		ButtonXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xoanhacc(evt);
			}
		});
		
		//NÚT SỬA
		JButton ButtonSua = new JButton("Sửa nhà cung cấp");
		ButtonSua.setIcon(new ImageIcon("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\icon\\edit.png"));
		ButtonSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQLNCC.add(ButtonSua);
		ButtonSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				suanhacc(evt);
			}
		});
		
				//KHUNG HIỂN THỊ TÊN CỦA CÁC NHÀ CC ĐANG HỢP TÁC
		JPanel panelCacnhacungcap = new JPanel();
		panelCacnhacungcap.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E0 cung c\u1EA5p ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCacnhacungcap.setBounds(507, 50, 752, 247);
		add(panelCacnhacungcap);
		panelCacnhacungcap.setLayout(new GridLayout(0, 1, 0, 0));
		
		//SCROLLPANE ĐỂ TABLE DS CÁC NHÀ CUNG CẤP
		JScrollPane scrollPaneCacnhacc = new JScrollPane();
		scrollPaneCacnhacc.setEnabled(false);
		panelCacnhacungcap.add(scrollPaneCacnhacc);
		
		//TABLE HIỆN SẢN PHẨM VÀ SỰ KIỆN CỦA NÓ
		DSNhaCC=new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DSNhaCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DSNhaCC.getTableHeader().setReorderingAllowed(false);
		DSNhaCC.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent evt){
            	chonnhacc(evt);
            }
        });
		DSNhaCC.setRowHeight(30);
		modelDSNhaCC=new DefaultTableModel();
		DSNhaCC.setModel(modelDSNhaCC);
		modelDSNhaCC.addColumn("Mã nhà cung cấp");
		modelDSNhaCC.addColumn("Tên nhà cung cấp");
		modelDSNhaCC.addColumn("Địa chỉ");
		modelDSNhaCC.addColumn("Số điện thoại");
		scrollPaneCacnhacc.setViewportView(DSNhaCC);
		
				//KHUNG TÌM KIẾM
		JPanel paneltìmkiem = new JPanel();
		paneltìmkiem.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paneltìmkiem.setBounds(10, 480, 487, 95);
		add(paneltìmkiem);
		paneltìmkiem.setLayout(null);
		
		//LABEL VÀ TEXTFIELD TÌM KIẾM THEO MÃ
		JLabel LabelMaNCC2 = new JLabel("Mã nhà cung cấp:");
		LabelMaNCC2.setBounds(10, 26, 103, 15);
		LabelMaNCC2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		paneltìmkiem.add(LabelMaNCC2);
		
		textFieldtimkiem1 = new JTextField();
		textFieldtimkiem1.setColumns(10);
		textFieldtimkiem1.setBounds(123, 25, 147, 19);
		paneltìmkiem.add(textFieldtimkiem1);
		
		//LABEL VÀ TEXTFIELD TÌM KIẾM THEO TÊN
		JLabel LabelTenNCC2 = new JLabel("Tên nhà cung cấp:");
		LabelTenNCC2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelTenNCC2.setBounds(10, 61, 108, 13);
		paneltìmkiem.add(LabelTenNCC2);
		
		textFieldtimkiem2 = new JTextField();
		textFieldtimkiem2.setColumns(10);
		textFieldtimkiem2.setBounds(123, 59, 147, 19);
		paneltìmkiem.add(textFieldtimkiem2);
		
		//NÚT XÁC NHẬN TÌM KIẾM
		JButton ButtonTimkiem = new JButton("Tìm");
		ButtonTimkiem.setIcon(new ImageIcon("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\icon\\search.png"));
		ButtonTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonTimkiem.setBounds(296, 26, 157, 48);
		paneltìmkiem.add(ButtonTimkiem);
		ButtonTimkiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xacnhantimkiemnhacc(evt);
			}
		});
		
				//KHUNG ĐỂ HIỂN THỊ BẢNG SẢN PHẨM CỦA 1 NHÀ CC NẾU BẤM VÀO
		JPanel panelSanphamthuoc = new JPanel();
		panelSanphamthuoc.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m c\u1EE7a nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSanphamthuoc.setBounds(507, 307, 752, 361);
		add(panelSanphamthuoc);
		panelSanphamthuoc.setLayout(new GridLayout(0, 1, 0, 0));
		
		//SCROLLPANE CHỨA TABLE SẢN PHẨM
		JScrollPane scrollPaneSP = new JScrollPane();
		scrollPaneSP.setEnabled(false);
		panelSanphamthuoc.add(scrollPaneSP);
		
		//TABLE SẢN PHẨM VÀ SỰ KIỆN CỦA NÓ
		DSSanPham=new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DSSanPham.getTableHeader().setReorderingAllowed(false);
		DSSanPham.setRowHeight(30);
		DSSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		modelDSSanPham=new DefaultTableModel();
		modelDSSanPham.addColumn("Mã nhà CC");
		modelDSSanPham.addColumn("Mã sản phẩm");
		modelDSSanPham.addColumn("Tên sản phẩm");
		DSSanPham.setModel(modelDSSanPham);
		scrollPaneSP.setViewportView(DSSanPham);
		
		//TẠO NÚT RESET MỌI THỨ
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon("D:\\Study Folder\\SGU\\2022-2023 HK2\\Java\\Project\\image\\icon\\refresh.png"));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRefresh.setBounds(10, 586, 110, 45);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				resetNCC();
			}
		});
		
		//GỌI HÀM NẠP DANH SÁCH TRONG HÀM THIẾT LẬP ĐỂ KHI MỞ THÌ CHẠY TỰ ĐỘNG LUÔN
		loadnhacc();
	}
	
	
	
	
	
			//PHẦN HÀM VÀ CHỨC NĂNG SỰ KIỆN
	//HÀM LOAD TỪ CSDL VÀO BẢNG
	public void loadnhacc() {
		ArrayList<NhaCungCap> arr=new ArrayList<NhaCungCap>();//tạo danh sách để chứa
		arr=NhaCungCapDAL.layDanhSachNhaCC();	//hàm lấy từ BLL, BLL thì nạp hàm từ DAL
	
		for(int i=0;i<arr.size(); i++) {
			NhaCungCap temp = arr.get(i);
			
			String id = temp.getMaNhaCC();
			String name = temp.getTenNhaCC();
			String addr = temp.getDiaChi();
			String sdt = temp.getSoDienThoai();
			Object[] row= {id,name,addr,sdt};
			modelDSNhaCC.addRow(row);
		}
	}
	
	//HÀM LOAD BẢNG SẢN PHẨM CỦA 1 NHÀ CC KHI NHẤN VÀO DS NHÀ CC
	public void loadsanphamcuanhacc(String mancc) {
		ArrayList<SanPham> arr=new ArrayList<SanPham>();
		arr=NhaCungCapDAL.laySanPhamCuaNhaCC(mancc);
		
		for(int i=0;i<arr.size();i++) {
			SanPham temp = arr.get(i);
			
			String idncc = mancc;
			String id = temp.getMaSanPham();
			String name = temp.getTenSanPham();
			Object[] row = {idncc,id,name};
			modelDSSanPham.addRow(row);
		}
	}
	
	//HÀM CHO KHI NHẤN VÀO 1 DÒNG TRONG TABLE NHÀCC
	private void chonnhacc(MouseEvent evt) {
		modelDSSanPham.setRowCount(0);//XÓA DANH SÁCH SẢN PHẨM
		int i=DSNhaCC.getSelectedRow();//lấy số dòng ĐANG ĐƯỢC CHỌN trong bảng
		if(i>=0) {//nếu có dòng tồn tại thì làm
			textFieldMaNCC.setText(modelDSNhaCC.getValueAt(i, 0).toString());
			textFieldTenNCC.setText(modelDSNhaCC.getValueAt(i, 1).toString());
			textFieldDCNCC.setText(modelDSNhaCC.getValueAt(i, 2).toString());
			textFieldSDTNCC.setText(modelDSNhaCC.getValueAt(i, 3).toString());
			String slsp = Integer.toString(NhaCungCapDAL.laysoluongspcuanhacc(textFieldMaNCC.getText()));
			LabelSL.setText(slsp);
			chinhtooltip(1);
			
			if(DSSanPham.getRowCount()>=0) {
				loadsanphamcuanhacc(modelDSNhaCC.getValueAt(i, 0).toString());
			}
		}
	}
	
	//HÀM SETTOOLTIPTEXT CHO Ô JTEXTFIELD
	public void chinhtooltip(int i) {
		if(i==1) {	//TẠO TOOLTIP
			textFieldMaNCC.setToolTipText(textFieldMaNCC.getText());//tạo ghi chú cho nó ghi dòng quá dài
			textFieldTenNCC.setToolTipText(textFieldTenNCC.getText());
			textFieldDCNCC.setToolTipText(textFieldDCNCC.getText());
			textFieldSDTNCC.setToolTipText(textFieldSDTNCC.getText());
		}else {
			textFieldMaNCC.setToolTipText(null);//tạo ghi chú cho nó ghi dòng quá dài
			textFieldTenNCC.setToolTipText(null);
			textFieldDCNCC.setToolTipText(null);
			textFieldSDTNCC.setToolTipText(null);
		}
	}
	
	//HÀM CHỈNH TRẠNG THÁI CHO Ô JTEXTFIELD
	public void chinhtrangthainhap(int i) {
		if(i==1) {
			textFieldTenNCC.setEditable(true);
			textFieldDCNCC.setEditable(true);
			textFieldSDTNCC.setEditable(true);
		} else {
			textFieldTenNCC.setEditable(false);
			textFieldDCNCC.setEditable(false);
			textFieldSDTNCC.setEditable(false);
		}
	}
	
	//HÀM NÚT  XÁC NHẬN TẠO VÀ SỬA NHÀ CC
	private void xacnhannhacc(ActionEvent evt) {
		NhaCungCap temp = new NhaCungCap();
		temp.setMaNhaCC(textFieldMaNCC.getText());
		temp.setTenNhaCC(textFieldTenNCC.getText());
		temp.setDiaChi(textFieldDCNCC.getText());
		temp.setSoDienThoai(textFieldSDTNCC.getText());
		if(	 //HÀM TRIM() XÓA HẾT KHOẢNG TRẮNG
			textFieldTenNCC.getText().trim().equals("") ||
			textFieldDCNCC.getText().trim().equals("") ||
			textFieldSDTNCC.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
		}
		else {
			if(modexacnhan=="them") {
				if(NhaCungCapBLL.themnhacungcap(temp))
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				else
					JOptionPane.showMessageDialog(this, "Thêm thất bại");
			}
			if(modexacnhan=="sua") {
				if(NhaCungCapBLL.suanhacungcap(temp))
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				else
					JOptionPane.showMessageDialog(this, "Sửa thành công");
			}
			resetNCC();
		}
	}
	
	
	//HÀM XÓA NHÀ CC
	private void xoanhacc(ActionEvent evt) {
		int vitri = DSNhaCC.getSelectedRow();
		if(vitri>=0) {
			int i = NhaCungCapDAL.xoanhacungcap(modelDSNhaCC.getValueAt(vitri, 0).toString());
			int c = JOptionPane.showConfirmDialog(null, "Xác nhận xóa nhà cung cấp ?","Thông báo", JOptionPane.INFORMATION_MESSAGE);
			if(i==1 && c == 0) 
				JOptionPane.showMessageDialog(this, "Xóa thành công");
			else
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			resetNCC();
		} else {
			JOptionPane.showMessageDialog(this, "Lỗi lấy dữ liệu/chưa chọn mục tiêu");
		}
	}
	
	//HÀM THÊM NHÀ CC
	private void themnhacc(ActionEvent evt) {
		chinhtrangthainhap(1);	//chuyển sang chế độ nhập
		ButtonXacnhan1.setEnabled(true);	//mở để xác nhận
		textFieldMaNCC.setText(BLL.NhaCungCapBLL.taoMaNhaCC());
		modexacnhan="them";
		textFieldMaNCC.setToolTipText("Mã nhà cung cấp là duy nhất");
		textFieldTenNCC.setText("");
		textFieldDCNCC.setText("");
		textFieldSDTNCC.setText("");
		LabelSL.setText("");
		DSNhaCC.setEnabled(false);
	}
	
	//HÀM SỬA NHÀ CC
	private void suanhacc(ActionEvent evt) {
		chinhtrangthainhap(1);
		ButtonXacnhan1.setEnabled(true);
		modexacnhan="sua";
		DSNhaCC.setEnabled(true);
	}
	
	//HÀM XÁC NHẬN TÌM KIẾM NHÀ CC
	private void xacnhantimkiemnhacc(ActionEvent evt) {
		modelDSNhaCC.setRowCount(0); //XÓA TOÀN BỘ DÒNG TRONG DANH SÁCH CÓ XÀI CÁI MODEL NÀY
		modelDSSanPham.setRowCount(0);
		//tạo 1 danh sách bao gồm thứ được chọn
		String mancc = textFieldtimkiem1.getText();
		String tenncc = textFieldtimkiem2.getText();
		ArrayList<NhaCungCap> arr = new ArrayList<NhaCungCap>();
		arr = NhaCungCapDAL.timtheomancc(mancc,tenncc);
		
		for(int i=0;i<arr.size();i++) {
			NhaCungCap temp = arr.get(i);
			
			String id = temp.getMaNhaCC();
			String name = temp.getTenNhaCC();
			String addr = temp.getDiaChi();
			String sdt = temp.getSoDienThoai();
			Object[] row= {id,name,addr,sdt};
			modelDSNhaCC.addRow(row);
		}
		//nạp thẳng sản phẩm của nhà cung cấp
		loadsanphamcuanhacc(mancc);
	}
	
	//HÀM RESET(HỦY)
	private void resetNCC() {
		textFieldMaNCC.setText("");
		textFieldTenNCC.setText("");
		textFieldDCNCC.setText("");
		textFieldSDTNCC.setText("");
		LabelSL.setText("");
		textFieldtimkiem1.setText("");
		textFieldtimkiem2.setText("");
		//clear bảng nhà cung cấp
		modelDSNhaCC.setRowCount(0);	//XÓA TOÀN BỘ DÒNG TRONG DANH SÁCH CÓ XÀI CÁI MODEL NÀY
		loadnhacc();
		//clear bảng sản phẩm
		modelDSSanPham.setRowCount(0);	//XÓA TOÀN BỘ DÒNG TRONG DANH SÁCH CÓ XÀI CÁI MODEL NÀY 
		//chỉnh tooltip
		chinhtooltip(0);
		//chỉnh trạng thái jtextfield
		chinhtrangthainhap(0);
		//chỉnh trạng thái nút tạo 
		ButtonXacnhan1.setEnabled(true);	
	}
}
