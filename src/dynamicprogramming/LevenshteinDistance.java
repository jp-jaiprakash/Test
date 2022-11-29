package dynamicprogramming;

/**
 *
 * Write a function that takes in two strings and returns the minimum number of edit
 * operations that need to be performed on the first string to obtain second string
 *
 * Three operations possible: insertion, deletion and substitution
 *
 */
public class LevenshteinDistance {

    public static int minOperations(String word1, String word2){

        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){

                // for first row and first column
                if(i<1 || j <1){
                    if(i==0 && j==0)
                        dp[i][j] = 0;
                    else if(i > 0)
                        dp[i][j] = dp[i-1][j] + 1;
                    else if (j > 0)
                        dp[i][j] = dp[i][j-1] + 1;
                }else{
                    if(word1.charAt(i) == word2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    }
                }
            }
        }
        return dp[n][m];

    }
}
