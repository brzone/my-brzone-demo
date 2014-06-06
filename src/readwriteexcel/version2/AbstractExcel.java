package readwriteexcel.version2;

import java.util.List;

/**
 * 实现Excelable接口，可生成Excel,这里针对的是单个对象或者对象的集合生成Excel表
 * @author li.jian
 * @date 2011-10-13 上午10:20:42
 */
public abstract class AbstractExcel {
	
	private int row;
	/**
	 * 生成Excel时的头部信息
	 * @return List&lt;jxl.write.Label&gt;
	 * 								头部信息的Label的List集合
	 */
	public abstract List<jxl.write.Label> headLabel();
	
	/**
	 * 单个对象对应的Excel一行
	 * @return	List&lt;jxl.write.Label&gt;
	 * 							一行有列的数目的单元格
	 */
	public abstract List<jxl.write.Label> bodyLabel();
	
	public  AbstractExcel setRow(int row){
		
		this.row = row;
		return this;
	} 
	
	public int getRow(){
		
		return row;
	}
	
}
