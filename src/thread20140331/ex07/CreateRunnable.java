package thread20140331.ex07;

public class CreateRunnable implements Runnable {

	private CreateNumber cn;

	public CreateRunnable(CreateNumber cn) {
		this.cn = cn;
	}

	@Override
	public void run() {

		for(int i = 0;i<5;i++) {

			System.out.println(Thread.currentThread().getName() + "\t" + cn.get());

		}

	}

}
