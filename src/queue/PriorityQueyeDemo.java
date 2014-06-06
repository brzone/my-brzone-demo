package queue;

import java.util.PriorityQueue;

public class PriorityQueyeDemo {

	public static void main(String[] args) {
	
		/**
		 * offer的时候，会通过排序进入队列
		 */
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		for(String s : "One Two Three Four".split(" "))
		pq.offer(s);
		
		while(!pq.isEmpty())
		System.out.println(pq.poll());
		
        //ABCDEFGHJKLMNOPQRSTUVWXYZ
		for(char c : "ABCDEFGHJKLMNOPQRSTUVWXYZ".toCharArray()){
			
			System.out.println(c);
		}
	}

}
