package annotation.two;

public class EmployeeService {
	
	@AutoWire(name="annotation.two.EmployeeDao")
	private EmployeeDao dao;

	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	public void save() {
		
		Employee emp = new Employee();
		emp.setId(246);
		emp.setName("brzone@126.com");
		emp.setSalary(8888);
		
		dao.save(emp);
		
	}
	
}
