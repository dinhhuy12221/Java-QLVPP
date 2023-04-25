import DTO.TaiKhoan;
import GUI.*;

public class run {

	public static void main(String[] args) {
//		DangNhapGUI dangNhap = new DangNhapGUI();
//		dangNhap.setVisible(true);
		
		GiaoDienGUI gd = new GiaoDienGUI(new TaiKhoan());
		gd.setVisible(true);
	}

}
