package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//(groups="Important")
//(priority=1)
//(dependsOnMethods="modifyLogin")
//(dependsOnMethods={"modifyLogin","deleteLogin"})
//(enabled=false)
//(alwaysRun=true)
//(invocationCount=3)
//(invocationCount=4,threadPoolSize=3)
public class SignUPTest {
	
	// WebDriver driver;
	// (groups="Important")
	@Test(groups = "Important")
	public void createSignUp() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(Thread.currentThread().getName() + "createSignUp()");
	//	Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void modifySignup() throws InterruptedException {
		WebDriver	driver=new ChromeDriver();
		System.out.println(Thread.currentThread().getName() + "modifySignup");
	//	Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void deleteSignUp() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(Thread.currentThread().getName() + "deleteSignUp()");
	//	Thread.sleep(3000);
		driver.quit();
	}
	
	

}
