package concurrency20120718.ex3.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {

		Queue<String> queue = new PriorityQueue<String>();

		for(String s : "one two three four five".split(" ")) {

			queue.offer(s);

		}

		while(!queue.isEmpty()) {

			System.out.println(queue.poll());

		}

	}

}
