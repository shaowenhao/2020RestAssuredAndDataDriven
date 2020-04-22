import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Json_Server_Examples {
	// @Test
	public void test_get() {
		baseURI = "http://localhost:3000";
		// given().when().get("/users").then().statusCode(200)
		// .log().all();

		// 只会返回/subjects?name=Automation
		given().param("name", "Automation").get("/subjects").then().statusCode(200).log().all();
		// http://localhost:3000/subjects/1/users 返回user含有 subjectId=1的信息

	}

	//@Test
	public void test_post() {
		baseURI = "http://localhost:3000";

		JSONObject jsonObject = new JSONObject();
		// jsonObject.put("id", 4); id will increase automatically
		jsonObject.put("name", "APITest");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(jsonObject.toJSONString()).when().post("/subjects").
				then().statusCode(201).log().all();
	}
	

	//@Test
	public void test_patch() {
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		// jsonObject.put("id", 4); id will increase automatically
		request.put("name", "APITest-updated-by-patch");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).when().patch("/subjects/4").
				then().statusCode(200).log().all();
	}
	
	//@Test
	public void test_put() {
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		// jsonObject.put("id", 4); id will increase automatically
		request.put("name", "APITest-updated-by-put");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).when().put("/subjects/4").
				then().statusCode(200).log().all();
	}
	
	@Test
	public void test_delete() {
		baseURI = "http://localhost:3000";
		
		given().when().delete("/subjects/4").
				then().statusCode(200).log().all();
	}
	
}

// db.json which used to test on local json server
// {
// "users": [
//
// { "firstName" : "ryan",
// "lastName" : "wenshao",
// "subjectId" : 1,
// "id" : 1
// },
//
// { "firstName" : "du",
// "lastName" : "xiaodan",
// "subjectId" : 2,
// "id" : 2
// },
//
// { "firstName" : "shao",
// "lastName" : "xiaobao",
// "subjectId" : 3,
// "id" : 3
// }
// ],
// "subjects" : [
// {
// "id" : 1,
// "name" : "Automation"
// },
//
// {
// "id" : 2,
// "name" : "Java"
// },
//
// {
// "id" : 3,
// "name" : "Bigddata"
// }
// ]
//
// }