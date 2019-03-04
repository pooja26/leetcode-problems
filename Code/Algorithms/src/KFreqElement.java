import javafx.scene.layout.Priority;

import java.util.*;

public class KFreqElement {
    public List<Integer> getFreq(int[] nums,int k) {
        List<Integer> res;
        res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> q= new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            q.add(entry);
        }
        while (res.size()<k) {
            res.add(q.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        KFreqElement k = new KFreqElement();
        List<Integer> list = k.getFreq(nums,2);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
