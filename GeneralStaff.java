
public class GeneralStaff extends Employee{

	private String duty;
	
	public GeneralStaff() {
		super();
		duty = "";
	}
	
	public GeneralStaff(String duty) {
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GeneralStaff) {
			GeneralStaff gs = (GeneralStaff)obj;
			if(super.equals(obj)== super.equals(gs)) {
				if(getDuty() == gs.getDuty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		String s = super.toString();
		s += String.format (" GeneralStaff: Duty: %10s",duty);
		
		return s;
	}
}
