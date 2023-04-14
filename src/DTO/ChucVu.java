package DTO;

public class ChucVu {
	private String maChucVu;
	private String tenChucVu;
	
	public ChucVu() {
		this.maChucVu = "";
		this.tenChucVu = "";
	}
	
	public ChucVu(String maChucVu, String tenChucVu) {
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	
	public String getMaChucVu() {
		return this.maChucVu;
	}
	
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
	public String getTenChucVu() {
		return this.tenChucVu;
	}
}
