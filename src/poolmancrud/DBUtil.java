/*package poolmancrud;

import java.sql.SQLException;

import com.frameworkset.common.poolman.PreparedDBUtil;

public class DBUtil {

	public static Object insert(String dbName,String sql,Object... args) throws SQLException {
		
		return insertUseDBOrNot(dbName,sql,args);
	}
	
     public static Object insert(String sql,Object... args) throws SQLException {
		
		return insertUseDBOrNot(null,sql,args);
	}
	
	
	private static Object insertUseDBOrNot(String dbName,String sql,Object... args) throws SQLException {
		
		PreparedDBUtil db = new PreparedDBUtil();
		
		if(dbName == null || "".equals(dbName.trim())){
		    db.preparedInsert(sql);
		} else {
			
			db.preparedInsert(dbName, sql);
		}
		
		fillPrepared(db,args);
		
		return db.executePrepared();
	}
	
	private static void fillPrepared(PreparedDBUtil db,Object... args) throws SQLException {
		
		for(int i = 0,j = args.length;i<j;i++) {
			
			db.setObject(i+1, args[i]);
		}
		
	}
	
	
	
}
*/