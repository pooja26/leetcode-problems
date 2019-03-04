package backtrack;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> getSubset(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(), nums,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums,int start) {
        res.add(new ArrayList<>(tempList));
        for (int i=start;i<nums.length;i++) {
            tempList.add(nums[i]);
            backtrack(res,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        PowerSet p = new PowerSet();
        List<List<Integer>> list = p.getSubset(nums);
        for (List<Integer> l:list){
            for (Integer i:l){
                System.out.print(i);
            }
            System.out.println();
        }

    }
}
