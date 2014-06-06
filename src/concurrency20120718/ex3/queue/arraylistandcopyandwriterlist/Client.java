package concurrency20120718.ex3.queue.arraylistandcopyandwriterlist;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author li jian
 *
 * @date 2012-8-30 下午05:27:56
 */
public class Client {


	public static void main(String[] args) {

		final String[] arr = "aa bb cc".split(" ");

		/**
		 * 普通的List在获取遍历器之后，是不容许修改List中的元素的，它里面有一个字段记录读写的操作次数，然后发现
		 * 遍历的时候，记录读写的操作次数变化了，便会抛出ConcurrentModificationException
		 *
		 *
		 * 而CopyOnWriteArrayList，遍历（读操作），取的是保存值的副本，当写完之后，
		 * 便会更新原来保存的值
		 * 而且生成的迭代器Iterator，只能用一次，第二次调用就没反应了，譬如：
		 * printlf(iter2);printlf(iter2);//两次这样调用，第二次调用没反应，必须重新生成迭代器
		 *
		 * 且对CopyOnWriteArrayList操作是同步的，用的是ReentrantLock
		 *
		 *
		 */
		List<String> list1 = new ArrayList<String>(Arrays.asList(arr));

		List<String> list2 = new CopyOnWriteArrayList<String>(Arrays.asList(arr));

		Iterator<String> iter1 = list1.iterator();

		Iterator<String> iter2 = list2.iterator();

		list1.add("ee");
		list2.add("ee");

		try {
		    printlf(iter1);

		}catch(Exception e) {

			e.printStackTrace();

		}

		try {

			printlf(iter2);

		}catch(Exception e) {

				e.printStackTrace();

			}
		printlf(list2.iterator());

	}

	private static void printlf(Iterator<String> iter) {

		while(iter.hasNext()) {

			String value = iter.next();

			System.out.println(value);

		}

	}

}
