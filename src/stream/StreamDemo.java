package stream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamDemo {

	public static void read() throws IOException {

		InputStream is = new FileInputStream(
				"eamil.xml");

		byte[] buff = new byte[1024];

		FileOutputStream os = new FileOutputStream("ceamil.xml", false);

		int len = 0;

		/**
		 * 读的字数不一定都是缓冲的大小，在末尾的时候呢，你说呢？
		 * 
		 * 
		 */
		
		while ((len = is.read(buff)) != -1) {

			os.write(buff, 0, len);

		}

		os.close();
		is.close();

	}

	public static void main(String[] args) throws IOException {

		read();
	}

}
