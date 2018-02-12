package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Timer1 {
	public static void main(String[] args) {
		Clock clock = new Clock();//创建倒计时钟
		clock.start(10);//开始10秒的倒计时
	}
}
class Clock{//倒计时时钟，包含方法：开始倒计时
	Timer timer = new Timer();
	int sec;//内部类可以共享外部类资源sec
	public void start(int sec){//开始倒计时的方法
		this.sec = sec;
		timer.schedule(new Task(), 0, 1000);
		timer.schedule(new CancelTask(), 1000*sec+100);
	}
	private class CancelTask extends TimerTask{
		public void run(){timer.cancel();};
	}
	private class Task extends TimerTask{//内部类
		public void run() {System.out.println(sec--);}
	}
}