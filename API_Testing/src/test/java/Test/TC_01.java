package Test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_01 {

	
	@DataProvider(name = "Data for Post")
	public Object[][] dataforpost() {

		return new Object[][] {

				{ "Graham", 5000, 35 }, 
				{ "Ian", 6000, 40 }

		};

	}

	@Test(priority = 1, dataProvider = "Data for Post")
	public void test_post(String employee_name, int Salary, int Age) {

		JSONObject request = new JSONObject();

		request.put("employee_name", employee_name);
		request.put("employee_salary", Salary);
		request.put("employee_age", Age);

		baseURI = "https://dummy.restapiexample.com/api/v1/";

	given().
	        contentType(ContentType.JSON).accept(ContentType.JSON).header("contentType", "new employee")
				.body(request.toJSONString()).
	when().
	      post("/create").
	then(). 
	      statusCode(200).log().all();

	}

	@DataProvider(name = "Delete Data")
	public Object[] datafordelete() {

		return new Object[] {

				4, 5, 6, 7

		};

	}

	@Test(priority = 2, dataProvider = "Delete Data")
	public void TCdelete(int id) {

		baseURI = "https://dummy.restapiexample.com/api/v1/";

		when().
		       delete("/delete/2" + id).
	    then().
	           statusCode(200).log().all();

	}

//	@Parameters({ "id" })
//	@Test(priority = 3)
//	public void TCdeletebysuite(int id) {
//
//		baseURI = "https://dummy.restapiexample.com/api/v1/";
//
//		when().
//		       delete("/delete/2" + id).
//		then().
//		       statusCode(200).log().all();
//
//	}
}
