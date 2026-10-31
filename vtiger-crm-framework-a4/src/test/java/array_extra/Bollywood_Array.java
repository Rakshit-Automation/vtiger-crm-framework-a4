package array_extra;

public class Bollywood_Array {
	
	public static void main(String[] args) {
		String[][] couples = new String[4][2];

		couples[0][0] = "Kareena";
		couples[0][1] = "Shahid";

		couples[1][0] = "Ranbir";
		couples[1][1] = "Deepika";

		couples[2][0] = "Salman";
		couples[2][1] = "Aishwarya";

		couples[3][0] = "Akshay";
		couples[3][1] = "Raveena";
		
		for(String[] couple:couples) {
			
			System.out.println(couple[0]+" "+couple[1]);
			
		}
	}

}
