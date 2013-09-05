package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListDeletion {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));

		int n = 0, r = 0, count = 0;
		int arr1[] = null, arr2[], pos[] = null;
		
		System.out.println("Enter the no of elements in the list");
		
		try{
			n = Integer.parseInt(bb.readLine());
			
			System.out.println("Enter the elements of the list");
			
			arr1 = new int[n];
			
			for(int i = 0; i < n; i++){
				arr1[i] = Integer.parseInt(bb.readLine());
			}
			
			System.out.println("Enter the element to be removed");			
			
			r = Integer.parseInt(bb.readLine());
		}catch(NumberFormatException e){
			
		}
		
		for(int i = 0; i < n; i++){
			if(r == arr1[i]){
				count++;
			}
		}
		
		pos = new int[count];
		
		for(int i = 0, k = 0; i < n; i++){
			if(count > 0){
				
				if(r == arr1[i] ){
					pos[k] = i;
					k++;
				}
			}
			
		}
		
		if(pos.length == 0){
			System.out.println("That element does not exist");	
		}
		else{
			arr2 = new int[n-pos.length];
			
			for(int i = 0, l = 0, k = 0; i < n; i++){
				if(i==pos[k]){
					
					if((k+1) < pos.length)
						k++;
					continue;
				}
				
				else{
					if(l == arr2.length)
						break;
					
					arr2[l] = arr1[i];
					
					l++;
				}
				
			}
			
			System.out.println("The new list is : ");
			
			for(int i = 0; i < arr2.length; i++){
				System.out.println(arr2[i]);
			}
		}
		
		
		
		
		
	}

}
