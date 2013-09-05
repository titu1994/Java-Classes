package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialSum {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		long n = 0, cp = 0;
		
		int size = 0;
		int digits[];
		
		long fact = 1;;
		long sum = 0;
		
		System.out.println("Input a number");
		
		try{
			n = Long.parseLong(bb.readLine());
			
		}catch(NumberFormatException e){
			
		}
		
		cp = n;
		
		while(cp != 0){
			size++;
			cp/=10;
		}
		
		cp = n;
		
		digits = new int[size];
		
		for(int i = size-1; i >= 0; i--){
			digits[i] = (int) (cp % 10);
			cp /= 10;
		}
		
		for(int i = 0; i < size; i++){
			
			for(int j = 1; j <= digits[i]; j++){
				
				fact*= j;
			}
			sum += fact;
			fact = 1;
		}
		
		System.out.println("The sum is : " + sum);
		
		
	}

}
