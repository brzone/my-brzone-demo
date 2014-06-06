package httpsimulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class HttpClient {

	public void request() throws UnknownHostException, IOException, InterruptedException {

		Socket socket = new Socket("127.0.0.1", 9000);

		OutputStream os = socket.getOutputStream();

		String requestmsg = "Post index.html Http/1.1";

		os.write(requestmsg.getBytes());
		os.close();
		
		/*发送请求后等待响应 */
		TimeUnit.SECONDS.sleep(5);

		InputStream is = socket.getInputStream();

		int len = is.available();

		byte[] buff = new byte[len];
		is.read(buff);

		is.close();
		System.out.println(requestmsg);
		System.out.println(new String(buff));
		
		
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {

		new HttpClient().request();

	}

}
