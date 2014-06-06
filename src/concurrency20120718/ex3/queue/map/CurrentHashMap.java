package concurrency20120718.ex3.queue.map;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CurrentHashMap {

	public static void printlf(ConcurrentMap<String, String> map) {
		Set<Map.Entry<String, String>> setEntry = map.entrySet();

		for(Map.Entry<String, String> entry : setEntry) {

			String key = entry.getKey();
			String value = entry.getValue();

			System.out.println(key + ":" + value);

		}

	}

	public static void main(String[] args) {

		ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();

		map.putIfAbsent("one", "one");
		map.putIfAbsent("two", "two");

		//当如果，有two这个key的时候，做的操作仅仅是返回该key的值
		//当然putIfAbsent操作是原子的，也就是说判断和执行操作，会在一个原子中
		map.putIfAbsent("two", "two-2");

		printlf(map);

		System.out.println("---------------------------");
		//因为two这个key对应的值two，而不是two-2,故不会删除two这个键
		map.remove("two", "two-2");

		printlf(map);

		System.out.println("---------------------------");

		map.remove("two", "two");

		printlf(map);

	}

}
