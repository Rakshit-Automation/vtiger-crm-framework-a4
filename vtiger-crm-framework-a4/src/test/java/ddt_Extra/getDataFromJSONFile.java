package ddt_Extra;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class getDataFromJSONFile {
	
	public static void main(String[] args) throws IOException, ParseException {
		//Simple json is the Library that supports JSON file related operations
		//1.Create java representation object of CommonData file
		FileReader fr=new FileReader("./src/test/resources/CommonData.json");
		//2.Parse the JRO into the Object class
		JSONParser jpObj=new JSONParser();
		Object obj=jpObj.parse(fr);
		//3.DOWNCAST to JSONobject to access the get("").toString();
		JSONObject joObj= (JSONObject) obj;
		
		//4.user get("Key")> to get value//use to get("Key").toString()>TO PRINT VALUE
		String username=joObj.get("un").toString();
		String password=joObj.get("pwd").toString();
		String url=joObj.get("url").toString();
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
			
		
	}

}
