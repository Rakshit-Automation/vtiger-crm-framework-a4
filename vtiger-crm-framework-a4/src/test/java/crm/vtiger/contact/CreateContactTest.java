package crm.vtiger.contact;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

import object_repository.CreatenewContact;
import object_repository.LoginPage;
import object_repository.LogoutPage;


@Listeners(listeners_utility.List_Imp.class)
public class CreateContactTest extends BaseClass {
	@Test
	public void createMethod() throws InterruptedException, IOException, ParseException {
		// public static void main(String[] args) throws InterruptedException,
		// IOException, ParseException {
		/************************* getting common Data *************************/
	//	String uname = FileUtility.getDataFromJsonFile("un");
	//	String psword = FileUtility.getDataFromJsonFile("pwd");
	//	String url = FileUtility.getDataFromJsonFile("url");

		/************************* How to get Test Script Data ****************** */
		String lastName = FileUtility.getDataFromExcelFile("contact", 1, 1);

		// getting DOB
		String dob = FileUtility.getDataFromExcelFile("contact", 1, 12);
		// getting ofcPhone
		String ofcPhone = FileUtility.getDataFromExcelFile("contact", 1, 8);
		// getting assistant

		String assistant = FileUtility.getDataFromExcelFile("contact", 1, 7);

		// getiing emailID
		String emailID = FileUtility.getDataFromExcelFile("contact", 1, 6);
		// Getting FirstName
		String firstName = FileUtility.getDataFromExcelFile("contact", 1, 0);
		/*
		 * // open the browser WebDriver driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Login
		 * driver.get(url);
		 */
		// WebElement username = driver.findElement(By.name("user_name"));
		// WebElement password = driver.findElement(By.name("user_password"));
		// LoginPage lp=new LoginPage(driver);
//		WebElement username = lp.getUsername();
		// WebElement password = lp.getPassword();

		// username.sendKeys(uname);
		// password.sendKeys(psword + Keys.ENTER);
// Create contact
		// driver.findElement(By.linkText("Contacts")).click();
		// CreatenewContact cnc=new CreatenewContact(driver);
		// WebElement clickNewContact = cnc.contact;
		// clickNewContact.click();
		CreatenewContact cnc = new CreatenewContact(driver);

		// Open Contacts and the Create Contact form
		cnc.contact.click();
		cnc.plusicon.click();

		// Fill contact details
		new Select(cnc.salutationDD).selectByIndex(1);

		cnc.firstNameField.sendKeys(firstName);
		cnc.lastNameField.sendKeys(lastName);

		// Click the organization lookup icon
		String parentWindow = driver.getWindowHandle();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(cnc.organizationSelect)).click();

		// Wait for the organization popup window
		wait.until(d -> d.getWindowHandles().size() > 1);
		// driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
// Filling Form

//choose Salutation
		// WebElement salutationdd = driver.findElement(By.name("salutationtype"));
		/*
		 * WebElement salutationdd = driver.findElement(By.name("salutationtype"));
		 * WebDriverUtility wdu = new WebDriverUtility(driver); wdu.select(salutationdd,
		 * 1);
		 * 
		 * //firstName WebElement firstNameField =
		 * driver.findElement(By.name("firstname")); firstNameField.sendKeys(firstName);
		 * //lastName String lastName = lastname; WebElement lastNameField =
		 * driver.findElement(By.name("lastname")); lastNameField.sendKeys(lastName);
		 * //choosing orgname String pid = driver.getWindowHandle(); WebDriverWait wait
		 * = new WebDriverWait(driver, Duration.ofSeconds(15)); WebElement orgAdd =
		 * wait.until( ExpectedConditions.elementToBeClickable(By.
		 * xpath("(//*[local-name()='img' and @alt='Select'])[1]"))); orgAdd.click();
		 * Set<String> cid = driver.getWindowHandles(); // cid.remove(pid); /*
		 * cid.stream().filter(n -> (!n.equals(pid))).forEach(n -> {
		 * driver.switchTo().window(n); System.out.println((driver.findElement(By.xpath(
		 * ("//a[text()='vtigerCRM Inc']")))).isDisplayed());
		 * 
		 * System.out.println((driver.findElement(By.xpath(
		 * ("//a[text()='vtigerCRM Inc']")))).isEnabled());
		 * System.out.println(driver.findElement(By.xpath(("//a[text()='vtigerCRM Inc']"
		 * ))).isSelected());
		 * driver.findElement(By.xpath(("//a[text()='vtigerCRM Inc']"))).click(); });
		 */

