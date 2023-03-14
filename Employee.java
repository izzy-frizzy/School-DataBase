
public class Employee extends Person {
	
	private String deptName;
	private static int numEmployees = 0;
	private int employeeID;
	
	public Employee() {
		super();
		deptName = "";
		numEmployees++;
		employeeID = numEmployees;
	}
	
	public Employee(String deptName) {
		this.deptName = deptName;
		numEmployees++;
		employeeID = numEmployees;
	}
	
	public Employee(String name, int birthYear, String deptName) {
		super(name, birthYear);
		numEmployees++;
		employeeID = numEmployees;
		this.deptName = deptName;
		
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Employee) {
			Employee worker = (Employee)obj;
			if(super.equals(obj) == super.equals(worker)) {
				if(getDeptName() == worker.getDeptName()) {
					if(getEmployeeID() == worker.getEmployeeID()) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		String s = super.toString();
		s += String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
		
		return s;
	}
	
	public int compareTo(Employee p) {
		if(this.employeeID < p.employeeID) {
			return -1;
		}
		else if(this.employeeID > p.employeeID) {
			return 1;
		}
		return 0;
	}
	
}
