package readwriteexcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFile {
	
	public static void read(File file) throws BiffException, IOException {
		
		Workbook wb=Workbook.getWorkbook(file);
		
		//获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
		
		//一个 Excel可能有很多个Sheet(工作区间)
		Sheet[] sheet = wb.getSheets();
		
		List<Person> list = new ArrayList<Person>();
		
		for(int i = 0,sheetlength = sheet.length;i<sheetlength;i++) {
			
			int rowCount = sheet[i].getRows();
			//去掉第一行
			for(int j = 0 + 1;j<rowCount;j++) {
				
				//某一行的所有单元格
				Cell[] cells = sheet[i].getRow(j);
				
				list.add(new Person(cells[0].getContents(),cells[1].getContents()));
				
			}
		}
		
		wb.close();
		
		for(Person person : list) {
			
			System.out.println(person);
		}
		
	}
	
	public static void main(String[] args) throws BiffException, IOException {
		
		//read(new File("d://brzone.xls"));
		
		//System.out.println(System.getProperty("user.dir")+"brzonett.txt");
		
		new File(System.getProperty("user.dir") + "\\temp").mkdir();
		
		File file = new File(System.getProperty("user.dir") + "\\temp","\\brzonett.txt");
		// 创建文件用createNewFile
		file.createNewFile();
		
		//创建路径 file.mkdir();
		
		
	}

}