		/*
		 * for (String i : cid) { driver.switchTo().window(i);
		 * 
		 * if (!i.equals(pid)) { System.out.println((driver.findElement(By.xpath(
		 * ("//a[text()='vtigerCRM Inc']")))).isDisplayed());
		 * 
		 * System.out.println((driver.findElement(By.xpath(
		 * ("//a[text()='vtigerCRM Inc']")))).isEnabled());
		 * System.out.println(driver.findElement(By.xpath(("//a[text()='vtigerCRM Inc']"
		 * ))).isSelected());
		 * driver.findElement(By.xpath(("//a[text()='vtigerCRM Inc']"))).click(); }
		 * 
		 * }
		 * 
		 * driver.switchTo().window(pid);
		 * 
		 * // orgChoose.click();
		 */

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		// Select the organization
		wait.until(ExpectedConditions.elementToBeClickable(cnc.organizationOption)).click();

		// Return to the contact form
		driver.switchTo().window(parentWindow);

		// Continue filling the form
		cnc.birthdate.sendKeys(dob);
		cnc.assistantName.sendKeys(assistant);
		cnc.emailField.sendKeys(emailID);

		new Select(cnc.leadSourceDD).selectByIndex(2);

		cnc.officePhoneField.sendKeys(ofcPhone);

		// Save
		cnc.save.click();

		/*
		 * // birthdate WebElement birthdate =
		 * driver.findElement(By.cssSelector("input[name='birthday']"));
		 * birthdate.sendKeys(dob); //assistant WebElement assistantName =
		 * driver.findElement(By.id("assistant")); assistantName.sendKeys(assistant);
		 * //emailID // String emailID = "contact@gmail.com"; WebElement email =
		 * driver.findElement(By.id("email")); email.sendKeys(emailID); //LeadSource
		 * WebElement leadSourceDD = driver.findElement(By.name("leadsource")); Select
		 * leadSourceSel = new Select(leadSourceDD); leadSourceSel.selectByIndex(2);
		 * //office phone WebElement officePhoneField =
		 * driver.findElement(By.id("phone")); officePhoneField.sendKeys(ofcPhone +
		 * Keys.ENTER); //Save //
		 * driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		 */
		/*
		 * Handling Alert WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(15)); wait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * Alert alt = driver.switchTo().alert(); alt.accept();
		 */
//Verification
		Thread.sleep(4000);

		// List<String> actResult= new ArrayList<String>();

		// verifying firstName
		String actFirstName = driver.findElement(By.id("dtlview_First Name")).getText();
		// if (actFirstName.equals(firstName)) {
		// System.out.println("Contact successfully created");
		// } else {
		// System.out.println("Failed......");
		// }
		// verifying atlastname

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String actDob = driver.findElement(By.id("dtlview_Birthdate")).getText();

		// if (actLastName.equals(lastName)) {
		// System.out.println("Contact Successfully created !!!");
		// } else {
		// System.out.println("Failed.....");
		// }
		/*
		 * List<String> realInput = List.of(firstName, lastName,actDob); List<String>
		 * actResult = List.of(actFirstName, actLastName,actDob);
		 * 
		 * for (int i = 0; i < actResult.size(); i++) {
		 * 
		 * //if (actResult.get(i).equals(realInput.get(i)))
		 * Assert.assertEquals(actResult.get(i), realInput.get(i));
		 * Reporter.log("Contact Successfully created !!!"+ realInput.get(i) );
		 * 
		 * // else { //Reporter.log("Failed....."+i); //} }
		 */

		List<String> expected = List.of(firstName, lastName, dob);
		List<String> actual = List.of(actFirstName, actLastName, actDob);

		List<String> fields = List.of("First Name", "Last Name", "Birthdate");

		for (int i = 0; i < actual.size(); i++) {
			Assert.assertEquals(expected.get(i), actual.get(i), "Verification failed for " + fields.get(i));

			Reporter.log("Contact successfully created: " + fields.get(i) + " = " + actual.get(i), true);
		}
//logout
		// WebElement profile =
		// driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		LogoutPage lop = new LogoutPage(driver);
		// WebElement profile = lop.getProfileBar();
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();
		// driver.findElement(By.linkText("Sign Out")).click();
//		WebElement signOut = lop.getSignOut();
//		signOut.click();
// close the browser

		Thread.sleep(10000);

	}
}