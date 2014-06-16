package mongodb.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import common.util.CSTLogger;
import common.util.PropertiesUtil;
import common.util.StringUtil;

/**
 * 操作mongo 数据库
 * 
 * @author lijian@cstonline.cn
 * 
 * @date 2014年6月15日 下午6:21:05
 */
public class MongoService {

	private static CSTLogger logger = new CSTLogger(PropertiesUtil.class);

	/** 主机IP */
	private static final String HOST;

	/** 端口 */
	private static final int PORT;

	/** 保存的dbName */
	private String dbName;

	/** collectionName */
	private String collectionName;

	static {
		Map<String, String> data = PropertiesUtil
				.getProperties("conf/mongo.properties");
		if (data == null || data.isEmpty()) {
			throw new RuntimeException(
					"在相对路径conf/mongo.properties，没有配置mongo的链接信息");
		}

		if (StringUtil.isNullOrBlank(data.get("HOST"))) {
			throw new RuntimeException("配置mongo的HOST不能为空");
		}

		if (data.get("PORT") == null) {
			throw new RuntimeException("配置mongo的PORT端口不能为空");
		}

		HOST = data.get("HOST");
		PORT = Integer.parseInt(data.get("PORT"));

		logger.logInfo("mongoDB系统配置参数:" + data);

	}

	/**
	 * 通过dbName和文档名字创建对象
	 * 
	 * @param dbName
	 * @param collectionName
	 */
	private MongoService(String dbName, String collectionName) {
		this.dbName = dbName;
		this.collectionName = collectionName;
	}

	/**
	 * 返回 通过MongoDBName枚举类型和文档名字创建的对象
	 * 
	 * @param dbName
	 * @param collectionName
	 * @return
	 */
	public static MongoService getServiceByDbNameAndColName(MongoDBName dbName,
			String collectionName) {

		StringUtil.checkIsNullOrBlank(collectionName,
				"传递的CollectionName文档名字不能为空");

		return new MongoService(dbName.toString(), collectionName);

	}
	
	
	/**
	 * <li>返回 通过dbName和文档名字创建的对象</li><br/>
	 * tip:最好是通过方法getServiceByDbNameAndColName（MongoDBName dbName,String collectionName），因为
	 * 这个可以保证你传入的DBName不会写错
	 * 
	 * @param dbName
	 * @param collectionName
	 * @return
	 */
	public static MongoService getServiceByDbNameAndColName(String dbName,String collectionName) {

		StringUtil.checkIsNullOrBlank(dbName,"传递的dbName文档名字不能为空");
		StringUtil.checkIsNullOrBlank(collectionName,"传递的CollectionName文档名字不能为空");

		return new MongoService(dbName, collectionName);

	}
	

	/**
	 * 返回，通过dbName为MongoDBName.GDCP[其值为gdcp]和文档名字创建的对象
	 * 
	 * @param collectionName
	 * @return
	 */
	public static MongoService getServiceByGDCPDBNameAndColName(
			String collectionName) {

		StringUtil.checkIsNullOrBlank(collectionName,"传递的CollectionName文档名字不能为空");

		return new MongoService(MongoDBName.GDCP.toString(), collectionName);

	}

	/**
	 * 查询，查询出来的每条记录[json]，转成传递的Class<T>
	 * 
	 * @param dbObject
	 * @param clazz
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> query(DBObject dbObject, final Class<T> clazz) throws Exception {

		if (dbObject == null) {
			logger.logInfo("查询传入需要更新的DBObject不能为空,直接返回");
			return null;
		}

		Object obj = this.executeTemplate(new MongoExecuteCallBack() {

			@Override
			public Object execute(MongoClient mg, DB db,
					DBCollection collection, DBObject... dbObj)
					throws Exception {

				if (dbObj == null || dbObj.length != 1) {
					logger.logInfo("查询操作，传入的DBObject不合法，只能包含一个元素,直接返回");
					return 0;
				}

				DBCursor cursor = collection.find(dbObj[0]);

				List<T> data = new ArrayList<T>(cursor.count());

				while (cursor.hasNext()) {

					DBObject obj = cursor.next();
					T t = dbObjectToBean(obj, clazz);
					data.add(t);
				}

				logger.logInfo("查询出来的数量：" + data.size());

				return data;

			}
		}, dbObject);

		return (List<T>) obj;
	}

	/**
	 * DBObject转成具体的对象
	 * 
	 * @param dbObject
	 * @param clazz
	 * @return
	 */
	private <T> T dbObjectToBean(DBObject dbObject, Class<T> clazz) {
		T info = null;
		if (dbObject != null) {
			Object job = com.alibaba.fastjson.JSON.toJSON(dbObject);
			info = com.alibaba.fastjson.JSON.parseObject(job.toString(), clazz);
		}
		return info;
	}

	/**
	 * 更新：不存在创建，匹配多条，更新多条
	 * 
	 * @param oldObj
	 *            需要更新的DBObject
	 * @param newObj
	 *            更新后的DBObject
	 * @return
	 * @throws Exception 
	 */
	public int updateUpsertTrueMultiTrue(DBObject oldObj, DBObject newObj) throws Exception {

		return update(oldObj, newObj, true, true);
	}

