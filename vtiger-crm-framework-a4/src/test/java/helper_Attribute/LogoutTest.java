package helper_Attribute;

import org.testng.annotations.Test;
//(groups="Important")
//(priority=1)
//(dependsOnMethods="modifyLogin")
//(dependsOnMethods={"modifyLogin","deleteLogin"})
//(enabled=false)
//(alwaysRun=true)
//(invocationCount=3)
//(invocationCount=4,threadPoolSize=3)

public class LogoutTest {

	//(groups="Important")
	@Test
	public void createLogout() {
		System.out.println("createLogout");
	}

	@Test(groups="Important")
	public void modifyLogout() {
		System.out.println("modifyLogout()");
	}

	@Test
	public void deleteLogout() {
		System.out.println("deleteLogout() ");
	}

}
