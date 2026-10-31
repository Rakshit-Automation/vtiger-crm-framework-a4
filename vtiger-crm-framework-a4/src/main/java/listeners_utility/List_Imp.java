package listeners_utility;

import base_utility.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class List_Imp implements ITestListener {

	public ExtentReports report;

	

	@Override
	public void onStart(ITestContext context) {
		String time = JavaUtility.getCurrentDateTime();

//		configure report
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/" + time + ".html");
		spark.config().setDocumentTitle("dummy title");
		spark.config().setReportName("dummy name");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("OS", "MAC");
		report.setSystemInfo("TESTER", "Rakshit");
		report.setSystemInfo("suite", "smoke");
		report.setSystemInfo("mode", "group");
	}

	public void onTestSuccess(ITestResult result) {

		String method = result.getName();
		ExtentTest test = report.createTest(method);
		test.log(Status.PASS, "This is pass");

	}

	public void onTestFailure(ITestResult result) {
		WebDriver sdriver=BaseClass.driver;
		String method = result.getName();
		ExtentTest test = report.createTest(method);

		TakesScreenshot tks = (TakesScreenshot) sdriver;
		
	String screenshot=	tks.getScreenshotAs(OutputType.BASE64);
	
	test.addScreenCaptureFromBase64String(
		    screenshot, "Failure Screenshot");

		test.log(Status.FAIL, "This is fail");
	}

	public void onTestSkipped(ITestResult result) {
		String method = result.getName();

		ExtentTest test = report.createTest(method);
		test.log(Status.SKIP, " This is Skipped");

	}

	@Override
	public void onFinish(ITestContext context) {

		report.flush();

	}

}
