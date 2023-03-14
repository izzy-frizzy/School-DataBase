
public class Student extends Person{

	private static int numStudents = 0;
	private int studentID;
	private Course [] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
	public Student() {
		super();
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		isGraduate = false;
		major = "undeclared";
		numStudents++;
		studentID = numStudents;
	}
	
	public Student(boolean isGraduate) {
		this.isGraduate = isGraduate;
		major = "undeclared";
		coursesTaken = new Course [50];
		numCoursesTaken = 0;
		numStudents++;
		studentID = numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		this.major = major;
		this.isGraduate = isGraduate;
		coursesTaken = new Course [50];
		numCoursesTaken = 0;
		numStudents++;
		studentID = numStudents;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		this.major = major;
		this.isGraduate = isGraduate;
		coursesTaken = new Course [50];
		numCoursesTaken = 0;
		numStudents++;
		studentID = numStudents;
	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getMajor() {
		return major;
	}
	public Course getCourseTaken(int c) {
		if(numCoursesTaken  == 0 || c < 0 || c >= 50) {
			return null;
		}
		return coursesTaken[c];
	}
	
	public String getCourseTakenAsString(int course) {
		if(numCoursesTaken == 0 || course <0 || course >= 50) {
			return "";
		}
		String s = String.format(" Course: %3s-%3d | Number of Credits: %02d | %s",coursesTaken[course].getCourseDept(),coursesTaken[course].getCourseNum(),coursesTaken[course].getNumCredits(),coursesTaken[course].gradCourse());
		return s;
	}
	
	public String getAllCoursesTakenAsString() { 
		String s = "";
		for(int i =0 ;i < numCoursesTaken; i++) {
			
			s += getCourseTakenAsString(i);
		}
		return s;
		
	}
	public void setisGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) { 
		
		if(numCoursesTaken >= 50) {
			System.out.println("course can't be added");	
		}
		else {
			this.coursesTaken[numCoursesTaken++] = course;
		}
	}
	
	public void addCoursesTaken(Course [] course) { 
		
		for(int i = 0; i < course.length; i++) {
			if(numCoursesTaken >= 50) {
				System.out.println("course can't be added");
			}
			else {
				this.addCourseTaken(course[i]);
			}
		}
		
	}
	public int sumCredits() { //extra
		
		int sum = 0;
		for(int i = 0; i < numCoursesTaken; i++) {
			sum += coursesTaken[i].getNumCredits();
		}
		
		return sum;
	}
	public String grad() { //extra
		String dis = isGraduate ? "Graduate" : "Undergraduate";
		return dis;
	}
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof Student) {
			Student kid = (Student)obj;
				if(super.equals(obj) == super.equals(kid)) {
					if(getMajor() == kid.getMajor()) {
						if(getStudentID() == kid.getStudentID()) {
							if(getNumCoursesTaken() == kid.getNumCoursesTaken()) {
								if(isGraduate() == kid.isGraduate()) {
									return true;
								}
							}
						}
					}
				}
			
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		
		String s = super.toString();
		s += String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",studentID, major, grad(),numCoursesTaken, getAllCoursesTakenAsString());
		
		return s;
	}
	
	public int compareTo(Student s) { //needs fixing
		if( this.sumCredits() < s.sumCredits()) {
			return -1;
		}
		else if(this.sumCredits() > s.sumCredits()) {
			return 1;
		}
		return 0;
	}

}
