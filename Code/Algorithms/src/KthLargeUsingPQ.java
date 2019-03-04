import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargeUsingPQ {
    public int getKthLargset(int[] nums,int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pQueue.add(nums[i]);
        }
        int res=0;
        for(int i=0;i<k;i++) {
            res=pQueue.poll();
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        KthLargeUsingPQ p = new KthLargeUsingPQ();
        System.out.println(p.getKthLargset(nums,2));

    }
}
