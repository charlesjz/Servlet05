package atGuiGu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import atGuiGu.Employee.Status;


public class lesson_12 {
	
	
	List<Employee> employees = Arrays.asList(
			new Employee("Alice", 32, 1000.00, Status.FREE),
			new Employee("Bob", 33, 1200.00, Status.BUSY),
			new Employee("Cindy", 34, 1400.00, Status.VOCATION),
			new Employee("Diana", 35, 1600.00, Status.BUSY),
			new Employee("Eric", 36, 1800.00, Status.FREE)
			);
	
	@Test
	public void test1(){
		int x=0;
		//1.print out empolyees' age older than 35
		Stream stream = employees.stream().filter((e)->{
														System.out.println("abcdefg");
														return e.getAge()>35;
														});
		
		System.out.println("===1===");
		stream.forEach(System.out::println);
		
		//2.print out all of employees' names
		System.out.println("===2===");
	
		List <String> list = employees.stream()
				.map(Employee::getName).collect(Collectors.toList());
		list.forEach(System.out::println);
		
		//3. print out total number of employees		
		System.out.println("===3===");

		Long count = employees.stream().collect(Collectors.counting());
		System.out.println(count);
		
		//4. print out average salary
		System.out.println("===4===");

		Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		//5. print out summary salary of all employees
		System.out.println("===5===");
		Double sum = (Double) employees.stream()
				.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		//6. print all employees' name
		System.out.println("===6===");
		List<String> list2 = employees.stream().map(Employee::getName).collect(Collectors.toList());
		list.forEach(System.out::println);
		
		Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(max.get());
		
		Optional<Double> min = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
		System.out.println(min.get());
		
		Map<Status, List<Employee>> map = 
				employees.stream()
				.collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
		Map<Status, Map<Object, List<Employee>>> map1 =
				employees.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) ->{
					if(((Employee) e).getAge() <=35){
						return "YOUTH";
					}else if(((Employee) e).getAge() <=50){
						return "MID-AGE";
					}else{
						return "SENIOR";
					}
				})));
		System.out.println(map1);
		
	}
	
	
	@Test
	public void test8(){
		System.out.println("------------");
		Map<Boolean, List<Employee>> map2= employees.stream()
				.collect(Collectors.partitioningBy(e->e.getSalary()>1400));
		System.out.println(map2);	
		
		System.out.println("------------");

	Map<String, Double> wagelist =
			employees.stream()
			.filter(x ->x.getSalary()>1200)
			.collect(Collectors.toMap(Employee::getName,Employee::getSalary));
	wagelist.forEach((k,v)-> System.out.println(k+","+v));

	}
	
	


	
}
