package Substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcat {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int window_size=0;
        for(String word:words) {
            window_size+=word.length();
            hmap.put(word,hmap.getOrDefault(word,0)+1);
        }
        int word_size=words[0].length();
        int begin=0,end=0;
        String ans="";int count=hmap.size();
        List<Integer> response = new ArrayList<>();
        for(int i=0;i<word_size;i++) {
            begin=i;
            end=i;
            while (end+word_size-1<s.length()) {
                ans = s.substring(end, end + word_size);
                if(hmap.containsKey(ans)) {
                    hmap.put(ans,hmap.get(ans)-1);
                    if(hmap.get(ans)==0) count--;
                }
                if(end+word_size-begin==window_size) {
                    if(count==0) {
                        response.add(begin);
                    }

                    String firstword=s.substring(begin, begin + word_size);
                    if(hmap.containsKey(firstword)) {
                        hmap.put(firstword,hmap.getOrDefault(firstword,0)+1);
                        if(hmap.get(firstword)>0) count++;
                    }
                    begin+=word_size;
                }
                end+=word_size;
            }

        }
        return  response;
    }
    public static void main(String[] args) {
        /**
         * worldbar
         *
         * end 4 word_size 3
         */
        SubstringConcat s = new SubstringConcat();
        String[] strings = {"foo","bar"};
        List<Integer> list =s.findSubstring("barfoothefoobarman",strings);
        for(Integer i:list) {
            System.out.println(i);
        }
    }
}
