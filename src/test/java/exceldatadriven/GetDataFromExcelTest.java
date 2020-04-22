package exceldatadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetDataFromExcelTest {
   
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		GetDataFromExcel dataFromExcel = new GetDataFromExcel(excelPath, sheetName);
		
		int rowCount = dataFromExcel.getRowCount();
		int colCount = dataFromExcel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				   try {
					data[i-1][j] =dataFromExcel.getCellData(i,j);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
		
	}
	@DataProvider(name = "DataForPost")
	public Object[][] getData(){

		Object[][]	data = testData("/Users/ryshao/eclipse-workspace/RestAssuredProject/data/dataForPost.xlsx", "Sheet1");	
		return data;
	}
	
	@Test(dataProvider = "DataForPost")
	public void testPost(String firstName, String lastName, String subjectId) {
		baseURI = "http://localhost:3000";

		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).when().post("/users").
				then().statusCode(201).log().all();
	}
}
