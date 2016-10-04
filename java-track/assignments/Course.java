
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private int seats, credits;
	private List<Student> students = new ArrayList<Student>();
	
	public Course(String name, int credits, int seats) {
		this.name = name;
		this.seats = seats;
		this.credits = credits;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getSeats() {
		return this.seats;
	}
	
	public int getRemainingSeats() {
		return this.seats - students.size();
	}
	
	public boolean addStudent(Student newStudent) {
		if (students.size() < this.seats){
			students.add(newStudent);
			return true;
		}
		
		return false;
	}
	
	public String generateRoster() {
		StringBuffer roster = new StringBuffer();
		
		for (Student s: students) {
			roster.append(s.toString() + ", ");
		}

		return roster.toString();
	}
	
	public Double averageGPA() {
		double sumGPA = 0.0;
		
		for (Student s: students) {
			sumGPA += s.getGPA();
		}
		
		return sumGPA / students.size();
	}
	
	public String toString() {
		return String.format("%s %d", name, credits);
	}
	
//	public static void main(String[] args) {
//		Course c = new Course("cs101", 2, 4);
//		System.out.println(c.getRemainingSeats());
//	}
}