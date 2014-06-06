package enumtest;

import java.util.Random;

/**
 * 可以在枚举中添加方法，抽象方法亦可，只要在定义的实例中（单例 final）中实现即可,<br/>
 * 一个枚举的实例，比如SMAll，就是一个Car的public static final Small。
 * @author Jian Lee
 * @mail brzone@126.com
 * @date 2012-11-23 下午05:14:41
 */
public enum Car {

	SMAll("this is small", 2000d) {
		@Override
		public int howManyDayCanYouGet() {

			return new Random().nextInt(10);
		}
	},
	MIDDLE("this is middle", 4000d) {
		@Override
		public int howManyDayCanYouGet() {

			return new Random().nextInt(10);
		}
	},
	BIG("this is big", 8000d) {
		@Override
		public int howManyDayCanYouGet() {

			return new Random().nextInt(10);
		}
	};

	private String description;
	private double money;

	Car(String description, double money) {
		this.description = description;
		this.money = money;
	}

	public String getDescription() {
		return description;
	}

	public double getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return this.description + ",cost:" + money + ",days:" + this.howManyDayCanYouGet();
	}

	public abstract int howManyDayCanYouGet();

}
