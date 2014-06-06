package concurrency20120718.ex2.threadloacl;

/**
 *
 * @author li jian
 *
 * @date 2012-8-9 上午09:48:21
 */
public class SequenceNum {

	private static ThreadLocal<Integer> seqnum = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 0;
		}

	};


	public int getNextNum() {

		seqnum.set(seqnum.get() + 1);
		return seqnum.get();

	}

}
