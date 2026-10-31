package learning_advanceReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreatingReport1 {
	@Test
	public static void Task1(String methodname) {
		
		//1. Doing Configuration
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/task1.html");
		
		spark.config().setDocumentTitle("DocumentTitile1");
		spark.config().setReportName("Report 1");
		spark.config().setTheme(Theme.STANDARD);  //setting theme
		
		
		ExtentReports report=new ExtentReports();
		
		report.attachReporter(spark);
		
		report.setSystemInfo("Desktop"," Dell");
		report.setSystemInfo("Test Engineer", "Rakshit");
		report.setSystemInfo("Sprint","1");
		//generate
	ExtentTest test=	report.createTest(methodname);
	test.log(Status.FAIL, "This is failed");
	test.log(Status.PASS, "This is pass");
	test.log(Status.SKIP,"This is skipped");
		
	
	report.flush();
	
	
	
	
		}
	
	
	

}
