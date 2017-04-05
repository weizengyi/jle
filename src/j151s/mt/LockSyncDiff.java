package j151s.mt;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.testng.annotations.Test;

public class LockSyncDiff {
	
	class Task{
		public void doSomeThing(){
			System.out.println("***********  thread:" +Thread.currentThread().getName());
			for(int i = 0 ; i < 10000 ;)
				i++;
			StringBuffer sb = new StringBuffer();
			sb.append("Thread-name:"+Thread.currentThread().getName());
			sb.append(" time:"+Calendar.getInstance().get(13)+" s");
			System.out.println(sb);
		}
	}
	
	class TaskWithLock extends Task implements Runnable{
		private final Lock privateLock = new ReentrantLock();

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				privateLock.lock();
				doSomeThing();
			}finally{
				privateLock.unlock();
			}
		}
	}
	
	
	
	class TaskWithSync extends Task implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized("A"){
				doSomeThing();
			}
		}
	}
	
	
	public static void runTask(Class<? extends Runnable> clz) throws Exception{
		ExecutorService es = Executors.newCachedThreadPool() ;
		System.out.println("***thread:" +Thread.currentThread().getName()+" start " + clz.getSimpleName() + " task ***");
	    es.submit(clz.newInstance());
	    TimeUnit.SECONDS.sleep(10);
		System.out.println("------" + clz.getName() +" finashed");
		es.shutdown() ;
		
	}
	
	
	
	
	@Test
	public void testLockAndSyncDiff(){
		try {
			runTask(TaskWithLock.class);
			runTask(TaskWithSync.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
