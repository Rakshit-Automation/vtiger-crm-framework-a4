package learning_dataProvider;

import org.testng.annotations.DataProvider;

public class creating2Darray {

	@DataProvider
	public String[][] getloginCredentials() {

		String[][] cred = new String[6][2];

		cred[0][0] = "standard_user";
		cred[0][1] = "secret_sauce";

		cred[1][0] = "locked_out_user";
		cred[1][1] = "secret_sauce";

		cred[2][0] = "problem_user";
        cred[2][1] = "secret_sauce";

		cred[3][0] = "performance_glitch_user";
		cred[3][1] = "secret_sauce";

		cred[4][0] = "error_user";
		cred[4][1] = "secret_sauce";

		cred[5][0] = "visual_user";
		cred[5][1] = "secret_sauce";
		
		
		return cred;

	}

}
