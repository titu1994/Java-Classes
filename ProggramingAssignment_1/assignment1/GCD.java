package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = 0, n2 = 0;
		int gcd = 0;
		
		System.out.println("Enter the 2 nos");
		
		try{
			n1 = Integer.parseInt(bb.readLine());
			n2 = Integer.parseInt(bb.readLine());
		}catch(NumberFormatException e){
			
		}
		
		if(n1 > n2){
			gcd = n1;
		}
		else
			gcd = n2;
		
		while(gcd != 1){
			if( n1 % gcd == 0 && n2 % gcd == 0)
				break;
			gcd--;
		}
		
		if(gcd == 1){
			System.out.println("No GCD");
		}
		else
			System.out.println("GCD is : " + gcd);
		
	}

}
