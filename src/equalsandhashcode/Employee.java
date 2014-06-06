package equalsandhashcode;
/**
 * 
 * @author jian.li
 *
 */
public class Employee {

	private int id;
	private String name;
	private String deptment;

	public Employee() {}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param deptment
	 */
	public Employee(int id, String name, String deptment) {
		this.id = id;
		this.name = name;
		this.deptment = deptment;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Employee)) return false;
		
		Employee e = (Employee)obj;
		
		/*测试是否为空，是为了避免出现空指针异常*/
		return id == e.getId() 
			   && (name== null ? e.getName()==null : name.equals(e.getName())
			   && (deptment == null ? e.getDeptment() == null : deptment.equals(e.getDeptment())));
	}
	
	@Override
	public int hashCode(){
		
		return id + name.hashCode() + deptment.hashCode();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	public String toString(){
		
		return String.valueOf(id) + "  " + name + "  " + deptment;
	}

}
