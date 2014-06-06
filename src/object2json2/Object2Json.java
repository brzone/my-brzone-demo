package object2json2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Object2Json {

	public static <T> String pase(Collection<T> coll) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		if (coll == null || coll.size() == 0) return "";

		StringBuilder sb = new StringBuilder("[");

		Field[] field = null;

		Class<?> clazz = null;

		for (T t : coll) {

			sb.append("{");

			if (field == null) {

				field = t.getClass().getDeclaredFields();
				clazz = t.getClass();

			}

			for (Field f : field) {

				String methodname = "get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1);

				//getXxx()方法是没有参数的，故传一个空的class数组进去
				Method method = clazz.getDeclaredMethod(methodname,
						new Class[] {});

				Object obj = method.invoke(t);

				sb.append("'"+f.getName() + "':");

				sb.append("'" + obj + "'");

				sb.append(",");
			}
			//删掉最后一个豆号
			sb.delete(sb.length() - 1, sb.length());

			sb.append("}");
			sb.append(",");

		}

		//删掉最后一个豆号
		sb.delete(sb.length() - 1, sb.length());

		sb.append("]");

		return sb.toString();
	}

	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("001","brzone","FBI"));
		list.add(new Employee("003","lili","清洁部门"));
		list.add(new Employee("007","scott","BJSCC"));

		String s = pase(list);

		System.out.println(s);
	}

}
