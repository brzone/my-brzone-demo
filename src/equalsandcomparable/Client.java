package equalsandcomparable;

import java.util.HashSet;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		
		Employee emp = new Employee("4", "scott", "SCC");
		Employee emp2 = new Employee("4", "scott2", "SCCwerwrr");
		Employee emp3 = new Employee("6", "tiger", "BJSCC");
		
		Set<Employee> set = new HashSet<Employee>();
		set.add(emp);
		set.add(emp2);
		set.add(emp3);
		System.out.println("add end");
		System.out.println(set.contains(new Employee("4","x","y")));
		
		for(Employee e  : set)
			System.out.println(e);
		
	}

}
