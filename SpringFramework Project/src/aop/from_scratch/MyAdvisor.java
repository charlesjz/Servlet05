package aop.from_scratch;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

public class MyAdvisor implements PointcutAdvisor {
	
	private Advice advice;
	private Pointcut pointcut;
	
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public void setPointcut(Pointcut pointcut) {
		this.pointcut = pointcut;
	}

	@Override
	public Advice getAdvice() {
		return this.advice;
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}

}
