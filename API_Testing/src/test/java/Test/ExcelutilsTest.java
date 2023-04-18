package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pom.Exceldataprovider;

import io.restassured.http.ContentType;

public class ExcelutilsTest {
	public static Exceldataprovider excel;

	@Test
	public void abctest() throws Exception {
		excel = new Exceldataprovider();

		JSONObject request = new JSONObject();

		request.put("employee_name", excel.getstringdata("Sheet1", 0, 0));
		request.put("employee_salary", excel.getintdata("Sheet1", 0, 1));
		request.put("employee_age", excel.getintdata("Sheet1", 0, 2));

		baseURI = "https://dummy.restapiexample.com/api/v1/";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("contentType", "new employee")
				.body(request.toJSONString()).
	    when().post("/create").
	    then().statusCode(200).log().all();

	}

}
