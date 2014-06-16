package mongodb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mongodb.test.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MongoDBServiceTest {
	
	private static MongoService service;
	
	@BeforeClass
	public static void before() {
		service = MongoService.getServiceByDbNameAndColName("test","person"); 
	}
	
	//@Test
	public void testQuery() throws Exception {
		
		DBObject obj = new BasicDBObject();
		obj.put("age", 24);
		
		for(Person p : service.query(obj, Person.class)) {
			
			System.out.println(p);
			
		}
	}
	
	
	//@Test
	public  void testUpdateUpsertTrueMultiTrue() throws Exception {
		DBObject oldobj = new BasicDBObject();
		oldobj.put("age", 24);
		
		DBObject newobj = new BasicDBObject();
		
		DBObject setObj = new BasicDBObject();
		
		setObj.put("age", 99);
		setObj.put("location", "china");
		
		newobj.put("$set", setObj);
		
		service.updateUpsertTrueMultiTrue(oldobj, newobj);
	}
	
	
	//@Test
	public void testUpdate() throws Exception {
		
		DBObject oldobj = new BasicDBObject();
		oldobj.put("age", 99);
		
		
		DBObject newobj = new BasicDBObject();
		
        newobj.put("age", 6666666);
		newobj.put("location", "china");
		//更新当条，无存在字段则添加。
		service.update(oldobj, newobj, true, false);
		
	}
	
	//@Test
	public void testDelete() throws Exception {
		
		DBObject dbObject = new BasicDBObject();
		dbObject.put("age", 99);
		
		service.delete(dbObject);
	}
	
	//@Test
	public void testSave() throws Exception {
		
		Random random = new Random(47);
		
		List<DBObject> dbObjList = new ArrayList<DBObject>();
		
		for(int i = 0;i<20;i++) {
			DBObject dbObject = new BasicDBObject();
			dbObject.put("age", random.nextInt(100));
			dbObject.put("name", "xingyun" + random.nextInt(100));
			dbObject.put("location", "china");
			
			dbObjList.add(dbObject);
		}
		
		DBObject[] dbObjArr = new DBObject[dbObjList.size()];
		
		service.save(dbObjList.toArray(dbObjArr));
		
	}
	
	@Test
	public void testCreateIndex() throws Exception {
		
		DBObject dbobj = new BasicDBObject();
		dbobj.put("age", 1);
		
		service.createIndex(dbobj);
		
	}

}
