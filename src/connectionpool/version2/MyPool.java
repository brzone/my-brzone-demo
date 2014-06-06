package connectionpool.version2;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.dom4j.DocumentException;

/**
 * 数据库连接池
 * 
 * @author jian.li
 * @date 2011-5-11 16:40
 */

public class MyPool {
	
	private static  Map<String,String> map;
	
	static {
		
		try {
			map = PoolProperty.getProperty();
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("获取数据库连接参数异常 .");
		}
		
	}

	/* 这些常量应该是放在配置文件中 */
	private final static String NAME = map.get("name");
	private final static String URL = map.get("url");
	private final static String USERNAME = map.get("username");
	private final static String PASSWORD = map.get("password");

	/*数据库连接Connection的数目*/
	private static int size = Integer.parseInt(map.get("size"));
	
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

				/* 生成Connection的动态代理 */

				Connection conn = DriverManager.getConnection(URL,
						USERNAME, PASSWORD);
				Connection proxyconn = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), 
						               conn.getClass().getInterfaces(), 
						               new ConnectionInvocationHandler(conn));
				
				poolList.put(proxyconn);
				
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
