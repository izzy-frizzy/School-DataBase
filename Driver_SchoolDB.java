
import java.util.Scanner; 

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//https://youtu.be/DRrYVhfiBq8
public class Driver_SchoolDB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);// input from keboard and file
		FileInputStream  fileStream = null; //connection to file
		Scanner cout = null;
		PrintWriter pw = null; // write to file
		boolean done = false;
		
		while(!done){
			
			try {
				
				File sch = new File("SchoolDB_Initial");
				BufferedReader in = new BufferedReader(new FileReader(sch));
				cout = new Scanner(new File("SchoolDB_Initial"));
				//pw = new PrintWriter(new FileOutputStream("SchoolDB_Updated.txt"));
				

				String line = in.readLine();

				while(line != null)

				{

				  System.out.println(line);
				  line = in.readLine();

				}
				
				Course a = new Course(true,771,"MAT", 4);
				Course b = new Course(true,777,"CMP", 4);
				Course c = new Course(true,711,"CMP", 4);
				Course d = new Course(true,723,"MAT", 4);
				Course e = new Course(false,168,"CMP", 4);
				Course f = new Course(false,338,"CMP", 4);
				
				Faculty f1 = new Faculty();
				Faculty f2 = new Faculty(true);
				Faculty f3 = new Faculty("MAT", false);
				Faculty f4 = new Faculty("Superman", 1938,"PHY",true);
				
				GeneralStaff g1 = new GeneralStaff();
				GeneralStaff g2 = new GeneralStaff("advise students");
				GeneralStaff g3 = new GeneralStaff("Sanitation", "clean");
				GeneralStaff g4 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
				
				Student s1 = new Student();
				Student s2 = new Student(false);
				Student s3 = new Student("Math", false);
				Student s4 = new Student("Wonderwoman",1941,"JST",true);
				
				Course [] classes = {e,f};
				Course [] courses = {c,b};
				Course[] learn = {a,b,c,d,e,f};
				
				Faculty [] teachers = {f1,f2,f3,f4};
				GeneralStaff [] workers = {g1,g2,g3,g4};
				Student [] learner = {s1,s2,s3,s4};
				
					displaySchoolDataBase(teachers,learn,learner,workers);
				
				in.close();
				FileReader fr = new FileReader("SchoolDB_Initial");
				done = true;
			}
			catch(FileNotFoundException e){
				System.out.println("cant find file" + "SchoolDB_Initial.txt");
				
			}
			finally {
				if(pw != null && cin!= null) {
					pw.close();
					cin.close();
					
				}
			}
			
		}
	
	}
	
	public static void displaySchoolDataBase(Faculty [] teachers,Course [] course,Student [] student,GeneralStaff [] staff) {

		System.out.println("");
		System.out.println("**************************************************************\nSCHOOL DATABASE INFO:\n\n************************************************");
		System.out.println("COURSES:");
		displayCourses(course);
		System.out.println("************************************************\n************************************************");
		System.out.println("PERSONS:\n************************************************\n************************************************");
		System.out.println("EMPLOYEES:\n************************************************\n************************************************\nGENERAL STAFF:");
		displayStaff(staff);
		System.out.println("************************************************\n************************************************\nFACULTY:");
		displayteachers(teachers);
		System.out.println("************************************************\n************************************************\nSTUDENTS:");
		displayStudents(student);
		System.out.println("************************************************\n**************************************************************\n");
		
		
	}
	public static void displayteachers(Faculty [] teachers) {
		for(int i = 0; i<teachers.length;i++) {
			System.out.println(teachers[i].toString());
		}
	}
	public static void displayCourses(Course [] course) {
		for(int i = 0; i<course.length;i++) {
			System.out.println(course[i].toString());
		}
	}
	public static void displayStudents(Student [] student) {
		for(int i = 0; i<student.length;i++) {
			System.out.println(student[i].toString());
		}
	}
	public static void displayStaff(GeneralStaff [] staff) {
		for(int i = 0; i<staff.length;i++) {
			System.out.println(staff[i].toString());
		}
	}

	public  static String mostTaught(Faculty [] teachers) { // not working properly
		
		for(int i = 0; i< teachers.length; i++) {
			for(int j = 0; j< teachers.length;i++) {
				if(teachers[j] != null && teachers[j+1] != null) {
					
					if(teachers[j].compareTo(teachers[j+1]) < 0) {
						Faculty sub = teachers[j];
						teachers[j] = teachers[j+1];
						teachers[j+1] = sub;
					}
				}
			}
		}
		String s = ("the Faculty with the most courses taught is " + teachers[0].toString() + "while the Faculty with the least course taught is " + teachers[teachers.length].toString());
		return s;
	}
	
public static void maxCourse(Course [] learn) { //not working properly
		
		for(int i = 0; i< learn.length; i++) {
			for(int j = 0; j< learn.length;i++) {
				if(learn[j] != null && learn[j+1] != null) {
					
					if(learn[j].compareTo(learn[j+1]) > 0) {
						Course sub = learn[j];
						learn[j] = learn[j+1];
						learn[j+1] = sub;
					}
				}
			}
		}
		System.out.println("the maximum course is  " + learn[0] + "while the minimum course is " + learn[learn.length]);
	}
	public static void mostTaken(Student [] learner) { //not working properly
		
		for(int i = 0; i< learner.length; i++) {
			for(int j = 0; j< learner.length;i++) {
				if(learner[j] != null && learner[j+1] != null) {
					
					if(learner[j].compareTo(learner[j+1]) > 0) {
						Student sub = learner[j];
						learner[j] = learner[j+1];
						learner[j+1] = sub;
					}
				}
			}
		}
		System.out.println("the student with the most credits is " + learner[0] + "while the student witht he least number of credits is " + learner[learner.length]);
	}

}
