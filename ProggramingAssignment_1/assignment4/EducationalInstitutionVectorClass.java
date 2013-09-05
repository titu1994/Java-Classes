package assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import assignment4.EducationalInstitutionClass;

/*
 * class Staff{
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
 * 
 */

public class EducationalInstitutionVectorClass {
	/*
	 * 
	 * Imports are from the EducationalInstitutionClass.
	 * Remove the Comments from the earlier lines if the other class is not loaded in Eclipse.
	 * 
	 */
	
	
	private static final String STAFF_MEMBER_CHOICE = "1 for Teacher\n2 for Regular Typist\n3 for Casual Typist\n4 for Officer";
	
	private static final BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException, NumberFormatException {
		
		Vector<Staff> v = new Vector<Staff>();
		
		int ch;

		do{
		System.out.println("Enter your choice : ");
		System.out.println("1 for Adding a Staff Member\n2 for Removing a Staff Member\n3 for Displaying information about a Staff Member");
		
		ch = Integer.parseInt(bb.readLine());
		int choice = -1;
		
			switch(ch){
			
			case 1:{
				System.out.println("Enter choice to add a staff member");
				System.out.println(STAFF_MEMBER_CHOICE);
				
				choice = Integer.parseInt(bb.readLine());
				
				switch(choice){
					case 1:{
						Teacher t = new Teacher();
						t.setData();
						
						boolean b = v.add(t);
						
						if(b)
							staffAdded();
						else
							staffAddFailed();
						
						break;
					}
					
					case 2:{
						Regular r = new Regular();
						r.setData();
						
						boolean b = v.add(r);
						
						if(b)
							staffAdded();
						else
							staffAddFailed();
						
						break;
					}
					case 3:{
						Casual c = new Casual();
						c.setData();
						
						boolean b = v.add(c);
						
						if(b)
							staffAdded();
						else
							staffAddFailed();
						
						break;
					}
					case 4:{
						Officer o = new Officer();
						o.setData();
						
						boolean b = v.add(o);
						
						if(b)
							staffAdded();
						else
							staffAddFailed();
						
						break;
					}
					
					default :
						System.out.println("Wrong choice");
					
				}
				
				break;	
			}
			
			case 2:{
				System.out.println("Enter the code name of the Staff Member you want to remove : ");
				String cName = bb.readLine();
				
				int p = -1;
				
				for(int i = 0; i < v.size(); i++){
					if(v.elementAt(i).codeName.equalsIgnoreCase(cName)){
						v.remove(i);
						p = i;
						System.out.println("Staff member removed");
						break;
					}	
				}
				
				if(p == -1)
					failedToFindStaffMember(cName);
				
				break ;
			}
			
			case 3:{
				System.out.println("Enter the code name of the Staff Member whose details you want to display : ");
				String cName = bb.readLine();
				
				int p = -1;
				
				for(int i = 0; i < v.size(); i++){
					if(v.elementAt(i).codeName.equalsIgnoreCase(cName)){
						p = i;
						System.out.println(v.elementAt(i));
						System.out.println();
						
						break;
					}	
				}
				
				if(p == -1)
					failedToFindStaffMember(cName);
				
				break;
			}
			
			default:{
				System.out.println("Exiting");
				
				ch = -1;
			}
			
			}
			
		}while(ch != -1);
	}

	private static void failedToFindStaffMember(String cName) {
		System.out.println("The Staff member with id : "+cName + " does not exist.");
	}

	private static void staffAddFailed() {
		System.out.println("Staff addition failed");
	}

	private static void staffAdded() {
		System.out.println("Staff member added");
	}

}
