package ExtraData;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/*
 * Leads sign in leads creation and signout
 * 
 * 
 */
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
@Listeners(listeners_utility.List_Imp.class)
public class Leads extends BaseClass {
  @Test(retryAnalyzer=listeners_utility.retry_Imp.class)  //calling listeners -> not listeners are only responsible for capturing @Test events.
	public  void createLeadinExtraDatq() throws InterruptedException {
	/*	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		Thread.sleep(5000);
*/
	//	driver.findElement(By.name("user_name")).sendKeys("admin");
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.TAB).sendKeys("manager").sendKeys(Keys.TAB).click(driver.findElement(By.id("submitButton")))
//				.perform();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();						
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[local-name()='img'and @title='Create Organization...'] ")).click();
		driver.findElement(By.name("accountname")).sendKeys("New ORG Noida");
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Assert.assertTrue(false);
//		WebElement adminIcon = driver.findElement(By.xpath("(//td[@class='small'])[1]//td[2]"));
//		WebElement signOut = driver.findElement(By.xpath("//a[text()='Sign Out']"));
//		act.moveToElement(adminIcon).pause(Duration.ofSeconds(5)).moveToElement(signOut).click()
//				.pause(Duration.ofSeconds(5)).perform();

//		Thread.sleep(5000);
		//driver.quit();

	}

}
