package DP;

public class MinimumCoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] table = new int[amount+1];
        table[0]=0;
        //fill entire array with max value
        for(int i=1;i<=amount;i++) {
            table[i]=Integer.MAX_VALUE;
        }
        //for every index from table find the min num of coins in coins[] req to form i.
         for (int i=1;i<=amount;i++) {
            for (int j=0;j<coins.length;j++) {
                if(coins[j]<=i) {
                    int res=table[i-coins[j]];
                    if(res!=Integer.MAX_VALUE && res+1<table[i]) {
                        table[i] = res+1;
                    }
                }
            }
        }
        if (table[amount]==Integer.MAX_VALUE)
            return -1;
        return table[amount];
    }

    public static void main(String[] args) {
        MinimumCoinChange c = new MinimumCoinChange();
        int[] coins = {2};
        System.out.println(c.coinChange(coins,11));
    }
}
