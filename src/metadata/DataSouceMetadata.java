package metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataSouceMetadata {

	private final static String NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@//149.16.20.102:1521/orcl2";
	private final static String USERNAME = "system";
	private final static String PASSWORD = "oxygenbrzone";

	static {

		try {
			Class.forName(NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void database() throws SQLException {

		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		/*鑾峰彇鏁版嵁搴撹繛鎺ョ殑鍏冩暟鎹璞�*/
		DatabaseMetaData meta = conn.getMetaData();

		/*鏁版嵁搴撶殑鍏冩暟鎹璞″彲浠ヨ幏鍙栨暟鎹簱鐨勪竴浜涘熀鏈俊鎭細琛ㄣ�瑙嗗浘銆佸瓨鍌ㄨ繃绋嬬瓑.*/
		ResultSet rs = meta.getTables(null, null, null, new String[]{"TABLE"});

		while(rs.next()) {

			String tablename = rs.getString(3);


			if(!(tablename.contains("_") || tablename.contains("$") || tablename.contains("/")))
			System.out.println(tablename + "\t" + (tablename.equals("EMPLOYEE") ? "----------------------------":""));
		}

		conn.close();
	}


	public void resultMeta() throws SQLException {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData meta = null;

		String sql = "select * from EMPLOYEE";

		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();

		meta = rs.getMetaData();



		for(int i = 1,j = meta.getColumnCount();i<=j;i++) {

			String columnname = meta.getColumnLabel(i);
			int columntype = meta.getColumnType(i);
			int size = meta.getColumnDisplaySize(i);
			System.out.println(columnname + "\t" + columntype + "\t" + size);

		}


		rs.close();
		pst.close();
		conn.close();

	}

	public static void main(String[] args) throws SQLException {

		DataSouceMetadata dsms = new DataSouceMetadata();
		//dsms.database();
		dsms.resultMeta();

	}

}
