package DP;

public class LCS {
    //leetcode
    public int minDistance(String word1, String word2) {

        if(word1.length()==0 || word2.length()==0)
            return Math.max(word1.length(),word2.length());
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<=m;i++) {
            for (int j=0;j<=n;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        LCS l = new LCS();
        System.out.println(l.minDistance("a","a"));
    }
}
