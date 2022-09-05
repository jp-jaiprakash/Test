package arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateValue {

    public static void main(String[] args) {
        int [] array = {2,1,5,3,4,1,2};
        System.out.println(firstDuplicateValueII(array));
    }

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< array.length; i++){
            Integer idx = map.get(array[i]);
            if(idx!= null){
                return array[i];
            }
            map.put(array[i], i);

        }
        return -1;
    }

    public static int firstDuplicateValueII(int[] array) {
        // Write your code here.

        for(int i=0; i< array.length; i++){
            int idx = Math.abs(array[i]) - 1;
            if(array[idx] < 0)
                return array[i];
            array[idx] = 0-array[idx];
        }
        return -1;
    }
}
