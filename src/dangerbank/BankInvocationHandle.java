package dangerbank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BankInvocationHandle implements InvocationHandler {

	private Object proxied;
	
	private final Object lock = new Object();
	
	public BankInvocationHandle(Object proxied) {
		
		this.proxied = proxied;
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		synchronized(lock) {
			
			return method.invoke(proxied, args);
			
		}
		
		
	}

}
