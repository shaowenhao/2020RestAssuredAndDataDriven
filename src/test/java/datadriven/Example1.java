package datadriven;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.*;

import io.restassured.http.ContentType;

public class Example1 extends DataForTests {
	// In excel sheet create columns : firstName, lastName, subjectId with two rows data
	 
	// 更好的做法是 不写死在DataForTests类 实现
	// @DataProvider(name = "DataForPost")
//	public Object[][] dataForPost(){
//		Object[][] data = new Object[2][3];
//		data[0][0] = "Albert";
//		data[0][1] = "Einstein";
//		data[0][2] = 4;
//		
//		data[1][0] = "Ryan";
//		data[1][1] = "wenhao";
//		data[1][2] = 5;
//		
//		return data;
//	}
	
//	@Test(dataProvider = "DataForPost")
		public void test_post(String firstName, String lastName, int subjectId) {
			baseURI = "http://localhost:3000";

			JSONObject request = new JSONObject();
			request.put("firstName", firstName);
			request.put("lastName", lastName);
			request.put("subjectId", subjectId);
			// jsonObject.put("id", 4); id will increase automatically
			//request.put("name", "APITest");
			given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
					.body(request.toJSONString()).when().post("/users").
					then().statusCode(201).log().all();
		}
	
//	@DataProvider(name = "DeleteData")
//	public Object[] dataForDelete() {
//		return new Object[] {
//		 4,5	
//		};
//	}
	
//	如果post执行了可以用这个delete 
 @Test(dataProvider = "DeleteData")
	public void test_delete(int userId) {
		baseURI = "http://localhost:3000";
		
		given().when().delete("/users/"+userId).
				then().statusCode(200).log().all();
	}
	
	
}


//db.json which used to test on local json server
//{
//"users": [
//
//{ "firstName" : "ryan",
//"lastName" : "wenshao",
//"subjectId" : 1,
//"id" : 1
//},
//
//{ "firstName" : "du",
//"lastName" : "xiaodan",
//"subjectId" : 2,
//"id" : 2
//},
//
//{ "firstName" : "shao",
//"lastName" : "xiaobao",
//"subjectId" : 3,
//"id" : 3
//}
//],
//"subjects" : [
//{
//"id" : 1,
//"name" : "Automation"
//},
//
//{
//"id" : 2,
//"name" : "Java"
//},
//
//{
//"id" : 3,
//"name" : "Bigddata"
//}
//]
//
//}