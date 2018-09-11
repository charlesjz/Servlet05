package aop.from_scratch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.springframework.aop.MethodBeforeAdvice;

public class MovieInspectAdvice implements MethodBeforeAdvice {
	
	private Set<String> blockedMovies = new HashSet<String> ( );

	@Override
	public void before(Method method, Object[] parameters, Object target) throws Throwable {
		
		if ( parameters != null ) {
			if ( this.blockedMovies.contains( parameters[0] ) ) {
				System.out.println( "The movie of \"" + parameters[0] + "\" is blocked for watching." );
				throw new BlockedMovieException();
			}
		}
		
	}

	public Set<String> getBlockedMovies() {
		return blockedMovies;
	}

	public void setBlockedMovies(Set<String> blockedMovies) {
		this.blockedMovies = blockedMovies;
	}
	
}
