package concurrency20120718.ex3.futuretest.other2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 女孩子的回复
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-25 上午09:36:20
 */
public class GirlAnswerCallable  implements Callable<Boolean>{

	private static  final Random random  = new Random();

	@Override
	public Boolean call() throws Exception {

		TimeUnit.SECONDS.sleep(ansewerTime());

		return yesOrNo();
	}


	private int ansewerTime() {

		return random.nextInt(20);

	}

	private boolean yesOrNo() {

		return random.nextBoolean();
	}

}
