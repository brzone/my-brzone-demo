package annotation;

import java.lang.reflect.Field;

@Description(author = "brzone", age = 10)
public class DescriptionDemo {

	@Description(author = "", age = 0, sex = "女")
	public String sex;

	public static void main(String[] args) {

		Class<DescriptionDemo> clazz = DescriptionDemo.class;

		/* 判断DescriptionDemo.class是否有Description的注解 */
		if (clazz.isAnnotationPresent(Description.class)) {

			/* 
			 * 通过某类的Class得到他的注解对象,需传注解的Class类型
			 * 		注解在类（class）上的，用该类的getAnnotation得到注解对象，
			 * 		如果是注解在method上，首先利用反射得到其方法，在method.getAnnotation得到注解对象
			 * 		如果是注解在Field上，当然是Field.getAnnotation得到注解对象
			 */
			Description description = clazz.getAnnotation(Description.class);

			/* 调用注解对象的方法 */
			String author = description.author();

			int age = description.age();

			System.out.println(author + "\t" + age);

		}

		// annotation in field

		System.out.println("********************************");

		Field[] fields = clazz.getFields();

		for (Field f : fields) {

			//当然方法也有是否有某注解的判断
			if(f.isAnnotationPresent(Description.class)) {
			
			System.out.println(f.getName());
			Description des = f.getAnnotation(Description.class);

			System.out.println("author:" + des.author());

			System.out.println("sex:" + des.sex());
			
			}
		}

	}

}
