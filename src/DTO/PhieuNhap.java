package DTO;

public class PhieuNhap extends Phieu{
    private NhaCungCap nhaCungCap;

    public PhieuNhap(){
        super();
        this.nhaCungCap = null;
    }

    public PhieuNhap(String maPhieu, NhanVien nhanVien, NhaCungCap nhaCungCap,String ngayLap, double tongTien){
        super(maPhieu, nhanVien, ngayLap, tongTien);
        this.nhaCungCap = nhaCungCap;
    }

    public void setMaNhaCC(NhaCungCap nhaCungCap){
        this.nhaCungCap = nhaCungCap;
    }

    public NhaCungCap getMaNhaCC(){
        return this.nhaCungCap;
    }
}
