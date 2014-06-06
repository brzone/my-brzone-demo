package gdcp.test.probuf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CompanyClient {
	
	public static void testRead() throws IOException {
		
		BufferedInputStream is = new BufferedInputStream(new FileInputStream("d:/company2.pro"));
		
		byte[] arr = new byte[is.available()];
		
		is.read(arr);
		
		is.close();
		
		CompanyEntity.Company company =  CompanyEntity.Company.parseFrom(arr);
		
		System.out.println(company);
	}
	
	
	public static void testWrite() throws IOException {
		
		EmployeeEntity.Employee.Builder builer1 =  EmployeeEntity.Employee.newBuilder();
		builer1.setId(11);
		builer1.setName("scott");
		builer1.setAge(12);
		EmployeeEntity.Employee emp1 = builer1.build();
		
		
		EmployeeEntity.Employee.Builder builer2 =  EmployeeEntity.Employee.newBuilder();
		builer2.setId(33);
		builer2.setName("tiger");
		builer2.setAge(55);
		EmployeeEntity.Employee emp2 = builer2.build();
		
		
		CompanyEntity.Company.Builder builder =  CompanyEntity.Company.newBuilder();
		
		builder.setId(888);
		builder.addEmployees(emp1);
		builder.addEmployees(emp2);
		
		CompanyEntity.Company company =  builder.build();
		
		System.out.println(company);
		
		byte[] arr = company.toByteArray();
		
		System.out.println(arr.length);
		
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("d:/company2.pro"));
		
		os.write(arr);
		
		os.close();
		
		System.out.println("write ok..");
	}
	

	public static void main(String[] args) throws IOException {
		
		//testWrite();
		testRead();
		
	}
}
