import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	private static ObjectMapper mObjectMapper = new ObjectMapper();
	
	private static void readFromFile() throws FileNotFoundException, IOException {
		//reading from the file myFile
		User[] users = mObjectMapper.readValue(new FileReader("myFile.json"), User[].class);
		System.out.println(mObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
		
		//writing to the file myAnotherFile
		mObjectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter("myAnotherFile.json"), users);
		
		System.out.println("operation successful");
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		readFromFile();
		
	}

}
