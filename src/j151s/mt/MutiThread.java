package j151s.mt;

public class MutiThread extends Thread{
	
	/**不能复写start
	@Override
	public void start(){
		run();
	}
	**/
	
	
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"sdf");
	}

}
