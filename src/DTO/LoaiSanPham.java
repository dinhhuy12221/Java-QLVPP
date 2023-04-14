package DTO;

public class LoaiSanPham {
    private String maLoaiSanPham;
    private String tenLoaiSanPham;

    public LoaiSanPham(){
        this.maLoaiSanPham = "";
        this.tenLoaiSanPham = "";
    }

    public LoaiSanPham(String maLoaiSanPham, String tenLoaiSanPham){
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public void setMaLoaiSanPham(String maLoaiSanPham){
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getMaLoaiSanPham(){
        return this.maLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham){
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public String getTenLoaiSanPham(){
        return this.tenLoaiSanPham;
    }
}
