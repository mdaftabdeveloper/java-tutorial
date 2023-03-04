import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Start {
	
	public static void main (String[] args) {

	
		System.out.println("Welcome to the Student Management System");
		
		while(true) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Students");
			System.out.println("Press 4 to EXIT the list");
			
			int c = 0;
			try {
				c = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (c==1) {
				//add student
				

				int roll = 0;
				String name = null;
				String email = null;
				float marks = 0;
				
				System.out.println("Enter Your Roll: ");
				try {
					roll = Integer.parseInt( br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Enter Your Name: ");
				try {
					name = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Enter Your Email");
				try {
					email = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Enter Your Marks");
				try {
					marks = Float.parseFloat(br.readLine());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//create student object to store student
				Student st = new Student(roll,name,email,marks);
				
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully....");
				}
				else {
					System.out.println("Something went wrong try again....");
				}
				System.out.println(st);
			}
			
			else if (c==2) {
				//delete student
				System.out.println("Enter the Roll of Student");
				try {
					int roll = Integer.parseInt(br.readLine());
					boolean f = StudentDao.deleteStudent(roll);
					
					if(f) {
						System.out.println("Deleted...");
					}
					else {
						System.out.println("Something went wrong");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (c==3) {
				//display student
				StudentDao.showAllStudent();
			}
			else if (c==4) {
				break;
				//exit
			}
			
			else {
				System.out.println("Please select Valid Option");
				
			}
			
		}
	
	
		System.out.println("THANK YOU");


}
}