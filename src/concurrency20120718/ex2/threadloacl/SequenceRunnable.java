package concurrency20120718.ex2.threadloacl;

/**
 *
 * @author li jian
 *
 * @date 2012-8-9 上午09:48:44
 */
public class SequenceRunnable implements Runnable {

	private SequenceNum seqnum;


	public SequenceRunnable(SequenceNum seqnum) {
		super();
		this.seqnum = seqnum;
	}



	@Override
	public void run() {

           for (int i = 0;i<8;i++) {

        	   System.out.println(Thread.currentThread().getName() + ":\t" + seqnum.getNextNum());

           }

	}

}
