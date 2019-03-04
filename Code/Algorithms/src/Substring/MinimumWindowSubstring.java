package Substring;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            hmap.put(t.charAt(i),hmap.getOrDefault(t.charAt(i),0)+1);
        }
        int counter=hmap.size();
        int end=0,begin=0,len=Integer.MAX_VALUE;
        String ans="";
        while (end<s.length()) {
            char c = s.charAt(end);
            if(hmap.containsKey(c)) {
                hmap.put(c,hmap.get(c)-1);
                if(hmap.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            while(counter==0) {
                if(end-begin<len){
                    len=end-begin;
                    ans=s.substring(begin,end);
                }
                if(hmap.containsKey(s.charAt(begin))){
                    hmap.put(s.charAt(begin),hmap.getOrDefault(s.charAt(begin),0)+1);
                    if(hmap.get(s.charAt(begin)) > 0) counter++;
                }
                begin++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("AAAC","AC"));
    }
}
