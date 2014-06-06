package concurrency20120718.ex3.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试类
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-11 下午05:20:26
 */
public class Client {

	public static void main(String[] args) {

		/**
		 *我们在这里约定，有10个学生，2个老师，
		 *老师，必须要等待10个学生全部到课堂
		 * 才可以进行教学。
		 *
		 */

		/*既然是要等待10个学生，当然计数器为10*/
		CountDownLatch latch = new CountDownLatch(10);

		ExecutorService exec = Executors.newFixedThreadPool(5);

		/**
		 *
		 * 在这里，就算是老师先执行，但是，在老师的run
		 * 方法中latch.await()，老师们要等待CountDownLatch
		 * 的计数器为0，就是要10个学生都执行latch.countDown()，
		 * 然后老师们才可以做自己的事情，在计数器不为0的
		 * 情况下是一直堵塞的。
		 *
		 *
		 * tip：
		 *     细心的你，是否有没有发现一个小bug，就是只要一个
		 *     老师来了，也就可以上课了，在这里，我们暂且约定
		 *     老师们是一起来的。
		 *
		 */

		for(int i = 0;i<2;i++) {

			exec.execute(new TeacherTask(latch));

		}

		for(int i=0;i<10;i++) {

			exec.execute(new StudentTask("s" + i, latch));

		}


		exec.shutdown();

	}

}
