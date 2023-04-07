import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UpdateMongoDB2 {

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
		
		//filtering the documents to be updated
		Document found = (Document) collection.find(new Document("name", "Kaushik Prajapati")).first();
		
		//updating the document
		if(found != null) {
			System.out.println("found user");
			
			Bson updatedDocument = new Document("age", 24);
			Bson updateOperation = new Document("$set", updatedDocument);
			
			collection.updateOne(found, updateOperation);
			System.out.println("document updated successfully");
		}
		else {
			System.out.println("Document does not found");
		}
		
		//closing the connection
		mongoClient.close();
		
		
	}

}
