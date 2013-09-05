package asignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class BirthDateClass {

	public static final BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		int year, month, date;
		Calendar c = Calendar.getInstance();
		
		System.out.println("Enter the Birth date in YYYY MM DD format ");
		
		do{
			year = Integer.parseInt(bb.readLine());
			
			if(year < 0){
				System.out.println("Year cannot be negative");
				System.out.println("Re enter Year");
			}
			
		}while(year < 0);
		
		do{
			month = Integer.parseInt(bb.readLine());
			
			if(month < 0 || month > 13){
				System.out.println("Month must be between 1 and 12");
				System.out.println("Re enter Month");
			}
			
		}while(month < 0 || month > 13);
		
		do{
			date = Integer.parseInt(bb.readLine());
			
			if(month == 2 ){
				if( isLeap(year) && date <= 0 || date >= 30 ){
					System.out.println("It is a leap year, minimum is 1 and maximum date is 29");
					System.out.println("Re enter Date");
				}
				
				else if(!isLeap(year) && date <= 0 || date > 29 ){
					System.out.println("It is not a leap year, minimum is 1 and maximum date is 28");
					System.out.println("Re enter Date");
				}
			}
			
			
			if(date <= 0 || date >=32){
				System.out.println("Day must be between 1 and 31");
				System.out.println("Re enter Date");
			}
			
		}while(date <= 0 || date >=32);
		
		c.set(year, month - 1, date);
		
		Calendar b = Calendar.getInstance();
		
		int age = b.get(Calendar.YEAR) - c.get(Calendar.YEAR);
		
		long delta = b.getTimeInMillis() - c.getTimeInMillis();
		
		double days = delta/1000/3600/24;
		double weeks = days/7;
		double months = (weeks/4.345);
		double years = months/12;
		
		System.out.println("Age : " + age + "\nNo of Leap years : "+noOfLeapYears(c, b) + "\nNo of days passed : "+days + "\nNo of weeks : "+weeks+"\nNo of Months : "+months +"\nNo of Years : "+years);
	}
	
	public static boolean isLeap(int year){
		
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public static long noOfLeapYears(Calendar c, Calendar b){
		
		long count = 0;
		
		int y1,y2;
		
		y1 = c.get(Calendar.YEAR);
		y2 = b.get(Calendar.YEAR);
		
		for(int i = y1; i <= y2; i++){
			if(isLeap(i))
				count++;
			
			c.add(Calendar.YEAR, 1);
		}
		
		return count;
		
	}

}