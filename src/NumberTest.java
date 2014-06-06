import java.util.ArrayList;
import java.util.List;

/**
 * @author li.jian
 * @date 2011-10-12 下午02:52:06
 */
public class NumberTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>(95);
		
		for(int i = 0;i<95;i++){
			
			list.add(i);
		}
		
		for(int m : list) {
			
			if(m % 19 == 0 || m % 18 == 0) {
				
				System.out.println(m);
			}
		}
	}
}
