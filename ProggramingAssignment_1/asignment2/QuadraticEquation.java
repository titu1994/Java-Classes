package asignment2;

import java.util.Scanner;

public class QuadraticEquation {

	
	static Scanner sc = new Scanner(System.in);
	
	private double a,b,c;
	
	private boolean isNegetive = false;
	
	public double getA() {
		return a;
	}



	public double getB() {
		return b;
	}



	public double getC() {
		return c;
	}
	
	
	
	public boolean isNegetive() {
		return isNegetive;
	}



	public void setNegetive(boolean isNegetive) {
		this.isNegetive = isNegetive;
	}



	public QuadraticEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getDiscriminent(){
		double dis = (getB()*getB() - 4*getA()*getC());
		
		if(dis < 0)
			setNegetive(true);
		else 
			setNegetive(false);
		
		return dis;
	}
	
	public double getRoot1(){
		if(!isNegetive()){
			return (-getB() + Math.sqrt(getDiscriminent()))/(2*getA());
		}
		else
			return -1;
		
	}

	public double getRoot2(){
		if(!isNegetive()){
			return (-getB() - Math.sqrt(getDiscriminent()))/(2*getA());
		}
		else
			return -1;
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the values a, b, and c : ");
		
		double a,b,c;
		
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();

		QuadraticEquation e = new QuadraticEquation(a, b, c);
		
		if(e.getDiscriminent() > 0){
			System.out.println("The roots are : \n" + e.getRoot1() + "\n"+e.getRoot2());;
		}
		else if(e.getDiscriminent() == 0){
			System.out.println("The root is : \n" + e.getRoot1());
		}
		else if(e.isNegetive()){
			System.out.println("This equation has no roots");
		}
	}

}
