package jvmxn.ch8;

public class WarmUpExample {
	
	public static void main(String[] args){
		int warmUpCycles = 1000000 ;
		int testCycles = 500000000;
		long nanoaPerIteration = 0L;
		WarmUpExample se = new WarmUpExample();
		System.out.println("warm up start");
		nanoaPerIteration = se.runTest(warmUpCycles);
		System.out.println("warm up end");
		System.out.println("warm up nanoaPerIteration:"+nanoaPerIteration);
		System.out.println("test start");
		nanoaPerIteration = se.runTest(testCycles);
		System.out.println("test end");
		System.out.println("test nanoaPerIteration:"+nanoaPerIteration);
	}
	
	private long runTest(int iterations){
		long startTime = System.nanoTime();
		long sum = 0;
		for(int i = 1 ; i < iterations ; i++ ){
			sum = sum * i ;
			sum = sum / i ;
		}
		long elapsedTime = System.nanoTime();
		return (elapsedTime - startTime)/iterations;
	}

}
