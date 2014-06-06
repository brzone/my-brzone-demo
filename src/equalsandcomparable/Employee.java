package equalsandcomparable;

public class Employee {

	private String id;
	private String name;
	private String deptment;

	public Employee(String id, String name, String deptment) {
		this.id = id;
		this.name = name;
		this.deptment = deptment;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		System.out.println("equals()");
		
		if(this == obj) return true;
		
		if(!(obj instanceof Employee)) return false;
		
		Employee e = (Employee)obj;
		
		return id == null ? e.getId() == null : id.equals(e.getId());
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode()");
		return 52;
	}

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

	public String getDeptment() {
		return deptment;
	}

	public void setDeptment(String deptment) {
		this.deptment = deptment;
	}

	@Override
	public String toString() {
		
		return "(id=" + id + ", name=" + name + ", deptment=" + deptment + ")";
	}
	
}
