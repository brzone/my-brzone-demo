package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {

	public static void test() throws IOException {

		Document doc = Jsoup.connect("http://www.baidu.com").get();

		//String title = doc.title();
		//System.out.println(title);
		
		
		Elements elements = doc.select("a[href]");
		
		for(Element e : elements) {
			
			String href = e.attr("href");
			String hrefText = e.text();
			
			System.out.println("href:" + href);
			System.out.println("hrefText:" + hrefText);
			
			System.out.println("------------");
		}
		
		String suVal = doc.select("#su").first().val();
		
		System.out.println("suVal:" + suVal);

	}
	
	public static void test2() throws IOException {
		
		Document doc = Jsoup.connect("http://132.96.67.2/webroot/logonChkPwdnoapp.jsp")
						//.header("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:7.0.1) Gecko/20100101 Firefox/7.0.1")
						.data("username", "2484")
						.data("password", "abc123")
						.timeout(55555)
						.post();
		
		
						
		String html = doc.html();
		
		System.out.println(html);
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		test2();
		
	}

}
