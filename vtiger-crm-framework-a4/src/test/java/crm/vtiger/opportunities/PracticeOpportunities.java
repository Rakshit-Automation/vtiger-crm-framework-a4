package crm.vtiger.opportunities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.WebDriverUtility;

public class PracticeOpportunities {

	@Test
	public void CreateOpportunities() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverUtility wdu = new WebDriverUtility(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wdu.maximizeWindow();

		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager" + Keys.ENTER);
		wdu.waitForElementClickable(driver.findElement(By.linkText("Opportunities")));
		driver.findElement(By.linkText("Opportunities")).click();
		
		
		// Thread.sleep(5000);

		driver.findElement(By.xpath("//*[name()='img' and @alt='Create Opportunity...']")).click();

		driver.findElement(By.name("potentialname")).sendKeys("BIG ONE");
		
		String pid=driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//*[name()='img' and @title='Select'])[1]")).click();
		Set<String> cid=driver.getWindowHandles();
		for(String w:cid) {
			//driver.switchTo().newWindow(w);
			if(!w.equals(pid)) {
				driver.switchTo().window(w);
			}
		}
		driver.findElement(By.linkText("New ORG Noida")).click();
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		Thread.sleep(5000);
		driver.quit();

	}

}
