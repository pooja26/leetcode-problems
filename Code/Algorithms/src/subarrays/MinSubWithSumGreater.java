package subarrays;

public class MinSubWithSumGreater {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length,currSum=0,minLen=Integer.MAX_VALUE;
        int start=0 ,end=0;
        while(end<n) {
            currSum+=nums[end++];
            while (currSum>=s) {
                minLen=Math.min(minLen,end-start);
                currSum-=nums[start++];
            }
        }
        return minLen;
    }
    public static void main(String[] args) {
        MinSubWithSumGreater m = new MinSubWithSumGreater();
        int[] arr = {2,3,1,2,4,3};
        System.out.println(m.minSubArrayLen(9,arr));
    }
}
