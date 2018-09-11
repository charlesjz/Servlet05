package atGuiGu;

import java.util.stream.LongStream;

import org.junit.Test;

public class Lesson_14 {

	@Test
	public void test01(){
		String l=LongStream.rangeClosed(0, 100000000000L)
		.parallel()
		.reduce(Long::sum).toString();
		System.out.println(l);
	}
}
