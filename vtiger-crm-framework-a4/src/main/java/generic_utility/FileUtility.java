package generic_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {

	public static String getDataFromJsonFile(String key) throws IOException, ParseException {
		
		FileReader fr=new FileReader("./src/test/resources/CommonData.json");
		JSONParser jpObj=new JSONParser();
		Object obj=jpObj.parse(fr);
		JSONObject jObj=(JSONObject) obj;
		String data =jObj.get(key).toString();
		return data;

	}
	
public static String getDataFromJsonFile(String key,String path) throws IOException, ParseException {
		
		FileReader fr=new FileReader(path);
		JSONParser jpObj=new JSONParser();
		Object obj=jpObj.parse(fr);
		JSONObject jObj=(JSONObject) obj;
		String data =jObj.get(key).toString();
		return data;
	}

public static String getDataFromExcelFile(String sheetName,int rowNumber,int cellPosition) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptDataTestData.xlsx");
	
	
	Workbook wb=WorkbookFactory.create(fis);
	
	Sheet sh=wb.getSheet(sheetName);
	
	Row row=sh.getRow(rowNumber);
	
	Cell cell=row.getCell(cellPosition);
	
	String data=cell.getStringCellValue();
	
	return data;
	
}



	
	
	
	
	
	
	
	
	
	
}
