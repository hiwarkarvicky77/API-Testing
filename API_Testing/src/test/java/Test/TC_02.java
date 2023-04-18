package Test;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_02 {

     @Test
	public void TC_02get() {
		
		given().
		      get("https://dummy.restapiexample.com/api/v1/employees").
		then().time(Matchers.lessThan(1000L)).
		      statusCode(200).log().all();
		
	}
     
     
	@Test
     public void TC_02post() {
    	 
    	 JSONObject request = new JSONObject();
    	 
    	 request.put("name", "test");
    	 request.put("Salary", "1000");
    	 request.put("age", "23");
    	 
    	 given().
    	            contentType(ContentType.JSON).accept(ContentType.JSON).
    	            header("contettype","New Employee").
    	            body(request.toJSONString()).
    	 when().post
    	         ("https://dummy.restapiexample.com/api/v1/create").
    	 then().    
    	            statusCode(201).log().all();
     
     }
	
	
	
}
