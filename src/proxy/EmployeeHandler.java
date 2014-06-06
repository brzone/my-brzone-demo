package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EmployeeHandler implements InvocationHandler {
	
	private Object emp;
	
	

	public EmployeeHandler(Object emp) {
		super();
		this.emp = emp;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println(proxy.getClass());
		System.out.println(method.getName());
		System.out.println(Arrays.toString(args));
		
		method.invoke(emp, args);
		
		return null;
	}

}
