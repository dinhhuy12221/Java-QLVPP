package DTO;

import java.util.ArrayList;
import java.util.Date;

public class Phieu {
    private String maPhieu;
    private NhanVien nhanVien;
    private ArrayList<ChiTietPhieu> dsct;
    private String ngayLap;
    private double tongTien;

    public Phieu(){
        this.maPhieu = "";
        this.nhanVien = new NhanVien();
        this.dsct = new ArrayList<ChiTietPhieu>();
        this.ngayLap = "";
        this.tongTien = 0;
    }

    public Phieu(String maPhieu, NhanVien nhanVien,ArrayList<ChiTietPhieu> dsct, String ngayLap, double tongTien){
        this.maPhieu = maPhieu;
        this.nhanVien = nhanVien;
        this.dsct = dsct;
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
    
    public void setDSCT(ArrayList<ChiTietPhieu> dsct) {
    	this.dsct = dsct;
    }
    
    public ArrayList<ChiTietPhieu> getDSCT(){
    	return this.dsct;
    }
    

    public void setNgayLap(String ngayLap){
        this.ngayLap = ngayLap;
    }

    public String getNgayLap(){
        return this.ngayLap;
    }

    public void setTongTien(double tongTien){
        this.tongTien = tongTien;
    }

    public double getTongTien(){
        return this.tongTien;
    }
}
