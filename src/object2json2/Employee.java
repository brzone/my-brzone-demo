package object2json2;

public class Employee {

	private String id;
	private String name;
	private String deptment;


	public Employee(String id, String name, String deptment) {
		this.id = id;
		this.name = name;
		this.deptment = deptment;
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



}
