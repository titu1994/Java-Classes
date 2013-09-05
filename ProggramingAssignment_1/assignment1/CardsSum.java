package assignment1;

public class CardsSum {

	
	public static void main(String[] args) {

		int cards[] = {1,2,3,4,5,6,7,8,9,10,11,12,13
					  ,1,2,3,4,5,6,7,8,9,10,11,12,13
					  ,1,2,3,4,5,6,7,8,9,10,11,12,13
					  ,1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		int noOfCards = cards.length;
		
		int c1,c2,c3,c4, count = 0;
		
		for(int i = 0; i < noOfCards; i++){
			for(int j = i ; j < noOfCards; j++){
				for(int k = j ; k < noOfCards; k++){
					for(int l = k ; l < noOfCards; l++){
						
						c1 = cards[i];
						c2 = cards[j];
						c3 = cards[k];
						c4 = cards[l];
						
						if(c1 + c2 + c3 + c4 == 24){
							count++;
						}
						
					}
				}
			}
		}
		
		System.out.println("The no of cards which give the sum as 24 is : " + count);
	}

}
