package asignment2;

import java.awt.Color;


public class Fan {
	
	private static final int SLOW = 1, MEDIUM = 2, FAST = 3;
	
	private int speed = SLOW;
	private boolean isOn = false;
	private double radius = 5;
	private String color = "Blue";
	
	public Fan(){
		
	}
	
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	
	public String toString() {
		String description = "";
		
		if(isOn())
			description = "Fan Speed : " + getSpeed() + " Fan Colour : " + getColor() + " Fan Radius : " + getRadius();
		
		else
			description = "Fan Colour : " + getColor() + " Fan Radius : " + getRadius() + ". Fan is off.";
		
		return description;
	}

	public static void main(String[] args) {
		
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		
		f1.setSpeed(Fan.FAST);
		f1.setRadius(10);
		f1.setColor("Yellow");
		f1.setOn(true);
		
		f2.setSpeed(Fan.MEDIUM);
		f2.setRadius(5);
		f2.setColor("Blue");
		f2.setOn(false);
		
		System.out.println(f1);
		System.out.println(f2);
	}

}
