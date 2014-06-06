package socket.romote;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketConnection {

	public void execte(String hostname, int port) throws UnknownHostException,
			IOException {

		Socket socket = new Socket(hostname, port);

		InputStream is = socket.getInputStream();

		Scanner sc = new Scanner(is);

		while (sc.hasNextLine()) {

			System.out.println(sc.nextLine());

		}

		sc.close();
		is.close();
		socket.close();

	}

	public static void main(String[] args) throws UnknownHostException, IOException {
        
		new SocketConnection().execte("127.0.0.1", 8086);
		
	}

}
