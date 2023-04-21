package DTO;

public class ChiTietPhieu {
    private SanPham sanPham;
    private double thanhTien;

    public ChiTietPhieu(){
        this.sanPham = null;
        this.thanhTien = 0;
    }

    public ChiTietPhieu( SanPham sanPham, double thanhTien){
        this.sanPham = sanPham;
        this.thanhTien = thanhTien;
    }

    public void setSanPham(SanPham sanPham){
        this.sanPham = sanPham;
    }
    
    public SanPham getSanPham() {
    	return this.sanPham;
    }

    public void setThanhTien(double thanhTien){
        this.thanhTien = thanhTien;
    }

    public double getThanhTien(){
        return this.thanhTien;
    }
}
