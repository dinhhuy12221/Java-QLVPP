import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

public class test2 {
	public static void main(String[] args) {
//		String d;
//		String ngaysinh = "";
//		try {
//			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//			d = df.format("Sat Apr 08 00:00:00 ICT 2023");
//			
//			System.out.print(d);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date date = cal.getTime();  
		System.out.print(date.toString());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");          
		String inActiveDate = null;
		try {
		    inActiveDate = format1.format(date);
		    System.out.println(inActiveDate );
		} catch (Exception e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
	}
}
