import java.util.Arrays;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

public class ReadingMany {

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
		
		
		Block<Document> printDocument = document -> System.out.println(document.toJson());
		
		//print many
		collection.aggregate(
				Arrays.asList(
//						Aggregates.match(Filters.eq("age", 24)),
						Aggregates.group("$name", Accumulators.sum("count", 1))
						)
				).forEach(printDocument);;
				
		System.out.println("Done!!!");
		
		//closing the connection
		mongoClient.close();
		
		
	}

}
