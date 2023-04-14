package DTO;

public class KhachHang extends ConNguoi{
    private double tongChiTieu;

    public KhachHang(){
        super();
        this.tongChiTieu = 0;
    }

    public KhachHang(String maKhachHang, String hoTen,String diaChi, String soDienThoai,String ngaySinh, Double tongChiTieu){
        super(maKhachHang, hoTen, diaChi, soDienThoai, ngaySinh);
        this.tongChiTieu = tongChiTieu;
    }

    public void setTongChiTieu(double tongChiTieu){
        this.tongChiTieu = tongChiTieu;
    }

    public double getTongChiTieu(){
        return this.tongChiTieu;
    }

}
