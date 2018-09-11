package aop.from_scratch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class MyPointcut implements Pointcut {
	
	private Set<String> classNames = new HashSet<String> ( );
	private Set<String> methodNames = new HashSet<String> ( );

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter ( ) {

			@Override
			public boolean matches(Class clazz) {
//				return clazz.getName().equals( "aop.from_scratch.ArtemisServiceImpl" );
				return classNames.contains( clazz.getName() );
			};
			
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
			public boolean matches(Method method, Class clazz) {
//				return method.getName().equals( "eat" );
				return methodNames.contains ( method.getName() );
			}

			@Override
			public boolean matches(Method arg0, Class arg1, Object[] arg2) {
				return false;
			}
			
		};
	}

	public Set<String> getClassNames() {
		return classNames;
	}

	public void setClassNames(Set<String> classNames) {
		this.classNames = classNames;
	}

	public Set<String> getMethodNames() {
		return methodNames;
	}

	public void setMethodNames(Set<String> methodNames) {
		this.methodNames = methodNames;
	}
	
}
