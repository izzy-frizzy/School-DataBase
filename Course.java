
public class Course {

	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits ) {
		
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
	
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {
		String dis = isGraduateCourse ? "G" : "U";
		String name = String.format(dis + courseDept  + courseNum);
	
		return name;
	}
	public String gradCourse() { //extra
		String dis = isGraduateCourse ? "Graduate" : "Undergraduate";
		return dis;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(obj == this) {return true;}
		if(obj instanceof Course) {
			Course c = (Course) obj;
			if(getCourseNum() == c.getCourseNum()) {
				if(getNumCredits() == c.getNumCredits()) {
						if(getCourseDept() == c.getCourseDept()) {
							if(isGraduateCourse() == c.isGraduateCourse()) {
								return true;
							}
						}
					
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		String s = String.format("Course: %3s-%3d | Number of Credits: %02d | %s", courseDept, courseNum,numCredits,gradCourse());
		
		return s;
	}
	
	public int compareTo(Course c) {
		
		if(courseNum < c.courseNum) {
			return -1;
		}
		else if(courseNum > c.courseNum) {
			return 1;
		}
		return 0;
	}
}
