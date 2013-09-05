package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class UniqueArrays {

	
	public static void main(String[] args) throws IOException{
	
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0, count = 0;
		int arr1[] = null, arr2[] = null, arr3[] = null;
		
		System.out.println("Enter the no of elements in both arrays");
		
		
		try{
			n = Integer.parseInt(bb.readLine());
			
			arr1 = new int[n];
			arr2 = new int[n];
			
			System.out.println("Enter the Elements of the first array : ");
			
			for(int i = 0; i < n ; i++){
				arr1[i] = Integer.parseInt(bb.readLine());
			}
			
			System.out.println("Enter the elements of the second array : ");
			
			for(int i = 0; i < n; i++){
				arr2[i] = Integer.parseInt(bb.readLine());
			}
		}catch(NumberFormatException e){
			
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		
		for(int i = 0; i < n; i++){
			
				for(int j = 0; j < n; j++){
				
				if(arr1[i] != arr2[j]){
					count++;
					
				}
			}
			
		}
		

		Integer[] a = new Integer[count];
		
		
		for(int i = 0, k = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				
				
				if(arr1[i] != arr2[j]){
					a[k] = arr1[j];
					k++;
					
				}
			}
		}
		
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(a));
		
		arr3 = new int[s.size()];
		
		int t = 0;
		for (Integer val : s)
			a[t++] = val;
		
		
		System.out.println("The unique elements are : ");
		
		for(int i = 0; i < count; i++){
			System.out.println(a[i]);
		}
		
		/*
		 * Doesn't work. Repeats values and always prints the first digit, whether its unique or not. Ask sir later.
		 */
	}

}
