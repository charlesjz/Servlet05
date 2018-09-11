package atGuiGu;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import atGuiGu.Employee.Status;

public class lesson_02 {
	
	
	List<Employee> employees = Arrays.asList(
			new Employee("Alice", 32, 1000.00, Status.FREE),
			new Employee("Bob", 33, 1200.00, Status.BUSY),
			new Employee("Cindy", 34, 1400.00, Status.VOCATION),
			new Employee("Diana", 35, 1600.00, Status.BUSY),
			new Employee("Eric", 36, 1800.00, Status.FREE)
			);
	@Test
	public void test1(){
		System.out.println("===1");
		employees.stream().filter((emp) -> emp.getSalary()>1300)
		.limit(2)
		.forEach(System.out::println);
		employees.stream().map(Employee::getName)
		.forEach(System.out::println);
		
//		List<Employee> list= (List<Employee>) employees.stream().filter((emp) -> emp.getSalary()>1300);
		
//		Stream<Employee> stream1 = list.stream();
		
		double sum=0;
		Optional<Double> op = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(op.get());
		
		Map<String, Status> map2 = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getStatus));
		System.out.println(map2);
		
		Double sum2 = employees.stream().map(Employee::getSalary).reduce(0.0d, Double::sum);
		System.out.println(sum2);
		
//		Map<K,V> map3 = employees.stream().collect(Collectors.groupingBy(Employee::Status, Collectors.counting())).entrySet().stream()
//						.max(Map.Entry.comparingByValue()).toMap();

	}
	
}
