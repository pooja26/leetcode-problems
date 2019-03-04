import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Person{

    public void talk() {
        System.out.println("I am a person");
    }
}
class Student extends Person{

    public void talk() {
        System.out.println("I am a student");
    }
}
public class Test {
    public static void main(String[] args) {
        Person p = new Student();
        p.talk();
        Deque<Integer> q = new LinkedList<>();
        q.add(5);
        q.remove(5);
    }
}
