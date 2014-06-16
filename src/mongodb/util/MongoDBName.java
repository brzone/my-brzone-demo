package mongodb.util;

/**
 * Mongo DB name 的enum常量
 * @author lijian@cstonline.cn
 *
 * @date 2014年6月15日 下午6:19:23
 */
public enum MongoDBName {
	
	/**dbName:gdcp*/
	GDCP("gdcp");
	
	private String dbName;
	
	private MongoDBName(String dbName) {
		this.dbName = dbName;
	}

	@Override
	public String toString() {
		return this.dbName;
	}
}
