package greedyalgorithms;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int n = queries.length;
        int sum =0;
        for(int i=0; i<n-1; i++ ){
            sum += (queries[i] * (n-i-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumWaitingTime m = new MinimumWaitingTime();

        int [] arr = {6,1,2,3,2};
        System.out.println(m.minimumWaitingTime(arr));
    }
}
