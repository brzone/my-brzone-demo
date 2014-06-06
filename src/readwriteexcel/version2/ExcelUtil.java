package readwriteexcel.version2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * Excel的工具类
 * @author li.jian
 * @date 2011-10-13 下午02:50:17
 */
public class ExcelUtil {
	
	/**
	 * 默认情况下(第一行为标题，数据主体从第二行开始)，数据集合转成Excel
	 * @param list
	 * @param filePath
	 * @return
	 * @throws WriteException
	 * @throws IOException
	 */
	public static File toExcel(List<? extends AbstractExcel> list,String filePath) throws WriteException, IOException {
		
		return toExcelTemplate(list,-1,filePath);
	}
	
	public static File toExcel(List<? extends AbstractExcel> list,int bodyBeginRowNumber,String filePath) throws WriteException, IOException {
		
		return toExcelTemplate(list,bodyBeginRowNumber,filePath);
	}
	
	private static File toExcelTemplate(List<? extends AbstractExcel> list,int bodyBeginRowNumber,String filePath) throws WriteException, IOException {
		
		//如果传过来小于1的行数，则从第2行开始(第1行为头部标题)
		int row = bodyBeginRowNumber < 1 ? 1 : bodyBeginRowNumber;
		
		WritableWorkbook wwb = null;
		
		File excelFile = null;
		
		try {
			
			excelFile =  new File(filePath);
			
			wwb = Workbook.createWorkbook(excelFile);
			
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			
			//头部
			addLabelList(ws,list.get(0).headLabel());
			
			for(AbstractExcel ae : list) {
				
				//主体
				addLabelList(ws,ae.setRow(row++).bodyLabel());
			}
			
			wwb.write();
			
			
		} finally {
			
			if(wwb != null) {
				wwb.close();
			}
		}
		
		return excelFile;
	}
	
	
	private static void addLabelList(WritableSheet ws,List<Label> list) throws RowsExceededException, WriteException {
		
		for(Label label : list) {
			
			ws.addCell(label);
		}
		
	}
	
}
