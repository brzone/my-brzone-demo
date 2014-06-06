package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public void conn(String urlname) throws IOException {
				
		URL url = new URL(urlname);
						
		URLConnection connection = url.openConnection();
		
		InputStream is = connection.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
				
		String line = "";
		
		while((line = br.readLine()) != null) {
			
			System.out.println(line.replaceAll("<br>", ""));
		}
	  br.close();
	
		is.close();	
		
	
/*		Map<String, List<String>> head =  connection.getHeaderFields();
		
		Set<Map.Entry<String, List<String>>> entry = head.entrySet();
		
		for(Map.Entry<String, List<String>> e : entry) {
			
			String key = e.getKey();
			
			System.out.print(key + ":");
			
			for(String value : e.getValue()) {
				
				System.out.println("\t" + value);
			}
			
		}*/
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		URLDemo demo = new URLDemo();
		
		demo.conn("http://www.baidu.com");
	
		
	/*	Calendar c = Calendar.getInstance();
		
		c.setTime(new java.util.Date());
		
		c.add(Calendar.YEAR, 100);
		
		
		
				
		int year = c.get(Calendar.YEAR);
		
		int month = c.get(Calendar.MONTH);
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		int hour = c.get(Calendar.HOUR_OF_DAY);
		
		int minute = c.get(Calendar.MINUTE);
		
		int second = c.get(Calendar.SECOND);
		
		
		System.out.println("" + year + "-" + month + "-" + day + " " + hour + ":" + minute+":" + second);
*/	}
	
	
	
	
	

}
