package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PolarCoordinates {
	
	double r,t;
	
	public void set(double r, double t){
		this.r = r;
		this.t = t;
	}
	
	
	public String toString() {
		
		return "The Polar Coordinates are : " +r + " and "+ t;
	}
	
	public PolarCoordinates add(PolarCoordinates k){
		
		PolarCoordinates a = new PolarCoordinates();
	
		double x1,x2,y1,y2;
		double finalX, finalY, finalR, finalT;
		
		this.t = Math.toRadians(this.t);
		k.t = Math.toRadians(k.t);
		
		x1 = this.r * Math.cos(this.t);
		x2 = k.r * Math.cos(k.t);
		
		y1 = this.r * Math.sin(this.t);
		y2 = k.r * Math.sin(k.t);
		
		finalX = x1 + x2;
		finalY = y1 + y2;
		
		finalR = Math.sqrt((finalX * finalX) + (finalY * finalY));
		finalT = Math.toDegrees(Math.atan2(finalY, finalX));
		
		a.set(finalR, finalT);
		
		return a;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		double tempR,tempT;
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		PolarCoordinates a1 = new PolarCoordinates();
		PolarCoordinates a2 = new PolarCoordinates();
		
		System.out.println("Enter the values of R and Theta in degrees for the first polar coordinate ");
		
		try{

			tempR = Double.parseDouble(bb.readLine());
			tempT = Double.parseDouble(bb.readLine());
			
			a1.set(tempR, tempT);
		}catch(NumberFormatException e){
			
		}
		
		System.out.println("Enter the values of R and Theta in degrees for the second polar coordinate ");
		
		try{

			tempR = Double.parseDouble(bb.readLine());
			tempT = Double.parseDouble(bb.readLine());
			
			a2.set(tempR, tempT);
			
		}catch(NumberFormatException e){
			
		}
		
		PolarCoordinates z = a1.add(a2);
		
		System.out.println(z);
	}

}
