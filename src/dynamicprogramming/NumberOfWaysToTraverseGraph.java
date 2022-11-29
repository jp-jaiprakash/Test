package dynamicprogramming;

/**
 * You're given two positive integers representing the width and height of a
 * grid-shaped, rectangular graph. Write a function that returns the number of ways to reach
 * the bottom right corner of the graph starting from top left corner.
 * Each move you take must either go down or right. In other words you can never
 * move up or left in the graph
 */
public class NumberOfWaysToTraverseGraph {

    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        int[][] dp = new int[height][width];

        int i = 0, j = 0;
        while (i < height) {
            dp[i][0] = 1;
            i++;
        }

        while (j < width) {
            dp[0][j] = 1;
            j++;
        }
        i = 1;
        while (i < height) {
            int y = 1;
            while (y < width) {
                dp[i][y] = dp[i - 1][y] + dp[i][y - 1];
                y++;
            }
            i++;
        }
        return dp[height - 1][width - 1];
    }


    // O(2^ (n+m) time | O(n+m) space
    public int numberOfWaysToTraverseGraphRecurse(int width, int height){
        if(width == 1 || height ==1)
            return 1;

        return numberOfWaysToTraverseGraph(width-1, height) +
                numberOfWaysToTraverseGraph(width, height-1);
    }

    public int numberOfWaysToTraverseGraphOptimized(int width, int height){
        int [][] numberOfWays = new int [height+1][width+1];

        for(int widthIdx = 1; widthIdx < width + 1; widthIdx++){
            for(int heightIdx = 1; heightIdx < height + 1; heightIdx++){
                if(widthIdx == 1 || heightIdx == 1)
                    numberOfWays[heightIdx][widthIdx] = 1;
                else {
                    int waysLeft = numberOfWays[heightIdx][ widthIdx-1];
                    int waysUp = numberOfWays[heightIdx-1][ widthIdx];
                    numberOfWays[heightIdx][widthIdx] = waysUp+waysLeft;
                }
            }
        }
        if(width == 1 || height ==1)
            return 1;

        return numberOfWaysToTraverseGraph(width-1, height) +
                numberOfWaysToTraverseGraph(width, height-1);
    }
}
