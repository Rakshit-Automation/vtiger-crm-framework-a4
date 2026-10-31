package array_extra;

public class credentials {
	
public static void main(String[] args) {
	String[][] credentials = new String[3][2];

	credentials[0][0] = "user1";
	credentials[0][1] = "pass1";

	credentials[1][0] = "user2";
	credentials[1][1] = "pass2";

	credentials[2][0] = "user3";
	credentials[2][1] = "pass3";
	
	for (String[] user : credentials) {

	    // Inner loop gets each value in that row
	    for (String value : user) {
	        System.out.print(value + " ");
	    }

	    System.out.println();
	}
	
	//System.out.println(credentials);
}

}
