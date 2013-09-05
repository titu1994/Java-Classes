package assignment3;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCounter {

	static Scanner sc = new Scanner(System.in);
	
	private int counter;
	
	public int count(String input, String check){
		
		counter = 0;
		int temp;
		int inputLength = input.length();
		
		for(int i = 0; i < inputLength; i++){
			
			temp = input.indexOf(check, i);
			
			if( temp != -1){
				counter++;
				i = temp;
			}
			else
				break;
			
		}
		
		return counter;
	}
	
	
	public int count(String input, char charArr[]){

		String s = new String(charArr);
		
		return count(input, s);
	}
	
	public int count(String input, byte byteArr[]){
		String s = new String(byteArr);
		
		return count(input,s);
	}
	
	public int count(String check, StringTokenizer token){
		counter = 0;
		
		while(token.hasMoreTokens()){
			if(token.nextToken().equals(check));
				counter++;
		}
		return counter;
	}
	
	public int count(StringBuffer input, StringBuffer check){
		
		counter = 0;
		
		int temp;
		
		for(int i = 0; i < input.length(); i++){
			
			temp = input.indexOf(check.toString(), i);
			
			if( temp != -1){
				counter++;
				i = temp;
			}
			else
				break;
			
		}
		
		return counter;
	}
	
	public int splitCount(String input, String splitter){
		
		counter = 0;
		int temp;
		
		String subs[] = input.split(" ");
		for(int i = 0; i < subs.length; i++){
			
			temp = input.indexOf(splitter, i);
			
			if( temp != -1 ){
				counter++; 
			}
			
			
		}
		
		return counter;
	}
	
	public static String patternBuilder(String check){
		
		return "\\b"+check+"\\b";
	}
	
	public int count(String input, String check ,Pattern regularPattern){
		
		/*String split[] = input.split(check);
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < split.length; i++){
			sb.append(split[i]);
			sb.append(" ");
		}
		
		String tempString = sb.toString();
		*/
		
		Matcher m = regularPattern.matcher(input);
		counter = 0;
		
		while(m.find()){
			counter++;
		}
		
		return counter;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Enter the string");
		
		String s = sc.nextLine();
		
		System.out.println("Enter the word to check");
		
		String check = sc.nextLine();
		
		StringCounter sCounter = new StringCounter();
		
		int c1 = sCounter.count(s, check);
		
		char cArrat[] = check.toCharArray();
		int c2 = sCounter.count(s, cArrat);
		
		byte cByteArr[] = check.getBytes();
		int c3 = sCounter.count(s, cByteArr);
		
		
		System.out.println("The count through String Check is : " + c1);
		System.out.println("The count through Char Array Check check is : " + c2);
		System.out.println("The count through Byte Array Check is : " + c3);
		
		if(s.contains(check)){ 
			int c4 = sCounter.splitCount(s, check);
			
			System.out.println("The count through Split String Array Check is : " + c4);
		}
		
		Pattern p = Pattern.compile(check);
		
		int c5 = sCounter.count(s, check, p);
		
		System.out.println("The count through String Pattern Check is : " + c5);
		
		StringTokenizer t = new StringTokenizer(s);
		int c6 = sCounter.count(check, t);
		
		System.out.println("The count through String Tokeniser Check is : " + c6);
		
		int c7 = sCounter.count(new StringBuffer(s), new StringBuffer(check));
		
		System.out.println("The count through String Buffer Check is : " + c7);
		

	}

}
