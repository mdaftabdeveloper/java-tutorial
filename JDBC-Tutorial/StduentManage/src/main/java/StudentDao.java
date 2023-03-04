import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	

	public static boolean insertStudentToDB(Student st) {
		
		boolean f = false;
		 
		//jdbc code...
		try {
			
			Connection con = CP.createC();
			
			String q = "insert into students(roll, name, email, marks) values(?,?,?,?)";
			//prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the values of parameter
			 pstmt.setInt(1, st.getRoll());
			 pstmt.setString(2, st.getName());
			 pstmt.setString(3, st.getEmail());
			 pstmt.setFloat(4, st.getMarks());
			 
			 //execute
			 pstmt.executeUpdate();
			 
			 f = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int roll) {
		// TODO Auto-generated method stub

		
		boolean f = false;
		 
		//jdbc code...
		try {
			
			Connection con = CP.createC();
			
			String q = "delete from students where roll=?";
			//prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the values of parameter
			 pstmt.setInt(1, roll);
			
			 //execute
			 pstmt.executeUpdate();
			 
			 f = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	
		
	}

	public static boolean showAllStudent() {
		// TODO Auto-generated method stub

		
		boolean f = false;
		 
		//jdbc code...
		try {
			
			Connection con = CP.createC();
			
			String q = "select * from students";
			//prepared statement
			 Statement stmt = con.createStatement();
			 stmt.executeQuery(q);
			 ResultSet set = stmt.executeQuery(q);
			 
			 while(set.next()) {
				 int roll = set.getInt(1);
				 String name = set.getString(2);
				 String email = set.getString(3);
				 float marks = set.getFloat(4);
				 
				 System.out.println("Roll: "+ roll);
				 System.out.println("Name: " + name);
				 System.out.println("Email: " + email);
				 System.out.println("Marks: " + marks);
				 
				 System.out.println("------------------------------------");
			 }
			 
			 f = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	
	}

}
