package common.util;


/**
 * 字符串的工具类
 * @author brzone@126.com
 *
 * @date 2014年6月16日 下午3:09:37
 */
public class StringUtil {

	private StringUtil(){}
	
	/**
	 * 如果一个字符串是空或者空字符串，返回true，否则返回false
	 * @param s
	 * @return
	 */
	public static boolean isNullOrBlank(String s) {
		
		return s == null ? true : ("".equals(s.trim())? true : false);
		
	}
	
	/**
	 * 如果一个字符串是空或者空字符串，则抛出RuntimeException(msg)异常
	 * @param s
	 */
	public static void checkIsNullOrBlank(String s,String msg) {
		
		if(isNullOrBlank(s)) {
			throw new RuntimeException(msg);
		}
	}
	
	/**
	 * just for test
	 * @param args
	 */
	public static void main(String[] args) {
		
		checkIsNullOrBlank("  dd","aa不能为空");
	}
}