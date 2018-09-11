package Chapter21;

//	class SequenceTest {
//    private int number = 1;
//
//    Lock lock = new ReentrantLock();
//
//    Condition condition1 = lock.newCondition();
//    Condition condition2 = lock.newCondition();
//    Condition condition3 = lock.newCondition();
//
//    public void loopA(int loopNum) {
//        lock.lock();
//        try {
//            while (number != 1) {
//                condition1.await();
//            }
//
//            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
//            number = 2;
//            condition2.signal();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void loopB(int loopNum) {
//        lock.lock();
//        try {
//            while (number != 2) {
//                condition2.await();
//            }
//
//            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
//            number = 3;
//            condition3.signal();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void loopC(int loopNum) {
//        lock.lock();
//        try {
//            while (number != 3) {
//                condition3.await();
//            }
//
//            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
//            number = 1;
//            condition1.signal();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//}

public class ThreadsSequenceTest {

    public static void main(String[] args) {
        SequenceTest st = new SequenceTest();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    st.loopA(i);
            }
        }, "A").start();
        
        

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    st.loopB(i);
            }
        }, "B").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    st.loopC(i);
            }
        }, "C").start();
    }
}