package crm.vtiger.opportunities;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/*
 * ==================
 * UNDER MODIFICATION
 * ===================
 */
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;

public class CreateOpportunitiesTest {
	// public static void main(String[] args) throws InterruptedException,
	// IOException, ParseException {

	@Test
	public static void createOrganization() throws InterruptedException, IOException, ParseException {

		/************************* getting common Data *************************/
		String uname = FileUtility.getDataFromJsonFile("un");
		String psword = FileUtility.getDataFromJsonFile("pwd");
		String url = FileUtility.getDataFromJsonFile("url");

		/************************* How to get Test Script Data ****************** */
		// orgName (the sheet value ends with "_", so a random number is appended)
		String orgName = FileUtility.getDataFromExcelFile("org", 1, 0) + JavaUtility.generateRandomNumber();
		// website
		String website = FileUtility.getDataFromExcelFile("org", 1, 1);
		// tickerSymbol
		String tickerSymbol = FileUtility.getDataFromExcelFile("org", 1, 2);
		// employees
		String employees = FileUtility.getDataFromExcelFile("org", 1, 4);
		// emailID
		String emailID = FileUtility.getDataFromExcelFile("org", 1, 5);
		// industry
		String industry = FileUtility.getDataFromExcelFile("org", 1, 7);
		// type
		String type = FileUtility.getDataFromExcelFile("org", 1, 8);
		// phone
		String phone = FileUtility.getDataFromExcelFile("org", 1, 11);

// open the browser
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wdu=new WebDriverUtility(driver);
		wdu.maximizeWindow();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
// Login
		driver.get(url);
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		username.sendKeys(uname);
		password.sendKeys(psword + Keys.ENTER);
// Create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
// Filling Form

//Opportunities
		
		
//website
		WebElement websiteField = driver.findElement(By.name("website"));
		websiteField.sendKeys(website);
//tickerSymbol
		WebElement tickerField = driver.findElement(By.name("tickersymbol"));
		tickerField.sendKeys(tickerSymbol);
//employees
		WebElement employeesField = driver.findElement(By.name("employees"));
		employeesField.sendKeys(employees);
//emailID
		WebElement email = driver.findElement(By.name("email1"));
		email.sendKeys(emailID);
//industry
		WebElement industryDD = driver.findElement(By.name("industry"));
		Select industrySel = new Select(industryDD);
		industrySel.selectByValue(industry);
//type
		WebElement typeDD = driver.findElement(By.name("accounttype"));
		Select typeSel = new Select(typeDD);
		typeSel.selectByValue(type);
//phone
		WebElement phoneField = driver.findElement(By.id("phone"));
		phoneField.sendKeys(phone);
// Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

// Verification (compare the page against the data entered from Excel)
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();

		List<String> fieldNames = List.of("Organization Name", "Industry", "Type", "Phone");
		List<String> realInput = List.of(orgName, industry, type, phone);
		List<String> actResult = List.of(actOrgName, actIndustry, actType, actPhone);

		for (int i = 0; i < actResult.size(); i++) {

			if (actResult.get(i).equals(realInput.get(i))) {
				System.out.println(
						"Organization Successfully created !!! " + fieldNames.get(i) + " = " + realInput.get(i));

			} else {
				System.out.println("Failed..... " + fieldNames.get(i) + " expected: " + realInput.get(i)
						+ " but found: " + actResult.get(i));
			}
		}

// logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
// close the browser
		Thread.sleep(10000);
		driver.quit();
	}
}
