package aop.pointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class MyStaticPointcut implements Pointcut {
	
	private List<String> classNames = new ArrayList<String> ( );
	
	public List<String> getClassNames() {
		return classNames;
	}

	public void setClassNames(List<String> classNames) {
		this.classNames = classNames;
	}

	public void setClassFilter(ClassFilter classFilter) {
		this.classFilter = classFilter;
	}

	ClassFilter classFilter = new ClassFilter ( ) {
		@Override
		public boolean matches(Class clazz) {
			for ( String className : classNames ) {
				if ( className.equals( clazz.getName() ) ) {
					return true;
				}
			}
			return false;
		};
	};
	
	private List<String> methodNames = new ArrayList<String> ( );
	
	public List<String> getMethodNames() {
		return methodNames;
	}

	public void setMethodNames(List<String> methodNames) {
		this.methodNames = methodNames;
	}
	
	MethodMatcher methodMacher = new MethodMatcher ( ) {
		public boolean isRuntime() { return false; }
		
		public boolean matches(java.lang.reflect.Method method, Class clazz) {
			for ( String methodName : methodNames ) {
				if ( methodName.equals( method.getName() ) ) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public boolean matches(Method arg0, Class arg1, Object[] arg2) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	@Override
	public ClassFilter getClassFilter() {
		// TODO Auto-generated method stub
		return this.classFilter;
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		// TODO Auto-generated method stub
		return this.methodMacher;
	}

}
