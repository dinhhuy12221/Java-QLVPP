package DAL;

import DTO.TaiKhoan;

public class DangNhapDAL extends DatabaseAccess{

    public static boolean isLogin(TaiKhoan taiKhoan){
        try{
        	getConnection();
            String select = "SELECT * FROM TAI_KHOAN WHERE TINH_TRANG = 'True'";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(select);
            while(resultSet.next()){
                String tenDangNhap = resultSet.getString(1);
                String matKhau = resultSet.getString(2);
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
