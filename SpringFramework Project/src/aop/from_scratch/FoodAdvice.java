package aop.from_scratch;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class FoodAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] parameters, Object target) throws Throwable {

		// I could specify which class/method(s) are affected by this advice. However, I would rather
		// to define separate PointCuts for this purpose.
//		if ( target.getClass().getName().equals( "aop.from_scratch.ArtemisServiceImpl" )
//				&& method.getName().equals( "eat" ) ) {
			int leftOver = (int) returnValue;
			if ( leftOver > 50 ) {
				System.out.println( "[FoodAdvice] Eat too little." );
			} else {
				System.out.println( "[FoodAdvice] Eat well." );
			}
//		}
		
	}

}
