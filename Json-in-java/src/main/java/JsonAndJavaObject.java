import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAndJavaObject {
	
	private static ObjectMapper mObjectMapper = new ObjectMapper();
	
	private static void toJson(User user) throws JsonProcessingException {
		String json = mObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		System.out.println(json);
	}
	
	private static void fromJson(String json) throws JsonMappingException, JsonProcessingException {
		User user = mObjectMapper.readValue(json, User.class);
		System.out.println(user);
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		User user = new User("Kaushik", "Prajapati", 23, new Address("wall street", "Mumbai", "Africa"));
		toJson(user);
		fromJson("{\"firstName\":\"xyz\",\"lastName\":\"pqr\",\"age\":404}");
	}
	
}
