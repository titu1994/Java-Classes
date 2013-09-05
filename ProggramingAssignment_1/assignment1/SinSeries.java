package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinSeries {

	public static void main(String[] args) throws IOException {

		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0, sign = -1, term = 3;
		
		double x = 0, fact = 1;
		double sum ;
		
		System.out.println("Enter the value of x and number of terms");
		
		try{
			
			x = Double.parseDouble(bb.readLine());
			n = Integer.parseInt(bb.readLine());
			
		}catch(NumberFormatException e){
			
		}
		
		x = Math.toRadians(x);
		final double cp = x;
		sum = cp;
		
		for(int i = 0; i < n; i++){
			x = Math.pow(cp, term);
			
			fact = fact * term* (term - 1);
			
			sum = sum + (sign * x / fact);
			
			term = term + 2;
			sign = -1 * sign;
			
		}
		
		System.out.println("Sin X = " +sum);
		
	}

}
