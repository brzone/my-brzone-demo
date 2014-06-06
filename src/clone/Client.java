package clone;

public class Client {

	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Employee emp = new Employee(7, "scott", "SCC");
		
		Employee clone = (Employee)emp.clone();
		
		System.out.println(emp);
		System.out.println(clone);
	
		clone.setEid(8).setUsername("tiger").setDeptment("BJSCC").changeArray().changeStudent();
		
		System.out.println("------After clone-------------------");
		
		/**
		 *  在需克隆的对象中，若只有不可变对象和基本类型，Object的clone方法可以
		 * 满足需求，但是对于不可变的，便要在度克隆
		 * 
		 */
		
		System.out.println(emp);
		System.out.println(clone);
	}

}
