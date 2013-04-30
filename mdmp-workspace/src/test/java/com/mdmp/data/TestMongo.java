/**
 * 
 */
package com.mdmp.data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author zhefang
 * 
 */
public class TestMongo {

	MongoClient mongoClient;

	DB db;

	// UserDao dao;
	ConfigurableApplicationContext context;
	private static ObjectMapper mapper = new ObjectMapper();
	@Before
	public void setupMongo() throws Exception {
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDB("mydb");

		System.out.println(this.getClass());
		context = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");
		// dao = context.getBean(UserDaoImpl.class);
	}

	@Test
	public void testMongoWrite() {
		DBCollection users = db.getCollection("user");
		for (int i = 0; i < 1000; i++) {
			BasicDBObject user = new BasicDBObject();
			user.put("userid", i);
			user.put("user", "mac fang");
			users.insert(user);
			if (i % 200 == 0) {
				System.out.println(" >>> complete" + i);
			}
		}
	}

	@Test
	public void testMongoMetricsWrite2() {
		DBCollection caldata = db.getCollection("caldata");
		for (int i = 0; i < 1000; i++) {
			BasicDBObject metrics = new BasicDBObject();
			metrics.put("ts", System.currentTimeMillis());
			BasicDBObject metric = new BasicDBObject();
			metric.put("key1", 1);
			metric.put("key2", 1);
			metric.put("key3", 1);
			metric.put("key4", 1);
			metrics.put("metric", metric);
			caldata.insert(metrics);
		}
	}
	
	@Test
	public void testMongoMetricsRoughRead(){
		DBCollection caldata = db.getCollection("caldata");
		System.out.println(caldata.count());
	}

	@Test
	public void testMongoRead() {
		DBCollection users = db.getCollection("user");
		System.out.println(users.getCount());
	}

	@Test
	public void testMongoSpringRead() {
		// // For Annotation
		// ApplicationContext ctx = new AnnotationConfigApplicationContext(
		// SpringMongoConfig.class); 
		// MongoOperations mongoOperation = (MongoOperations) ctx
		// .getBean("mongoTemplate");
		// DBCollection dbc = mongoOperation.getCollection("user");
		// System.out.println("Number of user = " + dbc.count());
	}

	@Test
	public void testMetricsRead() throws Exception {
		CalDataDao dao = context.getBean(CalDataDaoImpl.class);
//		List<Metrics> metrics = dao.listAll("caldata");
//		for(Metrics mets : metrics){
//			System.out.println(mets.getTs());
//			System.out.println(mets.getMetric());
////			for(Metric met : mets.getMetrics()){
////				System.out.println(met.getKey() + " : " + met.getValue());
////			}
//		}
//		System.out.println(dao.listAll("caldata").size());
		System.out.println(mapper.writeValueAsString(dao.listByTimestamp("caldata", retLastDay(), retNextDay())));
		//dao.listByTimestamp(collection, new Date(""), end);
	}
	
	private static long retLastDay(){
		Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1); 
        Date date = c.getTime();
        System.out.println(date + " long: " + date.getTime());
        return date.getTime();
	}
	
	private static long retNextDay(){
		Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1); 
        Date date = c.getTime();
        System.out.println(date + " long: " + date.getTime());
        return date.getTime();
	}
	// @Test
	// public void testMongoSpringXML() {
	// System.out.println(dao.listUsers());
	// System.out.println(dao.findUser(15, 20).size());
	// }
	public  static void main(String ... args){
		retLastDay();
		retNextDay();
	}
}
