package com.mongodb.example;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.example.model.User;

public class MongoDBDemo {

	private static final String IP = "127.0.0.1";
	private static final int PORT = 27017;
	private static final String DB_NAME = "mytestdb";
	private static final String COLLECTION_NAME = "students";

	private DBCollection dbc;

	public static void main(String[] args) {
		try {
			MongoDBDemo mongoDBDemo = new MongoDBDemo();
			mongoDBDemo.initDBCollection();
			mongoDBDemo.implementCRUDOperations();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void implementCRUDOperations() {
		User user = generateUserObject();

		insert(user);
		find(user);
		update(user);
		find(user);
		delete(user);
	}

	private User generateUserObject() {
		return new User(1, "Sameh");
	}

	private void initDBCollection() {
		ServerAddress sa = new ServerAddress(IP, PORT);

		// List<MongoCredential> mcList = new ArrayList<MongoCredential>();
		// mcList.add(MongoCredential.createPlainCredential("ssayed",
		// "mytestdb", "mongodb123456".toCharArray()));

		MongoClient mc = new MongoClient(sa);
		DB db = mc.getDB(DB_NAME);
		System.out.println("Connected to Mongo DB");
		dbc = db.getCollection(COLLECTION_NAME);
	}

	private void delete(User user) {
		DBObject criteria = BasicDBObjectBuilder.start().append("_id", user.getId()).get();
		dbc.remove(criteria);
		System.out.println("user has been deleted");
	}

	private void insert(User user) {
		DBObject dbo = BasicDBObjectBuilder.start().append("_id", user.getId()).append("name", user.getName()).get();
		dbc.insert(dbo);
		System.out.println("user has been inserted");
	}

	private void update(User user) {
		user.setName("Sila");
		DBObject dbo = BasicDBObjectBuilder.start().append("name", user.getName()).get();
		DBObject criteria = BasicDBObjectBuilder.start().append("_id", user.getId()).get();
		dbc.update(criteria, dbo);
		System.out.println("user has been updated");
	}

	private void find(User user) {
		DBObject dbo = BasicDBObjectBuilder.start().append("_id", user.getId()).get();
		DBCursor dbcr = dbc.find(dbo);

		while (dbcr.hasNext()) {
			System.out.println(dbcr.next());
		}
	}
}
