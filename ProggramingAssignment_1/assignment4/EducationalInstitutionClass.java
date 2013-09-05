package assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Staff{
	static BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
	
	protected String codeName;
	
	void setData() throws IOException{
		System.out.println("Code Name : ");
		codeName = bb.readLine();
	}

	public String toString() {
		
		return getClass().getSimpleName()+ " : Code Name : "+ codeName;
	}
	
	
}

class Teacher extends Staff{
	
	protected String subject;
	protected String qualification;
	
	void setData() throws IOException {
		System.out.println("Teacher : ");
		
		super.setData();
		
		System.out.println("Enter the Subject and Qualification : ");
		
		subject = bb.readLine();
		qualification = bb.readLine();
	}
	
	
	public String toString() {
		
		return super.toString() + " Subject : "+subject + " Qualification : " + qualification;
	}
	
	
}

class Officer extends Staff{
	
	
	protected char grade;

	void setData() throws IOException {
		System.out.println("Officer : ");
		
		super.setData();
		
		System.out.println("Enter the grade : ");
		
		grade = (char) bb.read();
	}

	
	public String toString() {
		return super.toString() + " Grade : "+grade;
	}
	
}

class Typist extends Staff{
	
	protected double speed;

	void setData() throws IOException, NumberFormatException {
		super.setData();
		
		System.out.println("Enter the typing speed : ");
		
		speed = Double.parseDouble(bb.readLine());
	}

	
	public String toString() {
		return super.toString() + " Speed : "+speed;
	}
	
}

class Regular extends Typist{
	
	protected double salary;

	void setData() throws IOException, NumberFormatException {
		System.out.println("Regular Typist : ");
		
		super.setData();
		
		System.out.println("Enter the salary of the regular typist : ");
		
		salary = Double.parseDouble(bb.readLine());
	}

	
	public String toString() {
		return super.toString() + " Salary : "+ salary;
	}
	
}

class Casual extends Typist{
	
	protected double dailyWages;

	
	void setData() throws IOException, NumberFormatException {
		System.out.println("Casual Typist : ");	
		
		super.setData();
		
		System.out.println("Enter the Daily wages of the casual typist : ");
		
		dailyWages = Double.parseDouble(bb.readLine());
	}

	
	public String toString() {
		return super.toString() + " Daily Wages : "+dailyWages;
	}
	
}


public class EducationalInstitutionClass {

	
	public static void main(String[] args) throws IOException, NumberFormatException {
		
		Staff a[] = new Staff[4];
		
		a[0] = new Teacher();
		a[1] = new Regular();
		a[2] = new Casual();
		a[3] = new Officer();
		
		a[0].setData();
		a[1].setData();
		a[2].setData();
		a[3].setData();
	
		System.out.println();
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);

	}

}
