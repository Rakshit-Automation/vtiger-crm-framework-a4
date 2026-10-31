package listeners_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry_Imp implements IRetryAnalyzer {
	int retry_count=0;
//	int final_retry=3;
	@Override
	public boolean retry(ITestResult result) {
		 
		if(retry_count<3) {
			
			retry_count++;
			return true;
		}
		
		
		
		return false;
	}

	
	
	
	
}
