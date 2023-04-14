package DTO;

public class NhaCungCap {
    private String maNhaCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    public NhaCungCap(){
        this.maNhaCC = "";
        this.tenNhaCC = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }

    public NhaCungCap(String maNhaCC, String tenNhaCC, String diaChi, String soDienThoai){
        this.maNhaCC = maNhaCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public void setMaNhaCC(String maNhaCC){
        this.maNhaCC = maNhaCC;
    }

    public String getMaNhaCC(){
        return this.maNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC){
        this.tenNhaCC = tenNhaCC;
    }

    public String getTenNhaCC(){
        return this.tenNhaCC;
    }

    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }

    public String getDiaChi(){
        return this.diaChi;
    }

    public void setSoDienThoai(String soDienThoai){
        this.soDienThoai = soDienThoai;
    }

    public String getSoDienThoai(){
        return this.soDienThoai;
    }
}