	/**
	 * 更新
	 * 
	 * @param oldObj
	 *            需要更新的DBObject
	 * @param newObj
	 *            更新后的DBObject
	 * @param upsert
	 *            如果不存在是否创建，true为创建，false为不创建
	 * @param multi
	 *            如果存在多条，是否更新多条，true为更新多条，false为只更新一条
	 * @return
	 * @throws Exception 
	 */
	public int update(DBObject oldObj, DBObject newObj, final boolean upsert,
			final boolean multi) throws Exception {

		if (oldObj == null || newObj == null) {
			logger.logInfo("传入需要更新的DBObject和更新后的DBOBject不能为空,直接返回");
			return 0;
		}

		Object obj = this.executeTemplate(new MongoExecuteCallBack() {

			@Override
			public Object execute(MongoClient mg, DB db,
					DBCollection collection, DBObject... dbObj)
					throws Exception {

				if (dbObj == null || dbObj.length != 2) {
					logger.logInfo("更新操作，传入的DBObject不合法，不能为空，且只能含有二个元素,直接返回");
					return 0;
				}

				int updateAmount = collection.update(dbObj[0], dbObj[1],
						upsert, multi).getN();

				logger.logInfo("更新的数量：" + updateAmount);

				return updateAmount;

			}
		}, oldObj, newObj);

		return (Integer) obj;
	}

	/**
	 * 通过DBObject进行删除
	 * 
	 * @param dbObj
	 * @return
	 * @throws Exception 
	 */
	public int delete(DBObject dbObj) throws Exception {

		if (dbObj == null) {
			logger.logInfo("禁止传入为null的DBObject进行全文档删除,直接返回");
			return 0;
		}

		Object obj = this.executeTemplate(new MongoExecuteCallBack() {

			@Override
			public Object execute(MongoClient mg, DB db,
					DBCollection collection, DBObject... dbObj)
					throws Exception {

				if (dbObj == null || dbObj.length != 1) {
					logger.logInfo("传入的DBObject不合法，不能为空，且只能含有一个元素,直接返回");
					return 0;
				}

				int removeAmount = collection.remove(dbObj[0]).getN();

				logger.logInfo("删除的数量：" + removeAmount);

				return removeAmount;

			}
		}, dbObj);

		return (Integer) obj;
	}

	/**
	 * 保存：返回本次插入mongodb数据库的数量
	 * 
	 * @param dbObj
	 * @return
	 * @throws Exception 
	 */
	public int save(DBObject... dbObj) throws Exception {

		if (dbObj == null || dbObj.length <= 0) {
			logger.logInfo("传递的DBObject为空或大小为0,直接返回");
			return 0;
		}

		Object obj = this.executeTemplate(new MongoExecuteCallBack() {

			@Override
			public Object execute(MongoClient mg, DB db,
					DBCollection collection, DBObject... dbObj)
					throws Exception {

				int amount = collection.insert(Arrays.asList(dbObj)).getN();
				logger.logInfo("本次插入数量:" + dbObj.length + ",插入失败的数量：" + amount);
				return amount;

			}
		}, dbObj);

		return (Integer) obj;
	}
	
	
	/**
	 * 创建索引：可以一次性创建多个索引
	 * @param dbObj
	 * @throws Exception
	 */
	public void createIndex(DBObject... dbObj)  throws Exception {
		
		if(dbObj == null || dbObj.length <= 0) {
			logger.logInfo("创建所以传递的索引DBObject为空或大小为0,直接返回");
			return;
		}
		
		this.executeTemplate(new MongoExecuteCallBack() {

			@Override
			public Object execute(MongoClient mg, DB db,
					DBCollection collection, DBObject... dbObj)
					throws Exception {

				for(DBObject indexDB : dbObj) {
					//此方法，如果已经存在了此索引，便不会创建，也不会抛出异常，故不需要判断是否存在了
					collection.createIndex(indexDB);
				}
				logger.logInfo("创建索引完毕，传递的创建索引的数量：" + dbObj.length);
				return dbObj.length;

			}
		}, dbObj);
		
		
	}
	

	/**
	 * 执行模板：在MongoExecuteCallBack实现中，MongoClient mg不需要关闭，因为在此模板方法中已经关闭
	 * 
	 * @param executer
	 * @param dbObj
	 * @return
	 * @throws Exception 
	 */
	public Object executeTemplate(MongoExecuteCallBack executer,
			DBObject... dbObj) throws Exception {

		MongoClient mg = null;

		DB db = null;

		DBCollection collection = null;

		Object returnObj = null;

		try {

			mg = new MongoClient(HOST, PORT);
			db = mg.getDB(this.getDbName());
			collection = db.getCollection(this.getCollectionName());

			returnObj = executer.execute(mg, db, collection, dbObj);

		} catch (Exception e) {

			e.printStackTrace();
			logger.logError("根据host[{}]和port[{}]创建MongoClient失败[{}]", HOST,
					PORT, e);
			throw e;
		} finally {

			if (mg != null) {
				mg.close();
			}

		}

		return returnObj;

	}

	// ==============================sets and gets methods
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	@Override
	public String toString() {
		return "MongoService [dbName=" + dbName + ", collectionName="
				+ collectionName + "]";
	}

}
