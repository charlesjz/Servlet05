package object;

public class Cat extends Animal{

	public static void main(String[] args) {
		
		Animal a = new Cat();
		a.eat();
		a.move();
		a.sleep();
		Cat c = (Cat)a;
		
		System.out.println(c==a);

	}

}
