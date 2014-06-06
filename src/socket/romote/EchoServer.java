package socket.romote;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	public void server() throws IOException {

		ServerSocket server = null;
		Socket s = null;
		
		try {
			server = new ServerSocket(9999);

			s = server.accept();
			
			System.out.println("someone has connection.");

			
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("Hello !" + s.getPort());
			InputStream is = s.getInputStream();

			Scanner sc = new Scanner(is);

			boolean stop = false;

			String echo = "";

			while (!stop && sc.hasNextLine()) {

				echo = sc.nextLine();

				pw.println("echo:" + echo);

				if ("bye".equalsIgnoreCase(echo)) {
					stop = true;
				}
			}

		} finally {

			s.close();
			server.close();

		}
	}

	public static void main(String[] args) throws IOException {

		new EchoServer().server();

	}

}
