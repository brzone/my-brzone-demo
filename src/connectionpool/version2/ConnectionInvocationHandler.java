package connectionpool.version2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * 
 * 做一个数据库连接的动态代理，在这里，如果调用是close
 * 方法时，便调用MyPool.release(conn)，其他的方法便不
 * 管了，该怎么调，就怎么调用.
 * @author jian.li
 *
 */

public class ConnectionInvocationHandler implements InvocationHandler {

	private Connection conn;
	
	public ConnectionInvocationHandler(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		/*若是调用close方法的话，便用线程池的释放方法*/
		if("close".equals(method.getName())) {
			
			MyPool.release(conn);
			return null;
		}
		
		return method.invoke(conn, args);
	}

}
