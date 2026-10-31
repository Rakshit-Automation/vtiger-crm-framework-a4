package ddt_Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	
	public static void main(String[] args) throws IOException {
		//1.Create a java representation object of physical file(Properties file)
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		
		//2.load(), to load all data
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//3. getProperty("Key"),get the value
		String browser=pObj.getProperty("bro");
		String url=pObj.getProperty("url");
		String username=pObj.getProperty("un");
		String password=pObj.getProperty("pwd");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
		
		
		
		
		
		
		
	}

}
