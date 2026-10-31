package base_utility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;

import object_repository.LoginPage;
import object_repository.LogoutPage;

public class BaseClass {

	static public WebDriver driver;
	static public WebDriver sdriver;

	@BeforeClass
	public void setup() throws IOException, ParseException {
		String browser = FileUtility.getDataFromJsonFile("bro").toString();

		if (browser.contentEquals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
	sdriver=driver;

		String url = FileUtility.getDataFromJsonFile("url").toString();
		driver.navigate().to(url);

	}

	@BeforeMethod
	public void login() throws IOException, ParseException {

		String uname = FileUtility.getDataFromJsonFile("un").toString();
		String psword = FileUtility.getDataFromJsonFile("pwd").toString();

		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(uname);
		lp.getPassword().sendKeys(psword + Keys.ENTER);

	}

	@AfterMethod
	public void logout() {
		LogoutPage lp = new LogoutPage(driver);
		Actions act = new Actions(driver);
		act.moveToElement(lp.getProfileBar()).build().perform();

		lp.getSignOut().click();

	}

	@AfterClass
	public void teardown() {
		
		driver.quit();

	}

}
