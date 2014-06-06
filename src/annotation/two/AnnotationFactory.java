package annotation.two;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationFactory {

	public  static  Object getBean(Class<?> t) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {

		Object obj = t.newInstance();

		Field[] fields = t.getDeclaredFields();

		for(Field f : fields) {

			if(f.isAnnotationPresent(AutoWire.class)) {


				AutoWire wire = f.getAnnotation(AutoWire.class);

				String clazzName = wire.name();
				//这里如果是交给某中容器管理,譬如spring，咱们也是可以从容器中获取自己想要注入的对象的
				Object inject = Class.forName(clazzName).newInstance();

				String fieldName = f.getName();

				String mName = fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

				//当然域的类型，也就是pojo中set方法中的传入参数的类型了。
				Method method = t.getMethod("set" + mName, f.getType());

				method.invoke(obj, inject);

				//return obj;
			}


		}


		return obj;
	}

}
