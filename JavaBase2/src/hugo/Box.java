package hugo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Box<T> {

	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		
		Box<Integer> box1 = new Box<>();
		box1.setData( 100 );
		
		Box<Float> box2 = new Box<>();
		box2.setData( 200.49f );
		
		Box<Long> box3 = new Box<>();
		box3.setData( 3405730857023482369l );
		
		Box<Double> box4 = new Box<>();
		box4.setData( 39472947923456345634563456345634574567236245623456245624562456245624655249593.293844563456735673524523523452356234563456356765492d );
		
		Box<String> box5 =new Box<>();
		box5.setData("Do-Re-Mi");
		
		Box<Map> box6 =new Box<>();
		Map<String,String> map1=new HashMap<>();
		map1.put("Australia", "Sydney");
		map1.put("China", "SHanghai");
		map1.put("United States", "New York");
		box6.setData(map1);
		
		Box<Set> box7 =new Box<>();
		Set<String> set1= new HashSet<>();
		set1.add("Dog");
		set1.add("Cat");
		box7.setData(set1);
		
		printData ( box1 );
		printData ( box2 );
		printData ( box3 );
		printData ( box4 );
		printData ( box5 );
		printData ( box6 );
		printData ( box7 );
	}
	

	public static void printData ( Box<?> numberBox ) {
		Object data = numberBox.getData();
		System.out.println( ("Data is: " + data ) );
	}
	
}