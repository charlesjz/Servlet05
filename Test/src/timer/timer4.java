package timer;

import java.util.Timer;
import java.util.TimerTask;

public class timer4 {

	public static void main(String[] args) {
		Tick4 tick=new Tick4();
		tick.start("0");
		
	}

}

class Tick4{

	Timer timer=new Timer();
	int counter4=0;
	String Tr="";
	public void start(String tr) {
		Tr=tr;
		timer.scheduleAtFixedRate (new Task1(), 0,20);
		timer.scheduleAtFixedRate(new Task2(), 0,40);
		timer.schedule(new CancelTask(), 10010);
	}
	
	private class Task1 extends TimerTask{

		@Override
		public void run() {
			System.out.println("1..");
		}
		
	}
	
private class Task2 extends TimerTask{

	@Override
	public void run() {
		System.out.println("2..");

	}
	
}

	private class CancelTask extends TimerTask{

		@Override
		public void run() {
			timer.cancel();
			System.out.println("Stopped!");
			
		}
		
	}
}