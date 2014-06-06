package maywide.export;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author li jian
 *
 * @date 2012-9-4 上午10:13:07
 */
public class DateUtil {

	private static final SimpleDateFormat DATE_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getDateHHMMSS() {

		return DATE_HH_MM_SS.format(new Date());
	}

	public static String getDateHHMMSS(Date date) {

		return DATE_HH_MM_SS.format(date);
	}

	/**
	 * just for test
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getDateHHMMSS());



	}

}
