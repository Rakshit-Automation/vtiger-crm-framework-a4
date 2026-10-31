package learning_advanceReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreatingReportDay2 {
	ExtentReports report;
	@BeforeSuite
	public void Config() {
		//ExtentSparkReporter spark = new ExtentSparkReporter("./reports/task1.html");

		// 1. Doing Configuration
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/task2Day2.html");

		spark.config().setDocumentTitle("DocumentTitile1");
		spark.config().setReportName("Report 1");
		spark.config().setTheme(Theme.STANDARD); // setting theme

		report = new ExtentReports();

		report.attachReporter(spark);

		report.setSystemInfo("Desktop", " Dell");
		report.setSystemInfo("Test Engineer", "Rakshit");
		report.setSystemInfo("Sprint", "1");
	}
@Test
	public void runningMethod1() {
		ExtentTest test = report.createTest("runningMethod1");
		
		test.log(Status.PASS, "This is pass");
	

	}
@Test
	public void runningMethod2() {
		ExtentTest test = report.createTest("runningMethod2");
		test.log(Status.FAIL, "This is pass");
	}
@Test
	public void runningMethod3() {
		ExtentTest test = report.createTest("runningMethod3");
		test.log(Status.SKIP, "This is skipped");
	}

	@AfterSuite
	public void backup() {
		 report.flush();
	}

}
