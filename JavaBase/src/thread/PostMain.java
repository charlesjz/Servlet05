package thread;

public class PostMain {

		public static void main(String[] args) {
			PostThread postUrl1=new PostThread("Thread1");
			PostThread postUrl2=new PostThread("Thread2");
			PostThread postUrl3=new PostThread("Thread3");
				  
			postUrl1.start();
			System.out.println("111");
			postUrl2.start();
			System.out.println("222");
			postUrl3.start();
			System.out.println("333");

				  
		}
  
}