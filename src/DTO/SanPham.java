package DTO;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String chatLieu;
    private String donVi;
    private LoaiSanPham loaiSanPham;
    private NhaCungCap nhaCC;
    private double giaNhap;
    private double giaBan;
    private int soLuong;
//    private byte[] anhSanPham;
    private String filePath;

    public SanPham(){
        this.maSanPham = "";
        this.tenSanPham = "";
        this.chatLieu = "";
        this.donVi = "";
        this.loaiSanPham = new LoaiSanPham();
        this.nhaCC = new NhaCungCap();
        this.giaNhap = 0;
        this.giaBan = 0;
        this.soLuong = 0;
//        this.anhSanPham = null;
        this.filePath = "";
    }

    public SanPham(String maSanPham, String tenSanPham, String chatLieu, String donVi,LoaiSanPham loaiSanPham, NhaCungCap nhaCC, double giaNhap, double giaBan, int soLuong, String filePath){
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.chatLieu = chatLieu;
        this.donVi = donVi;
        this.loaiSanPham = loaiSanPham;
        this.nhaCC = nhaCC;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
//        this.anhSanPham = anhSanPham;
        this.filePath = filePath;
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
    
    public void setDonVi(String donVi) {
    	this.donVi = donVi;
    }
    
    public String getDonVi() {
    	return this.donVi;
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

    public void setGiaBan(double giaBan){
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
    
//    public void setAnhSanPham(byte[] anhSanPham) {
//    	this.anhSanPham = anhSanPham;
//    }
//    
//    public byte[] getAnhSanPham() {
//    	return this.anhSanPham;
//    }
    
    public void setFilePath(String filePath) {
    	this.filePath = filePath;
    }
    
    public String getFilePath() {
    	return this.filePath;
    }
}
