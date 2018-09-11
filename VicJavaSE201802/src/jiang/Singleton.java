package jiang;

public class Singleton {

	private volatile static Singleton instance;
	private static final Object mtx = new Object ( );

    private Singleton(){}

    public synchronized static Singleton getInstance(){
    	Singleton _ins = instance;
    	if ( _ins == null ) {
    		synchronized (mtx ) {
    			_ins = instance;
    			if(_ins == null){
    				_ins = instance = new Singleton();
    			}
			}
    	}
        return _ins;
    }
    
    public static void main(String[] args) {
    	
    	
    	try {
        	Singleton obj1 = Singleton.getInstance();
//			Singleton obj2 = (Singleton) ClassLoader.getSystemClassLoader().loadClass( "Singleton" ).newInstance();
        	Singleton obj2 = Singleton.class.newInstance();
        	Singleton obj3 = Singleton.class.newInstance();
			System.out.println( obj1 == obj2 );
			System.out.println( obj1 + " " +  obj2 + " " +  obj3 );
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
