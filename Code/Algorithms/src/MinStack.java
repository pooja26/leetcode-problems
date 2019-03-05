import java.util.*;

public class MinStack {
    /** initialize your data structure here. */
   private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x<=min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());




    }
}
