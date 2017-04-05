package j151s.mt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class AsynCompute {
	
	
	@Test
	public void testAsynCompute(){
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(new TaxCalculator(100) );
		while(!future.isDone()){
			try {
				TimeUnit.MILLISECONDS.sleep(100L);
				System.out.print(">");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println("\n finished, tax :" + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
	}
	
	class TaxCalculator implements Callable<Integer> {
		
		private int seedMoney ;
		
		public TaxCalculator(int _seedMoney){
			this.seedMoney = _seedMoney ;
		}

		@Override
		public Integer call() throws Exception {
			TimeUnit.MILLISECONDS.sleep(10000L);
			return seedMoney / 10;
		}
		
	}

}
