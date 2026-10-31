package helper_Attribute;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

	//(groups="Important")
	//(priority=1)
	//(dependsOnMethods="modifyLogin")
	//(dependsOnMethods={"modifyLogin","deleteLogin"})
	//(enabled=false)
	//(alwaysRun=true)
	//(invocationCount=3)
	//(invocationCount=4,threadPoolSize=3)
	
	
	@Test(dependsOnMethods={"modifyLogin","deleteLogin"})
	public void createLogin() {
			System.out.println("createLogin()");
			// System.out.println(
			//	        "Method: " + Thread.currentThread().getName()
			//	    );
	}

	@Test
	public void modifyLogin() throws InterruptedException {
		
	WebDriver driver=	new ChromeDriver();
		System.out.println("modifyLogin()");
	//	Assert.assertFalse(true);
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void deleteLogin() {
		System.out.println("deleteLogin()");
		Assert.assertFalse(true);
	}

}
