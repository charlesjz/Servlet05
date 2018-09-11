package javatimer;

import java.util.TimerTask;

public class AuthCreditTask extends TimerTask {

	@Override
	public void run() {

		new Sample6e().checkCredit();

	}

}
