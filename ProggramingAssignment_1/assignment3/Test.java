package assignment3;

public class Test {

	
	public static void main(String args[]){
		
		char a[] = {'a','b','c','d'};
		String  s = new String(a);
		
		boolean b = true;
		
		for(int i = 1; i < s.length(); i++){
			b&=(a[i-1] == s.charAt(i));
		}
		
		System.out.println(b);
	}

}
