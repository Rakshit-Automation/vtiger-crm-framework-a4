package ddt_Extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getDataFromExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//1.Create a java representational Object of Excel File
		FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		//2.WorkBookFactory
		Workbook wb=WorkbookFactory.create(fis);
		//getSheet()>Sheet(I)>getRow()>
		String lname=wb.getSheet("TestScriptData").getRow(0).getCell(1).getStringCellValue();
		
		//wb.getSheet("")
		
		
		String dob=wb.getSheet("TestScriptData").getRow(1).getCell(1).getStringCellValue();
		
		String assistant=wb.getSheet("TestScriptData").getRow(2).getCell(1).getStringCellValue();
		
		String email=wb.getSheet("TestScriptData").getRow(3).getCell(1).getStringCellValue();
		
		System.out.println(lname);
		System.out.println(dob);
		System.out.println(assistant);
		System.out.println(email);
		wb.close();
	
	}

}
