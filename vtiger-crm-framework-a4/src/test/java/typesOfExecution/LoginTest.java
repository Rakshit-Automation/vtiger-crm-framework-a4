package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {
	
	;

	//(groups="Important")
	
	@Test
	public void createLogin() throws InterruptedException {
		WebDriver driver1=new ChromeDriver();
			Reporter.log(Thread.currentThread().getName() + "createLogin()");
		//	Thread.sleep(3000);
			driver1.quit();
	}

	@Test
	public void modifyLogin() throws InterruptedException {
		WebDriver driver2=new ChromeDriver();
		Reporter.log(Thread.currentThread().getName() + "modifyLogin()");
	//	Thread.sleep(3000);
		driver2.quit();
	}
    
	@Test(groups="Important")
	public void deleteLogin() throws InterruptedException {
	
		WebDriver driver3=new ChromeDriver();
		Reporter.log(Thread.currentThread().getName() + "deleteLogin()");
	//	Thread.sleep(3000);
		driver3.quit();
	}
	
}
