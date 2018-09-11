package aop.pointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

public class MyAdvisor implements PointcutAdvisor {
	
	private Advice advice;
	private Pointcut pointcut;

	@Override
	public Advice getAdvice() {
		// TODO Auto-generated method stub
		return this.advice;
	}

	@Override
	public boolean isPerInstance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pointcut getPointcut() {
		// TODO Auto-generated method stub
		return this.pointcut;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public void setPointcut(Pointcut pointcut) {
		this.pointcut = pointcut;
	}
	
	

}
