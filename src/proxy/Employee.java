package proxy;

public class Employee implements Person{
	
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void eat() {
		
		System.out.println(name + "  is eating.");
	}

}
