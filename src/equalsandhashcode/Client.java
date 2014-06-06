package equalsandhashcode;

import java.util.HashMap;
import java.util.Map;

public class Client {
	
	public static void main(String[] args) {
		
		/**
		 * override the equals method must be override hashCode method,
		 * or it can make you unhappy.
		 */
		
		/**
		 * 若立志于想成为一个优秀的程序员，必须对自己写下的代码负责，代码也是
		 * 生命，这是一种生活态度，敞篷也是一种态度.
		 * 
		 * 
		 */
		
		
		Map<Employee, String> map = new HashMap<Employee, String>();
		
		Employee emp = new Employee();
		emp.setId(17);
		emp.setName("scott");
		emp.setDeptment("SCC");
		
		System.out.println(emp.hashCode());
		
		map.put(emp, "scott");
		
		String name = map.get(new Employee(17,"scott","SCC"));
		
		System.out.println(name);
	}
	
}
