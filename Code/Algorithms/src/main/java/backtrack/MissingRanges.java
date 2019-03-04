package backtrack;

import java.util.*;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if(null == nums || nums.length==0) return null;
        if(nums[0]-lower>0) {
           outputToList(list,lower,nums[0]-1);
        }
        for(int i=1;i<nums.length;i++) {
            if(nums[i]-nums[i-1]>1) {
               outputToList(list,nums[i-1]+1,nums[i]-1);
            }
        }
        if(upper-nums[nums.length-1]>0) {
             outputToList(list,nums[nums.length-1]+1,upper);
        }
        return list;
    }
    public List<String> outputToList(List<String> list,int lower,int upper) {
        StringBuilder sb = new StringBuilder();
        if(lower==upper) {
            sb.append(lower);
        } else {
            sb.append(lower+"->"+upper);
        }
        list.add(sb.toString());
        return list;
    }

    public static void main(String[] args) {
        MissingRanges m = new MissingRanges();
        int nums[] = {1,2,3,5,7};
        List<String> list = m.findMissingRanges(nums,0,9);
        for(String s:list) {
            System.out.println(s);
        }
    }
}
