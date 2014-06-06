package clone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Employee implements Cloneable{

	private int eid;
	private String username;
	private String deptment;

	private Student student = new Student("yiya");

	private int[] arr = {1,3,5,7,9};

	public Employee(){}

	/**
	 *
	 * @param eid
	 * @param username
	 * @param deptment
	 */
	public Employee(int eid, String username, String deptment) {

		this.eid = eid;
		this.username = username;
		this.deptment = deptment;
	}

	public int getEid() {
		return eid;
	}

	public Employee setEid(int eid) {
		this.eid = eid;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Employee setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getDeptment() {
		return deptment;
	}

	public Employee setDeptment(String deptment) {
		this.deptment = deptment;
		return this;
	}

	public Employee changeArray() {

		arr = new int[]{2,4,6,8,10};
		return this;
	}

	public void changeStudent() {

		student.setName("brzone");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {

		Employee emp = (Employee)super.clone();
		emp.student = (Student)student.clone();

		return emp;
	}

	@Override
	public String toString() {

		return "(eid=" + eid + ", username=" + username + ", deptment="
				+ deptment +", arr=" + Arrays.toString(arr) +", student.name="+student.getName() + ")";
	}


	public String toString(Object[] obj){



		System.out.println(Arrays.toString(obj));

		return "33333";
	}


	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		Class<?> obj = Class.forName("clone.Employee");


		Method method = obj.getMethod("toString",new Class[]{Object[].class});

		//这里必须要造型为Object对象，因为invoke方法，传的值就是object的可变参数列表
		Object data = new Object[]{"aaa","bbb","ccc"};

		String s = (String)method.invoke(obj.newInstance(),data);

		System.out.println(s);
	}

}
