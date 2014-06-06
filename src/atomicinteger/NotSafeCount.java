package atomicinteger;

public class NotSafeCount {

	private int count;

	public int get() {

		return count;
	}

	public int increment() {

		return ++count;
	}

}
