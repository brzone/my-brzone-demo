package parsexml;

public class Person {

	private String id;

	private String name;

	private String age;

	private Deptment deptment;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Deptment getDeptment() {
		return deptment;
	}

	public void setDeptment(Deptment deptment) {
		this.deptment = deptment;
	}
	
	@Override
	public String toString() {
		
		return id + "\t" + name + "\t" + age + "\t" + deptment;
	}

}
