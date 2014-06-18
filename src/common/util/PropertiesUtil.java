package common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * 操作属性文件的工具类
 * @author brzone@126.com
 *
 * @date 2014年6月15日 上午11:01:55
 */
public class PropertiesUtil {
	

	private  PropertiesUtil(){
		throw new RuntimeException("haha,you can't do this.");
	}
	
	/**
	 * 通过传递文件的路径，以Map形式返回解析Properties的内容，key就是一行记录"="前面的内容
	 * @param filePath
	 * @return
	 * @throws Exception 
	 */
	public static Map<String,String> getProperties(String filePath)  {
		
		if(StringUtil.isNullOrBlank(filePath)) {
			return Collections.emptyMap();
		}
		
		Properties prop = new Properties();
		
		Map<String,String> data = new HashMap<String, String>();
		
		InputStream is = null;
		
		try {
			
			//is = PropertiesUtil.class.getResourceAsStream(filePath);
			is = new FileInputStream(filePath);
			
			prop.load(is);
			Set<Object> keySet = prop.keySet();
			
			if(keySet == null || keySet.isEmpty()) {
				return Collections.emptyMap();
			}
			
			
			for(Object key : keySet) {
				
				String value = prop.getProperty(key.toString());
				
				data.put(key.toString(), value);
			}
			
			
		} catch(Exception e) {
			
			
		} finally {
			
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
	
	
	/**
	 * just for test
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println(getProperties("conf/mongo.properties"));
	}
	
}
