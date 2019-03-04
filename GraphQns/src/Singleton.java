class Test {
    private volatile static Test obj;
    private Test(){}
    public static Test getInstance() {
        if(null == obj)
            synchronized (Test.class) {
                if(null == obj) {
                    System.out.println("Inside lock...");
                    obj = new Test();
                }
            }
        return obj;
    }
}


public class Singleton implements Runnable {
    public static void main(String[] args) {

    }

    @Override
    public void run() {

    }
}
