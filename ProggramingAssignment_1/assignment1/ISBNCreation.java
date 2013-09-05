package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBNCreation {

	
	public static void main(String[] args) throws IOException{
		
		int i = 0;
		long isbn = 0;
		long checkSum = 0;
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the first 9 digits : ");
		
		try{
			isbn = Long.parseLong(bb.readLine());
		}catch (NumberFormatException e){
			
		}
		
		long digits[] = new long[9];
		
		while(isbn != 0){
			digits[i] = isbn%10;
			
			isbn/=10;
			i++;
			
		}
		
		checkSum = (digits[0] + digits[1]*2 + digits[2]*3 + digits[3]*4 + digits[4]*5 + digits[5]*6 + digits[6]*7 + digits[7]*8 + digits[8]*9) % 11;
		
		System.out.println("Checksum is : " + checkSum);
		System.out.println("The ISBN is : ");
		
		for(int j = 8; j>= 0; j--){
			System.out.print(digits[j]);
		}
		
		if(checkSum == 10){
			System.out.print("X");
		}
		
		else{
			System.out.print(checkSum);
		}
	}

}
