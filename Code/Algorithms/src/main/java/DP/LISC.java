package main.java.DP;

public class LISC {
    public int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int[] lisc = new int[nums.length];
        for(int i=0;i<nums.length;i++ ) {
            lisc[i] = 1;
        }
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j] && lisc[i]<lisc[j]+1) {
                    lisc[i] = lisc[j]+1;
                }
            }
        }
        int max = lisc[0];
        for(int i=1;i<nums.length;i++) {
            if(max<lisc[i]) max = lisc[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LISC l = new LISC();
        int nums[] = {5,5};
        System.out.println(l.lengthOfLIS(nums));
    }
}
