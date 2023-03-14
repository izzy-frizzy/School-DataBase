
public class Person implements Comparable <Person>{

	private String name;
	private int birthYear;
	
	public Person() {
		name = "";
		birthYear = 0;
	}
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Person) {
			Person p = (Person)obj;
			if(getName() == p.getName()) {
				if(getBirthYear() == p.getBirthYear()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String f = String.format("Person: Name: %30s | Birth Year: %4d", getName(), getBirthYear());
		
		return f;
	}
	public int compareTo(Person p) {
		if(birthYear < p.birthYear) {
			return -1;
		}
		else if(birthYear > p.birthYear) {
			return 1;
		}
		return 0;
	}
}
