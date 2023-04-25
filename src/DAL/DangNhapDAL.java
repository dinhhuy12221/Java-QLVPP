package DAL;

import DTO.ChucVu;
import DTO.TaiKhoan;

public class DangNhapDAL extends DatabaseAccess{

    public static boolean isLogin(TaiKhoan taiKhoan){
        try{
        	getConnection();
            String select = "SELECT TEN_DANG_NHAP, MAT_KHAU, NV.MA_CHUC_VU FROM TAI_KHOAN TK, NHAN_VIEN NV WHERE TK.TINH_TRANG = 'True' AND TK.TEN_DANG_NHAP = NV.MA_NV";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select);
            while(resultSet.next()){
                String tenDangNhap = resultSet.getString(1);
                String matKhau = resultSet.getString(2);
                String maChucVu = resultSet.getString(3);
                taiKhoan.setChucVu(new ChucVu(maChucVu, ""));
                if(tenDangNhap.equals(taiKhoan.getTenDangNhap()) && matKhau.equals(taiKhoan.getMatKhau())){
                    closeConnection();
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        closeConnection();
        return false;
    }
}
