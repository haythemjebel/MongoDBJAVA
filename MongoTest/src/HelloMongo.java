import java.util.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class HelloMongo {

	public static void main(String[] args) {
		Mongo mongo = null;
		DB db = null;
		DBCollection table = null;
		// connection to mongo db serveur
		try {
			mongo = new Mongo("localhost", 27017);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// get the connections
		db = mongo.getDB("users");
		table = db.getCollection("employess");
		//table.drop();

		/// list all database
		System.out.println("Databases : ");
		List<String> dbs = mongo.getDatabaseNames();
		for (String dbset : dbs) {
			System.out.println(dbset);
		}

		// collection from a database
		System.out.println("\n Collections :");
		db = mongo.getDB("users");
		Set<String> tables = db.getCollectionNames();
		for (String coll : tables) {
			System.out.println(coll);
		}
		/// create document and insert
		BasicDBObject document1 = new BasicDBObject();
		document1.put("name", "hadil");
		document1.put("age", "9");

		BasicDBObject document2 = new BasicDBObject();
		document2.put("name", "nour");
		document2.put("age", "12");
		
		table.insert(document1);
		table.insert(document2);


		//// data of collection are output
		System.out.println("\n date of collection :");
		BasicDBObject searchQuery = new BasicDBObject();

		DBCursor cursor = table.find(searchQuery);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		/// update
		BasicDBObject query = new BasicDBObject();
		query.put("name", "hadil");

		BasicDBObject newdocument = new BasicDBObject();
		newdocument.put("name", "hachem");

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newdocument);
		
		table.update(query, updateObject);

		//// data of collection are output
		System.out.println("\n date of collection :");
		searchQuery = new BasicDBObject();

		cursor = table.find(searchQuery);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

}
