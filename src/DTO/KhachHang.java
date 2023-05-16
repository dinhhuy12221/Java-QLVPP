package DTO;

public class KhachHang extends ConNguoi{

    public KhachHang(){
        super();
    }

    public KhachHang(String maKhachHang, String hoTen,String diaChi, String soDienThoai,String ngaySinh){
        super(maKhachHang, hoTen, diaChi, soDienThoai, ngaySinh);
    }

//    public void setTongChiTieu(double tongChiTieu){
//        this.tongChiTieu = tongChiTieu;
//    }
//
//    public double getTongChiTieu(){
//        return this.tongChiTieu;
//    }

}
