package practice;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateII {

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< array.length; i++){
            int idx = Math.abs(array[i]) - 1;
            if(array[idx] < 0)
                return array[i];
            array[idx] = 0-array[i];
        }
        return -1;
    }
}
