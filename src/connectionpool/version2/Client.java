package connectionpool.version2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

public class Client {

	public static void test(Connection conn) {

		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from TD_EXC_HOUSE_PAYER";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				System.out.print(rs.getString(1) + " ");

			}

			System.out.println("结束了一次");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pst != null) {

				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) throws SQLException,
			InterruptedException {

		final CountDownLatch latch = new CountDownLatch(20);

		final long start = System.nanoTime();

		/* 分:秒:毫秒 */
		System.out.println(new SimpleDateFormat("mm:ss:SS")
				.format(new java.util.Date()));

		/* 起20个线程做JDBC */
		for (int i = 0; i < 20; i++) {
			
			new Thread(new Runnable() {

				@Override
				public void run() {
					Connection poolconn = null;
					try {
						poolconn = MyPool.getConnection();
						test(poolconn);
						latch.countDown();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 

				}

			}).start();

		}

		/*计时线程*/
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("pool time : " + (System.nanoTime() - start)
						/ 1000000000);

				System.out.println(new SimpleDateFormat("mm:ss:SS")
						.format(new java.util.Date()));

			}

		}).start();
		
		
		
		

	}

}
