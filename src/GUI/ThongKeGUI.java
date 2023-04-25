package GUI;

import javax.swing.JPanel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.SwingUtilities;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.*;

import java.time.LocalDateTime;

public class ThongKeGUI extends JPanel {
	JPanel panelDoanhThu = new JPanel(new BorderLayout());
	JButton btnDoanhThuNgay;
	JButton btnDoanhThuThang;
	JButton btnDoanhThuNam;
	private static ArrayList<ArrayList<String>> danhSachDoanhThu = new ArrayList<ArrayList<String>>();
	
	public ThongKeGUI() {
		setSize(1082,689);
		
		btnDoanhThuNgay = new JButton("Doanh thu theo ngày");
		btnDoanhThuNgay.setBounds(10, 14, 179, 21);
		btnDoanhThuNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDoanhThuBanHang(e);
			}
		});
		
		
		panelDoanhThu.setBounds(10, 45, 1016, 530);
		add(panelDoanhThu);
		setLayout(null);
		add(btnDoanhThuNgay);
		
		btnDoanhThuThang = new JButton("Doanh thu theo tháng");
		btnDoanhThuThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDoanhThuBanHang(e);
			}
		});
		btnDoanhThuThang.setBounds(199, 14, 180, 21);
		add(btnDoanhThuThang);
		
		btnDoanhThuNam = new JButton("Doanh thu theo năm");
		btnDoanhThuNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDoanhThuBanHang(e);
			}
		});
		btnDoanhThuNam.setBounds(389, 14, 180, 21);
		add(btnDoanhThuNam);
    }
	
	private void showDoanhThuBanHang(ActionEvent e) {
		panelDoanhThu.removeAll();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("DOANH SỐ BÁN HÀNG", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);;
		danhSachDoanhThu = BLL.ThongKeBLL.layDoanhThu();
				
		if(danhSachDoanhThu != null) {
			String temp="",d="";
			double doanhThu = 0;
			if(e.getSource() == btnDoanhThuNgay) {
				chart = ChartFactory.createBarChart("DOANH SỐ BÁN HÀNG THEO NGÀY", "Ngày", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
				for(ArrayList<String> a : danhSachDoanhThu) {
		        	doanhThu = Double.parseDouble(a.get(1).toString());
		        	dataset.setValue(doanhThu, "Doanh thu theo ngày", a.get(0));
				}
			} else if(e.getSource() == btnDoanhThuThang) {
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
				} else if(e.getSource() == btnDoanhThuNam) {
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
		}
		CategoryPlot catPlot = chart.getCategoryPlot();
		catPlot.setRangeGridlinePaint(Color.blue);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		panelDoanhThu.add(chartPanel,BorderLayout.CENTER);
		panelDoanhThu.setEnabled(false);
		panelDoanhThu.validate();
	}
}
