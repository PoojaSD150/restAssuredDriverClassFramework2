package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import coomonFuctionsPackage.utility_common_function;

public class post_req_repository1 {
public static String base_URI() {
		
		String baseURI="https://reqres.in/";
		
		return baseURI;
	}
	
	public  static String post_resource() {
		String resource="api/users";
		
		return resource;
	}
	public static String post_req_tc1() throws IOException {
		
		  ArrayList<String> data=utility_common_function.readDataExcel("Post_Test_Data","POST_TC1");
		  String req_name=data.get(1);
		  String req_job=data.get(2);
		  
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
	}
	
	
}
