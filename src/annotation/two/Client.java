package annotation.two;

import java.lang.reflect.InvocationTargetException;

public class Client {

	public static void main(String[] args) throws SecurityException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, NoSuchMethodException,
			InvocationTargetException, ClassNotFoundException {

		EmployeeService service = (EmployeeService) AnnotationFactory
				.getBean(EmployeeService.class);

		service.save();

	}

}
