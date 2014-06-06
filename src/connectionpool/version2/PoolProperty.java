package connectionpool.version2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PoolProperty {

	private static final String FILENAME = "pool.xml";

	public static Map<String, String> getProperty() throws DocumentException {

		return getPropertyDefaultFileOrDIY(null);
	}

	public static Map<String, String> getProperty(String fileName) throws DocumentException {

		return getPropertyDefaultFileOrDIY(fileName);
	}

	@SuppressWarnings("unchecked")
	private static Map<String, String> getPropertyDefaultFileOrDIY(
			String fileName) throws DocumentException {

		String useFileName = "";

		if (fileName == null || "".equals(fileName.trim())) {

			useFileName = FILENAME;
		} else {

			useFileName = fileName;
		}

		SAXReader sax = new SAXReader();
		Document doc = sax.read(ClassLoader
				.getSystemResourceAsStream(useFileName));

		List<Element> list = doc.selectNodes("/pool/datasource");

		Element e = list.get(0);

		Iterator<Element> iterator = e.elementIterator();

		Map<String, String> map = new HashMap<String, String>();

		while (iterator.hasNext()) {

			Element ele = iterator.next();
			String key = ele.getName();
			String value = ele.getText();

			map.put(key, value);

		}

		return map;
	}
	
	public static void main(String[] args) throws DocumentException {
		
		Set<Map.Entry<String, String>> set = getProperty("pool.xml").entrySet();
		
		for(Map.Entry<String, String> entry : set) {
			
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);
		}
		
	}
}
