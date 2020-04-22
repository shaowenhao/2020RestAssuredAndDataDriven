package exceldatadriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Create a class and function to get data from excel
public class GetDataFromExcel {

	 XSSFWorkbook workbook;
	 XSSFSheet sheet;

	
	public GetDataFromExcel(String excelPath, String sheetName){
		try {
			 workbook = new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  int getRowCount() {
	 	
	int	rowCount = sheet.getPhysicalNumberOfRows();
    return rowCount;
	}
	
	public  int getColCount() {
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}
	
	public  Object getCellData(int rowNum, int colNum) throws IOException {

	  DataFormatter formatter = new DataFormatter();
	  Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
	 // System.out.println(value);
	  return value;
	}
}
