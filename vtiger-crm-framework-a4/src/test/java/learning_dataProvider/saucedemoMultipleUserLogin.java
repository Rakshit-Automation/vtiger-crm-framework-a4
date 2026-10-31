package learning_dataProvider;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import learning_advanceReport.CreatingReport1;
public class saucedemoMultipleUserLogin {

	@Test(dataProvider="getloginCredentials",dataProviderClass = creating2Darray.class)
public void	loginPerforming(String username,String password) throws InterruptedException{
		
		
		
		
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
	driver.findElement(By.id("user-name")).sendKeys(username + Keys.END);
	driver.findElement(By.id("password")).sendKeys(password +Keys.ENTER);
	
	
	
	
	Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	CreatingReport1.Task1("loginPerforming");
	driver.quit();
	
	
    
	
		
		
		
	}
}
