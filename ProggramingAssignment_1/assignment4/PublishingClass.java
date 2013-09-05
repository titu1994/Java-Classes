package assignment4;

import java.util.Scanner;


class Publication
{
	private String title;
	private float price;
	
	
	public void getData(String title, float price){
		this.title = title;
		this.price = price;
	}
	
	public void putData(){
		System.out.print("Title : "+ title + " Price : "+price);
	}
	
}

class Book extends Publication{
	
	private int pageCount;
	
	public void getData(String title, float price, int pageCount){
		super.getData(title, price);
		
		this.pageCount = pageCount;
	}
	
	public void putData(){
		super.putData();
		System.out.print(" Page Count : " + pageCount);
		System.out.println();
	}
	
}

class Tape extends Publication{
	
	private float playTime;
	
	public void getData(String title, float price, float playTime){
		super.getData(title, price);
		
		this.playTime = playTime;
	}
	
	public void putData(){
		super.putData();
		
		System.out.print(" Play Time : " + playTime);
		System.out.println();
	}
	
}

class PublishingClass {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the Name of the title and the Price ");
		
		String title = sc.nextLine();
		float price = sc.nextFloat();
		
		System.out.println("Enter the page count of the book ");
		int pageCount = sc.nextInt();
		
		Book book = new Book();
		book.getData(title, price, pageCount);
		
		System.out.println("Enter the play time of the tape");
		float playTime = sc.nextFloat();
		
		Tape tape = new Tape();
		tape.getData(title, price, playTime);
		
		System.out.println("Printing Details : ");
		book.putData();
		tape.putData();
		
		
	}

}
