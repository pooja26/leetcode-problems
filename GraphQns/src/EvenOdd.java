import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Printer {
    private static Lock lock = new ReentrantLock();
    boolean isEven = false;
    private Condition condition1 = lock.newCondition();
    public void printEven(int num) {
        lock.lock();
        try {
                while(this.isEven == false){
                    //System.out.println("waiting...");
                    condition1.await();
                }
            System.out.println("Even "+num);
            this.isEven = false;
            condition1.signal();

        }catch (InterruptedException e){
                System.out.println("EXC");
        }
        finally {
            lock.unlock();
        }

    }
    public void printOdd(int num) {
        lock.lock();
        try{
            while (this.isEven) {
                //System.out.println("waiting...");
                condition1.await();
            }
            System.out.println("Odd "+num);
            this.isEven = true;
            condition1.signal();
        } catch (InterruptedException e){
            System.out.println("EXC");
        }finally {
            lock.unlock();
        }
    }
}
class Task implements  Runnable {
    private boolean isEven = false;
    private  int max;
    private Printer print;
    public Task(Printer print,int max, boolean isEven) {
        this.isEven = isEven;
        this.max = max;
        this.print = print;
    }
    @Override
    public void run() {
        int number = isEven?2:1;
        while (number<=50) {
            if(isEven){
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number+=2;

        }
    }

}
public class EvenOdd {
    public static void main(String[] args) {
        boolean isEven = true;
        Printer print = new Printer();
        Thread t1 = new Thread(new Task(print,50,true));
        Thread t2 = new Thread(new Task(print,50,false));
        t1.start();
        t2.start();
    }
}
