package jiang;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		super ( name );
	}
	
	@Override
	public void run() {
		System.out.println( getName() + " runs." );
	}
	
	public static void main(String[] args) {
		
		MyThread thread1 = new MyThread ( "Thread #1" );
		MyThread thread2 = new MyThread ( "Thread #2" );
		MyThread thread3 = new MyThread ( "Thread #3" );
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
