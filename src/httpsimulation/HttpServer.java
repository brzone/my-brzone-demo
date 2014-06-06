package httpsimulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class HttpServer {

	public void server() throws IOException, InterruptedException {

		ServerSocket server = new ServerSocket(9000);

		while (true) {

			Socket socket = server.accept();

			System.out.println("client ip:" + socket.getInetAddress().getHostAddress() + ",port:" + socket.getPort());
			
			InputStream is = socket.getInputStream();

			int length = is.available();

			byte[] buff = new byte[length];

			is.read(buff);

			is.close();
			String head = new String(buff);

			/* parse request head,like POST index.html Http/1.1 */
			String uri = head.split(" ")[1];
			
			System.out.println("uri: " + uri);

			/**
			 * 请求的uri，发送uri对应的文件给客服端
			 */
			InputStream ins = HttpServer.class.getResourceAsStream(uri);

			OutputStream os = socket.getOutputStream();

			byte[] outbuff = new byte[1024];

			int outlength = 0;

			while ((outlength = ins.read(outbuff)) != -1) {

				os.write(outbuff, 0, outlength);

			}

			TimeUnit.SECONDS.sleep(10);
			
			os.close();
			ins.close();
			
			

		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		new HttpServer().server();

	}

}
