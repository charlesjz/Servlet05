package atGuiGu;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	
	
	@Test
	public void test() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonStr="{\"@type\":\"ListItem\",\"position\":22,\"url\":\"https://job-openings.monster.ca/devops-architect-developer-toronto-on-ca-ntt-data-inc/11/195489509\"}";
		jsonStr=jsonStr.replace("@", "");
		
		ListItem e = objectMapper.readValue(jsonStr, ListItem.class);
		
		System.out.println(e);
		System.out.println("Type    : " + e.getType());
		System.out.println("Position: " + e.getPosition());
		System.out.println("Url     : " + e.getUrl());
		
		
		
	}
}
