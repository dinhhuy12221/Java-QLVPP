package GUI;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;

public class ThongKeGUI extends JPanel {
	
	JPanel panelThongKe = new JPanel(new BorderLayout());
	private static ArrayList<ArrayList<String>> danhSachDoanhThu = new ArrayList<ArrayList<String>>();
	private static ArrayList<ArrayList<String>> danhSachChiTieu = new ArrayList<ArrayList<String>>();
	private JLabel lblDoanhThu;
	private JComboBox cbDoanhThu;
	private JLabel lblChiTieu;
	private JComboBox cbChiTieu;
	
	public ThongKeGUI() {
		setSize(1269,679);
		setLayout(null);
		
		lblChiTieu = new JLabel("Thống kê chi tiêu");
		lblChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChiTieu.setBounds(362, 29, 140, 29);
		add(lblChiTieu);
		
		cbChiTieu = new JComboBox();
		cbChiTieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showChiTieu(cbChiTieu.getSelectedIndex());
			}
		});
		cbChiTieu.setModel(new DefaultComboBoxModel(new String[] {"", "Ngày", "Tháng", "Năm"}));
		cbChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbChiTieu.setBounds(512, 35, 134, 21);
		add(cbChiTieu);
		
		lblDoanhThu = new JLabel("Thống kê doanh thu");
		lblDoanhThu.setBounds(10, 29, 140, 29);
		add(lblDoanhThu);
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbDoanhThu = new JComboBox();
		cbDoanhThu.setBounds(160, 34, 134, 21);
		add(cbDoanhThu);
		cbDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDoanhThuBanHang(cbDoanhThu.getSelectedIndex());
			}
		});
		cbDoanhThu.setModel(new DefaultComboBoxModel(new String[] {"", "Ngày", "Tháng", "Năm"}));
		cbDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelThongKe.setBounds(10, 86, 1249, 582);
		add(panelThongKe);
		
//		tabbedPane.addTab("Doanh thu", null, panelThongKe, null);

    }
	
	private void showDoanhThuBanHang(int i) {
		panelThongKe.removeAll();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("DOANH SỐ BÁN HÀNG", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);;
		danhSachDoanhThu = BLL.ThongKeBLL.layDoanhThu();
				
		if(danhSachDoanhThu !=null && i != -1) {
			String temp="",d="";
			double doanhThu = 0;
			if(i == 1) {
				chart = ChartFactory.createBarChart("DOANH SỐ BÁN HÀNG THEO NGÀY", "Ngày", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
				int count = 0;
				for(ArrayList<String> a : danhSachDoanhThu) {
					if(count < 7) {
			        	doanhThu = Double.parseDouble(a.get(1).toString());
			        	dataset.setValue(doanhThu, "Doanh thu theo ngày", a.get(0));
						count ++;
					}
				}
			} else if(i == 2) {
				temp="";
				chart = ChartFactory.createBarChart("DOANH SỐ BÁN HÀNG THEO THÁNG", "Tháng", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
				for(ArrayList<String> a : danhSachDoanhThu) {
		        	String[] date = a.get(0).toString().split("-");
		        	d = date[1]+"-"+date[0];
		        	if(temp.equals("")) temp = date[1]+"-"+date[0]; 
		        	if (temp.equals(d)) doanhThu += Double.parseDouble(a.get(1).toString());
		        	else {
		        		dataset.setValue(doanhThu, "Doanh thu theo tháng", temp);
		        		doanhThu = Double.parseDouble(a.get(1).toString());
		        		temp = d;
		        		}
		        	}
				dataset.setValue(doanhThu, "Doanh thu theo tháng", temp);
				} else if(i == 3) {
					temp="";
					chart = ChartFactory.createBarChart("DOANH SỐ BÁN HÀNG THEO NĂM", "Năm", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
					for(ArrayList<String> a : danhSachDoanhThu) {
						String[] date = a.get(0).toString().split("-");
			        	d = date[0];
			        	if(temp.equals("")) temp = date[0]; 
			        	if (temp.equals(d)) doanhThu += Double.parseDouble(a.get(1).toString());
			        	else {
			        		dataset.setValue(doanhThu, "Doanh thu theo năm", temp);
			        		doanhThu = Double.parseDouble(a.get(1).toString());
			        		temp = d;
			        		}
			        	}
					dataset.setValue(doanhThu, "Doanh thu theo năm", temp);
				}
			CategoryPlot catPlot = chart.getCategoryPlot();
			catPlot.setRangeGridlinePaint(Color.blue);
			
			ChartPanel chartPanel = new ChartPanel(chart);
			panelThongKe.add(chartPanel,BorderLayout.CENTER);
			panelThongKe.setEnabled(false);
			panelThongKe.validate();
		}
	}
	
	private void showChiTieu(int i) {
		panelThongKe.removeAll();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("CHI TIÊU MUA HÀNG", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);;
		danhSachChiTieu = BLL.ThongKeBLL.layChiTieu();
				
		if(danhSachChiTieu != null  && i != -1) {
			String temp="",d="";
			double chiTieu = 0;
			if(i == 1) {
				chart = ChartFactory.createBarChart("CHI TIÊU MUA HÀNG THEO NGÀY", "Ngày", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
				int count = 0;
				for(ArrayList<String> a : danhSachChiTieu) {
					if(count < 7) {
						chiTieu = Double.parseDouble(a.get(1).toString());
			        	dataset.setValue(chiTieu, "Chi tiêu theo ngày", a.get(0));
			        	count ++;
					}
				}
			} else if(i == 2) {
				temp="";
				chart = ChartFactory.createBarChart("CHI TIÊU MUA HÀNG THEO THÁNG", "Tháng", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
				for(ArrayList<String> a : danhSachChiTieu) {
		        	String[] date = a.get(0).toString().split("-");
		        	d = date[1]+"-"+date[0];
		        	if(temp.equals("")) temp = date[1]+"-"+date[0]; 
		        	if (temp.equals(d)) chiTieu += Double.parseDouble(a.get(1).toString());
		        	else {
		        		dataset.setValue(chiTieu, "Doanh thu theo tháng", temp);
		        		chiTieu = Double.parseDouble(a.get(1).toString());
		        		temp = d;
		        		}
		        	}
				dataset.setValue(chiTieu, "Chi tiêu theo tháng", temp);
				} else if(i == 3) {
					temp="";
					chart = ChartFactory.createBarChart("CHI TIÊU MUA HÀNG THEO NĂM", "Năm", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
					for(ArrayList<String> a : danhSachChiTieu) {
						String[] date = a.get(0).toString().split("-");
			        	d = date[0];
			        	if(temp.equals("")) temp = date[0]; 
			        	if (temp.equals(d)) chiTieu += Double.parseDouble(a.get(1).toString());
			        	else {
			        		dataset.setValue(chiTieu, "Chi tiêu theo năm", temp);
			        		chiTieu = Double.parseDouble(a.get(1).toString());
			        		temp = d;
			        		}
			        	}
					dataset.setValue(chiTieu, "Chi tiêu theo năm", temp);
				}
			CategoryPlot catPlot = chart.getCategoryPlot();
			catPlot.setRangeGridlinePaint(Color.blue);
			
			ChartPanel chartPanel = new ChartPanel(chart);
			panelThongKe.add(chartPanel,BorderLayout.CENTER);
			panelThongKe.setEnabled(false);
			panelThongKe.validate();
		}
	}
}
