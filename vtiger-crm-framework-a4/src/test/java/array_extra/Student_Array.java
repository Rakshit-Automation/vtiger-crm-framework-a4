package array_extra;

public class Student_Array {
		public static void main(String[] args) {
			String[][] students = new String[3][2];

			students[0][0] = "Rahul";
			students[0][1] = "Sharma";

			students[1][0] = "Amit";
			students[1][1] = "Verma";

			students[2][0] = "Priya";
			students[2][1] = "Singh";

			// Print using for-each
			for (String[] student : students) {
			    System.out.println("First Name: " + student[0]
			            + ", Last Name: " + student[1]);
			}
		}
}
