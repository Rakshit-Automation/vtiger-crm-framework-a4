package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LogoutTest {
	//WebDriver driver;

	//(groups="Important")
	@Test
	public void createLogout() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(Thread.currentThread().getName() + "createLogout");
		//Thread.sleep(3000);
		driver.quit();
	}

	@Test(groups="Important")
	public void modifyLogout() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(Thread.currentThread().getName() + "modifyLogout()");
	//	Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void deleteLogout() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(Thread.currentThread().getName() + "deleteLogout() ");
	//	Thread.sleep(3000);
		driver.quit();
	}
	
	

}
