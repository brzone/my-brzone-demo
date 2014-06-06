import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) throws ParseException {

		/*String ip = "127.0.0.1";

		System.out.println(ip.length());
		System.out.println(ip.replace(".", ""));
		System.out.println(ip.replaceAll("\\.", ""));
		System.out.println(ip.length()-ip.replaceAll("\\.", "").length());
		*/
	//	String s = "xxx";

		//String str = null;

		/*只要保证s不为空便可以了(不会抛出空指针异常了)，str也就随意了*/
		/*boolean boo = s.equals(str);

		System.out.println(boo);

		System.out.println(System.nanoTime());
		System.out.println(System.nanoTime());*/

/*
		String low = "abcdefghjklmnopqrstuvwxyz";

		String up = low.toUpperCase();

		for(int i = 0,j = low.length();i<j;i++) {

			System.out.println((int)(low.charAt(i)));

		}

		System.out.println("*****************");
		for(int i = 0,j = up.length();i<j;i++) {

			System.out.println((int)(up.charAt(i)));

		}

		System.out.println("*****************");

		char c = 'a';

		for(int i = 0;i<26;i++) {

			System.out.println((char)(c+i));
		}*/

	/*	String s = "2008-01-10 00:00:00.0";

		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);

		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));*/

	/*	String s = "adff##dfewrw##ewrwr##";

		System.out.println(s.split("##").length);

		for(String str : s.split("##")){

			System.out.println(str);
		}*/

	/*	String a = "abc";

		String b = "abc";

		//System.out.println(a == b);


		String[] aArr = a.split(",");
		System.out.println(aArr.length +"\t" + aArr[0]);*/

		String a = "  ";

		String[] b = a.split(",");

		System.out.println(b.length);

		System.out.println("======" + b[0] + "======");



	}

}
