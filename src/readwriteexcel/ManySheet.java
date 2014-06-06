package readwriteexcel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ManySheet {
	
	public static void test() throws IOException, RowsExceededException, WriteException {
		
		WritableWorkbook wwb = Workbook.createWorkbook(new File("D://workbook.xls"));
		
		WritableSheet ws = wwb.createSheet("sheet1", 0);
		
		for(int row = 0;row<20000;row++) {
			
			for(int column = 0;column < 10;column++) {
				
				Label label = new Label(column,row,"第"+ row + "行"+ "第" + column + "列" );
				
				ws.addCell(label);
				
			}
			
		}
		
		wwb.close();
		
	}
	
	
	public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
		
		test();
		
	}

}
