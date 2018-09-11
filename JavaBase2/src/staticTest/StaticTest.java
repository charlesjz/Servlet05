package staticTest;

public class StaticTest {
	static{
	    System.out.println("----Static-1----");		
	}

	public static void main(String[] args) {
		{
		System.out.println("----1----");
		Student stuA=new Student("Adam","001","adam@gmail.com");
		Student stuB=new Student("Bob","002","bob@gmail.com");
		Student stuC=new Student("Cindy ","003","cindy@gmail.com");
		
		System.out.println(stuA.id);

		}
		{
//			System.out.println(stuA.id);
		}
		{
			int w=999;
			{
				System.out.println("w="+w);
				w++;
			}
			System.out.println("w="+w);
			
		}

	}
	
	static{
	    System.out.println("----Static-2----");		
	}


}
