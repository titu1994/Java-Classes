package assignment3;

import java.io.IOException;

public class StringInsert {

	public static String append(String s, int pos, String word){
		
		String fin = "";
		
		if(pos > s.length() || pos < 0){
			return "Error";
		}
		else{
			s = s.trim();
			String arr[] = s.split(" ");
			int counter = 0;
			
			
			for(int i = 0; i < arr.length; i++){
				counter += arr[i].length();
				
				if(pos > counter || pos <= -1){
					pos -= arr[i].length() + 1;
					
					fin += arr[i] + " ";
					
				}
				else{
					char sChars[] = arr[i].toCharArray();
					char endCharArr[] = new char[sChars.length + word.length()];
					
					for(int j = 0; j < pos; j++){
						endCharArr[j] = sChars[j];
					}
					
					for(int j = pos; j <word.length() + pos ; j++){
						endCharArr[j] = word.charAt(j-pos);
					}
					
					for(int j = pos + word.length()  ; j < endCharArr.length; j++){
						endCharArr[j] = sChars[j - word.length() ];
					}
					
					String temp = new String(endCharArr);

					fin+= temp + " ";
					
					pos = -1;
				}
				
			}
			
			fin = fin.trim();
			return fin;
			
		}
		
	}
	
	public static String append(char s[], int pos, String word ){
		
		String fin = "";
		
		if(pos > s.length){
			return "Error";
		}
		
		else{
			
			char endCharArr[] = new char[s.length + word.length()];
			
			for(int j = 0; j < pos; j++){
				endCharArr[j] = s[j];
			}
			
			for(int j = pos; j <word.length() + pos ; j++){
				endCharArr[j] = word.charAt(j-pos);
			}
			
			for(int j = pos + word.length()  ; j < endCharArr.length; j++){
				endCharArr[j] =	s[j - word.length() ];
			}
					
			fin = new String(endCharArr);
			
			fin = fin.trim();
			return fin;
			
		}
		
	}
	
	public static String append(StringBuffer s, int pos, String word){
		
		if(pos > s.length()){
			return "Error";
		}
		
		else{
			
			s.insert(pos, word);
			
			return s.toString();
		}
	}
	
	

	
	public static void main(String[] args) throws IOException {
		
		String s = args[0];
		int pos = Integer.parseInt(args[1]);
		String word = args[2];
		
		String s1 = StringInsert.append(s, pos, word);
		String s2 = StringInsert.append(s.toCharArray(), pos, word);		
		
		StringBuffer b = new StringBuffer(s);
		
		String s3 = StringInsert.append(b, pos, word);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
