import java.util.ArrayList;
import java.util.List;


public class OneSqlToMany {

	public static List<String> split(String sql) {

		final int selectIndex = sql.indexOf("select");

		final int fromIndex = sql.indexOf("from");

		String[] columnArray = sql.substring(selectIndex+6, fromIndex).split(",");


		String headSql = "select ";

		String endSql = "  " + sql.substring(fromIndex);



		List<String> columnSqlList = new ArrayList<String>(columnArray.length);

		for(String column:columnArray) {

			columnSqlList.add(headSql + column + endSql);

		}


		return columnSqlList;
	}

	public static void main(String[] args) {

		String sql = "select   age 年龄,b,c,  d   from dual";

		for(String s:split(sql)){

			System.out.println(s);
		}

	}

}
