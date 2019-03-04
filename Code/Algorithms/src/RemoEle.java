import java.util.ArrayList;
import java.util.List;

public class RemoEle {
    public int removeEle(int[] nums, int val) {
        int count = 0;
        int m = nums.length;
        for(int i=0;i<m;i++) {
            if(nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};

        RemoEle ele = new RemoEle();
        System.out.println(ele.removeEle(nums,2));
    }
}
