package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 数据库连接池
 * 
 * @author jian.li
 * @date 2011-5-11 16:40
 */

public class MyPool {

	/* 这些常量应该是放在配置文件中 */
	private final static String NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@//149.16.20.37:1521/transfer";
	private final static String USERNAME = "edata";
	private final static String PASSWORD = "edata";

	/*数据库连接Connection的数目*/
	private static int size = 20;
	
	/* 因为在获取数据库连接的时候需要同步，故选择了BlockingQueue */
	private static BlockingQueue<Connection> poolList ;

	/* 初始化数据库连接池 */
	static {

		try {
			Class.forName(NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		/* 创建容量有限的ArrayBlockingQueue*/
		poolList = new  ArrayBlockingQueue<Connection>(size);
		
		for (int i = 0; i < size; i++) {
			try {

				/* 生成Connection的适配者MyConnection */

				poolList.put(new MyConnection(DriverManager.getConnection(URL,
						USERNAME, PASSWORD)));
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			}
		}

	}

	private MyPool() {
	}

	/**
	 * 获取数据库的连接，从阻塞队列中获取
	 * 
	 * @return
	 * @throws SQLException
	 * @throws InterruptedException 
	 */

	public static Connection getConnection() throws SQLException, InterruptedException {

			return  poolList.take();

	}

	/**
	 * 
	 * 非数据库连接池的数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */

	public static Connection getConnectionByJDBC() throws SQLException {

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	/**
	 * 
	 * 释放连接
	 * 
	 * @param conn
	 * @throws SQLException
	 */

	public static void release(Connection conn) throws SQLException {

		try {
			System.out.println("before put :" + poolList.size());
			poolList.put(conn);
			System.out.println("after put :" + poolList.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new SQLException("释放数据库连接异常");
		}
	}

	/**
	 * 返回还有几个数据库连接可以使用
	 * 
	 */
	@Override
	public String toString() {

		return "" + poolList.size();
	}

}
