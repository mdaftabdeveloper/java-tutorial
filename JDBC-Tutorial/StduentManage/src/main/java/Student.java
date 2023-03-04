
public class Student {

	
		// TODO Auto-generated constructor stub
		private int roll;
		private String name;
		private String email;
		private float marks;
		public Student(int roll, String name, String email, float marks) {
			super();
			this.roll = roll;
			this.name = name;
			this.email = email;
			this.marks = marks;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getRoll() {
			return roll;
		}
		public void setRoll(int roll) {
			this.roll = roll;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public float getMarks() {
			return marks;
		}
		public void setMarks(float marks) {
			this.marks = marks;
		}
		@Override
		public String toString() {
			return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", marks=" + marks + "]";
		}
	

}                                
