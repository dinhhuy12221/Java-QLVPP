package DTO;

public class ConNguoi {
    private String ma;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;
    private String ngaySinh;

    public ConNguoi(){
        this.ma = "";
        this.hoTen = "";
        this.diaChi = "";
        this.soDienThoai = "";
        this.ngaySinh = "";
    }

    public ConNguoi(String ma, String hoTen,String diaChi, String soDienThoai,String ngaySinh){
        this.ma = ma;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
    }

    public void setMa(String ma){
        this.ma = ma;
    }

    public String getMa(){
        return this.ma;
    }

    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }

    public String getHoTen(){
        return this.hoTen;
    }

    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }

    public String getDiaChi(){
        return this.diaChi;
    }

    public void setNgaySinh(String ngaySinh){
        this.ngaySinh = ngaySinh;
    }

    public String getNgaySinh(){
        return this.ngaySinh;
    }

    public void setSoDienThoai(String soDienThoai){
        this.soDienThoai = soDienThoai;
    }

    public String getSoDienThoai(){
        return this.soDienThoai;
    }
}
