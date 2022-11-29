package dynamicprogramming;

/**
 * Write a function that takes in an array of positive integers and returns
 * the maximum sum of non-adjacent elements in the array
 */
public class MaxSubSetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0)
            return 0;

        if (array.length == 1)
            return array[0];
/**
 *create an array of same size
 * value[i] = max(maxarray[i-1], (maxarray[i-2]+array[i]))
 */

        int[] maxarray = new int[array.length];
        maxarray[0] = array[0];
        maxarray[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            maxarray[i] = Math.max(maxarray[i - 1], (maxarray[i - 2] + array[i]));

        }
        return maxarray[array.length - 1];


    }
}
