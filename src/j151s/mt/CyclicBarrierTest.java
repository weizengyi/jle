package j151s.mt;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.testng.annotations.Test;

public class CyclicBarrierTest {
	
	static class Worker implements Runnable{

		private CyclicBarrier cb ;
		
		public Worker(CyclicBarrier _cb){
			this.cb = _cb ;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(new Random().nextInt(1000));
				System.out.println(Thread.currentThread().getName() + " - arrived");
				try {
					cb.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(2,new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("transparent");
				
			}
			
		}
		);
		
		new Thread(new Worker(cb),"worker-1").start() ;
		new Thread(new Worker(cb),"worker-2").start() ;
	}

}
