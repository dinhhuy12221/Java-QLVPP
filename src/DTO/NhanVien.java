package DTO;

public class NhanVien extends ConNguoi{
    private ChucVu chucVu;
    private double luong;
    private byte[] anhNhanVien;
    private String anhFilePath;

    public NhanVien(){
        super();
        this.chucVu = null;
        this.luong = 0;
    }

    public NhanVien(String maNhanVien, String hoTen,String diaChi, String soDienThoai,String ngaySinh, ChucVu chucVu,Double luong, byte[] anhNhanVien, String anhFilePath){
        super(maNhanVien, hoTen, diaChi, soDienThoai, ngaySinh);
        this.chucVu = chucVu;
        this.luong = luong;
        this.anhNhanVien = anhNhanVien;
        this.anhFilePath = anhFilePath;
    }

    public void setChucVu(ChucVu chucVu){
        this.chucVu = chucVu;
    }

    public ChucVu getChucVu(){
        return this.chucVu;
    }

    public void setLuong(double luong){
        this.luong = luong;
    }

    public double getLuong(){
        return this.luong;
    }
    
    public void setAnhNhanVien(byte[] anhNhanVien) {
    	this.anhNhanVien = anhNhanVien;
    }
    
    public byte[] getAnhNhanVien() {
    	return this.anhNhanVien;
    }
    
    public void setAnhFilePath(String anhFilePath) {
    	this.anhFilePath = anhFilePath;
    }
    
    public String getAnhFilePath() {
    	return this.anhFilePath;
    }
}
