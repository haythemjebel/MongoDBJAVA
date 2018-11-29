package MethodeSeul;
import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential; 

public class CreatingCollection {

	public static void main(String args[]) {

		// Creating a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("Haythem", "users", "password".toCharArray());
		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("users");

		// Creating a collection
		database.createCollection("NewCollection");
		System.out.println("Collection created successfully");
	}
}