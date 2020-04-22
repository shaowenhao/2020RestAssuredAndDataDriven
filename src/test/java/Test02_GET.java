import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test02_GET {
     
	//given(). 后面 get()前面 这里可以加
	// .header("key","value")  .param(parameterName,parameteerValue)
	@Test
	public void test_1() {
		given().
		   get("https://reqres.in/api/users?page=2").
		   then().
		    statusCode(200).
		    body("data.id[1]", equalTo(8)).
		    body("data.first_name", hasItems("Michael","Lindsay","Tobias","Byron","George","Rachel")).
		    log().all();
	}
}
