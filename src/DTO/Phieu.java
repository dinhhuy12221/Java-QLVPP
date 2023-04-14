package DTO;

public class Phieu {
    private String maPhieu;
    private NhanVien nhanVien;
    private String ngayLap;
    private double tongTien;

    public Phieu(){
        this.maPhieu = "";
        this.nhanVien = null;
        this.ngayLap = "";
        this.tongTien = 0;
    }

    public Phieu(String maPhieu, NhanVien nhanVien, String ngayLap, double tongTien){
        this.maPhieu = maPhieu;
        this.nhanVien = nhanVien;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public void setMaPhieu(String maPhieu){
        this.maPhieu = maPhieu;
    }

    public String getMaPhieu(){
        return this.maPhieu;
    }

    public void setNhanVien(NhanVien nhanVien){
        this.nhanVien = nhanVien;
    }

    public NhanVien getNhanVien(){
        return this.nhanVien;
    }

    public void setNgayLap(String ngayLap){
        this.ngayLap = ngayLap;
    }

    public String getNgayLap(String ngayLap){
        return this.ngayLap;
    }

    public void setTongTien(double tongTien){
        this.tongTien = tongTien;
    }

    public double getTongTien(){
        return this.tongTien;
    }
}
