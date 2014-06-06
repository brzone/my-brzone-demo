package mongodb.test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class SimpleTest {
	
	private Mongo mongo ;
	
	private DB db ;
	
	private DBCollection collection;
	
	private AtomicInteger nameAtomic = new AtomicInteger(0);
	
	private AtomicInteger ageAtomic = new AtomicInteger(0);
	
	@Before
	public void init() throws UnknownHostException {
		
		mongo = new Mongo();
		db = mongo.getDB("test");
		collection =  db.getCollection("person");
		
		System.out.println("mongo init.");
	}
	
	
	@After
	public void close() {
		
		if(mongo != null) {
			mongo.close();
			System.out.println("mongo.close()");
		}
		
	}
	

	//@Test
	public void testQuery() throws UnknownHostException {
		
		DBCursor cursor =  collection.find();
		
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		println(cursor.count());
		
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
	
	
	@Test
	public void testRemoveBatch() {
		
		println("testRemoveBatch()");
		
		DBObject db = new BasicDBObject();
		DBObject ageWhere = new BasicDBObject();
		ageWhere.put("$gt", 900);
		
		db.put("age", ageWhere);
		
		println(collection.remove(db).getN());
	}
	
	
	
	public void println(Object obj) {
		System.out.println(obj);
	}
	
}
