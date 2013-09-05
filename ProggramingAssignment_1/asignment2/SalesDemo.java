package asignment2;

import java.util.Scanner;

public class SalesDemo {

	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		double sales;
		
		System.out.println("Enter the amount of sales : ");
		
		sales = sc.nextDouble();
		
		if(sales > 0){
			Sales s = new Sales(sales);
			s.commissionCalculate();
			
			System.out.println(s);
		}
		else{
			System.out.println("Invalid Input");
		}
		
	}

}
