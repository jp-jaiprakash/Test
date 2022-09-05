package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int [][] intervals ={{-20,30}, {1,22}};
        int [][] intervalsII ={{2, 3},{4, 5},{6, 7},{8, 9},{1, 10}};

//        mergeOverlappingIntervals(intervals);
        int [][] ans =mergeOverlappingIntervalsII(intervalsII);
        for(int i=0; i< ans.length; i++){
            System.out.print(ans[i][0]+","+ans[i][1]);
            System.out.println();

        }
    }

    // it passed 80% test cases
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.

        int cnt=0;
        for(int i =0; i< intervals.length; ){
            while (i< intervals.length - 1 && intervals[i][1] > intervals[i+1][0])
                i++;

            i++;
            cnt++;
        }

        int [][] answer = new int[cnt][2];
        int k =0;

        for(int i =0; i< intervals.length; ){
            int initialIdx = i;
            while (i< intervals.length - 1 && intervals[i][1] > intervals[i+1][0])
                i++;

            answer[k][0] = intervals[initialIdx][0];
            answer[k][1] = intervals[i][1];

            k++;
            i++;
        }
        return answer;
    }

    public static int[][] mergeOverlappingIntervalsII(int[][] interval) {
        // Write your code here.

        int [][] intervals = interval.clone();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int [] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);
        for(int[] nextInterval: intervals){
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if(currentIntervalEnd >= nextIntervalStart){
                currentInterval[1]= Math.max(currentIntervalEnd, nextIntervalEnd);
            }else{
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
