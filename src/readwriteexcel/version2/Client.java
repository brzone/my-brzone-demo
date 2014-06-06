package readwriteexcel.version2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WriteException;

public class Client {
	
	public static void main(String[] args) throws WriteException, IOException {
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee("001","brzone","男"));
		list.add(new Employee("003","yiiq","男"));
		list.add(new Employee("005","xiaoli","女"));
		
		String filePath = "employee.xls";
		
		File file = ExcelUtil.toExcel(list, filePath);
		
		System.out.println(file.getAbsolutePath());

	}

}
