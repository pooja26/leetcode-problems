package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WordNode{
    String word;
    int numSteps;

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(null == beginWord || null == endWord) {
            return 0;
        }
        if(!wordList.contains(endWord)) return 0;
        Queue<WordNode> q = new LinkedList<>();
        q.add(new WordNode(beginWord, 1));
        while(!q.isEmpty()) {
            WordNode temp = q.poll();
            if (temp.word.equals(endWord)) return temp.numSteps;
            char chars[] = temp.word.toCharArray();
            for(int i=0;i<chars.length;i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char old = chars[i];
                    chars[i] = ch;
                    String s = new String(chars);
                    if(wordList.contains(s)) {
                        q.add(new WordNode(s, temp.numSteps+1));
                        wordList.remove(s);
                    }
                    chars[i]=old;
                }
            }
        }
        return 0;
    }
    boolean isAdjacent(String a, String b) {
        if(null == a || null == b) {
            return false;
        }
        int count=0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)!=b.charAt(i))
            {
                count++;
                if(count>1) return false;
            }
        }
        return count==1?true:false;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println(w.ladderLength("hit","cog",list));
    }
}
