package DTO;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String chatLieu;
    private LoaiSanPham loaiSanPham;
    private NhaCungCap nhaCC;
    private double giaNhap;
    private double giaBan;
    private int soLuong;
    private byte[] anhSanPham;

    public SanPham(){
        this.maSanPham = "";
        this.tenSanPham = "";
        this.chatLieu = "";
        this.loaiSanPham = null;
        this.nhaCC = null;
        this.giaNhap = 0;
        this.giaBan = 0;
        this.soLuong = 0;
        this.anhSanPham = null;
    }

    public SanPham(String maSanPham, String tenSanPham, String chatLieu, LoaiSanPham loaiSanPham, NhaCungCap nhaCC, double giaNhap, double giaBan, int soLuong, byte[] anhSanPham){
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.chatLieu = chatLieu;
        this.loaiSanPham = loaiSanPham;
        this.nhaCC = nhaCC;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.anhSanPham = anhSanPham;
    }

    public void setMaSanPham(String maSanPham){
        this.maSanPham = maSanPham;
    }

    public String getMaSanPham(){
        return this.maSanPham;
    }

    public void setTenSanPham(String tenSanPham){
        this.tenSanPham = tenSanPham;
    }

    public String getTenSanPham(){
        return this.tenSanPham;
    }

    public void setChatLieu(String chatLieu){
        this.chatLieu = chatLieu;
    }

    public String getChatLieu(){
        return this.chatLieu;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham){
        this.loaiSanPham = loaiSanPham;
    }

    public LoaiSanPham getLoaiSanPham(){
        return this.loaiSanPham;
    }
    
    public void setNhaCC(NhaCungCap nhaCC) {
    	this.nhaCC = nhaCC;
    }
    
    public NhaCungCap getNhaCC() {
    	return this.nhaCC;
    }

    public void setGiaNhap(double giaNhap){
        this.giaNhap = giaNhap;
    }

    public double getGiaNhap(){
        return this.giaNhap;
    }

    public void setGiaNBan(double giaBan){
        this.giaBan = giaBan;
    }

    public double getGiaBan(){
        return this.giaBan;
    }

    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }

    public int getSoLuong(){
        return this.soLuong;
    }
    
    public void setAnhSanPham(byte[] anhSanPham) {
    	this.anhSanPham = anhSanPham;
    }
    
    public byte[] getAnhSanPham() {
    	return this.anhSanPham;
    }
}
