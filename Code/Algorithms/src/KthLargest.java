public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
        for(int i=n/2-1;i>=0;i--) {
            heapify(nums,n,i);
        }
        int i=0;
        for(i=n-1;i>k;i--) {
            int temp = nums[0];
           // res= nums[0];

            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums,i,0);
        }
        return nums[i-1];
    }
    public void heapify(int[] nums,int n,int index) {
        int largest = index;
        int l = 2*index+1;
        int r = 2*index+2;
        if(l<n && nums[l] > nums[largest]) {
            largest = l;
        }
        if(r<n && nums[r] > nums[largest]) {
            largest = r;
        }
        if(largest!=index) {
            int temp = nums[largest];
            nums[largest] = nums[index];
            nums[index] = temp;
            heapify(nums,n,largest);
        }


    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargest l = new KthLargest();
        System.out.println(l.findKthLargest(nums,2));
    }
}
