package algorithm.ex1;

import java.util.Arrays;
import java.util.Random;

public class FindKMax {
	
	private Random random = new Random(47);
	
	private int[] data = new int[100];
	
	private int k;
	
	public FindKMax(int k) {
		this.k = k;
	}

	private void init() {
		
		for(int i = 0,j = data.length;i<j;i++) {
			
			data[i] = random.nextInt(1000);
		}
	}
	
	public FindKMax() {
		init();
	}
	
	public int find() {
		
		int[] temp = new int[k];
		
		for(int i = 0;i<k;i++) {
			
			temp[i] = data[i];
		}
		
		sort(temp);
		
		System.out.println(Arrays.toString(temp));
		
		return 0;
	}
	
	private void sort(int[] arr) {
		
		for(int i = 0,j = arr.length;i<j;i++) {
			
			for(int t = i+1; t<j;t++) {
				
				// 7  3  
				if(arr[i] > arr[t]) {
					
					int temp = arr[i]; //7
					arr[i] = arr[t];
					arr[t] = temp;
				}
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		FindKMax find = new FindKMax(20);
		
		find.find();
		
	}

}
