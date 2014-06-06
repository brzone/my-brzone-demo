package readwriteexcel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcelFile {

	public static void writeExcel(String fileName){
		WritableWorkbook wwb = null;
		try {
			//首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(wwb!=null){
			//创建一个可写入的工作表
			//Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			
			//下面开始添加单元格
			// 多少行
			
			Label head1 = new Label(0,0,"用户名");
			Label head2 = new Label(1,0,"密码");
			Label head3 = new Label(2,0,"部门");
			Label head4 = new Label(3,0,"car");
			Label head5 = new Label(4,0,"地址");
			
			
			try {
				ws.addCell(head1);
				ws.addCell(head2);
				ws.addCell(head3);
				ws.addCell(head4);
				ws.addCell(head5);
				
				
				
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (WriteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//行数，很明显，这里要写行，从第一行开始，因为第0行已经写了头部标题信息了
			for(int i=1;i<10;i++){
				
				//多少列(列的话，应该是固定的)
				for(int j=0;j<5;j++){
					//这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
					Label labelC = new Label(j, i, "这是第"+(i+1)+"行，第"+(j+1)+"列");
					try {
						//将生成的单元格添加到工作表中
						ws.addCell(labelC);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}

				}
			}

			try {
				//从内存中写入文件中
				wwb.write();
				//关闭资源，释放内存
				wwb.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	} 
	
		
	public static void main(String[] args) {
		
		writeExcel("test.xls");
		
	}
	
}
