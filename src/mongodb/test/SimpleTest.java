package mongodb.test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import mongodb.util.MongoService;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.DateUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class SimpleTest {
	
	private Mongo mongo ;
	
	private DB db ;
	
	private DBCollection collection;
	
	private AtomicInteger nameAtomic = new AtomicInteger(0);
	
	private AtomicInteger ageAtomic = new AtomicInteger(0);
	
	//@Before
	public void init() throws UnknownHostException {
		
		mongo = new Mongo();
		db = mongo.getDB("test");
		collection =  db.getCollection("person");
		
		System.out.println("mongo init.");
	}
	
	
	//@After
	public void close() {
		
		if(mongo != null) {
			mongo.close();
			System.out.println("mongo.close()");
		}
		
	}
	

	//@Test
	public void testQueryMap() throws UnknownHostException {
		
		DBCursor cursor =  collection.find();
		
		List<Map> data = new ArrayList<Map>();
		
		while(cursor.hasNext()) {
			
			
			DBObject dbObj = cursor.next();
			
			System.out.println(dbObj);
			
			System.out.println("============================");
			
			System.out.println("name:" + dbObj.get("name"));
			
			Set<String> set = dbObj.keySet();
			
			if(set == null || set.isEmpty()) {
				continue;
			}
			
		
			
			int keySize = set.size();
			
			for(String key : set) {
				
				Map<String,Object> map = new HashMap<String, Object>(keySize);
				map.put(key.toUpperCase(), dbObj.get(key));
				data.add(map);
			}
			
		}
		println(cursor.count());
		
		System.out.println("-----------我就是爱分割线-----------------");
		
		System.out.println("data.size():" + data.size());
		System.out.println("data:" + data);
	}
	
	
	
	//@Test
	public void testQueryBean() throws UnknownHostException {
		
		DBCursor cursor =  collection.find();
		
		List<Person> data = new ArrayList<Person>();
		
		while(cursor.hasNext()) {
			
			
			DBObject dbObj = cursor.next();
			
		
			data.add(dbObjectToBean(dbObj,Person.class));
			
		}
		println(cursor.count());
		
		System.out.println("-----------我就是爱分割线-----------------");
		
		System.out.println("data.size():" + data.size());
		
		for(Person p : data) {
			System.out.println(p);
		}
		
	}
	
	
	public <T> T dbObjectToBean(DBObject dbObject,Class<T> clazz){
		T info=null;
		if(dbObject!=null){
			Object job=com.alibaba.fastjson.JSON.toJSON(dbObject);
			info=com.alibaba.fastjson.JSON.parseObject(job.toString(),clazz);
		}
		return info;
	}
	
	
	
	//@Test
	public void testSaveOne() {
		
		DBObject obj = new BasicDBObject();
		obj.put("name", "tcp" + nameAtomic.incrementAndGet());
		obj.put("age",11);
		int n = collection.save(obj).getN();
		println(n);
		
		
	}
	
	//@Test
	public void testSaveBatch() {
		
		println("testSaveBatch()");
		
		List<DBObject> dbList = new ArrayList<DBObject>();
		
		for(int i = 0;i<1000;i++) {
			
			DBObject db = new BasicDBObject();
			db.put("name", "xingyun" + nameAtomic.incrementAndGet());
			db.put("age",  ageAtomic.incrementAndGet());
			
			dbList.add(db);
			
		}
		
		println(collection.insert(dbList).getN());
		
	}
	
	//@Test
	public void testRemoveByID() {
		
		println("testRemoveByID()");
		
		DBObject db = new BasicDBObject();
		db.put("_id", new ObjectId("539027e4673e67dd8f88cc30"));
		
		println(collection.remove(db).getN());
	}
	
	
	//@Test
	public void testRemoveBatch() {
		
		println("testRemoveBatch()");
		
		DBObject db = new BasicDBObject();
		DBObject ageWhere = new BasicDBObject();
		ageWhere.put("$gt", 900);
		
		db.put("age", ageWhere);
		
		println(collection.remove(db).getN());
	}
	
	
	//@Test
	public void testIndex() {
		
		List<DBObject> indexList = collection.getIndexInfo();
		
		if(indexList == null || indexList.isEmpty()) {
			return ;
		}
		
		for(DBObject index : indexList) {
			System.out.println("AAA:" + index);
		}
		
		DBObject wantCreateIndex = new BasicDBObject();
		wantCreateIndex.put("age", 1);
		
		//此方法，如果已经存在了此索引，便不会创建，也不会抛出异常
		collection.createIndex(wantCreateIndex);
		
		/*for(DBObject index : indexList) {
			
			if(wantCreateIndex.equals(index)) {
				System.out.println("catch it : " + index);
			}
			
		}*/
		
		
	}
	
	@Test
	public void testDistinctCount() throws Exception {
		//MongoService service = MongoService.getServiceByGDCPDBNameAndColName("oldOriData");
		
		MongoClient mg = new MongoClient("192.168.1.132", 27017);

		DB db = mg.getDB("gdcp");

		DBCollection collectionA = db.getCollection("oldOriData");

		
	/*	List<Object> data = collection.distinct("devcode");

		if(data == null || data.isEmpty()) {
			println("data == null || data.isEmpty()");
			mg.close();
			return;
		}
		
		println(data.size());
		println(data.get(0).getClass());
		
		for(Object obj : data) {
			//println(obj);
		}*/
		
		println("===================================");
		
		DBObject query = new BasicDBObject();
		
		BasicDBObject objTime = new BasicDBObject();
		
		println(DateUtil.formatYYYYMMDDHHMMSS(DateUtil.parseYYYYMMDD("2014-04-27")));
		
		println(new Date());
		
		objTime.append("$gt",DateUtil.parseYYYYMMDD("2014-04-27"));
		objTime.append("$lt",DateUtil.parseYYYYMMDD("2014-05-01"));
		
		query.put("obdTime", objTime);
		
		println(query);
		
		List<Object>  queryList =  collectionA.distinct("devcode", query);
		
		
		if(queryList == null || queryList.isEmpty()) {
			println("queryList == null || queryList.isEmpty()");
			mg.close();
			return;
		}
		
		println(queryList.size());
		for(Object obj : queryList) {
			//println(obj);
		}
		
		
		mg.close();
		
	}
	
	//@Test
	public void testInsertDate() throws Exception {
		MongoService service =  MongoService.getServiceByGDCPDBNameAndColName("haha");
		
		/**
		 * 
		 * 插入的时候，时间会减8小时，读取的时候，时间会加八小时，且查询的时候，时间参数会减八小时
		 */
		
		/*DBObject obj = new BasicDBObject();
		obj.put("name", "scott");
		obj.put("insertDate", new Date());
		
		service.save(obj);
		
		println("save ok");;*/
		
	
		List<DBObject> list = service.query(new BasicDBObject("name", "scott"));
		
		for(DBObject db : list) {
			println(db.get("insertDate"));
		}
		
	}
	
	
	
	public void println(Object obj) {
		System.out.println(obj);
	}
	
}
