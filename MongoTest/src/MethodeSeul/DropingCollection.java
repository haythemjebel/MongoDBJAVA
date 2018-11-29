package MethodeSeul;

import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;  

import org.bson.Document;  
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class DropingCollection { 
   
   public static void main( String args[] ) {  

      // Creating a Mongo client 
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

      // Creating Credentials 
      MongoCredential credential; 
      credential = MongoCredential.createCredential("Haythem", "users", 
         "password".toCharArray()); 
      System.out.println("Connected to the database successfully");  
      
      // Accessing the database 
      MongoDatabase database = mongo.getDatabase("users");  
      
      // Creating a collection 
      System.out.println("Collections created successfully"); 

      // Retieving a collection
      MongoCollection<Document> collection = database.getCollection("newCollection");

      // Dropping a Collection 
      collection.drop(); 
      System.out.println("Collection dropped successfully");
   } 
}