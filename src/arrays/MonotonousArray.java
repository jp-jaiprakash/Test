package arrays;

public class MonotonousArray {

    public static void main(String[] args) {
//        int [] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        int [] array = {5,5,5,5,5,4,3};
        System.out.println(isMonotonicII(array));
    }

    public static boolean isMonotonic(int[] array) {
        // Write your code here.

        if(array.length < 2)
            return true;

        int diff = 0;
        int i=1;
        do{
            diff = array[i] - array[i-1];
            i++;
        }while (diff==0 && i < array.length);

        if(i == array.length)
            return true;


        int sign = showSign(diff);

        for(;i < array.length;i++){
            diff = array[i] - array[i-1];
            if(showSign(diff) != 0 && showSign(diff) != sign)
                return false;

        }

        return true;
    }

    static int showSign(int difference){
        return difference < 0 ? -1 : (difference > 0 ? 1 : 0);
    }

    public static boolean isMonotonicII(int [] array){
        if(array.length < 2)
            return true;

        boolean isDecreasing = array[0] > array[1];

        for(int i =1; i< array.length; i++){
            if(array[i]!= array[i-1] && isDecreasing && array[i] > array[i-1])
                return false;

            if(array[i]!= array[i-1] &&!isDecreasing && array[i] < array[i-1])
                return false;
        }

        return true;
    }
}
