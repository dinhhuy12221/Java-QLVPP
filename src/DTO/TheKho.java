package DTO;

public class TheKho {
	private String maSP;
	private String maPhieu;
	private String ngayLap;
	private double tongGiaTri;
	private int soLuong;
	private int tonCuoi;
	
	public TheKho() {
		this.maSP = "";
		this.maPhieu = "";
		this.ngayLap = "";
		this.tongGiaTri = 0;
		this.soLuong = 0;
		this.tonCuoi = 0;
	}
	
	public TheKho(String maSP, String maPhieu, String ngayLap, double tongGiaTri, int soLuong, int tonCuoi) {
		this.maSP = maSP;
		this.maPhieu = maPhieu;
		this.ngayLap = ngayLap;
		this.tongGiaTri = tongGiaTri;
		this.soLuong = soLuong;
		this.tonCuoi = tonCuoi;
	}
	
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	
	public String getMaSP() {
		return this.maSP;
	}
	
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	
	public String getMaPhieu() {
		return this.maPhieu;
	}
	
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public String getNgayLap() {
		return this.ngayLap;
	}
	
	public void setTongGiaTri(double tongGiaTri) {
		this.tongGiaTri = tongGiaTri;
	}
	
	public double getTongGiaTri() {
		return this.tongGiaTri;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public int getSoLuong() {
		return this.soLuong;
	}
	
	public void setTonCuoi(int tonCuoi) {
		this.tonCuoi = tonCuoi;
	}
	
	public int getTonCuoi() {
		return this.tonCuoi;
	}
}
