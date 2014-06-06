package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class MyClient {

	public void request() throws UnknownHostException, IOException,
			InterruptedException {

		Socket socket = new Socket("127.0.0.1", 9999);

		TimeUnit.SECONDS.sleep(5);

		InputStream is = socket.getInputStream();

		int len = is.available();

		byte[] msg = new byte[len];
		is.read(msg);

		is.close();
		System.out.println(new String(msg));
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {

		new MyClient().request();

	}

}
