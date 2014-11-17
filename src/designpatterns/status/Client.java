package designpatterns.status;

public class Client {

	public static void main(String[] args) {
		
		State red = new RedState();
		
		Light light = new Light(red);
		
		light.work();
		
	}
	
}
