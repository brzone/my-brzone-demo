import java.lang.reflect.Method;

/**
 * 心动的Employee
 * 
 * @author brzone
 * @date 2011-8-8 11:47
 */

class Employee {

	private String id;
	private String name;
	private double bouse;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBouse() {
		return bouse;
	}

	public void setBouse(double bouse) {
		this.bouse = bouse;
	}

}

public class FieldDemo {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException {

		for (Method f : Employee.class.getDeclaredMethods()) {

			System.out.println(f.getName());

		}

	}

}
