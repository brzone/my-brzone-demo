package maywide.export;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Excel的一些基本操作方法
 * @author li.jian
 *
 */
public class ExcelUtil {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat fullSdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

	public static String getCurrentTimeOfString() {

		return sdf.format(new Date());
	}

	public static String getCurrentFullTimeOfString() {

		return fullSdf.format(new Date());
	}

	public static void valueExcel(LinkedHashMap<String, Object> map,WritableSheet ws,int row) throws RowsExceededException, WriteException {

		Set<String> set = map.keySet();

		int index = 0;

		for(String key : set) {

			//列   行
			Label lable = new Label(index,row,map.get(key)==null ? "" :map.get(key).toString());

			ws.addCell(lable);

			index++;

		}


	}

	public static void valueExcel(List<String> list,WritableSheet ws,int row)
									throws RowsExceededException, WriteException {

		for(int i = 0,length = list.size();i<length;i++) {

			Label lable = new Label(i,row,list.get(i));
			ws.addCell(lable);
		}


	}

	/**
	 * just for test
	 * @param args
	 */
	public static void main(String[] args) {

		String date = fullSdf.format(new Date());

		System.out.println(date);
	}


}
