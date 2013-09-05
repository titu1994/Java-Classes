package asignment2;

import java.util.Scanner;

public class EmployeeData {

	static Scanner sc = new Scanner(System.in);
	
	private String name;
	private long no;
	private double basicSalary;
	private double HRA;
	private double DA;
	private double PF;
	private double PT;

	private double netSalary;
	
	
	public double getPT() {
		return PT;
	}



	public void setPT() {
		if(getBasicSalary() < 5000)
			PT = 20;
		else
			PT = 50;
	}


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public long getNo() {
		return no;
	}




	public void setNo(long no) {
		this.no = no;
	}




	public double getBasicSalary() {
		return basicSalary;
	}




	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}




	public double getHRA() {
		return HRA;
	}




	public void setHRA() {
		HRA = (12/100 * getBasicSalary());
	}




	public double getDA() {
		return DA;
	}




	public void setDA() {
		DA = (80/100 * getBasicSalary());
	}




	public double getPF() {
		return PF;
	}




	public void setPF() {
		PF = (10 / 100 * getBasicSalary());
	}




	public double getNetSalary() {
		return netSalary;
	}




	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	
	public void allowence(){
		setNetSalary(getNetSalary() + getHRA() + getDA() + 200); 
	}
	
	public void reduction(){
		setNetSalary(getNetSalary() - getPF() - getPT());
	}

	
	public String toString() {
		
		return "Employe Name : "+getName() + "\n Employe no : "+ getNo() + "\n Net Salary : " + getNetSalary() ;
	}



	public static void main(String[] args) {
		
		System.out.println("Enter the Name, No and Basic Salary of employes");
		
		EmployeeData e = new EmployeeData();
		
		e.setName(sc.next());
		e.setNo(sc.nextLong());
		e.setBasicSalary(sc.nextDouble());
		
		e.setHRA();
		e.setDA();
		e.setPF();
		e.setPT();
		
		e.setNetSalary(e.getBasicSalary());
		
		e.allowence();
		e.reduction();
		
		System.out.println(e);
	}

}
