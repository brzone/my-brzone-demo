package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
	
	public static void main(String[] args) {
		
		Person emp = new Employee("scott");
		
		//对象的InvocationHandler
		InvocationHandler handler = new EmployeeHandler(emp);
		
		//代理类
		Person empProxy = (Person)Proxy.newProxyInstance(emp.getClass().getClassLoader(), 
				new Class[]{Person.class}, handler);
		
		/**
		 * 动态代理，也就是动态生成一个类，实现传进来的接口，并用传进来的InvocationHandler调用相对应
		 * 的方法来实现，有种牵线搭桥的样子
		 * 
		 * 
		 * class $Proxy0 implemnts Person {
		 * 
		 * 		private InvocationHandler handler;
		 * 
		 * 		public $Proxy0(InvocationHandler handler) {
		 * 
		 *                 this.handler = handler;
		 * 			}
		 * 			
		 * 
		 * 			public void eat() {
		 * 
		 * 					handler.eat();
		 * 
		 * 			}
		 * 
		 * }
		 * 
		 * 
		 * 
		 */
		
		
		empProxy.eat();
		
		System.out.println("----" + empProxy.getClass());
		
		for(Method m : empProxy.getClass().getMethods()) {
			
			System.out.println(m.getName());
		}
		
		
	}

}
