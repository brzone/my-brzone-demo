package parsexml;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParsePerson {

	@SuppressWarnings("unchecked")
	public static List<Person> parse(String fileName) throws DocumentException {

		SAXReader sax = new SAXReader();

		Document document = sax.read(new File(fileName));

		/**
		 * document.selectNodes(): 支持节点查询
		 */
		List<Element> list = document.selectNodes("/persons/person");

		List<Person> result = new ArrayList<Person>();

		for (Element e : list) {

			/*多个person节点*/
			Person person = new Person();

			/*拿到第一个元素id*/
			String id = e.attributeValue("id");

			person.setId(id);

			Iterator<Element> iterator = e.elementIterator();

			while (iterator.hasNext()) {

				Element ele = iterator.next();

				String key = ele.getName();
				String value = ele.getTextTrim();

				if ("name".equals(key)) {

					person.setName(value);

				} else if ("age".equals(key)) {
					person.setAge(value);

				} else if ("department".equals(key)) {

					Iterator<Element> deptIterator = ele.elementIterator();

					Deptment d = new Deptment();

					while (deptIterator.hasNext()) {

						Element dept = deptIterator.next();

						String deptkey = dept.getName();
						String deptvalue = dept.getTextTrim();

						if ("id".equals(deptkey)) {

							d.setId(deptvalue);
						} else if ("name".equals(deptkey)) {
							d.setName(deptvalue);

						}

					}

					person.setDeptment(d);

				}

				
			}
			result.add(person);

		}

		return result;
	}

	public static void main(String[] args) throws DocumentException {

			List<Person> list = parse("D:\\eclipse_utf8_workspace\\Demo_UTF-8\\src\\persons.xml");
		
			for(Person person : list) {
				
				System.out.println(person);
			}
	}

}
