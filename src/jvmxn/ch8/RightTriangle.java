package jvmxn.ch8;

public class RightTriangle implements Shape {
	
	final private double base ,height;
	
	public RightTriangle(double base ,double height){
		this.base = base ;
		this.height = height ;
	}

	private RightTriangle(){base = height = 0 ;}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0.5 * base * height;
	}

}
