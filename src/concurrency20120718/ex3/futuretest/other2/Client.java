package concurrency20120718.ex3.futuretest.other2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-25 上午09:47:37
 */
public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		ExecutorService exec = Executors.newSingleThreadExecutor();

		/**
		 * 执行Callable有俩中方法，
		 *          1. 就是下文的代码段，把Callable传给FutureTask，
		 *             创建FutureTask，然后execute FutureTask
		 *          2.Future<Boolean>  futer = exec.submit
		 *                           (new GirlAnswerCallable())
		 *            submit一个Callable，然后返回一个Future
		 *
		 *
		 */
		FutureTask<Boolean> futer = new FutureTask<Boolean>(new GirlAnswerCallable());

		exec.execute(futer);

		System.out.println("To girl: When I first saw you, I fell in love with you.");

		boolean success = false;

		try {

			/**
			 * 这里假设：
			 *         男孩向女孩表白，如果女孩超过一定时间没回复的话，
			 *         那就果断cancel吧，都放开点。
			 *         如果，在限定的时间回复的话，当然，女方回复必须是
			 *         false或者true，当然，听到这话，你应该知道什么意
			 *         思了，也不需要我教你了吧，呵呵。
			 *
			 *
			 *
			 *
			 */

			//如果延迟的话，便会抛出TimeoutException异常
			success = futer.get(5, TimeUnit.SECONDS);

			System.out.print("girl says: ");
			System.out.println(success ? "yes." : "no.");

		}catch(TimeoutException e) {

			System.out.println("女孩超过5秒没回复，你就死了这份心吧。");



			/**
			 * 中断运行，不能让女方给张"好人卡"，拔腿就跑.
			 * 其实，这里是变相的要女方不要说话了（不执行），
			 * 因为男方走了，女方说话给谁听。
			 *
			 * 当然如果是futer.cancel(false)，就是说明，
			 * 想听她继续说，想"死"的明白
			 *
			 */
			futer.cancel(true);

		}

		exec.shutdown();

	}

}
