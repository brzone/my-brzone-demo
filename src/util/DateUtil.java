package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期的工具类
 * 
 * @author brzone@126.com
 * 
 * @date 2014年5月20日 下午5:06:03
 */
public class DateUtil {

	private DateUtil() {
	}

	/**
	 * 获取当前时间的前一天的开始时间，如：今天为2014-05-20 11:11:11，返回时间为：2014-05-19 00:00:00
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getBeforeCurrentDayStartTime() {

		try {

			Calendar cal = Calendar.getInstance();

			SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

			cal.add(Calendar.DAY_OF_MONTH, -1);

			SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String strTime = YYYYMMDD.format(cal.getTime()) + " 00:00:00";

			return YYYYMMDDHHMMSS.parse(strTime);

		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 获取当前时间的前一天的最晚时间，如：今天为2014-05-20 11:11:11，返回时间为：2014-05-19 23:59:59
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getBeforeCurrentDayEndTime() {

		try {

			Calendar cal = Calendar.getInstance();

			SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

			cal.add(Calendar.DAY_OF_MONTH, -1);

			SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String strTime = YYYYMMDD.format(cal.getTime()) + " 23:59:59";

			return YYYYMMDDHHMMSS.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	
	/**
	 * 获取当前时间的最晚时间，如：今天为2014-05-20 11:11:11，返回时间为：2014-05-20 23:59:59
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getCurrentDayEndTime() {

		try {

			Calendar cal = Calendar.getInstance();

			SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

			SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String strTime = YYYYMMDD.format(cal.getTime()) + " 23:59:59";

			return YYYYMMDDHHMMSS.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	

	/**
	 * 以yyyy-MM-dd HH:mm:ss进行格式化
	 * 
	 * @param date
	 * @return
	 */
	public static String formatYYYYMMDDHHMMSS(Date date) {

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	/**
	 * 以yyyy-MM-dd HH:mm:ss进行格式化
	 * @param s
	 * @return
	 */
	public static Date parseYYYYMMDDHHMMSS(String s) {
		
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	/**
	 * 以yyyy-MM-dd进行格式化
	 * @param s
	 * @return
	 */
	public static Date parseYYYYMMDD(String s) {
		
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	/**
	 * 返回当前时间距离传递参数的日期，相隔多少秒,比如当前时间为：2014-05-22 00:00:00 ,传递的参数为：2014-05-23 00:00:00，那就返回一天的秒数：60*60*24=86400秒
	 * @param d  未来的某个时间
	 * @return
	 */
	public static long currentTimeSeparatedSecond(Date d) {
		
		if(d == null) {
			throw new IllegalArgumentException("传递的日期不能为空");
		}
		
		return (d.getTime() - new Date().getTime())/1000;
	}

	/**
	 * just for test
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		Date d = getBeforeCurrentDayStartTime();

		System.out.println(d);

		System.out.println(formatYYYYMMDDHHMMSS(d));

		System.out.println("--------------------");

		Date d2 = getBeforeCurrentDayEndTime();
		System.out.println(d2);

		System.out.println(formatYYYYMMDDHHMMSS(d2));
		
		long d1Time = d.getTime();
		
		long d2Time =  d2.getTime(); 
		
		System.out.println("d1Time:" + d1Time);
		System.out.println("d2Time:" + d2Time);
		System.out.println("d2Time-d1Time:" + (d2Time-d1Time));
		
		
		
		System.out.println("end:" + currentTimeSeparatedSecond(parseYYYYMMDDHHMMSS("2014-05-23 00:00:00")));
		
		System.out.println("getCurrentDayEndTime():" + getCurrentDayEndTime());
		
	}

}
