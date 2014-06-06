package maywide.export;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  解析参数链接参数和Sql
 * @author li.jian
 *
 */
public class AnalysisParas {

	private AnalysisParas(){}

	public static Map<String,String> analy(String dbParas,String sql) throws IOException {

		Map<String,String> paraMap = analyParas(dbParas);

		Map<String,String> sqlMap = analySql(sql);

		paraMap.putAll(sqlMap);

		return paraMap;
	}

	public static Map<String,String> analySql(String sqlFilePath) throws IOException {

		FileReader fr = null;
		BufferedReader br = null;

		Map<String,String> map = new HashMap<String,String>(1);

		StringBuilder sb = new StringBuilder();

		String line = "";

		try {

			fr = new FileReader(sqlFilePath);
			br = new BufferedReader(fr);

			while((line = br.readLine()) != null) {

				sb.append(line + "  ");  //加几个空格，为了解决上一行和下一行读完后是挨着排在一起
			}

			map.put("sql", sb.toString());

		}finally {

			   if(br != null) {
	    		   br.close();
	    	   }

	    	   if(fr != null) {
	    		   fr.close();
	    	   }
		}


		return map;
	}


	public static Map<String,String> analyParas(String parasFilePath) throws IOException {

		FileReader fr = null;
		BufferedReader br = null;

		String line = "";

		Map<String,String> map = new HashMap<String,String>(5);

		try {
			fr = new FileReader(parasFilePath);
			br = new BufferedReader(fr);

			while((line = br.readLine()) != null) {

				String[] s = line.split("=");

				if(s.length == 2) {
					map.put(s[0]== null ? "" :s[0].trim(), s[1] == null ? "" :s[1].trim());
				}

			}

	   } finally {

	    	   if(br != null) {
	    		   br.close();
	    	   }

	    	   if(fr != null) {
	    		   fr.close();
	    	   }
	       }


		return map;
	}

}
