package jvmxn.ch8;

public class Square implements Shape {
	
	final private double side ;

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return side * side;
	}
	
	public Square(){side = 0;}

	public Square(double s) {
		// TODO Auto-generated constructor stub
		this.side = s;
	}
	

}
