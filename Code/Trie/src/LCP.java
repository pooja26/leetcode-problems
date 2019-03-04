public class LCP {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str: strs) {
            addWord(str, trie);
        }
        if (trie.isEnd) {
            return "";
        }
        return searchSingleChildLevel(trie);
    }

    private void addWord(String s, Trie trie) {
        for (int i=0; i<s.length(); i++) {
            if (trie.children[s.charAt(i) - 'a'] == null) {
                trie.children[s.charAt(i) - 'a'] = new Trie();
            }
            trie = trie.children[s.charAt(i) - 'a'];
        }
        trie.isEnd = true;
    }

    private String searchSingleChildLevel(Trie trie) {
        String ans = "";
        boolean flag = true, end = false;
        Trie nextLevel = trie;
        while (flag && !end) {
            Trie children[] = nextLevel.children;
            int count = 0, ind = -1;
            for (int i=0; i<26; i++) {
                Trie child = children[i];
                if (child != null) {
                    count++;
                    if (count > 1) {
                        flag = false;
                        break;
                    } else {
                         ind = i;
                         nextLevel = child;
                         if (child.isEnd) {
                             end = true;
                         }
                    }
                }
            }
            if (count == 0) {
                flag = false;
            }
            if (flag && ind != -1) {
                ans+= (char)(ind + 'a');
            }
        }
        return ans;
    }

    class Trie {
        boolean isEnd;
        Trie children[] = new Trie[26];

        public Trie() {
            isEnd = false;
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        String strs[] = {"a"};
        LCP lcp = new LCP();
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
