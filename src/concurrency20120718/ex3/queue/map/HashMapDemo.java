package concurrency20120718.ex3.queue.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("one", "one");

		map.put("two", "two");

		//如果存在two的key，便会覆盖.
		map.put("two", "two-2");

		Set<Map.Entry<String, String>> entrySet =  map.entrySet();

		for(Map.Entry<String, String> entry : entrySet) {

			String key = entry.getKey();
			String value = entry.getValue();

			System.out.println(key + ":" + value);

		}

	}

}
