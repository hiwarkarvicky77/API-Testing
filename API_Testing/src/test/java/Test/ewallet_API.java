package Test;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ewallet_API {

	@Test (invocationCount = 1)
	public void getV1agent() {
		
		given().
		       get("http://10.128.51.6:8080/v1/agent").
		then().
		       statusCode(200).log().all();
		
	}
	
	@Test (invocationCount = 5)
    public void getV1requestid() {
		
		given().
		       get("http://10.128.51.6:8080/v1/agent/request/dc6539fc7282427ca3d02497a4b5bdb1").
		then().time(Matchers.lessThan(1000L)).
		       statusCode(200).log().all();
		
	}
}
