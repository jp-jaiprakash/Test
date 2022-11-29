package recursion;

import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int lvl) {
        int sum=0;
        for(Object obj: array){
            if(obj instanceof Integer)
                sum +=(Integer) obj;
            else
                sum +=productSum((List<Object>) obj, lvl+1);
        }
        return sum*lvl;
    }


}
