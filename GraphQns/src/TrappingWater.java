import java.util.ArrayList;
import java.util.List;

public class TrappingWater {

    public static int getSum(int[] height) {

        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0]=height[0];
        for(int i=1;i<height.length;i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }

        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2;i>=0;i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        for(int i=0;i<height.length;i++) {
            sum+=Math.min(left[i],right[i])-height[i];
        }
        return sum;

    }

    public static void main(String args[]) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getSum(height));
    }
}
