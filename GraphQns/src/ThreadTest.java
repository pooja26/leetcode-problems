import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static Lock lock = new ReentrantLock();
    private int count = 0;
    public int accessResource() {
        lock.lock();
      try {
          count++;
          System.out.println(count + " " + lock);
        } finally {
          lock.unlock();
      }
      return count;
    }
    public static void main(String[] args) {
        ThreadTest count = new ThreadTest();
        Thread t1 = new Thread(){
                @Override
                public void run() {
                    while (count.accessResource() < 6) {
                        try{
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

         };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (count.accessResource() < 6) {
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        t1.start();
        t2.start();
    }
}
