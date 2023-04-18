package Test;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class dummyApi {
	@Test
	public void get () {
		
		given().
		       get("https://reqres.in/api/users?page=2").
        then().
               statusCode(200).log().all();	
	}
	@Test
	public void Post () {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name" ,"morpheus");  
		request.put("job" , "leader");  
		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("contentType" , "new employee").
	    body(request.toJSONString()).
		      
		when().
		       post("https://reqres.in/api/users").
        then().
               statusCode(201).log().all();	
	}
	@Test
	public void Put () {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name" ,"morpheus");  
		request.put("job" , "zion residentr");  
		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("contentType" , "new employee").
	    body(request.toJSONString()).
		      
		when().
		       put("https://reqres.in/api/users/2").
        then().
               statusCode(200).log().all();	
	}
	@Test
	public void Delete () {
		
		when().
          delete("https://reqres.in/api/users/2").
       then().
          statusCode(204).log().all();
		
	}
}
