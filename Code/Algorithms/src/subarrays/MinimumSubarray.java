package subarrays;

public class MinimumSubarray {
    public int getMinSubArray(int[] arr,int k) {
        int min=Integer.MAX_VALUE;
        for (int i=0;i<arr.length-1;i++) {
            int currSum=arr[i];
            if(currSum==k)
                return 1;
            for (int j=i+1;j<arr.length;j++) {
                currSum+=arr[j];
                if (currSum==k) {
                    int start=i;
                    int end=j;
                        min=Math.min(min,j-i+1);
                } else if(currSum>k) break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumSubarray m = new MinimumSubarray();
        int[] arr = {1,2,3,4,5};
        System.out.println(m.getMinSubArray(arr,9));
    }
}
