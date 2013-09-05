package assignment3;

import java.util.Scanner;

public class MatrixMult {

	static Scanner sc = new Scanner(System.in);
	
	private int a[][];
	int r,c;
	
	public MatrixMult(int r, int c){
		this.r = r;
		this.c = c;
		
		a = new int[r][c];
	}
	
	public void initArray(){
		
		System.out.println("Enter the elements of the matrix");
		
		for(int i = 0; i < r; i++){
			
			for(int j = 0; j < c; j++){
				
				a[i][j] = sc.nextInt();
				
			}
		}
	}
	
	
	
	public MatrixMult transpose(){
		MatrixMult z = new MatrixMult(c, r);
		
		for(int i = 0; i < r; i++){
			
			for(int j = 0; j < c; j++){
				
				z.a[j][i] = a[i][j];
			}
		}
		
		return z;
	}
	
	public MatrixMult mult(MatrixMult t){
		MatrixMult m = new MatrixMult(r, r);
		
		for(int i = 0; i < r; i++){
			
			for(int j = 0; j < c; j++){
				
				m.a[i][j] = 0;
				
				for(int k = 0; k < r; k++){
					m.a[i][j] += a[i][k] + t.a[j][k];
				}
				
				
			}
		}
		
		return m;
	}
	
	public void display(){
		for(int i = 0; i < r; i++){
			
			for(int j = 0; j < c; j++){
				
				System.out.print(a[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Enter r and c");
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		MatrixMult m = new MatrixMult(r, c);
		m.initArray();
		
		//MatrixMult t = m.transpose();
		MatrixMult t = new MatrixMult(c, 3);
		t.initArray();
		
		MatrixMult mult; 
		mult = m.mult(t);
		
		m.display();
		System.out.println();
		t.display();
		System.out.println();
		mult.display();
	}

}
