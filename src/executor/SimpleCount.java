package executor;
/**
 * 
 * 一个简单的倒数器，每个倒数器有一个独一无二的编号id
 * @author jian.li
 *
 */
public class SimpleCount implements Runnable {

	private static int base = 1;

	private int maxcount = 10;

	/*分配独一无二的id*/
	private final int id = base++;

	@Override
	public void run() {

		while (maxcount > 0) {

			System.out.print(id + "(" + (maxcount--) + ")  ");

		}

	}

}
