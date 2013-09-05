package asignment5;

import java.io.IOException;

public class ConsoleArgsTypeCounter {
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		
		ConsoleArgsTypeCounter c = new ConsoleArgsTypeCounter();
		
		TypeChecker checker = c.new TypeChecker();
		
		checker.countType(args);
		
		System.out.println("No of Integers is : "+checker.intCount+"\nNo of Double : "+checker.doubleCount+"\nNo of Strings : "+checker.stringCount);
		
	}
	
	
	
	public class TypeChecker{
		
		private int intCount = 0, doubleCount = 0, stringCount = 0;
		private boolean isInteger, isDouble;
		
		public void countType(String args[]){
			
			int cArrLength;
			
			int argsLength = args.length;
			
			char cArr[];
			
			for(int i = 0; i < argsLength; i++){
				
				args[i] = args[i].replaceAll(" ", "");
				
				cArr = args[i].toCharArray();
				
				boolean earlierDotExists = false;
				cArrLength = cArr.length;
				
				for(int j = 0; j < cArrLength; j++){
					
					if( cArr[j] == '.' && !earlierDotExists){	
						
						isDouble = true;
						isInteger = false;
						earlierDotExists = true;
						
					}
					else if(earlierDotExists && !isDouble){
						isDouble = false;
						isInteger = false;
						break;
					}
					
					if(!isDouble && Character.isDigit(cArr[j]) ){
						isInteger = true;
					}
					else{
						isInteger = false;
					}
					
					if(!Character.isDigit(cArr[j]) && cArr[j] != '.' ){
						isInteger = false;
						isDouble = false;
						break;
					}
				}
				
				
					
				
				if(isInteger)
					intCount++;
				else if(isDouble)
					doubleCount++;
				else
					stringCount++;
				
				isDouble = false;
				isInteger = false;
				
				
			}
		}
	}
}
