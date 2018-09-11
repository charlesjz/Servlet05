package generics;

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
		Box<Number> box2 = new Box<>();
		box2.setData( 200 );
		
		printData ( box2 );
		printData ( box1 );
	}
	
	public static void printData ( Box<Number> numberBox ) {
		Number data = numberBox.getData();
		System.out.println( ("Data is: " + data ) );
	}
	
}
