package maywide.export.simplewritecsv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Jian Lee
 * @mail   brzone@126.com
 * @date 2013-3-12 下午02:25:23
 */

public class WriteCsvDemo {

	private static final Random random = new Random();

	private static final String[] NAME = "孙迪,scott,yiiq,brzone".split(",");
	private static final int[] AGE = new int[] { 22, 23, 18, 16 };
	private static final String[] SEX = new String[] { "男", "女", "不详" };

	private static String getName() {

		return NAME[random.nextInt(NAME.length)];
	}

	private static int getAge() {

		return AGE[random.nextInt(AGE.length)];
	}

	private static String getSex() {

		return SEX[random.nextInt(SEX.length)];
	}

	public static void write() throws IOException {

		System.out.println(System.currentTimeMillis());

		FileWriter fw = null;

		PrintWriter pw = null;

		try {
			fw = new FileWriter("D://aaa.csv");
			pw = new PrintWriter(fw);

			pw.println("姓名,年龄,性别,姓名,年龄,性别,姓名,年龄,性别");
			// 以逗号风格的csv文件
			int i = 0;
			for (; i < 60000; i++) {

				pw.print(getName() + "," + getAge() + "," + getSex());
				pw.print(",");
				pw.print(getName() + "," + getAge() + "," + getSex());
				pw.print(",");
				pw.print(getName() + "," + getAge() + "," + getSex());
				pw.println();

				if (i % 1000 == 0) {

					System.out.println(i);
					pw.flush();
				}
			}

			System.out.println(i);

		} finally {

			if (fw != null) {

				fw.close();
			}

			if (pw != null) {

				pw.close();
			}

		}

		System.out.println("successfully!");
		System.out.println(System.currentTimeMillis());
	}

	public static void main(String[] args) throws IOException {

		write();
	}

}
