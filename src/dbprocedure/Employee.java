package dbprocedure;

public class Employee {

	private int eid;
	private String username;
	private String deptment;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeptment() {
		return deptment;
	}

	public void setDeptment(String deptment) {
		this.deptment = deptment;
	}
	
	@Override
	public String toString() {
		
		return "eid:" + eid + "\nusername:" + username + "\ndeptment:" + deptment;
	}

}
