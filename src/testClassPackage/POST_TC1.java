package testClassPackage;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import coomonFuctionsPackage.API_Common_Function;
import coomonFuctionsPackage.utility_common_function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.post_req_repository1;



public class POST_TC1 {

		public static void execute() throws IOException{
		for(int i=0;i<5;i++)
		{
			String requestbody=post_req_repository1.post_req_tc1();
			int statusCode=API_Common_Function.response_statuscode(post_req_repository1.base_URI(), post_req_repository1.post_resource(), post_req_repository1.post_req_tc1());
			System.out.println(statusCode);
			if(statusCode==201)
			{
				String responseBody=API_Common_Function.response_Body(post_req_repository1.base_URI(), post_req_repository1.post_resource(), post_req_repository1.post_req_tc1());
				System.out.println(responseBody);
				POST_TC1.validator(responseBody, statusCode , requestbody);
				utility_common_function.evidencefilecreator("Post_TC1", post_req_repository1.post_req_tc1(), responseBody);
				break;
			}
			else
			{
				System.out.println("correct status code is not found hence retrying the API");
			}
		}		
	}
	
	public static void validator(String responseBody, int statusCode, String requestbody) throws IOException
	{
		JsonPath jspRes=new JsonPath(responseBody);
		String resName=jspRes.getString("name");
		String resJob=jspRes.getString("job");
		String resId=jspRes.getString("id");
		String resCreatedAt=jspRes.getString("createdAt");
		String actDate=LocalDateTime.now().toString().substring(0, 10);
		
		JsonPath jspReq=new JsonPath(post_req_repository1.post_req_tc1());
		String reqName=jspReq.getString("name");
		String reqJob=jspReq.getString("job");
		String expDate=resCreatedAt.substring(0, 10);
		
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(resName, reqName);
		Assert.assertEquals(resJob, reqJob);
		Assert.assertNotNull(resId);
		Assert.assertEquals(expDate, actDate);
	}
}


	
