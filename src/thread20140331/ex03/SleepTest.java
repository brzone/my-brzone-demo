package thread20140331.ex03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepTest {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String args[]) {

		for(int i = 0;i<5;i++) {

			String start = sdf.format(new Date());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			String end = sdf.format(new Date());

			System.out.println("start:" + start + "\t" + "end:" + end);

		}

	}

}
