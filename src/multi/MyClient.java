package multi;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * 服务器端
 * @author brzone@126.com
 *
 */

public class MyClient {

	public void link() {

		try {

			Socket socket = new Socket("127.0.0.1", 9999);

			DataInputStream dis = new DataInputStream(socket.getInputStream());

			String msg = "";
			while ((msg = dis.readUTF()) != null) {

				System.out.println("[" + new java.util.Date() + "] message : "
						+ msg);

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new MyClient().link();
	}

}
