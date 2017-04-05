package jvmxn.ch8;

public class Rectangle implements Shape {
	
	
	final private double length ,width;
	
	public Rectangle(double length,double width){
		this.length = length ;
		this.width = width ;
	}
	
	private Rectangle(){length = width = 0;}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return length * width ;
	}

}
