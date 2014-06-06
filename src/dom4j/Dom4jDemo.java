package dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	@SuppressWarnings("unchecked")
	public static void read(String fileName) throws DocumentException {

		SAXReader sax = new SAXReader();

		Document document = sax.read(new File(fileName));

		/**
		 * document.selectNodes(): 支持节点查询
		 */
		List<Element> list = document.selectNodes("/HD/disk");

		/* 有多少个disk,是HD下面的disk，其他节点下disk的一律不理 */
		System.out.println("list.size(): " + list.size());

		for (Element element : list) {

			/**
			 * e.getName()，也就是元素(节点的意思)的名称 e.getTextTrim(),也就是元素中的值，不是属性的值哦。
			 * 譬如： 某一p元素：
			 * <p name = "brzone">oxygenbrzone</p>
			 *
			 *
			 *
			 * e.getName(): p e.getTextTrim(): oxygenbrzone
			 * e.attributeValue("name"): brzone
			 */

			System.out.println(element.getName() + "\t"
					+ element.attributeValue("name"));

			/*
			 * 遍历它的子元素，但是只是第一层子元素，若需要遍历第二层子元素，则把该子元素再遍历，即可得到第二层子元素 。
			 */
			Iterator<Element> iterator = element.elementIterator();

			while (iterator.hasNext()) {

				Element e = iterator.next();

				/**
				 * e.getName()，也就是元素(节点的意思)的名称 e.getTextTrim(),也就是元素中的值，不是属性的值哦。
				 * 譬如： 某一p元素：
				 * <p name = "brzone">
				 * oxygenbrzone
				 * </p>
				 *
				 * e.getName(): p e.getTextTrim(): oxygenbrzone
				 * e.attributeValue("name"): brzone
				 */

				System.out.print(e.getName() + "\t" + e.getTextTrim() + "\t");

				String info = "";

				/**
				 * 为了有意思一点，做了一些其他的输出： 如果当前的元素的名字为capacity，则
				 * 把它的属性名为username的值给输出来。
				 */

				if ("capacity".equals(e.getName())) {

					info = e.attributeValue("username");
				}

				System.out.println(info);

			}

			System.out.println("-----------------------");

			/* 把一个document解析为一个String字符串 */
			String xml = document.asXML();
			System.out.println(xml);

			/* 把一个字符串解析为一个Document对象 */
			DocumentHelper.parseText(xml);

		}

	}


	public static void modify() throws DocumentException {

		SAXReader sax = new SAXReader();

		Document document = sax.read(new File("D:\\bossworkspace\\Demo_UTF-8\\ceamil.xml"));

		/**
		 * document.selectNodes(): 支持节点查询
		 */
		List<Element> list = document.selectNodes("/我的资料");



		System.out.println(list.size());

		Element root  = document.getRootElement();

		for(Element e : list) {

			root.remove(e);

		}





	}

	public static void read(InputStream is) throws DocumentException {

		SAXReader sax = new SAXReader();

		Document document = sax.read(is);

		/**
		 * document.selectNodes(): 支持节点查询
		 */
		List<Element> list = document.selectNodes("/HD/disk");

		/* 有多少个disk,是HD下面的disk，其他节点下disk的一律不理 */
		System.out.println("list.size(): " + list.size());

		for (Element element : list) {

			System.out.println(element.getName() + "\t"
					+ element.attributeValue("name"));

			/*
			 * 遍历它的子元素，但是只是第一层子元素，若需要遍历第二层子元素，则把该子元素再遍历，即可得到第二层子元素 。
			 */
			Iterator<Element> iterator = element.elementIterator();

			while (iterator.hasNext()) {

				Element e = iterator.next();

				/**
				 * e.getName()，也就是元素(节点的意思)的名称 e.getTextTrim(),也就是元素中的值，不是属性的值哦。
				 * 譬如： 某一p元素：
				 * <p name = "brzone">
				 * oxygenbrzone
				 * </p>
				 *
				 * e.getName(): p e.getTextTrim(): oxygenbrzone
				 * e.attributeValue("name"): brzone
				 */

				System.out.print(e.getName() + "\t" + e.getTextTrim() + "\t");

				String info = "";

				/**
				 * 为了有意思一点，做了一些其他的输出： 如果当前的元素的名字为capacity，则
				 * 把它的属性名为username的值给输出来。
				 */

				if ("capacity".equals(e.getName())) {

					info = e.attributeValue("username");
				}

				System.out.println(info);

			}

			System.out.println("-----------------------");

			/* 把一个document解析为一个String字符串 */
			String xml = document.asXML();
			System.out.println(xml);

			/* 把一个字符串解析为一个Document对象 */
			DocumentHelper.parseText(xml);

		}

	}

	public static void write() throws IOException {

		Document document = DocumentHelper.createDocument();

		// 添加一个根元素"我的资料"
		// 一个Document中只能有一个根元素,记住
		Element root = document.addElement("我的资料");



		// 根元素"我的资料"下添加一个子元素"我的电话"
		Element myphone = root.addElement("我的电话");

		// 元素"我的电话"下添加一个子元素"phone",并依次添加属性值对、元素的值
		// <phone character = "工作电话">110</phone>
		// 每次的操作，都放回一个this(Document)，这样可以很方便的进行连锁操作(jQuery的兄弟呀 )
		myphone.addElement("phone").addAttribute("character", "工作电话").addText(
				"110");

		// 再次在元素"我的电话"下添加一个子元素"phone",并依次添加属性值对、元素的值
		// <phone character = "家庭电话 ">119</phone>
		myphone.addElement("phone").addAttribute("character", "家庭电话").addText(
				"119");

		// 根元素添加一个子元素"email"
		// 若你想在oneEmail下添加元素,即可这样写 ：oneEmail.adddElement....
		Element oneEmail = root.addElement("email").addText(
				"oneworld_dream@126.com").addAttribute("date", "2008-08-08");

		// 根元素添加一个子元素"email"
		Element twoEmail = root.addElement("email").addText("brzone@live.cn")
				.addAttribute("date", "2010-08-08");

		// 构建文件输出流
		FileWriter fw = new FileWriter(
				"D:\\eclipseWorkspace\\Demo_UTF-8\\src\\我的邮箱.xml");

		// 把Document对象写入到输出流
		document.write(fw);

		// 关闭流
		fw.close();

		// 也可以把一个刚创建的Document做为一个字符串给返回
		System.out.println(document.asXML());

	}

	public static void demo() throws DocumentException {

		SAXReader sax = new SAXReader();
		Document document = sax.read(new File(
				"D:\\eclipseWorkspace\\Demo_UTF-8\\src\\我的邮箱.xml"));
		Element element = document.getRootElement();

		System.out.println("root name : " + element.getName());

		int size = document.selectNodes("/我的资料/email").size();
		System.out.println(size);

		Iterator<Element> iterator = element.elementIterator();

		while (iterator.hasNext()) {

			Element e = iterator.next();

			System.out.print(e.getName() + "\t");

			if (e.getName().equals("我的电话")) {

				System.out.println();
				Iterator<Element> it = e.elementIterator();

				while (it.hasNext()) {

					Element el = it.next();

					System.out.println(el.getName() + "\t"
							+ el.attributeValue("character") + "\t"
							+ el.getTextTrim());

				}

			}

			System.out.println(e.attributeValue("date") + "\t"
					+ e.getTextTrim());

		}

	}

	public static void demo3() throws DocumentException {

		SAXReader sax = new SAXReader();
		Document document = sax.read(new File(
				"D:\\eclipseWorkspace\\Demo_UTF-8\\src\\test.xml"));

		Element element = document.getRootElement();

		System.out.println(element.getName());

		Iterator<Element> iterator = element.elementIterator();

		while (iterator.hasNext()) {

			Iterator<Element> it = iterator.next().elementIterator();

			while (it.hasNext()) {

				System.out.println(it.next().getName());

			}

		}

	}

	public static void main(String[] args) throws DocumentException,
			IOException {



		modify() ;

	}

}

/**
 *
 * 1.Service类注入Dao类
 *
 * 2.通过提供完整的类名
 *
 * @AutoWire(name="com.xx.EmployeeDao")
 * private EmployeeDao dao;
 *
 * 3.直接用Service类了，因为，已经注入了Dao了。
 *
 * A:自定义注解
 * A.1 注解解析
 * B:反射知识
 *
 *
 */



