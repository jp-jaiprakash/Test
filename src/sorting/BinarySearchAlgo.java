package sorting;

public class BinarySearchAlgo {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.

        return binarySearch(array, target, 0, array.length);
    }

    public static int binarySearch(int[] array, int target, int low, int high){
        int mid = (high -low)/ 2;
        while(low < high){
            if(array[mid] == target)
                return mid;
            else if(array[mid] > target)
                return binarySearch(array, target, low, mid);
            else if(array[mid] < target)
                return binarySearch(array, target, mid+1, high);
        }


            return -1;
    }

    public static void main(String[] args) {
        int [] arr ={0,1,21,33,45,45,61,71,72,73};
        System.out.println(binarySearch(arr,9));
    }
}
