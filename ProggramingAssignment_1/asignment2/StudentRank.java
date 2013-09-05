package asignment2;

import java.util.Scanner;

public class StudentRank {

	static Scanner sc =  new Scanner(System.in);
	
	private String name;
	private long rollNo;
	private double per;
	
	private static int rank[];
	
	private static int pos = -1;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}

	public static void sort(StudentRank[] a){
		double temp;
		int c = a.length;
		
		for(int i = 0; i < c; i++){
			for(int j = 0; j < c - 1 ; j++){
				
				if(a[j + 1].getPer() > a[j].getPer()){
					temp = a[j].getPer();
					a[j].setPer(a[j+1].getPer());
					a[j+1].setPer(temp);
				}
			}
		}
		
		
		
	}
	
	
	public static void calculateRank(StudentRank a[]){
		
		rank = new int[a.length];
		
		for(int i = 0,j = 1; i < a.length -1 ; i++){
			
			if(a[i].getPer() != a[i+1].getPer()){
				j = i;
				rank[i] = ++j;
				
			}
			else{
				rank[i] = ++j; 
				j--;
				
			}
			
			
		}
		
		rank[a.length - 1] = rank[a.length - 2] + 1;
	}
	
	
	
	public static int[] getRank() {
		
		return rank;
	}

	public String toString() {
		
		String s = "Student Name : " + getName() + " Roll no : " + getRollNo() + " Percentage : " + getPer()+ " Rank : " + StudentRank.getRank()[++pos];
		
		return s;
	}



	public static void main(String[] args) {
		
		int n = 0;
		
		System.out.println("Enter the no of Students : ");
		n = sc.nextInt();
		
		StudentRank arr[] = new StudentRank[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the Name, Roll No and the Percentage of student " + (i+1));
			
			arr[i] = new StudentRank();
			
			arr[i].setName(sc.next());
			arr[i].setRollNo(sc.nextLong());
			arr[i].setPer(sc.nextDouble());
		}
		
		StudentRank.sort(arr);
		StudentRank.calculateRank(arr);
		
		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
		}
	}

}
