package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Timer2 {
	public static void main(String[] args) {
		Tick tick= new Tick();
		tick.start();
	}

}

class Tick{
	Timer timer=new Timer();
	int counter=0;


    public void start() {
    	timer.schedule(new Task(),0,1000);
    	timer.schedule(new CancelTask(),10010);
	
    }
    
    private class Task extends TimerTask{
    	public void run(){
    		System.out.println(counter);
    		counter++;
    	}
    }
    
    private class CancelTask extends TimerTask{
    	public void run(){
    		timer.cancel();
    	}

    }
}