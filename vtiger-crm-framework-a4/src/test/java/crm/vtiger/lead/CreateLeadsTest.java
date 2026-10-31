package crm.vtiger.lead;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import junit.framework.Assert;
import object_repository.CreateNewLead;
import object_repository.LeadVerificationPage;
import object_repository.LoginPage;

public class CreateLeadsTest extends BaseClass {
	@Test
	public  void createLeadMethod() throws InterruptedException, IOException, ParseException {
//	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		/************************* getting common Data *************************/
	//	String uname = FileUtility.getDataFromJsonFile("un");
	//	String psword = FileUtility.getDataFromJsonFile("pwd");
	//	String url = FileUtility.getDataFromJsonFile("url");

		/************************* How to get Test Script Data ****************** */
		// firstName
		String firstName = FileUtility.getDataFromExcelFile("lead", 1, 0);
		// lastName
		String lastName = FileUtility.getDataFromExcelFile("lead", 1, 1);
		// company
		String company = FileUtility.getDataFromExcelFile("lead", 1, 2);
		// title
		String title = FileUtility.getDataFromExcelFile("lead", 1, 3);
		// leadSource
		String leadSource = FileUtility.getDataFromExcelFile("lead", 1, 4);
		// industry
		String industry = FileUtility.getDataFromExcelFile("lead", 1, 5);
		// annualRevenue
		String annualRevenue = FileUtility.getDataFromExcelFile("lead", 1, 6);
		// noOfEmployees
		String employees = FileUtility.getDataFromExcelFile("lead", 1, 7);
		// emailID
		String emailID = FileUtility.getDataFromExcelFile("lead", 1, 8);
		// phone
		String phone = FileUtility.getDataFromExcelFile("lead", 1, 9);
		// mobile
		String mobile = FileUtility.getDataFromExcelFile("lead", 1, 10);
		// website
		String website = FileUtility.getDataFromExcelFile("lead", 1, 11);
/*
// open the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
*/
/*		
// Login
		driver.get(url);
		// WebElement username = driver.findElement(By.name("user_name"));
		// WebElement password = driver.findElement(By.name("user_password"));
		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUsername();
		driver.navigate().refresh();
		WebElement password = lp.getPassword();

		username.sendKeys(uname);
		password.sendKeys(psword + Keys.ENTER);
*/
		
		
		/*
		 * // Filling Form //firstName //WebElement firstNameField =
		 * driver.findElement(By.name("firstname"));
		 * //firstNameField.sendKeys(firstName); //lastName //WebElement lastNameField =
		 * driver.findElement(By.name("lastname")); //lastNameField.sendKeys(lastName);
		 * //company //WebElement companyField = driver.findElement(By.name("company"));
		 * //companyField.sendKeys(company); //title //WebElement titleField =
		 * driver.findElement(By.name("designation")); //titleField.sendKeys(title);
		 * //leadSource // WebElement leadSourceDD =
		 * driver.findElement(By.name("leadsource")); //Select leadSourceSel = new
		 * Select(leadSourceDD); //leadSourceSel.selectByValue(leadSource); //industry
		 * //WebElement industryDD = driver.findElement(By.name("industry")); //Select
		 * industrySel = new Select(industryDD); // industrySel.selectByValue(industry);
		 * //annualRevenue (the field is pre-filled with 0, so clear it first) //
		 * WebElement revenueField = driver.findElement(By.name("annualrevenue"));
		 * //revenueField.clear(); // revenueField.sendKeys(annualRevenue);
		 * //noOfEmployees // WebElement employeesField =
		 * driver.findElement(By.name("noofemployees")); //
		 * employeesField.sendKeys(employees); //emailID // WebElement email =
		 * driver.findElement(By.id("email")); // email.sendKeys(emailID); //phone //
		 * WebElement phoneField = driver.findElement(By.id("phone")); //
		 * phoneField.sendKeys(phone); //mobile // WebElement mobileField =
		 * driver.findElement(By.id("mobile")); // mobileField.sendKeys(mobile);
		 * //website / WebElement websiteField = driver.findElement(By.name("website"));
		 * 
		 * websiteField.sendKeys(website);
		 * 
		 * // Create lead driver.findElement(By.linkText("Leads")).click();
		 * driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		 */
		/*
		 * =================================================== Using POM ->
		 * CreateNewLead class ==================================================
		 */
//===================================================================================
		CreateNewLead lead = new CreateNewLead(driver);

		lead.leadSection.click();
		lead.plusicon.click();
		lead.firstNameField.sendKeys(firstName);
		lead.lastNameField.sendKeys(lastName);
		lead.companyField.sendKeys(company);
		lead.titleField.sendKeys(title);

		new Select(lead.leadSourceDD).selectByValue(leadSource);
		new Select(lead.industryDD).selectByValue(industry);

		lead.revenueField.clear();
		lead.revenueField.sendKeys(annualRevenue);

		lead.employeesField.sendKeys(employees);
		lead.emailField.sendKeys(emailID);
		lead.phoneField.sendKeys(phone);
		lead.mobileField.sendKeys(mobile);
		lead.websiteField.sendKeys(website);
		// Save
		// driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		LeadVerificationPage lvp = new LeadVerificationPage(driver);
		lvp.save.click();


		/*// Verification (compare the page against the data entered from Excel)
		 * 
		 * String actFirstName =driver.findElement(By.id("dtlview_First Name")).getText(); String actLastName
		 * = driver.findElement(By.id("dtlview_Last Name")).getText(); String actCompany
		 * = driver.findElement(By.id("dtlview_Company")).getText(); String actIndustry
		 * = driver.findElement(By.id("dtlview_Industry")).getText(); String actPhone =
		 * driver.findElement(By.id("dtlview_Phone")).getText();
		 */
		String actFirstName = lvp.firstName.getText();
		String actLastName = lvp.lastName.getText();
		String actCompany = lvp.company.getText();
		String actIndustry = lvp.industry.getText();
		String actPhone = lvp.phone.getText();

		List<String> fieldNames = List.of("First Name", "Last Name", "Company", "Industry", "Phone");
		List<String> realInput = List.of(firstName, lastName, company, industry, phone);
		List<String> actResult = List.of(actFirstName, actLastName, actCompany, actIndustry, actPhone);

		for (int i = 0; i < actResult.size(); i++) {

			Assert.assertEquals(actResult.get(i), (realInput.get(i)));
			Reporter.log("Lead Successfully created !!! " + fieldNames.get(i) + " = " + realInput.get(i));

		//	Assert.assertFalse(false);
		//	Reporter.log("Failed..... " + fieldNames.get(i) + " expected: " + realInput.get(i) + " but found: "
			//		+ actResult.get(i));
		}
//============================================================================
// logout
	/*	WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
// close the browser
		Thread.sleep(10000);
		driver.quit();
		*/
	}
}