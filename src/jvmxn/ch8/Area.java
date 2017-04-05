package jvmxn.ch8;

public class Area {
	
	final static long ITERATIONS = 5000000000L ;
	final static long NANOS_PER_MS = (1000L * 1000L);
	final static StringBuilder sb = new StringBuilder();
	
	private static void printStats(String s , long n, long elapsedTime){
		float millis = elapsedTime / NANOS_PER_MS ;
		float rate = 0 ;
		if(millis != 0){
			rate = n / millis ;
		}
		
		System.out.println(s + ": Elapsed time in ms -> "+millis);
		System.out.println(s + ": Iterations per ms  -> "+rate);
	}
	
	private static long doTest(String str ,Shape s ,long n){
		double area = 0 ;
		long start = System.nanoTime() ;
		for(long i = 0 ; i< n ; i++){
			area = s.area() ;
		}
		long elapsedTime = System.nanoTime() - start ;
		sb.append(str).append(area);
		System.out.println(sb.toString());
		sb.setLength(0);
		return elapsedTime ;
	}
	
	public static void main(String [] args){
		String areaStr = "  Area:  ";
		Shape s = new Square(25.33);
		Shape r = new Rectangle(20.75 , 30.25);
		Shape rt = new RightTriangle(20.50,30.25);
		
		System.out.println("1st Warming up...");
		long elapsedTime = doTest(areaStr,s,ITERATIONS);
		printStats("   Square",ITERATIONS,elapsedTime );
		elapsedTime = doTest(areaStr,r,ITERATIONS);
		printStats("   Rectangle",ITERATIONS,elapsedTime );
		elapsedTime = doTest(areaStr,rt,ITERATIONS);
		printStats("   RightTriangle",ITERATIONS,elapsedTime );
		System.out.println("1st Warming up done");
		
		System.out.println("2nd Warming up...");
		elapsedTime = doTest(areaStr,s,ITERATIONS);
		printStats("   Square",ITERATIONS,elapsedTime );
		elapsedTime = doTest(areaStr,r,ITERATIONS);
		printStats("   Rectangle",ITERATIONS,elapsedTime );
		elapsedTime = doTest(areaStr,rt,ITERATIONS);
		printStats("   RightTriangle",ITERATIONS,elapsedTime );
		System.out.println("2nd Warming up done");
		
		System.out.println("Starting measurement intervals...");
		elapsedTime = doTest(areaStr,s,ITERATIONS);
		printStats("   Square",ITERATIONS,elapsedTime );
		elapsedTime = doTest(areaStr,r,ITERATIONS);
		printStats("   Rectangle",ITERATIONS,elapsedTime );
		elapsedTime = doTest(areaStr,rt,ITERATIONS);
		printStats("   RightTriangle",ITERATIONS,elapsedTime );
		System.out.println("measurement intervals done");
		
		
	}

}
