package dynamicprogramming;

/**
 * Given an array of positive integers representing coin denominations and a single non-negative integer 'n'
 * representing a taget amount of number. Write a function that returns the number of ways to make change for taht target amount using the given coin denoiminations
 */
public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int coin : denoms) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[n];
    }
}
