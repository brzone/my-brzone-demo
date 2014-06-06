package saxparsexml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class IISXMLPrase extends DefaultHandler {

	private Map<String, String> map;
	
	private String tagName = null;

	public IISXMLPrase() {
		map = new HashMap<String, String>();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
        
		if ("faultcode".equals(qName) || "faultstring".equals(qName))
			tagName = qName;

	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String text = new String(ch, start, length);

		if ("faultcode".equals(tagName)) {

			map.put("faultcode", text);
		} else if ("faultstring".equals(tagName)) {

			map.put("faultstring", text);
		}

		/*元素的名字，在这里为faultcode和faultstring*/
		tagName = null;
	}

	public Map<String, String> getMap() {

		return map;
	}

	

	public static void main(String[] args) {
	
		try {
			IISXMLPrase testSAX = new IISXMLPrase();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			// parser.parse(new File("D:/aa/brzone.txt"), testSAX);

			String str = "<?xml version=\"1.0\"?>";

			str += "<SOAP-ENV:Envelope ";

			str += "	xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ";

			str += "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ";

			str += "xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\"> ";

			str += "<SOAP-ENV:Body><SOAP-ENV:Fault><faultactor/> ";
			str += "<faultcode>SOAP-ENV:Server</faultcode> ";
			str += "<faultstring>XML 文档必须包含顶层元素Line: 0</faultstring> ";
			str += "</SOAP-ENV:Fault> ";
			str += "</SOAP-ENV:Body> ";
			str += "</SOAP-ENV:Envelope> ";

			
			/**
			 * 这里，你的那个str就不要向上面的那样拼接，直接把那从WebService获取的字符串赋值给str
			 * 就可以了。
			 * 
			 * 
			 */
			
			parser.parse(new ByteArrayInputStream(str.getBytes("utf-8")),
					testSAX);

			Map<String, String> m = testSAX.getMap();
			
			/*获取faultcode的值*/
			String faultcode = m.get("faultcode");
			
			/*获取faultstring的值*/
			String faultstring = m.get("faultstring");

			System.out.println("faultcode:" + faultcode);
			System.out.println("faultstring:" + faultstring);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
