package enumtest;



/**
 *
 * @author Jian Lee
 * @mail   brzone@126.com
 * @date 2012-11-23 下午04:56:38
 */
public class CarClient {

	public static void testCase(Car car) {

		switch (car) {

		/**
		 * 这里有个问题，为什么要直接引用变量，而不是Car.SMAll ？？
		 *
		 *
		 */
		case SMAll:
			System.out.println("this is small");
			break;

		case MIDDLE:
			System.out.println("this is small");
			break;
		case BIG:
			System.out.println("this is small");
			break;

		default:

			System.out.println("bad man");
			break;
		}


	}

	public static void info(Car car) {

		System.out.println("cost:" + car.getMoney());
		//invoke the toString method,hehe ,i was override the method,do you know?
		System.out.println(car);

	}

	public static void main(String[] args) {

		for(Car car :Car.values()) {

			System.out.println(car);

		}

		System.out.println("######################################");


		for(Car car :Car.values()) {

			testCase(car);

		}

		System.out.println("######################################");

		for(Car car :Car.values()) {

			info(car);

		}

	}

}
