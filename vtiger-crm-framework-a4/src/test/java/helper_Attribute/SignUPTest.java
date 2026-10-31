package helper_Attribute;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SignUPTest {
	
	@Parameters({"un","pwd"})
	@Test(groups="Important")
	public void createSignUp(String userName,String password) {
		
		System.out.println(userName);
		System.out.println(password);
		
		System.out.println("createSignUp()");
	}

	@Test
	public void modifySignup() {
		System.out.println("modifySignup");
	}

	@Test
	public void deleteSignUp() {
		System.out.println("deleteSignUp()");
	}

}
