package atGuiGu;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

public class Lesson_18 {
	
	@Test
	public void test01() {
		LocalDateTime ldt1 = LocalDateTime.now();
		
		System.out.println("1."+ldt1);
		
		for (int i=0;i<1000000000;i++){
			i++;i--;
		}
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println("2."+ldt2);
		System.out.println("3."+ldt1.compareTo(ldt2));
		
		System.out.println("4."+ldt1.plusYears(11));
		Instant ins=Instant.now();
		System.out.println("5."+ins);
		System.out.println("6."+ins.toEpochMilli());
		LocalDateTime ldt3=ldt1.plusYears(11);
		System.out.println("7."+ldt3);
		LocalDateTime ldt4=ldt3.with(ldt1.plusYears(2));
		System.out.println("8."+ldt4);
		

	}
	
	@Test
	public void test02() {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
	
	@Test
	public void test03() {
		LocalDateTime ldt= LocalDateTime.now();
		System.out.println(ldt.plusDays(10000));

	}
	
	@Test
	public void printSomething() {
		print("John Smith", (name) -> System.out.println("Have a nice day, "+name+"."));

	}

	public void print(String str, Consumer<String> con){
		con.accept(str);
	}
}
