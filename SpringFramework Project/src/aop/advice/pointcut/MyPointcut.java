package aop.advice.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class MyPointcut implements Pointcut {
	
	private String[] classNames;
	private String[] methodNames;
	
	public String[] getClassNames() {
		return classNames;
	}

	public void setClassNames(String[] classNames) {
		this.classNames = classNames;
	}

	public String[] getMethodNames() {
		return methodNames;
	}

	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter ( ) {

			@Override
			public boolean matches(Class clazz) {
				for ( String className : classNames ) {
					if (className.equals(clazz.getName()) ) {
						return true;
					}
				}
				return false;
			}
			
		};
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return new MethodMatcher ( ) {

			@Override
			public boolean isRuntime() {
				return false;
			}

			@Override
			public boolean matches(Method method, Class Clazz) {
				for ( String methodName : methodNames ) {
					if ( methodName.equals( method.getName() ) ) {
						return true;
					}
				}
				return false;
			}

			@Override
			public boolean matches(Method arg0, Class arg1, Object[] arg2) {
				return false;
			}
			
		};
	}

}
