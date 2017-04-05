package jvmxn.ch8;

public class DeadCode3 {
	
	final private static long NANOS_PER_MS = 1000000L ;
	
	final private static int NUMBER = 25 ;
	
	private static int calcFibonacci(int n ){
		int result = 1 ;
		int prev = -1 ;
		int sum = 0 ;
		for(int i = 0 ; i <= n ;i++){
			sum = prev + result ;
			prev = result ;
			result = sum ;
		}
		return result ;
	}
	
	private static void doTest(long iterations){
		long startTime = System.nanoTime() ;
		int answer = 0  ;
		for(long i = 0 ; i<iterations ; i++ )
			answer = calcFibonacci(NUMBER);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Elapsed nanos ->" + elapsedTime);
		System.out.println("answer ->" + answer);
		float millis = elapsedTime / NANOS_PER_MS ;
		float itrsPerMs = 0 ;
		if(millis != 0)
			itrsPerMs = iterations / millis ;
		System.out.println("Iteration per ms ->" + itrsPerMs);
	}
	
	public static void main(String[] args){
		System.out.println("Warm up 1st ...");
		doTest(1000000L);
		System.out.println("Warm up 1st done");
		System.out.println("Warm up 2nd ...");
		doTest(9000000L);
		System.out.println("Warm up 2nd done");
		System.out.println("starting measurement interval...");
		doTest(9000000000L);
		System.out.println("starting measurement interval done");
		System.out.println("Test completed");
		
	}

}
