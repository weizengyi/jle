package j151s.mt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class CountDownLatchTest {
	
	static class Runner implements Callable<Integer> {
		
		private CountDownLatch begin;
		
		private CountDownLatch end;
		
		public Runner(CountDownLatch _begin , CountDownLatch _end){
			this.begin = _begin ;
			this.end = _end ;
		}

		@Override
		public Integer call() throws Exception {
			int score = new Random().nextInt(25);
			begin.await();
			TimeUnit.MILLISECONDS.sleep(score);
			end.countDown();
			return score ;
		}
		
	}
	
	@Test
	public void countDownLatchTest(){
		int num = 10 ;
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(num);
		ExecutorService es = Executors.newFixedThreadPool(num);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>> ();
		for( int i = 0 ; i < num ; i++){
			futures.add(es.submit(new Runner(begin,end))) ;
		}
		begin.countDown() ;
		try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0 ;
		
		for ( Future<Integer> f : futures){
			try {
				count += f.get() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(count / num);
	}
	

}
