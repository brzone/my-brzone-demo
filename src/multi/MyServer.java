package multi;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * 服务器端
 * @author brzone@126.com
 *
 */

public class MyServer {

	private final String[] MESSAGE = "city make life more better".split(" ");

	private List<Socket> list;

	private Random random = new Random(47);

	/*同步锁，因为在添加、删除、遍历Socket，都需要同步*/
	private Object obj = new Object();

	/*这里的驱动任务用的是线程池*/
	private static ExecutorService exec;

	public MyServer() {

		list = new ArrayList<Socket>();
		exec = Executors.newFixedThreadPool(10);
	}

	private String getMsg() {

		return MESSAGE[random.nextInt(MESSAGE.length)];
	}

	/**
	 * 监听器
	 */

	public void monitor() {

		try {
			ServerSocket server = new ServerSocket(9999);

			while (true) {

				//不能让异常把服务端给毁了，故要处理它
				try {
				Socket socket = server.accept();

				synchronized (obj) {

					list.add(socket);

				}
				}catch(IOException e) {

					e.printStackTrace();
				}


			}

		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	/**
	 * 发送消息
	 */

	public void sendMsg() {



		while (true) {

		String msg = getMsg();

			synchronized (obj) {

				System.out.println("socket.size(): " + list.size());

				for (Socket socket : list) {

					exec.execute(new SendMsgTask(socket, msg));

				}

			}

			// 睡眠3秒
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}

	private class SendMsgTask implements Runnable {

		Socket socket;

		String msg;

		public SendMsgTask(Socket socket, String msg) {
			this.socket = socket;
			this.msg = msg;
		}

		@Override
		public void run() {

			try {

				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);

				dos.writeUTF(msg);

			} catch (IOException e) {

				synchronized (obj) {

					list.remove(socket);

					if (socket != null)
						try {
							socket.close();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
				}
			}
		}

	}

	public static void main(String[] args) {

		final MyServer server = new MyServer();

		//监听器的线程
		exec.execute(new Runnable() {

			@Override
			public void run() {
				server.monitor();

			}
		});

		//发送消息的线程
		exec.execute(new Runnable() {

			@Override
			public void run() {
				server.sendMsg();

			}
		});

	}

}
