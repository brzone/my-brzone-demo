package gdcp.test.probuf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EmployeeClient {
	
	public static void main(String[] args) throws IOException {
		
		testRead();
	}
	
	public static void testRead() throws IOException {
		
		 BufferedInputStream is =  new BufferedInputStream( new FileInputStream("d:/a.pro"));
		 
		 System.out.println("is.available():" + is.available());
		 
		 byte[] b = new byte[is.available()];
		
		 is.read(b);
		
		 is.close();
		 EmployeeEntity.Employee emp =  EmployeeEntity.Employee.parseFrom(b);
		 System.out.println(emp);
		
	}
	
	
	public  static void testWrite() throws IOException {
		
		EmployeeEntity.Employee.Builder builder =  EmployeeEntity.Employee.newBuilder();
		builder.setId(100);
		builder.setName("scott");
		builder.setAge(22);
		
		EmployeeEntity.Employee emp = builder.build();
		
		System.out.println(emp);
		
		byte[] bytes = emp.toByteArray();
		
		System.out.println(bytes.length);
		
		BufferedOutputStream os = new BufferedOutputStream( new FileOutputStream(new File("d:/a.pro")));
		
		os.write(bytes);
		
		os.close();
		
		System.out.println("ok.");
		
	}

}
