package assignment3;

import java.util.Scanner;

public class StringWordReverse {
	
	static Scanner sc = new Scanner(System.in);
	
	public static String wordReverse(String input){
		
		input = input.trim();
		String arr[] = input.split(" ");
		
		final int arrLength = arr.length;
		
		StringBuffer x = new StringBuffer();
		
		for(int i = 0; i < arrLength; i++){
			x.append(arr[arrLength-1-i] + " ");
		}
		
		String s = x.toString().trim();
		return s;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter a setence : ");
		String s = sc.nextLine();
		
		s = StringWordReverse.wordReverse(s);
		System.out.println(s);		
	}

}
