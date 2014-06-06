package readwriteexcel;

public class Person {

	private String name;
	
	private String carType;

	public Person(String name, String carType) {
		this.name = name;
		this.carType = carType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	@Override public String toString() {
		
		return name + "\t" + carType;
	}
	
}
