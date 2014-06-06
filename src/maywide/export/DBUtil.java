package maywide.export;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DBUtil {

	private String className;

	private String url;

	private String username;

	private String password;

	/* 同步原子变量 */
	private static AtomicInteger ai;

	static {
		ai = new AtomicInteger();

	}

	private List<String> fileList = new ArrayList<String>();;

	/**
	 * 链接任意的数据库的初始化参数
	 *
	 * @param className
	 * @param url
	 * @param username
	 * @param password
	 */
	private DBUtil(String className, String url, String username,
			String password) {
		super();
		this.className = className;
		this.url = url;
		this.username = username;
		this.password = password;
		init();
	}

	/**
	 * 初始化默认Oracle的链接参数
	 *
	 * @param url
	 * @param username
	 * @param password
	 */
	private DBUtil(String url, String username, String password) {
		this.className = "oracle.jdbc.driver.OracleDriver";
		this.url = url;
		this.username = username;
		this.password = password;

		init();
	}

	/**
	 * 获取操作Oracle数据库的DBUtil对象
	 *
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public static DBUtil getDBUtilForOracle(String url, String username,
			String password) {

		DBUtil db = new DBUtil(url, username, password);

		return db;

	}

	/**
	 * 获取链接任何数据库的DBUtil实例
	 *
	 * @param className
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public static DBUtil getDBUtilForAnyDB(String className, String url,
			String username, String password) {

		DBUtil db = new DBUtil(className, url, username, password);

		return db;

	}

	private void init() {

		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("没有找到【" + className + "】驱动器", e);
		}
	}

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, username, password);
	}

	/**
	 *
	 *
	 * @param sql
	 * @return List的LinkedHashMap，用LinkedHashMap为了使sql字段顺序和保存顺序相同
	 * @throws SQLException
	 */
	public List<LinkedHashMap<String, Object>> executeSql(String sql)
			throws SQLException {

		List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rmd = null;

		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rmd = rs.getMetaData();

			int columnCount = rmd.getColumnCount();

			while (rs.next()) {

				LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

				for (int i = 1; i <= columnCount; i++) {

					String columnName = rmd.getColumnName(i);
					map.put(columnName, rs.getObject(columnName));
				}

				list.add(map);

			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw e;
		} finally {

			close(rs, pst, conn);
		}

		return list;
	}

	public void executeSqlOfAllData(String sql, String filePath)
			throws SQLException, IOException, RowsExceededException,
			WriteException {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rmd = null;

		WritableWorkbook wwb = null;

		// 查询sql中有多少条记录
		int amount = 0;

		int oneExcleAmount = 40000;

		// 提取的数据是否刚好就是几个Excel装满，而不用一个Exce装剩余的。
		boolean isFullExcel = false;

		File file = null;

		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rmd = rs.getMetaData();

			amount = getSqlResultSetCount(conn, sql);

			System.out.println("amount:" + amount);

			// 需要几个Excel
			// amountExcel = amount/(oneExcleAmount + 1); //加上一个头部信息，它占一行

			isFullExcel = (amount % (oneExcleAmount + 1)) == 0 ? true : false;

			int columnCount = rmd.getColumnCount();

			List<String> headList = new ArrayList<String>();

			for (int i = 1; i <= columnCount; i++) {

				headList.add(rmd.getColumnLabel(i));

			}

			// 由于可能要产生多个文件，则要保证产生不同的文件名，用原子变量生成

			file = new File(getSeqFilePathName(filePath));

			fileList.add(file.getAbsolutePath());

			wwb = Workbook.createWorkbook(file);

			WritableSheet ws = wwb.createSheet("数据导出"
					+ ExcelUtil.getCurrentTimeOfString(), 0);

			boolean hasWriterHead = false;

			int index = 0;

			// int hasWriterHowManyExcel = 0;

			int writeToExcelDataAmount = 0;

			while (rs.next()) {

				writeToExcelDataAmount++;

				List<String> listData = new ArrayList<String>();

				for (int i = 0, length = headList.size(); i < length; i++) {

					listData.add(rs.getObject(i + 1) == null ? "" : rs
							.getObject(i + 1).toString());

				}

				if (!hasWriterHead) {

					ExcelUtil.valueExcel(headList, ws, 0);

					hasWriterHead = true; // 以后就不写头部信息了

					index++;
				}

				ExcelUtil.valueExcel(listData, ws, index);

				index++;

				// 每一个Excel写4W条数据，超过4W，则分几个Excel
				if (index == 40001) {

					// 写了多少个Excel文件了。
					// hasWriterHowManyExcel++;
					index = 0;
					wwb.write();
					wwb.close();

					System.out
							.println("写入到一个Excel文件:" + file.getAbsolutePath());

					wwb = null;
					ws = null;

					// 由于可能要产生多个文件，则要保证产生不同的文件名，用原子变量生成
					file = new File(getSeqFilePathName(filePath));

					fileList.add(file.getAbsolutePath());
					wwb = Workbook.createWorkbook(file);
					ws = wwb.createSheet("数据导出"
							+ ExcelUtil.getCurrentTimeOfString(), 0);

					hasWriterHead = false; // 重新来了，便要重新写一次头部信息
				}

				if (writeToExcelDataAmount % 2000 == 0) {

					System.out.println("已导入记录数:" + writeToExcelDataAmount + "\t" + "[" + DateUtil.getDateHHMMSS() + "]");
				}

			}

			if (!isFullExcel) {
				wwb.write();
				wwb.close();

			}

			System.out.println("导出记录数汇总:" + amount);
			System.out.println("产生的文件为:");
			for (String s : fileList) {

				System.out.println("\t" + s);
			}

			System.out.println("导出over.");

		} finally {

			close(rs, pst, conn);
		}

		System.out.println("writer successfully!");
	}

	/**
	 * 获取某sql有多少条数据。
	 *
	 * @param conn
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private int getSqlResultSetCount(Connection conn, String sql)
			throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;

		String countSql = "select count(1) amount from ( " + sql + " )";



		try {

			pst = conn.prepareStatement(countSql);
			rs = pst.executeQuery();

			rs.next();

			return  rs.getInt("amount");

		} finally {

			close(rs, pst);

		}
	}

	/**
	 * 产生一个唯一的整形序号
	 *
	 * @return
	 */
	private String getSeqFilePathName(String filePath) {

		return filePath.replaceFirst(".xls", ""
				+ ExcelUtil.getCurrentTimeOfString() + "-"
				+ ai.getAndIncrement() + ".xls");
	}

	private void close(ResultSet rs) throws SQLException {

		if (rs != null) {
			rs.close();
		}
	}

	private void close(PreparedStatement pst) throws SQLException {

		if (pst != null) {

			pst.close();
		}

	}

	private void close(Connection conn) throws SQLException {

		if (conn != null) {

			conn.close();
		}
	}

	private void close(ResultSet rs, PreparedStatement pst) throws SQLException {

		close(rs);
		close(pst);

	}

	private void close(ResultSet rs, PreparedStatement pst, Connection conn)
			throws SQLException {

		close(rs, pst);

		close(conn);

	}

	/**
	 * 一些头部信息
	 *
	 * @param url
	 * @param username
	 * @param password
	 * @param sql
	 * @param savePath
	 */
	private static void headMsg(String url, String username, String password,
			String sql, String savePath) {

		System.out
				.println("\t##########################################################");
		System.out
				.println("\t#                                                        #");
		System.out
				.println("\t#                   开始进行数据导出                                                          #");
		System.out.println("\t# 导出环境为：");
		System.out.println("\t# url:" + url);
		System.out.println("\t# username:" + username);
		System.out.println("\t# password:" + password);
		System.out.println("\t# sql:" + sql);
		System.out.println("\t# savePath:" + savePath);
		System.out.println("\t#                                                        #");
		System.out.println("\t##########################################################");

	}

	public static void main(String[] args) throws SQLException,
			RowsExceededException, WriteException, IOException {

         Date startDate = new Date();



		File f = new File(".");

		Map<String, String> dbMap = AnalysisParas.analy(f.getCanonicalPath()
				+File.separator+ "db.txt", f.getCanonicalPath() + File.separator+"sql.txt");

		String url = dbMap.get("url");
		String username = dbMap.get("username");
		String password = dbMap.get("password");
		String sql = dbMap.get("sql");
		String savePath = dbMap.get("savePath");

		String hasreadline = dbMap.get("hasreadline");

		DBUtil db = DBUtil.getDBUtilForOracle(url, username, password);

		headMsg(url, username, password, sql, savePath);

		System.out.println("开始时间[" + DateUtil.getDateHHMMSS(startDate)+"]");
		try {

			db.executeSqlOfAllData(sql, savePath);

		} catch (Exception e) {

			System.out.println("导出出错，请检查！！！！！");
			System.out.println(e.getMessage());
		}


		Date endDate = new Date();

        System.out.println("结束时间[" + DateUtil.getDateHHMMSS(endDate)+"]");

        System.out.println("历时：" );

        System.out.println(" " + DateUtil.getDateHHMMSS(startDate));

        System.out.println("-" + DateUtil.getDateHHMMSS(endDate));
        System.out.println("--------------------" );
        System.out.println("                   ?" );


        if("yes".equalsIgnoreCase(hasreadline)) {

        	Scanner sc = new Scanner(System.in);

        	System.out.println("输入任何值退出...");

        	sc.nextLine();

        	sc.close();

        }


	}

}
