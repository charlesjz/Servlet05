package testAll;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestSetRetainAll {
	
//	@Test
//    public void testRemoveAll(){
//        Set<Integer> set1=new HashSet<>();
//        for(int i=0;i<30000;i++){
//        	set1.add(i*400);
//        }
//
//        Set<Integer> set2=new HashSet<>();
//        for(int i=0;i<11727755;i++){
//        	set2.add(i);
//        }
//
//      Set<Integer> set = new HashSet<>();
//      
//      System.out.println("====求交集===");
//      set.addAll(set1);
//      set.retainAll(set2);
//	  set.stream().forEach(System.out::println);
//
//	  System.out.println("====求差集===");
//      set = new HashSet<>();
//      set.addAll(set1);
//	  set.removeAll(set2);
//	  set.stream().forEach(System.out::println);
//    }
//	
	@Test
    public void testRemoveAll2(){
		System.out.println("===Test 2===");
		
		Instant ins1=Instant.now();
		
		Set<String> set1=new HashSet<>();
        for(int i=0;i<30000;i++){
        	set1.add("A"+i*400);
        }
		Instant ins2=Instant.now();
		
		Duration dur1 = Duration.between(ins1, ins2);
		System.out.println("----------------------------timer----------------------------");
		System.out.println(dur1.getNano());

        Set<String> set2=new HashSet<>();
        for(int i=0;i<11727755;i++){
        	set2.add("A"+i);
        }
		Instant ins3=Instant.now();
		Duration dur2 = Duration.between(ins2, ins3);
		System.out.println("----------------------------timer----------------------------");
		System.out.println(dur2.getNano());

      Set<String> set = new HashSet<>();
      
      System.out.println("====求交集===");
      set.addAll(set1);
      set.retainAll(set2);
	  set.stream().forEach(System.out::println);

		Instant ins4=Instant.now();
		Duration dur3 = Duration.between(ins4, ins3);
		System.out.println("----------------------------timer----------------------------");
		System.out.println(dur3.getSeconds());
		System.out.println(dur3.getNano());

	  System.out.println("====求差集===");
      set = new HashSet<>();
      set.addAll(set1);
	  set.removeAll(set2);
	  set.stream().forEach(System.out::println);

	  Instant ins5=Instant.now();
		Duration dur4 = Duration.between(ins1, ins5);
		System.out.println("----------------------------timer----------------------------");
		System.out.println(dur4.getSeconds());
		System.out.println(dur4.getNano());

	  
	}

}
