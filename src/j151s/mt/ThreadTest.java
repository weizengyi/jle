package j151s.mt;

public class ThreadTest {
	
	public static void main(String [] args){
		System.out.println(Thread.currentThread().getName());
		MutiThread mt = new MutiThread();
		mt.start();
	}

}
