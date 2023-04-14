package DTO;

public class ChiTietPhieu {
    private String maPhieu;
    private String maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietPhieu(){
        this.maPhieu = "";
        this.maSanPham = "";
        this.soLuong = 0;
        this.donGia = 0;
        this.thanhTien = 0;
    }

    public ChiTietPhieu(String maPhieu, String maSanPham, int soLuong, double donGia, double thanhTien){
        this.maPhieu = maPhieu;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public void setMaPhieu(String maPhieu){
        this.maPhieu = maPhieu;
    }

    public String getMaPhieu(){
        return this.maPhieu;
    }

    public void setMaSanPham(String maSanPham){
        this.maSanPham = maSanPham;
    }

    public String getMaSanPham(){
        return this.maSanPham;
    }

    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }

    public int getSoLuong(){
        return this.soLuong;
    }

    public void setDonGia(double donGia){
        this.donGia = donGia;
    }

    public double getDonGia(){
        return this.donGia;
    }

    public void setThanhTien(double thanhTien){
        this.thanhTien = thanhTien;
    }

    public double getThanhTien(){
        return this.thanhTien;
    }
}
