package readwriteexcel.version2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jxl.write.Label;

public class Employee extends AbstractExcel{
	
	private String id;
	
	private String name;
	
	private String sex;
	
	public Employee(){}
	
	public Employee(String id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	@Override public List<Label> headLabel() {
		
		return new ArrayList<Label>(
				Arrays.asList(
						new Label(0,0,"编号"),
						new Label(1,0,"用户名"),
						new Label(2,0,"性别")
							)
									);
	
	}

	@Override public List<Label> bodyLabel() {
		
		return new ArrayList<Label>(
				Arrays.asList(
						new Label(0,getRow(),getId()),
						new Label(1,getRow(),getName()),
						new Label(2,getRow(),getSex())
							)
									);
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override public String toString() {
		
		return id + "\t" + name + "\t" + sex;
	}

}
