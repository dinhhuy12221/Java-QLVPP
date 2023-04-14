package DTO;

public class NhanVien extends ConNguoi{
    private ChucVu chucVu;
    private double luong;
    private byte[] anhNhanVien;

    public NhanVien(){
        super();
        this.chucVu = null;
        this.luong = 0;
    }

    public NhanVien(String maNhanVien, String hoTen,String diaChi, String soDienThoai,String ngaySinh, ChucVu chucVu,Double luong){
        super(maNhanVien, hoTen, diaChi, soDienThoai, ngaySinh);
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public void setChucVu(ChucVu chucVu){
        this.chucVu = chucVu;
    }

    public ChucVu getChucVu(){
        return this.chucVu;
    }

    public void setLuong(double luong){
        this.luong = luong;
    }

    public double getLuong(){
        return this.luong;
    }
}
