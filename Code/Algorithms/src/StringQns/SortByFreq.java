package StringQns;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFreq {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        q.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            Map.Entry<Character,Integer> m = q.poll();
            for(int i=0;i<m.getValue();i++) {
                sb.append(m.getKey());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        SortByFreq f = new SortByFreq();
        System.out.println(f.frequencySort("tree"));
    }
}
