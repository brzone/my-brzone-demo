
public class TestFinally {

	public static String  test() {

		try {

			System.out.println("try");

			if("dddddd".length() > 0) {

				System.out.println("dddddd");
				return "ddddd";
			}

			return "ddd";

		}catch(Exception e) {

			System.out.println("error");
		} finally {
			//不管有无异常，finally语句必须会执行。。
			System.out.println("finally");

		}

		return "ddd";

	}




	public static void main(String[] args) {

		test();

	}

}
