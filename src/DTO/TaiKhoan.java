package DTO;

public class TaiKhoan {
    private String tenDangNhap;
    private String tenNhanVien;
    private String matKhau;
    private ChucVu chucVu;
    private String quyenTaiKhoan;
    private String tinhTrang;

    public TaiKhoan(){
        this.tenDangNhap = "";
        this.tenNhanVien = "";
        this.matKhau = "";
        this.quyenTaiKhoan = "";
        this.tinhTrang = "";
    }

    public TaiKhoan(String tenDangNhap, String tenNhanVien,String matKhau, ChucVu chucVu,String quyenTaiKhoan, String tinhTrang){
        this.tenDangNhap = tenDangNhap;
        this.tenNhanVien = tenNhanVien;
        this.quyenTaiKhoan = quyenTaiKhoan;
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
    
    public void setChucVu(ChucVu chucVu) {
    	this.chucVu = chucVu;
    }
    
    public ChucVu getChucVu() {
    	return this.chucVu;
    }
    
    public void setQuyenTaiKhoan(String quyenTaiKhoan){
        this.quyenTaiKhoan = quyenTaiKhoan;
    }

    public String getQuyenTaiKhoan(){
        return this.quyenTaiKhoan;
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
