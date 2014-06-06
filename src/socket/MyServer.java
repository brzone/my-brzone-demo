package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public void server() throws IOException {

		ServerSocket server = new ServerSocket(9999);

		while (true) {

			Socket socket = server.accept();

			OutputStream os = socket.getOutputStream();

			InputStream is = MyServer.class.getResourceAsStream("eamil.xml");

			byte[] buff = new byte[1024];

			int len = 0;

			while ((len = is.read(buff)) != -1) {

				os.write(buff, 0, len);

			}

			is.close();
			os.close();
		}

	}

	public static void main(String[] args) throws IOException {

		new MyServer().server();
		
	}

}
