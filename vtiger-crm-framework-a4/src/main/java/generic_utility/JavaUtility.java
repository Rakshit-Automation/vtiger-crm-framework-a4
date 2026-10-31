package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Java Utility is one class in generic component, which contain java specific methods
   which can be used across the test Scripts / Application
 its contains several generic reusable methods like
 getRandomNum() : it’s used to generate random number for every invocation
 getSystemDate() : it’s used to generate system date and time
 * 
 */

public class JavaUtility {
	public static int generateRandomNumber() {
		double ranDouble = Math.random();
		double random = ranDouble * 10000;
		int ran = (int) random;
		
		return ran;
		
	}
public static String	getCurrentDateTime() {
	
	
	
	String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss_ddMMMyyyy"));
	return date;
}





}

