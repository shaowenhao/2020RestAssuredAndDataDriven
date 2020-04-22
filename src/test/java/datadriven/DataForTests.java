package datadriven;

import org.testng.annotations.DataProvider;

public class DataForTests {

	 //更进一步 结合  apache poi excel 读取excel 数据
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost(){
		Object[][] data = new Object[2][3];
		data[0][0] = "Albert";
		data[0][1] = "Einstein";
		data[0][2] = 4;
		
		data[1][0] = "Ryan";
		data[1][1] = "wenhao";
		data[1][2] = 5;
		
		return data;
	}
	
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {
		return new Object[] {
		 4,5	
		};
	}
	
}
