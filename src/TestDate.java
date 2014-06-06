import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestDate {

	public  static void main(String[] args) throws ParseException {




		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date otherDate = sdf.parse("2013-05-01");

		System.out.println(otherDate);

		Date date = new Date();

		System.out.println(date);


		//如果，在当前时间后，急返回ture，则是非及时，N
		System.out.println(otherDate.after(date));


		SimpleDateFormat sss = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

		String currentTime = sss.format(new Date());

		System.out.println(currentTime);

	}
}
