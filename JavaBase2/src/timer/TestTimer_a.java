package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer_a extends TimerTask {
    @Override
        public void run() {
            System.out.println(new Date().toString());
        }

    public static void main(String[] args) {
        Timer timer = new Timer("hello");
        timer.schedule(new TestTimer_a(), 1000L, 2000L);
    }
}