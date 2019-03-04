package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums,int target) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums,target,0);
        return res;

    }
    public void backtrack(List<List<Integer>> list,List<Integer> tempList,int[] nums,int remain,int start) {
        if(remain<0) return;
        else if(remain==0) list.add(new ArrayList<>(tempList));
        else{
            for (int i=start;i<nums.length;i++) {
                tempList.add(nums[i]);
                backtrack(list,tempList,nums,remain-nums[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        CombinationSum c = new CombinationSum();
        List<List<Integer>> list = c.combinationSum(nums,4);
        for (List<Integer> l:list){
            for (Integer i:l){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
