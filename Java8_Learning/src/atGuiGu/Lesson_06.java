package atGuiGu;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lesson_06 {

	Function <Integer, String[]> func= (x) -> new String[x];
    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
//    R apply(T t);

	Consumer<Integer>con = x->System.out.println(x); 
    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
//    void accept(T t);
	
	Supplier<Employee> sup = Employee::new;
    /**
     * Gets a result.
     *
     * @return a result
     */
//    T get();
	BiFunction<Integer, Integer, Integer> bif = (x,y) -> x*y;
	
	
	
	
	

}
