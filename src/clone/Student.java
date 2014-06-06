package clone;

public class Student implements Cloneable{
	
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Object clone()  throws CloneNotSupportedException {
		
	
			return super.clone();
		
		
	}
	
}
