package thread20140331.ex07;

public class CreateNumber {

	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public int get() {

		local.set(local.get() + 1);
		return local.get();
	}


}
