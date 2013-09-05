package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalenderForm {
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		int day = 0, month = 0, year = 0;
		int start = 0;
		
		String months[] = {"January","February","March","April","May","June","July" ,"August", "September","October","November","December"};
		int noOfDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		
		System.out.println("Enter the starting date of the month : 1 - Mon 2, - Tue, 3 - Wed, 4 - Thu, 5 - Fri, 6 - Sat, 7 - Sun");
		System.out.println("Enter the month");
		System.out.println("Enter the year");
		
		try{
			day = Integer.parseInt(bb.readLine());
			month = Integer.parseInt(bb.readLine());
			year = Integer.parseInt(bb.readLine());
		}catch(NumberFormatException e){
			
		}
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			noOfDays[1] = 29;
		
		if(month >= 1 && month <= 12){
			
			if(day >= 1 && day <= 7){
				
				System.out.println("\t\t\t"+(months[month-1])+ " "+ year + "\t\t\t");
				
				System.out.println("----------------------------------------------------------");
				
				System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
				
				for(int i = 0; i < 6; i++){
					
					for(int j = 0; j <7; j++){
						
						 
						if(start < noOfDays[day - 1] && start >= 1){
							start++;
							System.out.print(start+ "\t");
						}
						
						else if((day) == j){
							start++;
							System.out.print(start+ "\t");
							
							
						}
						
						else if(start >= noOfDays[day - 1])
							break;
							
						else{
							System.out.print("\t");
						}
						
						
					}
					
					if(start < noOfDays[day - 1]){
						System.out.println();
					}
				}
				
			}
			
			else 
				System.out.println("Wrong Choice");
			
			
			
		}
		
		else 
			System.out.println("Wrong Choice");
		
	}

}
