package concurrency20120718.ex3.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author li jian
 *
 * @date 2012-8-13 下午05:27:37
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		//LinkedList实现了List和Queue，所以LinkedList也是一个Queue
		//Queue
		//队列先进先出
		Queue<String> queue = new LinkedList<String>();

		for(String s : "one two three four five".split(" ")) {

			queue.offer(s);
		}

		while(!queue.isEmpty()) {

			System.out.println(queue.poll());
		}

	}

}
