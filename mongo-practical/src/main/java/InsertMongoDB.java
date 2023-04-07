import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertMongoDB {

	public static void main(String[] args) {
		
		
		/*
		 * URI
		 * Connection (MongoClient)
		 * Database
		 * Collection
		 * Document
		 */
		
		//preparing the uri
		String uri = "mongodb://localhost:27017";
		MongoClientURI mongoClientURI = new MongoClientURI(uri);
		
		//connection establishment
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		System.out.println("Connection established");

		//selecting the database
		MongoDatabase database = mongoClient.getDatabase("java-integration");
		
		//taking collection
		MongoCollection<Document> collection = database.getCollection("myCollection");
		System.out.println("Collection found");
		
		//preparing document
		Document document = new Document("name", "xyz");
		document.append("age", 404);
		document.append("sex", "Female");
		document.append("place", "nowhere");
		
		//save document into the collection
		collection.insertOne(document);
		System.out.println("Document added to the connection");
		
		//closing the connection
		mongoClient.close();
		
		
	}

}
