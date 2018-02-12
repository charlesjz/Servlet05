package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Timer3 {

	public static void main(String[] args) {
		Tick2 tick=new Tick2();
		tick.start();

	}

}

class Tick2{
	Timer timer=new Timer();
	int count=0;

	public void start() {
		timer.schedule(new Task(),0,1000);
		timer.schedule(new CancelTask(), 10100);
		
	}
	
	private class Task extends TimerTask{

		@Override
		public void run() {
			System.out.println(count);
			count++;
		}
		
	}
	
	private class CancelTask extends TimerTask{

		@Override
		public void run() {
			timer.cancel();
			
		}
	}
}