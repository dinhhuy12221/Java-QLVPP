package DTO;

public class TaiKhoan {
    private String tenDangNhap;
    private String tenNhanVien;
    private ChucVu chucVu;
    private String matKhau;
    private String tinhTrang;

    public TaiKhoan(){
        this.tenDangNhap = "";
        this.tenNhanVien = "";
        this.matKhau = "";
        this.tinhTrang = "";
    }

    public TaiKhoan(String tenDangNhap, String tenNhanVien, ChucVu chucVu, String matKhau, String tinhTrang){
        this.tenDangNhap = tenDangNhap;
        this.tenNhanVien = tenNhanVien;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
    }

    public void setTenDangNhap(String tenDangNhap){
        this.tenDangNhap = tenDangNhap;
    }

    public String getTenDangNhap(){
        return this.tenDangNhap;
    }
    
    public void setTenNhanVien(String tenNhanVien) {
    	this.tenNhanVien = tenNhanVien;
    }
    
    public String getTenNhanVien() {
    	return this.tenNhanVien;
    }
    
    public void setChucVu(ChucVu chucVu){
        this.chucVu = chucVu;
    }

    public ChucVu getChucVu(){
        return this.chucVu;
    }

    public void setMatKhau(String matKhau){
        this.matKhau = matKhau;
    }

    public String getMatKhau(){
        return this.matKhau;
    }
    
    public void setTinhTrang(String tinhTrang) {
    	this.tinhTrang = tinhTrang;
    }
    
    public String getTinhTrang() {
    	return this.tinhTrang;
    }
}
