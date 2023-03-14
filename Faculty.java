

public class Faculty extends Employee {
	
	private Course [] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	public Faculty() {
		coursesTaught  = new Course [100];
		numCoursesTaught = 0;
		isTenured = false;
	}
	
	public Faculty(boolean isTenured) {
		this();
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public Faculty(String deptName, boolean isTenured) {
		super(deptName);
		this.isTenured = isTenured;
		numCoursesTaught = 0;
		coursesTaught = new Course[100];
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear,deptName);
		this.isTenured = isTenured;
		coursesTaught  = new Course [100];
		numCoursesTaught = 0;
	}
	
	public boolean isTenured() {
		return isTenured;
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	
	public void setisTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	public void addCourseTaught(Course course) {  
		
		if(numCoursesTaught >= 100) {
			System.out.println("course can't be added");	
		}
		else {
			this.coursesTaught[numCoursesTaught++] = course;
		}
		
	}
	
	public void addCoursesTaught(Course [] learn) { 
		
		for(int i = 0; i < learn.length; i++) {
			if(numCoursesTaught >= 100) {
				System.out.println("course can't be added");
			}
			else {
				this.addCourseTaught(learn[i]);
			}
		}
		
	}
	
	public Course getCourseTaught(int course) {
		
		if(numCoursesTaught == 0 || course< 0 || course >= 100) {
			return null;
		}
		return coursesTaught[course];
	}
	
	public String getCourseTaughtAsString(int course) { 
		if(numCoursesTaught == 0 || course < 0 || course >= 100) {
			return "";
		}
		String s = String.format(" %3s-%3d ",coursesTaught[course].getCourseDept(),coursesTaught[course].getCourseNum());
		return s;
	}
	
	public String getAllCoursesTaughtAsString() { 
		
		String s = "";
		for(int i =0 ;i < numCoursesTaught; i++) {	
				s+= getCourseTaughtAsString(i);
				
		}
		return s;
	}
	
	 public String tenured() { //extra
			String dis = isTenured ? "Is Tenured" : "Not Tenured";
			return dis;
		}
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Faculty) {
			Faculty peps = (Faculty)obj;
			if(super.equals(obj) == super.equals(peps)) {
				if(isTenured == peps.isTenured()) {
					if(getNumCoursesTaught() == peps.getNumCoursesTaught()) {
						if(coursesTaught == peps.coursesTaught) {
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
		
		String s = super.toString();
		s += String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",tenured(), numCoursesTaught, getAllCoursesTaughtAsString());
		
		return s;
	}
	
	public int compareTo(Faculty f) { 
		
		if(this.numCoursesTaught < f.numCoursesTaught) {
			return -1;
		}
		else if(this.numCoursesTaught > f.numCoursesTaught) {
			return 1;
		}
		return 0;
	}
	
	

}
