
public class Student {

	private String firstName;
	private String lastName;
	private Integer studentId;
	private Integer credits = 0;
	private Double qualityScore = 0.0;
	
	public Student(String first, String last, int id){
		this.firstName = first;
		this.lastName = last;
		this.studentId = id;
	}
	
	public Student(String first, String last, int id, int credits, double quality){
		this.firstName = first;
		this.lastName = last;
		this.studentId = id;
		this.credits = credits;
		this.qualityScore = quality;
	}
	
	public String getName() {
		return String.format("%s %s", this.firstName, this.lastName);
	}
	
	public int getStudentID() {
		return this.studentId;
	}
	
	public void setStudentID(int studentID){
		this.studentId = studentID;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public void setCredits(int credits){
		this.credits = credits;
	}
	
	public double getGPA() {
		double GPA = this.qualityScore / this.credits;
		
		if (!(GPA >= 0)) {
			return 0.0;
		}
		
		return Double.valueOf(String.format("%.3f", GPA));
	}
	
	
	public String getClassStanding() {
		if (credits < 30) {
			return "Freshman";
		} else if (credits >= 30 && credits < 60) {
			return "Sophomore";
		} else if (credits >= 60 && credits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}

	public void submitGrade(Double grade, int credits) {
		this.qualityScore += grade * credits;
		this.credits += credits;
	}
	
	public void submitGrade(int grade, int credits) {
		this.qualityScore += grade * credits;
		this.credits += credits;
	}

	public Double computeTuition() {
		//Double tuition = ((float)this.credits / 15.0) * 20000.0;
		//tuition = (double)(Math.round(tuition * 100) / 100);
		Double tuition;
		
		System.out.println(this.credits);
		
		if (this.credits % 15 != 0 && this.credits > 15) {
			tuition = (this.credits / 15) * 20000.0;
			tuition += (this.credits % 15) * 1333.33;
					
		} else if (this.credits % 15 == 0) {
			tuition = (this.credits / 15) * 20000.0;
			
		} else {
			tuition = 1333.33 * this.credits;
		}
		
		return tuition; // Double.valueOf(String.format("%.2f", tuition));
	}
	
	public Student createLegacy(Student one, Student other) {
		int newID = this.studentId + other.getStudentID();
		int newCredits = Integer.max(this.credits, other.getCredits());
		Double newQuality = (((this.getGPA() + other.getGPA()) / 2) * newCredits);
		return new Student(this.getName(), other.getName(), newID, newCredits, newQuality);
	}
	
	public String toString() {
		return String.format("%s %s %d", this.firstName, this.lastName, this.studentId);
	}
	
	public static void main(String[] args){
		Student s = new Student("", "", 1);
		s.submitGrade(0, 15);
		System.out.println(s.getCredits());
		System.out.println(s.computeTuition());
	}
}
