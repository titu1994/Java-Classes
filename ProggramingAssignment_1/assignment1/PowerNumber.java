package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerNumber {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		long x = 0, y = 0, pow = 1;
		
		System.out.println("Enter a number");
		
		try {
			x = Long.parseLong(bb.readLine());
			
			System.out.println("Enter the power to which " + x + " must be raised to : ");
			
			y = Long.parseLong(bb.readLine());
		}catch(NumberFormatException e){
			
		}
		
		for(int i = 0; i < y; i++){
			
			pow = pow * x;
			
		}
		
		System.out.println("The power of " + x + " raised to " + y + " is "+ pow);

	}

}
