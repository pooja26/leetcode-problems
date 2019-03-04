import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public int[] sliding(int[] nums,int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i=0;i<k;i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.removeLast();
            q.addLast(i);
        }
        int c=0;
        res[c++] = nums[q.peek()];
        for (;i<nums.length;i++) {
            while (!q.isEmpty() && q.peek() <= i-k)
                q.removeFirst();
            while (!q.isEmpty() && nums[i]>=nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
            res[c++] = nums[q.peek()];
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1,3,1,2,0,5};
        SlidingWindowMax m = new SlidingWindowMax();
        int[] res = m.sliding(nums,3);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
