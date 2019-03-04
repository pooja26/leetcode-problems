package DP;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        int[][] count = new int[m][n];
        for(int i=0;i<m;i++) {
            count[i][0]=1;
        }
        for(int j=0;j<n;j++) {
            count[0][j]=1;
        }
        for (int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                count[i][j] = count[i-1][j]+count[i][j-1];
            }
        }
        return count[m-1][n-1];

    }

    public static void main(String[] args) {
        UniquePaths  uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,2));
    }
}