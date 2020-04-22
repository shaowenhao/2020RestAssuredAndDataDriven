import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.sun.javafx.beans.IDProperty;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Test03_POST {
    
	
	@Test(enabled = false)
	public void test1_post() {
		
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("name", "Raghav");
	 map.put("job", "Teacher");
	 
	 System.out.println(map);
	 
	 JSONObject request = new JSONObject(map);
	 System.out.println(request);
	 
	 // request 能直接 put(key,value) 效果同上 都不需要Map
	 
	 given().
	   header("Content-Type","application/json").
	   contentType(ContentType.JSON).
	   body(request.toJSONString()).
	    when().post("https://reqres.in/api/users").then()
	    .statusCode(201);
	    
	}
	
	@Test
	public void test2_put() {
		
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("name", "Raghav");
		 map.put("job", "Teacher");
		 
		 System.out.println(map);
		 
		 JSONObject request = new JSONObject(map);
		 System.out.println(request);
		 
		 // request 能直接 put(key,value) 效果同上 都不需要Map
		 
		 given().
		   header("Content-Type","application/json").
		   contentType(ContentType.JSON).
		   body(request.toJSONString()).
		    when().post("https://reqres.in/api/users/2").then()
		    .statusCode(200).log().all();
		    
		}
		
	@Test
	public void test3_delete() {
		
		 
		 // request 能直接 put(key,value) 效果同上 都不需要Map
		 
		 given().
		    when().delete("https://reqres.in/api/users/2").then()
		    .statusCode(204).log().all();
		    
		}
	
}
