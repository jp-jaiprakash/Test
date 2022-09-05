package arrays;

public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        // Write your code here.

        int product =1;
        int leftArray[] = new int[array.length];
        int rightArray[] = new int[array.length];
        int i=0;

        while (i< leftArray.length ){
            leftArray[i] = product;
            product = product * array[i];
            i++;
        }
        product = 1;
        i--;
        while (i>= 0){
            rightArray[i] = product;
            product = product * array[i];
            i--;
        }
        for(i=0; i< array.length; i++)
            leftArray[i] = leftArray[i] * rightArray[i];
        return leftArray;
    }
}
