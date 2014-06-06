import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class CrossDemo {

	private static final Random random = new Random();

	private int[] generate(int length) {

		int[] data = new int[length];

		for(int i = 0;i < length;i++) {

			data[i] = random.nextInt(100);
		}

		return data;

	}



	public void work() {

		int[] arr1 = generate(20);

		int[] arr2 = generate(50);

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		Map<Integer,Integer> map = new HashMap<Integer,Integer>();

		List<Integer> list = new ArrayList<Integer>();

		for(int a:arr1) {

			map.put(a, 1);

		}

		for(int a : arr2) {

			Integer key = map.get(Integer.valueOf(a));

			if(key != null) {

				list.add(a);
			}

		}

		System.out.println(list);

	}




	public static void main(String[] args) {


		new CrossDemo().work();

	}

}
