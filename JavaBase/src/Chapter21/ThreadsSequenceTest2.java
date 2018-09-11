package Chapter21;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

	class SequenceTest {
    private int token = 1;

    Lock lock = new ReentrantLock();

    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(int loopNum) {
        lock.lock();
        try {
            while (token != 1) {
                condition1.await();
            }

            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
            token = 2;
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int loopNum) {
        lock.lock();
        try {
            while (token != 2) {
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
            token = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int loopNum) {
        lock.lock();
        try {
            while (token != 3) {
                condition3.await();
            }

            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
            token = 1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadsSequenceTest2 {

    public static void main(String[] args) {
        SequenceTest st = new SequenceTest();

        new Thread(() -> IntStream.range(0,10).forEach(i -> st.loopA(i)), "A").start();
        new Thread(() -> IntStream.range(0,10).forEach(i -> st.loopB(i)), "B").start();
        new Thread(() -> IntStream.range(0,10).forEach(i -> st.loopC(i)), "C").start();
        
     }
}