import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueDemo {

	private final static String NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@//149.16.20.37:1521/transfer";
	private final static String USERNAME = "edata";
	private final static String PASSWORD = "edata";

	static {

		try {
			Class.forName(NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws InterruptedException,
			SQLException {

		int size = 10;
		BlockingQueue<Connection> queue = new ArrayBlockingQueue<Connection>(
				size);

		for (int i = 0; i < size; i++) {

			queue.put(DriverManager.getConnection(URL, USERNAME, PASSWORD));

			System.out.println("after put:" + queue.size());
		}

		Connection conn = queue.take();
		System.out.println("after take:" + queue.size());

		Connection conn2 = queue.take();
		System.out.println("after take:" + queue.size());

		queue.put(conn);
		System.out.println("after put:" + queue.size());

		queue.put(conn2);
		System.out.println("after put:" + queue.size());

	}
}
