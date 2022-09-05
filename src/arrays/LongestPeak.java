package arrays;

public class LongestPeak {
    public static void main(String[] args) {
        int [] array = {5, 4, 3, 2, 1, 2, 10, 12};

//        int [] array = {51,2,3,3,4,0,10,6,5,-1,-3,2,3};
        System.out.println(longestPeak(array));
    }
    public static int longestPeak(int[] array) {
        // Write your code here.
        if(array.length < 3)
            return 0;
       int i = 1;
       int currentlength = 0;

       while(i < array.length-1){

           boolean isPeak = (array[i] > array[i-1]) && (array[i] > array[i+1]);
           // Figure out the peak

           if(!isPeak){
               i++;
               continue;
           }

           int leftIdx= i-2;

           while(leftIdx >= 0 && array[leftIdx] < array[leftIdx+1]){
               leftIdx--;

           }
            int rightIdx = i+2;
           while(rightIdx < array.length && array[rightIdx] < array[rightIdx-1]){
               rightIdx++;
           }

           int newcurrentlength = rightIdx - leftIdx - 1;
           if(newcurrentlength > currentlength)
               currentlength = newcurrentlength;
           i = rightIdx;
       }
       return currentlength;
    }
}