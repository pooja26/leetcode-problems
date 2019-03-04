package DP;

public class SubsetSum {
    public boolean getSubset(int[] arr,int amount) {
        boolean[][] subset = new boolean[arr.length+1][amount+1];
        for (int i=0;i<=arr.length;i++) {
            subset[i][0]=true;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - arr[i - 1] >= 0) {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - arr[i - 1]];
                } else {
                    subset[i][j] = subset[i-1][j];
                }
            }
        }
        return subset[arr.length][amount];
    }

    public static void main(String[] args) {
        SubsetSum s = new SubsetSum();
        int[] arr = {2,3,7,8,10};
        System.out.println(s.getSubset(arr,11));
    }
}
