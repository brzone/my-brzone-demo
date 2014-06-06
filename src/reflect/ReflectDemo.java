package reflect;

import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) {

		for (Method method : Person.class.getMethods()) {

			System.out.println(method.getName());
		}

		System.out.println("-----------------------------");

		/*getDeclaredMethods，得到本类，继承方法不在此范围，任何修饰在方法前都亦可*/
		for (Method method : Person.class.getDeclaredMethods()) {

			System.out.println(method.getName() + "\t" + method.isAccessible());
		}

	}

}
